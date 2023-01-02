package kz.bee.bip.esedo;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public class LogHandle implements SOAPHandler<SOAPMessageContext>{

    private final static Logger LOGGER = LogManager.getLogger(LogHandle.class);

    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        if(context!=null) {
            boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
            LOGGER.debug("Invoke, bound mode: " + outbound);
            SOAPMessage message = context.getMessage();
            try {
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
            SOAPMessage message = context.getMessage();
            try {
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
