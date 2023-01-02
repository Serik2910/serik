package kz.bee.bip.esedo.wsshandler;

import kz.bee.bip.esedo.WriteMessageToFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WSSLogHandle implements SOAPHandler<SOAPMessageContext>{

    private final static Logger LOGGER = LogManager.getLogger(WSSLogHandle.class);

    @Override
    public Set<QName> getHeaders() {
        final HashSet headers = new HashSet();
        final QName securityHeader = new QName(
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
                "Security");
        headers.add(securityHeader);
        return headers;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        if(context!=null) {
            boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
            LOGGER.debug("Invoke, bound mode: " + outbound);
            try {
                SOAPMessage message = context.getMessage();
                if (outbound) {
                    new WriteMessageToFile().writeMessage(message, "out");
                } else {
                    new WriteMessageToFile().writeMessage(message, "in");
                }
            } catch (SOAPException e) {
                LOGGER.error("Error clean duplicate namespace or write message in OutputStream: ", e);
            } catch (IOException e) {
                LOGGER.error("Error write message in file: ", e);
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        if(context!=null) {
            try {
                SOAPMessage message = context.getMessage();
                new WriteMessageToFile().writeMessage(message, "fault");
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
        return true;
    }



    @Override
    public void close(MessageContext context) {

    }
}
