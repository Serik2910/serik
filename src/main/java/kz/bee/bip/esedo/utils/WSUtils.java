package kz.bee.bip.esedo.utils;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;


public class WSUtils {
    private static final Logger LOGGER = LogManager.getLogger(WSUtils.class);

    /**
     * VFigurov 151006 - иногда (при "кривой" WSDL ?, в некоторых версиях Веблоджика? ) SOAPHeader & SOAPBody имеют разные имена намеспэйсов (но значения этих намеспэйсов - одинаковые)
     * и есть возможность принудительно сменить наймспас на требуемый
     * - хотя валидатор XML DSign обрабатывает такое XML вполне нормально...
     * - но у некоторых Партнеров сервисы/клиенты отказываются работать с разными "намеспасями"
     *
     * @message - SOAPMessage object
     * @return -
     */
    public static SOAPMessage cleanDuplicateXMLNS(SOAPMessage message) throws SOAPException {
        LOGGER.debug("Invoke");
        String msg_modified = "unmodified";
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        SOAPHeader header = envelope.getHeader();
        if (header != null) {
            String envelope_pref = envelope.getPrefix();
            String header_pref = header.getPrefix();
            if (envelope_pref == null || header_pref == null || !envelope_pref.equals(header_pref)) {
                if (envelope_pref == null) {
                    LOGGER.warn("Envelope prefix is NULL!");
                } else if (header_pref == null) {
                    LOGGER.warn("Header prefix is NULL!");
                } else {
                    // а это - нормально
                    msg_modified = "modified";
                    LOGGER.debug("Need repair: Envelops and Header prefixes - is NOT equials! header_pref: \"" + header_pref + "\", envelope_pref: \"" + envelope_pref + "\"");
                    header.setPrefix(envelope_pref);
                    // удалить дубликат из SOAPEnvelope
                    envelope.removeNamespaceDeclaration(header_pref);
                    LOGGER.info("duplicate Prefix \"" + header_pref + "\" removed");
                }
            } else {
                LOGGER.debug("Envelops and Header prefixes - is equials: \"" + header_pref + "\"");
            }
        }
        LOGGER.debug("Finish, SOAPMessage is " + msg_modified);

        return message;
    }
}

