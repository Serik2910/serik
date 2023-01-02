package kz.bee.bip.esedo;

import kz.bee.bip.esedo.utils.WSUtils;
import kz.bee.bip.esedo.utils.XUtils;
import org.w3c.dom.Node;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Collections;
import java.util.Set;

/**
 * @author OldSpark on 03.02.2020
 */
public class SignEgovHandler implements SOAPHandler<SOAPMessageContext> {



    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        //LOGGER.debug("Invoke, Outbound mode: " + outbound);
        if (outbound) {
            SOAPMessage message = context.getMessage();
            try {
                WSUtils.cleanDuplicateXMLNS(message);
                SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
                Node dataNode = envelope.getOwnerDocument().getElementsByTagName("data").item(0);
                XUtils.cleanNameSpace(dataNode.getFirstChild(), "http://ipc.kz/emigration/egov/response/v1/Types");
                XUtils.cleanFistNode(dataNode, "");
                Node parentDataNode = dataNode.getParentNode();
                parentDataNode.removeChild(dataNode);
                parentDataNode.appendChild(dataNode);
                new SignXMLElement().signed(envelope,
                        message.getSOAPBody().getElementsByTagName("data").item(0).getFirstChild().getNodeName(), "1");
                //LOGGER.debug("envelope " + envelope.getOwnerDocument().getDocumentElement());
            } catch (Exception e) {
               // LOGGER.error("Error signed xml element: " + e.getMessage(), e);
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext soapMessageContext) {
        SOAPMessage message = soapMessageContext.getMessage();
        try {
            new WriteMessageToFile().writeMessage(message, "fault");
        } catch (Exception e) {
           // LOGGER.error(e.getMessage());
        }
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}
