package soap.start.serik.service;


import kz.gov.pki.kalkan.asn1.pkcs.PKCSObjectIdentifiers;
import kz.gov.pki.kalkan.jce.provider.KalkanProvider;
import kz.gov.pki.kalkan.xmldsig.KncaXS;
import org.apache.xml.security.encryption.XMLCipherParameters;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

@Service
public class KeyStoreFileAdapter implements IxmlDsigUtil {

    private String storetype; //JKS | PKCS12
    private String storefileUrl;

    private String storepass;
    @Value("${p12.file.alias}")
    private String alias;
    private Provider provider;
    private KeyStore keyStore;

    public String getStoretype() {
        return storetype;
    }

    public String getStorefileUrl() {
        return storefileUrl;
    }

    public String getStorepass() {
        return storepass;
    }

    public String getAlias() {
        return alias;
    }

    public Provider getProvider() {
        return provider;
    }

    public KeyStore getKeyStore() {
        return keyStore;
    }

    public KeyStoreFileAdapter(
            @Value("${p12.file.location}") String storefileUrl,
            @Value("${p12.file.password}") String storepass,
            @Value("${p12.file.alias}") String alias,
            @Value("${p12.file.type}") String storetype
            ) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, NoSuchProviderException {
        Security.addProvider(new KalkanProvider());
        // загружаем конфигурацию либо магической функцией
        KncaXS.loadXMLSecurity();
        // либо многословно так
        // System.setProperty("org.apache.xml.security.resource.config", "/kz/gov/pki/kalkan/xmldsig/pkigovkz.xml");
        // org.apache.xml.security.Init.init();
        // org.apache.xml.security.algorithms.JCEMapper.setProviderId(KalkanProvider.PROVIDER_NAME);
        this.provider = new KalkanProvider();
        Security.addProvider(this.provider);
        this.storefileUrl = storefileUrl;
        this.storepass = storepass;
        this.storetype = storetype;
        this.alias = alias;
        this.keyStore = getKeyStoreFromSource();
    }
    private KeyStore getKeyStoreFromSource()
            throws IOException,
            KeyStoreException,
            NoSuchProviderException,
            CertificateException,
            NoSuchAlgorithmException {
        char[] passBytes = storepass.toCharArray();
        byte[] p12Bytes = readFile(storefileUrl);
        KeyStore ks = KeyStore.getInstance(storetype, KalkanProvider.PROVIDER_NAME);
        ks.load(new ByteArrayInputStream(p12Bytes), passBytes);
        return ks;
    }
    private byte[] readFile(String filename) throws IOException {
        Resource resource;
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        resource=resourceLoader.getResource(filename);
        InputStream stream = resource.getInputStream();
        byte[] byteArray = new byte[stream.available()];
        stream.read(byteArray);
        return byteArray;
    }
    public String signXML(String xmlString) {

        String result = null;

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            final Document doc = documentBuilder.parse(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
            final String signMethod;
            final String digestMethod;

            Enumeration<String> als = getKeyStore().aliases();
            String alias = null;
            while (als.hasMoreElements()) {
                alias = als.nextElement();
            }

            final PrivateKey privateKey = (PrivateKey) getKeyStore().getKey(alias, this.storepass.toCharArray());
            final X509Certificate x509Certificate = (X509Certificate) getKeyStore().getCertificate(alias);
            String sigAlgOid = x509Certificate.getSigAlgOID();
            if (sigAlgOid.equals(PKCSObjectIdentifiers.sha1WithRSAEncryption.getId())) {
                signMethod = Constants.MoreAlgorithmsSpecNS + "rsa-sha1";
                digestMethod = Constants.MoreAlgorithmsSpecNS + "sha1";
            } else if (sigAlgOid.equals(PKCSObjectIdentifiers.sha256WithRSAEncryption.getId())) {
                signMethod = Constants.MoreAlgorithmsSpecNS + "rsa-sha256";
                digestMethod = XMLCipherParameters.SHA256;
            } else {
                signMethod = Constants.MoreAlgorithmsSpecNS + "gost34310-gost34311";
                digestMethod = Constants.MoreAlgorithmsSpecNS + "gost34311";
            }

            XMLSignature sig = new XMLSignature(doc, "", signMethod);

            if (doc.getFirstChild() != null) {
                doc.getFirstChild().appendChild(sig.getElement());
                Transforms transforms = new Transforms(doc);
                transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
                transforms.addTransform(XMLCipherParameters.N14C_XML_CMMNTS);
                sig.addDocument("", transforms, digestMethod);
                sig.addKeyInfo(x509Certificate);
                sig.sign(privateKey);
                StringWriter os = new StringWriter();
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer trans = tf.newTransformer();
                trans.transform(new DOMSource(doc), new StreamResult(os));
                os.close();
                result = os.toString();
            }

            System.err.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean verifyXml(String xmlString) {
        boolean result = false;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document doc = documentBuilder.parse(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));

            Element sigElement = null;
            Element rootEl = (Element) doc.getFirstChild();

            NodeList list = rootEl.getElementsByTagName("ds:Signature");
            int length = list.getLength();
            for (int i = 0; i < length; i++) {
                Node sigNode = list.item(length - 1);
                sigElement = (Element) sigNode;
                if (sigElement == null) {
                    System.err.println("Bad signature: Element 'ds:Reference' is not found in XML document");
                }
                XMLSignature signature = new XMLSignature(sigElement, "");
                KeyInfo ki = signature.getKeyInfo();
                X509Certificate cert = ki.getX509Certificate();
                if (cert != null) {
                    result = signature.checkSignatureValue(cert);
                    rootEl.removeChild(sigElement);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("VERIFICATION RESULT IS: " + result);
        return result;
    }
}
