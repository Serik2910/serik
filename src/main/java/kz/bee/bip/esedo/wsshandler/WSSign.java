package kz.bee.bip.esedo.wsshandler;

import kz.bee.bip.esedo.KeyStoreFileAdapter;
import kz.bee.bip.esedo.WriteMessageToFile;
import kz.gov.pki.kalkan.asn1.pkcs.PKCSObjectIdentifiers;
import kz.gov.pki.kalkan.jce.provider.KalkanProvider;
import kz.gov.pki.kalkan.xmldsig.KncaXS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.token.SecurityTokenReference;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.encryption.XMLCipherParameters;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.w3c.dom.Node;
import org.w3c.dom.*;


import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Set;
import java.util.UUID;

public class WSSign implements SOAPHandler<SOAPMessageContext> {

    private static final Logger LOGGER = LogManager.getLogger(WSSign.class);
    private static Provider kalkanProvider;
    private static final String keystoreType="PKCS12";
    private static final String keystorePassword="e123456";
    private static final String keystoreAlias="282da03e55b9f2ffbda78aca3933358cfcc8a31c";
    //private static final String keystoreFile="/Users/janalinov/Downloads/key" +
          //  "/GOSTKNCA_282da03e55b9f2ffbda78aca3933358cfcc8a31c.p12";
    private static final String keystoreFile = "/opt/tomcat/apache-tomcat-9.0.64/certs/GOSTKNCA_282da03e55b9f2ffbda78aca3933358cfcc8a31c.p12";
    public static final String WSU_NAMESPACE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
    private static final String SIMPLE_XML_SOAP = "/home/simbase/out_bb670113-ec38-4da3-867c-66ff3dc83621.xml";
    private KeyStore keyStore;
    private Provider provider;

    public WSSign(){
        try {
            //initProvider();
            initKalkanProvider();
            initKeystore();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }
    private void initKalkanProvider() {
        kalkanProvider = new KalkanProvider();

        boolean exists = Arrays.stream(Security.getProviders())
                .anyMatch(p -> p.getName().equals(kalkanProvider.getName()));

        if (!exists) {
            Security.addProvider(kalkanProvider);
        }
    }

    private void initProvider() {

        Security.addProvider(new KalkanProvider());
        KncaXS.loadXMLSecurity();
        org.apache.xml.security.Init.init();
        JCEMapper.setProviderId(KalkanProvider.PROVIDER_NAME);
    }


    private void initKeystore() throws IOException, KeyStoreException, NoSuchProviderException,
            NoSuchAlgorithmException, CertificateException {

        keyStore = new KeyStoreFileAdapter(keystoreType, keystoreFile, keystorePassword).getKeyStore();

    }

    public SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
        return message;
    }

    public String soapMessageToString(SOAPMessage message)
    {
        String result = null;
        if (message != null)
        {
            ByteArrayOutputStream baos = null;
            try
            {
                baos = new ByteArrayOutputStream();
                message.writeTo(baos);
                result = baos.toString("UTF-8");
            }
            catch (Exception e)
            {
            }
            finally
            {
                if (baos != null)
                {
                    try
                    {
                        baos.close();
                    }
                    catch (IOException ioe)
                    {
                    }
                }
            }
        }
        return result;
    }

    public void signMessage() throws SOAPException, IOException {

        boolean outbound = true; //(Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        final String signMethod;
        final String digestMethod;
        File xmlFile = new File(SIMPLE_XML_SOAP);
        String xml = new String(
                Files.readAllBytes(xmlFile.toPath()), StandardCharsets.UTF_8);
        if (outbound) {
            try {
                Class.forName("kz.gov.pki.kalkan.jce.X509Principal");

                InputStream is = new ByteArrayInputStream(xml.getBytes());
                //SOAPMessage msg = MessageFactory.newInstance().createMessage(null, is);
                SOAPMessage msg = getSoapMessageFromString(xml);
                SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
                SOAPBody body = env.getBody();

                WSSecHeader secHeader = new WSSecHeader();
                secHeader.setMustUnderstand(false);
                secHeader.insertSecurityHeader(env.getOwnerDocument());
                String bodyId = "id-" + UUID.randomUUID().toString();
                String prefix = "wsu";
                for (int i = 0; i < secHeader.getSecurityHeader().getAttributes().getLength(); i++) {
                    Attr attr = (Attr) secHeader.getSecurityHeader().getAttributes().item(i);
                    if (WSU_NAMESPACE.equals(attr.getNamespaceURI())) {
                        prefix = attr.getName();
                    }
                }
                body.addAttribute(new QName(WSU_NAMESPACE, "Id", prefix), bodyId);
                body.setIdAttributeNS(WSU_NAMESPACE, "Id", true);

                SOAPHeader header = env.getHeader();
                if (header == null) {
                    header = env.addHeader();
                }

                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(keystoreAlias);
                PrivateKey privateKey = (PrivateKey) keyStore.getKey(keystoreAlias, keystorePassword.toCharArray());
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

                Document doc = env.getOwnerDocument();

                Transforms transforms = new Transforms(env.getOwnerDocument());
                transforms.addTransform(Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS);

                XMLSignature sig = new XMLSignature(env.getOwnerDocument(), "", signMethod, Canonicalizer.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);
                sig.addDocument("#" + bodyId, transforms, digestMethod);
                sig.getSignedInfo().getSignatureMethodElement().setNodeValue(Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS);
                secHeader.getSecurityHeader().appendChild(sig.getElement());
                header.appendChild(secHeader.getSecurityHeader());

                SecurityTokenReference reference = new SecurityTokenReference(doc);
                reference.setKeyIdentifier(x509Certificate);
                sig.getKeyInfo().addUnknownElement(reference.getElement());

                sig.sign(privateKey);

                //verifyMessage(signedSoap);

            }  catch (SOAPException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                SOAPEnvelope env = getSoapMessageFromString(xml).getSOAPPart().getEnvelope();
                Element sigElement = null;
                Element rootEl = (Element) env.getOwnerDocument().getFirstChild();

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
//                        result = signature.checkSignatureValue(cert);
                        rootEl.removeChild(sigElement);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void check(Boolean result) {
        if (!result) {
//	    	EStatFaultBean faultBean = new EStatFaultBean();
//	    	faultBean.setCode(EStatError.SHEP_VERIFICATION_ERROR.getCode());
//	    	faultBean.setMessage(EStatError.SHEP_VERIFICATION_ERROR.name());
//	    	throw new EStatTransportException(faultBean);
        }
    }

    public void removeAllChilds(Node node) {
        while (node.getFirstChild() != null) {
            Node n = node.getFirstChild();
            if (n.hasChildNodes()) {
                removeAllChilds(n);
                node.removeChild(n);
            } else {
                node.removeChild(n);
            }
        }
    }

    public boolean verifyMessage(SOAPMessage message) throws SOAPException, IOException {
        boolean result = false;
        boolean outbound = false;

        if (!outbound) {
            try {
                SOAPEnvelope env = message.getSOAPPart().getEnvelope();
                Element sigElement = null;
                Element rootEl = (Element) env.getOwnerDocument().getFirstChild();

                NodeList list = rootEl.getElementsByTagName("ds:Signature");
                int length = list.getLength();
                for (int i = 0; i < length; i++) {
                    Node node = list.item(i).getParentNode();
                    if (node.getNodeName().equals("data")) {
                        continue;//костыль, чтобы не валидировать тег data
                    }
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
                        sigNode.getParentNode().removeChild(sigElement);
//	                    rootEl.removeChild(sigElement);
                    }
                    check(result);
                }

                NodeList listData = rootEl.getElementsByTagName("data");
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer tr = tf.newTransformer();

                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                dbf.setNamespaceAware(true);
                DocumentBuilder documentBuilder = dbf.newDocumentBuilder();

                length = listData.getLength();
                for (int i = 0; i < length; i++) {
                    StringWriter os = new StringWriter();
                    tr.transform(new DOMSource(listData.item(i)), new StreamResult(os));
                    os.close();
                    String xml = os.toString();
                    Document doc = documentBuilder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
                    Element dataNode = (Element) doc.getFirstChild();//importNode(listData.item(i), true);

                    NodeList list2 = dataNode.getElementsByTagName("ds:Signature");
                    if (list2.getLength() > 0) {
                        os = new StringWriter();
                        tr.transform(new DOMSource(doc), new StreamResult(os));
                        os.close();
                        Element dataEl = rootEl.getOwnerDocument().createElement("data");
                        dataEl.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:xs", "http://www.w3.org/2001/XMLSchema");
                        dataEl.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
                        dataEl.setAttribute("xsi:type", "xs:string");
                        dataEl.setTextContent(os.toString());
                        listData.item(i).getParentNode().replaceChild(dataEl, listData.item(i));
                    }
                }

                check(result);
            } catch (Exception e) {
                e.printStackTrace(System.err);
                try {
                    SOAPBody body = message.getSOAPBody();
                    SOAPFault fault = body.addFault();
                    SOAPFaultException ex = new SOAPFaultException(fault);
                    throw ex;
                } catch (SOAPException e1) {

                }
            }
        }
        try {
            message.writeTo(System.err);
        } catch (SOAPException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return result;
    }


    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        String xml = soapMessageToString(context.getMessage());

        String signedXml = null;
        try {
            KncaXS.loadXMLSecurity();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            final Document doc = documentBuilder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
            final String signMethod;
            final String digestMethod;
            KeyStore store = KeyStore.getInstance("PKCS12", kalkanProvider.getName());
            InputStream inputStream = AccessController.doPrivileged((PrivilegedExceptionAction<FileInputStream>) () -> {
                FileInputStream fis = new FileInputStream(keystoreFile);
                return fis;
            });
            store.load(inputStream, keystorePassword.toCharArray());
            Enumeration<String> als = store.aliases();
            String alias = null;
            while (als.hasMoreElements()) {
                alias = als.nextElement();
            }

            final PrivateKey privateKey = (PrivateKey) store.getKey(alias, keystorePassword.toCharArray());
            final X509Certificate x509Certificate = (X509Certificate) store.getCertificate(alias);
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
                //StringWriter os = new StringWriter();
                //TransformerFactory tf = TransformerFactory.newInstance();
                //Transformer trans = tf.newTransformer();
                //trans.transform(new DOMSource(doc), new StreamResult(os));
                //os.close();
                //signedXml = os.toString();
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        LOGGER.info("Fault message");
        SOAPMessage message = context.getMessage();
        try {
            // Распечатаем исходящее сообщение
            new WriteMessageToFile().writeMessage(message, "fault");
        }
        catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}
