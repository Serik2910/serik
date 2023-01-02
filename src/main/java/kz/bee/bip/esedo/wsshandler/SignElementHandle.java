package kz.bee.bip.esedo.wsshandler;

import kz.bee.bip.esedo.utils.WSUtils;
import kz.bee.bip.esedo.WriteMessageToFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Collections;
import java.util.Set;

public class SignElementHandle implements SOAPHandler<SOAPMessageContext>{

    private static final Logger LOGGER = LogManager.getLogger(SignXMLElement.class);

    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        LOGGER.debug("Invoke, Outbound mode: " + outbound);

        SOAPMessage message = context.getMessage();
        try {
            message = WSUtils.cleanDuplicateXMLNS(message);
            SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
            if (outbound) {
                new SignXMLElement().signed(envelope, "data");
            } else {

            }
        } catch (Exception e) {
            LOGGER.error("Error signed xml element: " + e.getMessage(), e);
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext soapMessageContext) {
        LOGGER.info("Fault message");
        SOAPMessage message = soapMessageContext.getMessage();
        try {
            new WriteMessageToFile().writeMessage(message, "fault");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}
