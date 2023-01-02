package kz.bee.bip.esedo.wsshandler;

import kz.bee.bip.esedo.WSS4JSignRGP;
import kz.bee.bip.esedo.WriteMessageToFile;
import kz.bee.bip.esedo.utils.WSUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.HashSet;
import java.util.Set;

public class VerifySoap implements SOAPHandler<SOAPMessageContext> {

    private static String VERSION = "1.17.9.1";
    private static final Logger LOGGER = LogManager.getLogger(WSSSignHandle.class);

    @Override
    public Set<QName> getHeaders() {
        final HashSet<QName> headers = new HashSet<>();
        final QName securityHeader = new QName(
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
                "Security");
        headers.add(securityHeader);
        return headers;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext soapMessageContext) {
        //boolean outbound = (Boolean) soapMessageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        boolean outbound = true;
        //LOGGER.debug("Invoke, Outbound mode: " + outbound);

        SOAPMessage message = soapMessageContext.getMessage();
        try {
            //message = WSUtils.cleanDuplicateXMLNS(message);
            if (outbound) {
                //LOGGER.debug("before " + message.getSOAPPart().getOwnerDocument().getDocumentElement());
               // message = WSUtils.cleanDuplicateXMLNS( message);
                new WSS4JSignRGP().verifyMessage(message);
            } else {

            }
        } catch (Exception e) {
            LOGGER.error("", e); //распечатет весь стек-трэс
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext soapMessageContext) {
        LOGGER.info("Fault message");
        SOAPMessage message = soapMessageContext.getMessage();
        try {
            // Распечатаем исходящее сообщение
            new WriteMessageToFile().writeMessage(message, "fault");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return true;
    }

    @Override
    public void close(MessageContext messageContext) {}
}
