package soap.start.serik.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.xml.transform.StringResult;
import org.w3c.dom.Node;
import soap.start.serik.handlers.PropertyInjector;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

public class NodeToStringTransformer {
    private static final Logger LOGGER= LogManager.getLogger(PropertyInjector.class);
    public static DatatypeFactory DATATYPE_FACTORY = null;

    static {
        try {
            DATATYPE_FACTORY = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            LOGGER.error("Error on transform: "+e);
        }
    }

    public static final Integer INTEGER_TRUE = 1;

    private static final TransformerFactory transformerFactory = TransformerFactory.newInstance();

    public static String getStringFromNode(Node node) throws TransformerException {
        Result result = new StringResult();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(node), result);
        return result.toString();
    }
}
