package kz.bee.bip.esedo;

import kz.gov.pki.kalkan.jce.provider.KalkanProvider;
import kz.gov.pki.kalkan.xmldsig.KncaXS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.token.SecurityTokenReference;
import org.apache.xml.security.c14n.Canonicalizer;
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
import javax.xml.ws.soap.SOAPFaultException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.UUID;

public class WSS4JSignRGP1 {
    private static final Logger LOGGER= LogManager.getLogger(WSS4JSignRGP1.class);
    private static final String keystoreType="PKCS12";
    private static final String keystorePassword="e123456";
    private static final String keystoreAlias="282da03e55b9f2ffbda78aca3933358cfcc8a31c";
    //private static final String keystoreFile="/Users/janalinov/Downloads/key" +
           // "/GOSTKNCA_282da03e55b9f2ffbda78aca3933358cfcc8a31c.p12";
    private static final String keystoreFile="/opt/tomcat/apache-tomcat-9.0.64/certs/GOSTKNCA_282da03e55b9f2ffbda78aca3933358cfcc8a31c.p12";
    public static final String WSU_NAMESPACE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";

    private KeyStore keyStore;
    private Provider provider;

    public WSS4JSignRGP1(){
        try {
            initProvider();
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

    private void initProvider() {
        LOGGER.debug("Invoke");
        //  org.apache.xml.security.Init.init();
//        provider = Security.getProvider(KalkanProvider.PROVIDER_NAME);
//        if (provider == null) {
//            provider = new KalkanProvider();
//            Security.addProvider(provider);
//            KncaXS.loadXMLSecurity();
//            LOGGER.info("Succ inited the CryptoProvider: " + provider.getName());
//        } else {
//            LOGGER.debug("The Security Provider: " + provider.getName() + " allready inited");
//        }
        Security.addProvider(new KalkanProvider());
        KncaXS.loadXMLSecurity();
        //org.apache.xml.security.Init.init();
        //JCEMapper.setProviderId(KalkanProvider.PROVIDER_NAME);
    }


    private void initKeystore() throws IOException, KeyStoreException, NoSuchProviderException,
            NoSuchAlgorithmException, CertificateException {
        LOGGER.debug("Invoke");
        keyStore = new KeyStoreFileAdapter(keystoreType, keystoreFile, keystorePassword).getKeyStore();
        LOGGER.info("Keystore inited");
    }

    private SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
        return message;
    }

    public void signMessage(SOAPMessage message) throws SOAPException, IOException {

        boolean outbound = true; //(Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        final String signMethod;
        final String digestMethod;

        if (outbound) {
            try {
                Class.forName("kz.gov.pki.kalkan.jce.X509Principal");
                SOAPEnvelope env = message.getSOAPPart().getEnvelope();
                SOAPBody body = env.getBody();

                WSSecHeader secHeader = new WSSecHeader();
                secHeader.setMustUnderstand(true);
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
                //body.setIdAttributeNS(WSU_NAMESPACE, "Id", true);

                SOAPHeader header = env.getHeader();
                if (header == null) {
                    header = env.addHeader();
                }

                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(keystoreAlias);
                PrivateKey privateKey = (PrivateKey) keyStore.getKey(keystoreAlias, keystorePassword.toCharArray());
                //String sigAlgOid = x509Certificate.getSigAlgOID();
                //LOGGER.info(sigAlgOid);
                //if (sigAlgOid.equals(PKCSObjectIdentifiers.sha1WithRSAEncryption.getId())) {
                  //  LOGGER.info("Algorithm signature: " + "rsa-sha1");
                    //signMethod = Constants.MoreAlgorithmsSpecNS + "rsa-sha1";
                    //digestMethod = Constants.MoreAlgorithmsSpecNS + "sha1";
                //} else if (sigAlgOid.equals(PKCSObjectIdentifiers.sha256WithRSAEncryption.getId())) {
                  //  LOGGER.info("Algorithm signature: " + "rsa-sha256");
                    //signMethod = Constants.MoreAlgorithmsSpecNS + "rsa-sha256";
                    //digestMethod = XMLCipherParameters.SHA256;
                //} else {
                    LOGGER.info("Algorithm signature: " + "gost34310-gost34311");
                    signMethod = Constants.MoreAlgorithmsSpecNS + "gost34310-gost34311";
                    digestMethod = Constants.MoreAlgorithmsSpecNS + "gost34311";
                //}

                Document doc = env.getOwnerDocument();

                Transforms transforms = new Transforms(env.getOwnerDocument());
                transforms.addTransform(Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS);

                XMLSignature sig = new XMLSignature(env.getOwnerDocument(), "", signMethod, Canonicalizer.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);
                //sig.addDocument("#" + bodyId, transforms, digestMethod);
                sig.getSignedInfo().getSignatureMethodElement().setNodeValue(Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS);
                secHeader.getSecurityHeader().appendChild(sig.getElement());
                header.appendChild(secHeader.getSecurityHeader());

                SecurityTokenReference reference = new SecurityTokenReference(doc);
                reference.setKeyIdentifier(x509Certificate);
                sig.getKeyInfo().addUnknownElement(reference.getElement());

                sig.sign(privateKey);
            }  catch (SOAPException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                SOAPEnvelope env = message.getSOAPPart().getEnvelope();
                Element sigElement = null;
                Element rootEl = (Element) env.getOwnerDocument().getFirstChild();

                NodeList list = rootEl.getElementsByTagName("ds:Signature");
                int length = list.getLength();
                for (int i = 0; i < length; i++) {
                    Node sigNode = list.item(length - 1);
                    sigElement = (Element) sigNode;
                    if (sigElement == null) {
                        java.lang.System.err.println("Bad signature: Element 'ds:Reference' is not found in XML document");
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
                        java.lang.System.err.println("Bad signature: Element 'ds:Reference' is not found in XML document");
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
                e.printStackTrace(java.lang.System.err);
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
            message.writeTo(java.lang.System.err);
        } catch (SOAPException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return result;
    }
}
