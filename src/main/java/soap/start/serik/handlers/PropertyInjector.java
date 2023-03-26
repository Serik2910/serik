package soap.start.serik.handlers;


import kz.gov.pki.kalkan.asn1.pkcs.PKCSObjectIdentifiers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.ws.security.message.token.SecurityTokenReference;


import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.algorithms.SignatureAlgorithm;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.encryption.XMLCipherParameters;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.transforms.params.InclusiveNamespaces;
import org.apache.xml.security.utils.Constants;
import org.apache.xml.security.utils.XMLUtils;
import com.sun.xml.messaging.saaj.soap.SOAPDocumentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.w3c.dom.*;
import soap.start.serik.service.KeyStoreFileAdapter;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

public class PropertyInjector implements SOAPHandler<SOAPMessageContext> {
    private static final Logger LOGGER= LogManager.getLogger(PropertyInjector.class);
    private static final String WSU_NAMESPACE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
    private static final String ENV_NAMESPACE = "http://schemas.xmlsoap.org/soap/envelope/";
    private static KeyStoreFileAdapter adapter;
    private static Properties properties;
    static {
        try {
            properties = loadProperties("application.properties");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        String storefileUrl = properties.getProperty("p12.file.location");
        String storepass = properties.getProperty("p12.file.password");
        String alias = properties.getProperty("p12.file.alias");
        String storetype = properties.getProperty("p12.file.type");
        try {
           adapter = new KeyStoreFileAdapter(storefileUrl, storepass,alias,storetype);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static Properties loadProperties(String resourceFileName) throws IOException {
        Properties configuration = new Properties();
        InputStream inputStream = PropertyInjector.class
                .getClassLoader()
                .getResourceAsStream(resourceFileName);
        configuration.load(inputStream);
        inputStream.close();
        return configuration;
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        LOGGER.info("***handleMessage***");
        logSoapMessage(context);
        Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        SOAPMessage message = context.getMessage();
        final String signMethod;
        final String digestMethod;
        // If it is an outgoing message
        if (outboundProperty) {

            try {
                Class.forName("kz.gov.pki.kalkan.jce.X509Principal");
                //Class.forName("com.sun.xml.messaging.saaj.soap.SOAPDocumentImpl");
                SOAPPart soappart = message.getSOAPPart();
                SOAPEnvelope env = soappart.getEnvelope();

                SOAPBody body = env.getBody();
                Document document = env.getOwnerDocument();

                StringWriter os = new StringWriter();
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer trans = tf.newTransformer();
//                trans.transform(new DOMSource(document), new StreamResult(os));
//                os.close();
//                System.out.println(os.toString());
                WSSecHeader secHeader = new WSSecHeader(document);
                secHeader.setMustUnderstand(true);

                secHeader.insertSecurityHeader();
                os = new StringWriter();
                trans.transform(new DOMSource(document), new StreamResult(os));
                os.close();
                System.out.println(os.toString());
                String bodyId = "id-"+ UUID.randomUUID().toString();
                String prefix = "wsu";
                for (int i = 0; i < secHeader.getSecurityHeaderElement().getAttributes().getLength(); i++) {
                    Attr attr = (Attr) secHeader.getSecurityHeaderElement().getAttributes().item(i);
                    if (WSU_NAMESPACE.equals(attr.getNamespaceURI())) {
                        prefix = attr.getName();
                    }
                }
                body.addAttribute(new QName(WSU_NAMESPACE, "Id", prefix),  bodyId);
                body.setIdAttributeNS(WSU_NAMESPACE, "Id", true);

                SOAPHeader header = env.getHeader();
                if (header == null) {
                    header = env.addHeader();
                }
                X509Certificate x509Certificate = (X509Certificate) adapter.getKeyStore().getCertificate(adapter.getAlias());
                PrivateKey privateKey = (PrivateKey) adapter.getKeyStore().getKey(adapter.getAlias(), adapter.getStorepass().toCharArray());
                String sigAlgOid = x509Certificate.getSigAlgOID();
                if (sigAlgOid.equals(PKCSObjectIdentifiers.sha1WithRSAEncryption.getId())) {
                    LOGGER.info("Algorithm signature: " + "rsa-sha1");
                    signMethod = Constants.MoreAlgorithmsSpecNS + "rsa-sha1";
                    digestMethod = Constants.MoreAlgorithmsSpecNS + "sha1";
                } else if (sigAlgOid.equals(PKCSObjectIdentifiers.sha256WithRSAEncryption.getId())) {
                    LOGGER.info("Algorithm signature: " + "rsa-sha256");
                    signMethod = Constants.MoreAlgorithmsSpecNS + "rsa-sha256";
                    digestMethod = XMLCipherParameters.SHA256;
                } else {
                    LOGGER.info("Algorithm signature: " + "gost34310-gost34311");
                    signMethod = Constants.MoreAlgorithmsSpecNS + "gost34310-gost34311";
                    digestMethod = Constants.MoreAlgorithmsSpecNS + "gost34311";
                }
                Document doc = document;
                //transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
                SignatureAlgorithm signatureAlgorithm = new SignatureAlgorithm(doc,signMethod);
                Element canonicalizationElement =  XMLUtils.createElementInSignatureSpace(doc, "CanonicalizationMethod");
                canonicalizationElement.setAttributeNS((String)null, "Algorithm", Canonicalizer.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);
                InclusiveNamespaces inclusiveNamespaces = new InclusiveNamespaces(doc, "soap");
                canonicalizationElement.appendChild(inclusiveNamespaces.getElement());
                XMLSignature sig = new XMLSignature(doc, "",  signatureAlgorithm.getElement(), canonicalizationElement);
                Transforms transforms = new Transforms(env.getOwnerDocument());
                //transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE,);
                InclusiveNamespaces inclusiveNamespaces_ = new InclusiveNamespaces(sig.getDocument(), "");
                transforms.addTransform(Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS, inclusiveNamespaces_.getElement() );

                //transforms.getElement().appendChild(inclusiveNamespaces_.getElement());
                sig.addDocument("#" + bodyId, transforms, digestMethod);
                sig.getSignedInfo().getSignatureMethodElement().setNodeValue(Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS);
//                sig.addKeyInfo(x509Certificate);
                secHeader.setSecurityHeaderElement(sig.getElement());
                header.getFirstChild().appendChild(secHeader.getSecurityHeaderElement());

                SecurityTokenReference reference = new SecurityTokenReference(doc);
                reference.setKeyIdentifier(x509Certificate);
                sig.getKeyInfo().addUnknownElement(reference.getElement());

                sig.sign(privateKey);
                os = new StringWriter();
                trans.transform(new DOMSource(doc), new StreamResult(os));
                os.close();
                LOGGER.info(os.toString());


            }  catch (SOAPException e) {
                LOGGER.debug("SOAPException " + e.getMessage());
            } catch (Exception e) {
                LOGGER.debug("OtherException " + e.getMessage());
            }

        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        LOGGER.info("***handleFault***");
        this.logSoapMessage(context);
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }
    private void logSoapMessage(SOAPMessageContext context) {
        Boolean isOutbound = (Boolean)context.get("javax.xml.ws.handler.message.outbound");
        SOAPMessage message = context.getMessage();

        try {
            LOGGER.info("-------------------------------------- \n");
            if (isOutbound) {
                LOGGER.info("Outbound message:");
            } else {
                LOGGER.info("Inbound message:");
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            message.writeTo(outputStream);
            LOGGER.info(outputStream);
            LOGGER.info("\n--------------------------------------");
        } catch (SOAPException se) {
            LOGGER.trace("Error while logging: " + se.getMessage());
        } catch (IOException ioe) {
            LOGGER.trace("Error while logging: " + ioe.getMessage());
        }

    }
}
