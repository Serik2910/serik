package kz.bee.bip.esedo;

import kz.gov.pki.kalkan.asn1.pkcs.PKCSObjectIdentifiers;
import kz.gov.pki.kalkan.jce.provider.KalkanProvider;
import kz.gov.pki.kalkan.xmldsig.KncaXS;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.token.SecurityTokenReference;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.encryption.XMLCipherParameters;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessController;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PrivilegedExceptionAction;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.UUID;

public class SignWssSec {
    private static final String KEYSTORE_PASSWORD = "Qwerty12";
    private static final String KEYSTORE_KEY = "D:\\Work\\projects\\shep\\wss\\test_keys\\BIN123456789021.p12";
    private static final String SIMPLE_XML_SOAP = "<?xml version='1.0' encoding='UTF-8'?>\n" +
            "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "\t<S:Body>\n" +
            "\t\t<ns0:sendMessage xmlns:ns0=\"http://bip.bee.kz/AsyncChannel/v10/Types\">\n" +
            "\t\t\t<request>\n" +
            "\t\t\t\t<messageInfo>\n" +
            "\t\t\t\t\t<messageId>5024113e-b70b-479d-8ac7-8c65103e3338</messageId>\n" +
            "\t\t\t\t\t<serviceId>TestService</serviceId>\n" +
            "\t\t\t\t\t<messageType>REQUEST</messageType>\n" +
            "\t\t\t\t\t<messageDate>2018-01-04T19:38:18.518</messageDate>\n" +
            "\t\t\t\t\t<sender>\n" +
            "\t\t\t\t\t\t<senderId>test</senderId>\n" +
            "\t\t\t\t\t\t<password>test</password>\n" +
            "\t\t\t\t\t</sender>\n" +
            "\t\t\t\t</messageInfo>\n" +
            "\t\t\t\t<messageData>\n" +
            "\t\t\t\t\t<data xmlns:ns1=\"http://schemas.simple.kz/test\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"ns1:TestObject\">\n" +
            "\t\t\t\t\t\t<status>STARTED</status>\n" +
            "\t\t\t\t\t</data>\n" +
            "\t\t\t\t</messageData>\n" +
            "\t\t\t</request>\n" +
            "\t\t</ns0:sendMessage>\n" +
            "\t</S:Body>\n" +
            "</S:Envelope>";

    public static void main(String[] args) {

        KalkanProvider kalkanProvider = new KalkanProvider();
        Security.addProvider(kalkanProvider);
        KncaXS.loadXMLSecurity();

        try {
            final String signMethod;
            final String digestMethod;
            InputStream is = new ByteArrayInputStream(SIMPLE_XML_SOAP.getBytes());

            SOAPMessage msg = MessageFactory.newInstance().createMessage(null, is);

            SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
            SOAPBody body = env.getBody();

            String bodyId = "id-" + UUID.randomUUID().toString();
            body.addAttribute(new QName(WSConstants.WSU_NS, "Id", WSConstants.WSU_PREFIX), bodyId);

            SOAPHeader header = env.getHeader();
            if (header == null) {
                header = env.addHeader();
            }
            KeyStore store = KeyStore.getInstance("PKCS12", KalkanProvider.PROVIDER_NAME);
            InputStream inputStream;
            inputStream = AccessController.doPrivileged(new PrivilegedExceptionAction<InputStream>() {
                @Override
                public FileInputStream run() throws Exception {
                    return new FileInputStream(KEYSTORE_KEY);
                }
            });
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

            XMLSignature sig = new XMLSignature(env.getOwnerDocument(), "", signatureMethod, c14nMethod );

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

            String signedSoap = org.apache.ws.security.util.XMLUtils.PrettyDocumentToString(doc);
            //System.out.println(signedSoap);

            verifyXml(signedSoap, x509Certificate);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public static boolean verifyXml(String xmlString, X509Certificate x509Certificate) {
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
            //System.out.println(length);
            for (int i = 0; i < length; i++) {
                Node sigNode = list.item(length - 1);
                sigElement = (Element) sigNode;
                if (sigElement == null) {
                    //System.err.println("Bad signature: Element 'ds:Reference' is not found in XML document");
                }
                XMLSignature signature = new XMLSignature(sigElement, "");
                if (x509Certificate != null) {
                    result = signature.checkSignatureValue(x509Certificate);
//                    rootEl.removeChild(sigElement);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("VERIFICATION RESULT IS: " + result);
        return result;
    }
}

