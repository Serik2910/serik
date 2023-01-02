package kz.bee.bip.esedo;

import kz.bee.bip.esedo.utils.XUtils;
import kz.gov.pki.kalkan.asn1.pkcs.PKCSObjectIdentifiers;
import kz.gov.pki.kalkan.jce.provider.KalkanProvider;
import kz.gov.pki.kalkan.xmldsig.KncaXS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.encryption.XMLCipherParameters;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class SignXMLElement {

    private static final Logger LOGGER= LogManager.getLogger(SignXMLElement.class);

    private static final String keystoreType="PKCS12";
    private static final String keystorePassword="e123456";
    private static final String keystoreAlias="282da03e55b9f2ffbda78aca3933358cfcc8a31c";
    private static final String keystoreFile="/opt/tomcat/apache-tomcat-9.0.64/certs/GOSTKNCA_282da03e55b9f2ffbda78aca3933358cfcc8a31c.p12";

    private KeyStore keyStore;
    private Provider provider;

    public SignXMLElement() throws Exception{
        initProvider();
        initKeystore();
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
        org.apache.xml.security.Init.init();
        JCEMapper.setProviderId(KalkanProvider.PROVIDER_NAME);
    }

    private void initKeystore() throws IOException, KeyStoreException, NoSuchProviderException,
            NoSuchAlgorithmException, CertificateException {
        LOGGER.debug("Invoke");
        keyStore = new KeyStoreFileAdapter(keystoreType, keystoreFile, keystorePassword).getKeyStore();
        LOGGER.info("Keystore inited");
    }



    public void signed(SOAPEnvelope envelope, String elementName) throws UnrecoverableKeyException, TransformerException, KeyStoreException, XPathExpressionException, NoSuchAlgorithmException, XMLSecurityException {
        signed(envelope, elementName, keyStore, keystoreAlias, keystorePassword);
    }
	
	public void signed(SOAPEnvelope envelope, String elementName, String id) throws UnrecoverableKeyException, TransformerException, KeyStoreException, XPathExpressionException, NoSuchAlgorithmException, XMLSecurityException {
        signed(envelope, elementName, keyStore, keystoreAlias, keystorePassword, id);
    }

    private static String nodeToString(Node node) {
        StringWriter sw = new StringWriter();
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            t.setOutputProperty(OutputKeys.INDENT, "no");
            t.transform(new DOMSource(node), new StreamResult(sw));
        } catch (TransformerException te) {
            java.lang.System.out.println("nodeToString Transformer Exception");
        }
        return sw.toString();
    }

    public void signed(SOAPEnvelope envelope, String elementName, KeyStore keyStore, String alias, String password) throws
            TransformerException, XPathExpressionException,
            KeyStoreException, UnrecoverableKeyException,
            NoSuchAlgorithmException, XMLSecurityException {

        Document document = envelope.getOwnerDocument();
        LOGGER.debug("Document for sign:\n" + XUtils.nodeToString(document.getDocumentElement()));

        // get body ID
        LOGGER.debug("Search data");

        String xPathElement = "//" + elementName;
        Node nodeToSign = XUtils.getNode(document, xPathElement);
        if (nodeToSign == null) {
            // не найден element@SOAP-SEC:id, поискать просто element
            LOGGER.debug("SOAP Style Node SOAP-SEC:" + elementName + " was not found, try find a simple style node" +
                    elementName + "...");
        } else {
            LOGGER.debug("Node found: " + nodeToSign);
            Document doc = XUtils.createDocument(nodeToSign);
            // Provide certificate and key
            X509Certificate cer = (X509Certificate) keyStore.getCertificate(alias);
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());
            if (cer == null || privateKey == null) {
                throw new KeyStoreException("Not found PrivateKey with alias \"" + alias + "\"");
            }

            String signMethod;
            String digestMethod;

            String sigAlgOid = cer.getSigAlgOID();
            LOGGER.debug("signAlgorithmOid: " + sigAlgOid);

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
            // SDrozdov 20151124

            LOGGER.debug("signMethod: " + signMethod);
            // Создает объект подписи signature с ассоциированным документом document
            XMLSignature signature = new XMLSignature(doc, "", signMethod);
            if (doc.getFirstChild() != null) {
                doc.getFirstChild().appendChild(signature.getElement());
                Transforms transforms = new Transforms(doc);
                transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
                transforms.addTransform(XMLCipherParameters.N14C_XML_CMMNTS);
                signature.addDocument("", transforms, digestMethod);
                signature.addKeyInfo(cer);
                signature.sign(privateKey);
                Node signedNode = signature.getDocument().getDocumentElement();
                Node importedNode = document.importNode(signedNode, true);
                Node parentNode = nodeToSign.getParentNode();
                parentNode.removeChild(nodeToSign);
                parentNode.appendChild(importedNode);
				LOGGER.debug("after for sign:\n" + XUtils.nodeToString(document.getDocumentElement()));
				LOGGER.debug("aftere for sign:\n" + XUtils.nodeToString(parentNode));
            }
        }
    }
	
	public void signed(SOAPEnvelope envelope, String elementName, KeyStore keyStore, String alias, String password, String id) throws
            TransformerException, XPathExpressionException,
            KeyStoreException, UnrecoverableKeyException,
            NoSuchAlgorithmException, XMLSecurityException {

        Document document = envelope.getOwnerDocument();
        LOGGER.debug("Document for sign:\n" + XUtils.nodeToString(document.getDocumentElement()));

        // get body ID
        LOGGER.debug("Search element " + elementName);

        String xPathElement = "//" + elementName;
		Node nodeToSign = document.getElementsByTagName(elementName).item(0);
		LOGGER.debug("for sign:\n" + document.getDocumentElement());
//        Node nodeToSign = XUtils.getNode(document, xPathElement);
        if (nodeToSign == null) {
            // не найден element@SOAP-SEC:id, поискать просто element
            LOGGER.debug("SOAP Style Node SOAP-SEC:" + elementName + " was not found, try find a simple style node" +
                    elementName + "...");
        } else {
            LOGGER.debug("Node found: " + nodeToSign);
            Document doc = XUtils.createDocument(nodeToSign);
			LOGGER.debug("create doc" + doc.getDocumentElement());
            // Provide certificate and key
            X509Certificate cer = (X509Certificate) keyStore.getCertificate(alias);
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());
            if (cer == null || privateKey == null) {
                throw new KeyStoreException("Not found PrivateKey with alias \"" + alias + "\"");
            }

            String signMethod;
            String digestMethod;

            String sigAlgOid = cer.getSigAlgOID();
            LOGGER.debug("signAlgorithmOid: " + sigAlgOid);

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
            // SDrozdov 20151124

            LOGGER.debug("signMethod: " + signMethod);
            // Создает объект подписи signature с ассоциированным документом document
            XMLSignature signature = new XMLSignature(doc, "", signMethod);
			signature.setId(id);
            if (doc.getFirstChild() != null) {
                doc.getFirstChild().appendChild(signature.getElement());
                Transforms transforms = new Transforms(doc);
                transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
                transforms.addTransform(XMLCipherParameters.N14C_XML_CMMNTS);
                signature.addDocument("", transforms, digestMethod);
                signature.addKeyInfo(cer);
                signature.sign(privateKey);
                Node signedNode = signature.getDocument().getDocumentElement();
                Node importedNode = document.importNode(signedNode, true);
                Node parentNode = nodeToSign.getParentNode();
				LOGGER.debug(parentNode + " parb node");
                parentNode.removeChild(nodeToSign);
                parentNode.appendChild(importedNode);
				LOGGER.debug(parentNode + " par node");
            }
        }
    }
}
