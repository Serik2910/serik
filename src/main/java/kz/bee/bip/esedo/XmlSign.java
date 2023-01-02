package kz.bee.bip.esedo;

import kz.gov.pki.kalkan.asn1.pkcs.PKCSObjectIdentifiers;
import kz.gov.pki.kalkan.jce.provider.KalkanProvider;
import kz.gov.pki.kalkan.xmldsig.KncaXS;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.WSSecurityException;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.token.SecurityTokenReference;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.encryption.XMLCipherParameters;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.signature.XMLSignatureException;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.UUID;

public class XmlSign {


    private String senderIdShep;

    private String passwordIdShep;

    //private static String certPath = "/Users/janalinov/Downloads/esedokey";

    //private static final String certPath="/Users/janalinov/Downloads/key";
    private static String certPath = "/opt/tomcat/apache-tomcat-9.0.64/certs/";

    private static String certKey = "GOSTKNCA_282da03e55b9f2ffbda78aca3933358cfcc8a31c.p12";

    private static String certPass = "e123456";

    private static String ocspurl = "http://ocsp.pki.gov.kz";
    private static String tspurl = "http://tsp.pki.gov.kz";
    //private static ArrayList<String> cacerts = new ArrayList<String>("root_gost.crt","root_rsa.crt","nca_gost.crt",
    // "nca_rsa.crt");


    public String xmlSign(String xmlSoap) {
        final String KEYSTORE_KEY = certPath + File.separator + certKey;
        final String KEYSTORE_PASSWORD = certPass;
        String signedSoap = null;
        KalkanProvider kalkanProvider = new KalkanProvider();
        Security.addProvider(kalkanProvider);
        KncaXS.loadXMLSecurity();
        try {
            final String signMethod;
            final String digestMethod;
            InputStream is = new ByteArrayInputStream(xmlSoap.getBytes());

            SOAPMessage msg = MessageFactory.newInstance().createMessage(null, is);
            SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
            //TEST
            env.setEncodingStyle("UTF-8");
            //TEST
            SOAPBody body = env.getBody();
            body.setEncodingStyle("UTF-8");
            String bodyId = "id-" + UUID.randomUUID();
            body.addAttribute(new QName(WSConstants.WSU_NS, "Id", WSConstants.WSU_PREFIX), bodyId);

            SOAPHeader header = env.getHeader();

            if (header == null) {
                header = env.addHeader();
            }
            KeyStore store = KeyStore.getInstance("PKCS12", KalkanProvider.PROVIDER_NAME);
            InputStream inputStream;
            inputStream = AccessController.doPrivileged((PrivilegedExceptionAction<InputStream>) () -> new FileInputStream(KEYSTORE_KEY));
            store.load(inputStream, KEYSTORE_PASSWORD.toCharArray());
            Enumeration<String> als = store.aliases();
            String alias = null;
            while (als.hasMoreElements()) {
                alias = als.nextElement();
            }
            final PrivateKey privateKey = (PrivateKey) store.getKey(alias, KEYSTORE_PASSWORD.toCharArray());
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
            Document doc = env.getOwnerDocument();

            Transforms transforms = new Transforms(env.getOwnerDocument());
            transforms.addTransform(Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS);
            Element c14nMethod = XMLUtils.createElementInSignatureSpace(doc, "CanonicalizationMethod");
            c14nMethod.setAttributeNS(null, "Algorithm", Canonicalizer.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);
            Element signatureMethod = XMLUtils.createElementInSignatureSpace(doc, "SignatureMethod");
            signatureMethod.setAttributeNS(null, "Algorithm", signMethod);

            XMLSignature sig = new XMLSignature(env.getOwnerDocument(), "", signatureMethod, c14nMethod);


            sig.addDocument("#" + bodyId, transforms, digestMethod);
            sig.getSignedInfo().getSignatureMethodElement().setNodeValue(Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS);
            WSSecHeader secHeader = new WSSecHeader();
            secHeader.setMustUnderstand(true);
            secHeader.insertSecurityHeader(env.getOwnerDocument());
            secHeader.getSecurityHeader().appendChild(sig.getElement());
            header.appendChild(secHeader.getSecurityHeader());
            SecurityTokenReference reference = new SecurityTokenReference(doc);
            reference.setKeyIdentifier(x509Certificate);

            sig.getKeyInfo().addUnknownElement(reference.getElement());
            sig.sign(privateKey);

            signedSoap = org.apache.ws.security.util.XMLUtils.PrettyDocumentToString(doc);

        } catch (SOAPException e) {
            //logger.error("Exception :: " + e.getCause().getMessage(), e);
            //throw new RuntimeException(e);
            return "Error with sign";
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (XMLSecurityException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        }  catch (WSSecurityException e) {
            e.printStackTrace();
        } catch (PrivilegedActionException e) {
            e.printStackTrace();
        }
        return signedSoap;
    }
}
