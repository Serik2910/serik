package soap.start.serik.handlers;

import kz.gov.pki.kalkan.jce.provider.KalkanProvider;
import kz.gov.pki.kalkan.xmldsig.KncaXS;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.keys.keyresolver.KeyResolverException;

import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.signature.XMLSignatureException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.ByteArrayInputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.*;


public class PropertyValidator  implements SOAPHandler<SOAPMessageContext> {
    public static final String WSU_NAMESPACE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";

    private static final Logger LOGGER= LogManager.getLogger(PropertyValidator.class);

    @Override
    public Set<QName> getHeaders(){
        final HashSet<QName> headers = new HashSet<>();
        final QName securityHeader = new QName(
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
                "Security");
        headers.add(securityHeader);
        return headers;
    }
    static  {
        Security.addProvider(new KalkanProvider());
        KncaXS.loadXMLSecurity();
        org.apache.xml.security.Init.init();
        JCEMapper.setProviderId(KalkanProvider.PROVIDER_NAME);
    }
    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        System.out.println("Server executing SOAP Handler");
        boolean result = false;
        Boolean outBoundProperty = (Boolean) context
                .get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        // if this is an incoming message from the client
        if (!outBoundProperty) {
            try {
                // Get the SOAP Message and grab the headers
                SOAPMessage soapMsg = context.getMessage();
                SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
                SOAPHeader soapHeader = soapEnv.getHeader();
                SOAPBody soapBody = soapEnv.getBody();
                NodeList list = soapHeader.getElementsByTagName("ds:Signature");
                Element sigElement = null;
                // Grab an iterator to go through the headers
                Document doc = soapEnv.getOwnerDocument();
                // if there is no additional header
                int length = list.getLength();
                for (int i = 0; i < length; i++) {
                    Node sigNode = list.item(length - 1);
                    sigElement = (Element) sigNode;
                    if (sigElement == null) {
                        System.err.println("Bad signature: Element 'ds:Reference' is not found in XML document");
                    }
                    soapBody.setIdAttributeNS(WSU_NAMESPACE, "Id", true);
                    XMLSignature signature = new XMLSignature(sigElement, "");
                    KeyInfo ki = signature.getKeyInfo();

                    Element keyElement =ki.getElement();
                    NodeList nodeList = keyElement.getElementsByTagName("wsse:KeyIdentifier");
                    String certB64 = nodeList.item(0).getFirstChild().getNodeValue();
                    byte encodedCert[] = Base64.getDecoder().decode(certB64);
                    ByteArrayInputStream inputStream  =  new ByteArrayInputStream(encodedCert);
                    CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
                    X509Certificate x509Certificate = (X509Certificate)certFactory.generateCertificate(inputStream);

                    result = signature.checkSignatureValue(x509Certificate);
//                    System.out.println("check");
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                throw new RuntimeException(e);
            }
            if(!result){
                try {
                    return true;
                    //throw new Exception("signature header problem");
                } catch (Exception e) {
                    LOGGER.error(e.getMessage());
                    throw new RuntimeException(e);
                }
            }
            return result;
        }
        else{
            return true;
        }

    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        LOGGER.info("Fault message");
        SOAPMessage message = context.getMessage();
        SOAPBody body = null;
        try {
            body = message.getSOAPBody();
        } catch (SOAPException e) {
            throw new RuntimeException(e);
        }
        SOAPFault fault = body.getFault();
        String code = fault.getFaultCode();
        String faultString = fault.getFaultString();
        Detail detail = fault.getDetail();

        if(detail!=null){
            Iterator<SOAPElement> iter = detail.getChildElements();
            //Getting first level of detail
            HashMap<String, String> detailMap = new HashMap<String, String>();
            while(iter.hasNext()){
                SOAPElement element = iter.next();
                detailMap.put(element.getLocalName(), element.getValue());
            }
            LOGGER.debug(detailMap);
        }
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}
