package soap.start.serik.handlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {
    private static final Logger LOG = LogManager.getLogger(PropertyInjector.class);

    public LoggingHandler() {
    }

    public boolean handleMessage(SOAPMessageContext context) {
        LOG.info("***handleMessage***");
        this.logSoapMessage(context);
        return true;
    }

    public boolean handleFault(SOAPMessageContext var1) {
        LOG.info("***handleFault***");
        this.logSoapMessage(var1);
        return false;
    }

    public void close(MessageContext var1) {
    }

    public Set<QName> getHeaders() {
        return new HashSet();
    }

    private void logSoapMessage(SOAPMessageContext context) {
        Boolean var2 = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        SOAPMessage message = context.getMessage();

        try {
            LOG.info("-------------------------------------- \n");
            if (var2) {
                LOG.info("Outbound message:");
            } else {
                LOG.info("Inbound message:");
            }
            SOAPPart soappart = message.getSOAPPart();
            SOAPEnvelope env = soappart.getEnvelope();
            Document document = env.getOwnerDocument();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(document);
            StringWriter os = new StringWriter();

            transformer.transform(source, new StreamResult(os));
            os.close();
            String result = os.toString();;
            LOG.info(result);
            LOG.info("\n--------------------------------------");
        } catch (SOAPException se) {
            LOG.trace("Error while logging: " + se.getMessage());
        } catch (IOException ie) {
            LOG.trace("Error while logging: " + ie.getMessage());
        } catch (TransformerConfigurationException e) {
            LOG.trace("Error on transforming for indent: " + e.getMessage());
        } catch (TransformerException e) {
            LOG.trace("Error while transforming: " + e.getMessage());
        }

    }
}
