package kz.bee.bip.esedo.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.*;

public class XMLSerialize {

    /**
     * Convert a string to an object of a given class.
     *
     * @param cl Type of object
     * @param s Input string
     * @return Object of the given type
     * @throws JAXBException
     */
    public static <T> T unmarshal(Class<T> cl, String s) throws JAXBException
    {
        return unmarshal(cl, new StringReader(s));
    }

    /**
     * Convert the contents of a file to an object of a given class.
     *
     * @param cl Type of object
     * @param f File to be read
     * @return Object of the given type
     * @throws JAXBException
     */
    public static <T> T unmarshal(Class<T> cl, File f) throws JAXBException
    {
        return unmarshal(cl, new StreamSource(f));
    }

    /**
     * Convert the contents of a Reader to an object of a given class.
     *
     * @param cl Type of object
     * @param r Reader to be read
     * @return Object of the given type
     * @throws JAXBException
     */
    public static <T> T unmarshal(Class<T> cl, Reader r) throws JAXBException
    {
        return unmarshal(cl, new StreamSource(r));
    }

    /**
     * Convert the contents of an InputStream to an object of a given
     * class.
     *
     * @param cl Type of object
     * @param s InputStream to be read
     * @return Object of the given type
     * @throws JAXBException
     */
    public static <T> T unmarshal(Class<T> cl, InputStream s) throws JAXBException
    {
        return unmarshal(cl, new StreamSource(s));
    }

    /**
     * Convert the contents of a Source to an object of a given class.
     *
     * @param cl Type of object
     * @param s Source to be used
     * @return Object of the given type
     * @throws JAXBException
     */
    public static <T> T unmarshal(Class<T> cl, Source s) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(cl);
        Unmarshaller u = ctx.createUnmarshaller();
        return u.unmarshal(s, cl).getValue();
    }

    /**
     * Converts the contents of the string to a List with objects of
     * the given class.
     *
     * @param cl Type to be used
     * @param s Input string
     * @return List with objects of the given type
     * @throws JAXBException
     */
    public static <T> List<T> unmarshalCollection(Class<T> cl, String s) throws JAXBException
    {
        return unmarshalCollection(cl, new StringReader(s));
    }

    /**
     * Converts the contents of the Reader to a List with objects of
     * the given class.
     *
     * @param cl Type to be used
     * @param r Input
     * @return List with objects of the given type
     * @throws JAXBException
     */
    public static <T> List<T> unmarshalCollection(Class<T> cl, Reader r) throws JAXBException
    {
        return unmarshalCollection(cl, new StreamSource(r));
    }

    /**
     * Converts the contents of the InputStream to a List with objects
     * of the given class.
     *
     * @param cl Type to be used
     * @param s Input
     * @return List with objects of the given type
     * @throws JAXBException
     */
    public static <T> List<T> unmarshalCollection(Class<T> cl, InputStream s) throws JAXBException
    {
        return unmarshalCollection(cl, new StreamSource(s));
    }

    /**
     * Converts the contents of the Source to a List with objects of
     * the given class.
     *
     * @param cl Type to be used
     * @param s Input
     * @return List with objects of the given type
     * @throws JAXBException
     */
    @SuppressWarnings("all")
    public static <T> List<T> unmarshalCollection(Class<T> cl, Source s) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(JAXBCollection.class, cl);
        Unmarshaller u = ctx.createUnmarshaller();
        JAXBCollection<T> collection = u.unmarshal(s, JAXBCollection.class).getValue();
        return collection.getItems();
    }

    /**
     * Convert the contents of a Source to an object of a given class.
     *
     * @param cl Type of object
     * @param s Source to be used
     * @return Object of the given type
     * @throws JAXBException
     */
    public static <T> T unmarshal(Class<T> cl, Node s) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(cl);
        Unmarshaller u = ctx.createUnmarshaller();
        return u.unmarshal(s, cl).getValue();
    }

    /**
     * Convert an object to a string.
     *
     * @param obj Object that needs to be serialized / marshalled.
     * @return String representation of obj
     * @throws JAXBException
     */
    public static <T> String marshal(T obj) throws JAXBException
    {
        StringWriter sw = new StringWriter();
        marshal(obj, sw);
        return sw.toString();
    }

    public static <T> String marshal(T obj, Map<String, ?> props) throws JAXBException
    {
        StringWriter sw = new StringWriter();
        marshal(obj, sw, props);
        return sw.toString();
    }

    /**
     * Convert an object to a string and send it to a Writer.
     *
     * @param obj Object that needs to be serialized / marshalled
     * @param wr Writer used for outputting the marshalled object
     * @throws JAXBException
     */
    public static <T> void marshal(T obj, Writer wr) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(obj.getClass());
        Marshaller m = ctx.createMarshaller();
        m.marshal(obj, wr);
    }

    public static <T> void marshal(T obj, Writer wr, Map<String, ?> props) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(new Class[] {obj.getClass()}, props);
        Marshaller m = ctx.createMarshaller();
        m.marshal(obj, wr);
    }

    public static <T> String marshal(JAXBElement<?> element, T obj, Map<String, ?> props) throws JAXBException
    {
        Class<?> clazz = obj.getClass();
        StringWriter sw = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz.getPackage().getName());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        // format the XML output
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(element, sw);

        return sw.toString();
    }

    /**
     * Convert an object to a string and save it to a File.
     *
     * @param obj Object that needs to be serialized / marshalled
     * @param f Save file
     * @throws JAXBException
     */
    public static <T> void marshal(T obj, File f) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(obj.getClass());
        Marshaller m = ctx.createMarshaller();
        m.marshal(obj, f);
    }

    /**
     * Convert an object to a string and send it to an OutputStream.
     *
     * @param obj Object that needs to be serialized / marshalled
     * @param s Stream used for output
     * @throws JAXBException
     */
    public static <T> void marshal(T obj, OutputStream s) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(obj.getClass());
        Marshaller m = ctx.createMarshaller();
        m.marshal(obj, s);
    }

    /**
     * @param element JAXB root element
     * @param obj Object that needs to be serialized / marshalled
     * @param <T> String representation of obj
     * @return
     * @throws JAXBException
     */
    public static <T> String marshal(JAXBElement<?> element, T obj) throws JAXBException
    {
        Class<?> clazz = obj.getClass();
        StringWriter sw = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz.getPackage().getName());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        // format the XML output
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(element, sw);

        return sw.toString();
    }

    /**
     * Convert a collection to a string.
     *
     * @param rootName Name of the XML root element
     * @param c Collection that needs to be marshalled
     * @return String representation of the collection
     * @throws JAXBException
     */
    public static <T> String marshal(String rootName, Collection<T> c) throws JAXBException
    {
        StringWriter sw = new StringWriter();
        marshal(rootName, c, sw);
        return sw.toString();
    }
    

    /**
     * Convert a collection to a string and sends it to the Writer.
     *
     * @param rootName Name of the XML root element
     * @param c Collection that needs to be marshalled
     * @param w Output
     * @throws JAXBException
     */
    public static <T> void marshal(String rootName, Collection<T> c, Writer w) throws JAXBException
    {
        // Create context with generic type
        JAXBContext ctx = JAXBContext.newInstance(findTypes(c));
        Marshaller m = ctx.createMarshaller();

        // Create wrapper collection
        JAXBElement<?> element = createCollectionElement(rootName, c);
        m.marshal(element, w);
    }

    /**
     * Convert a collection to a string and stores it in a File.
     *
     * @param rootName Name of the XML root element
     * @param c Collection that needs to be marshalled
     * @param f Output file
     * @throws JAXBException
     */
    public static <T> void marshal(String rootName, Collection<T> c, File f) throws JAXBException
    {
        // Create context with generic type
        JAXBContext ctx = JAXBContext.newInstance(findTypes(c));
        Marshaller m = ctx.createMarshaller();

        // Create wrapper collection
        JAXBElement<?> element = createCollectionElement(rootName, c);
        m.marshal(element, f);
    }

    /**
     * Convert a collection to a string and sends it to the
     * OutputStream.
     *
     * @param rootName Name of the XML root element
     * @param c Collection that needs to be marshalled
     * @param s Output
     * @throws JAXBException
     */
    public static <T> void marshal(String rootName, Collection<T> c, OutputStream s) throws JAXBException
    {
        // Create context with generic type
        JAXBContext ctx = JAXBContext.newInstance(findTypes(c));
        Marshaller m = ctx.createMarshaller();

        // Create wrapper collection
        JAXBElement<?> element = createCollectionElement(rootName, c);
        m.marshal(element, s);
    }

    /**
     * Discovers all the classes in the given Collection. These need
     * to be in the JAXBContext if you want to marshal those objects.
     * Unfortunatly there's no way of getting the generic type at
     * runtime.
     *
     * @param c Collection that needs to be scanned
     * @return Classes found in the collection, including
     * JAXBCollection.
     */
    protected static <T> Class<?>[] findTypes(Collection<T> c)
    {
        Set<Class<?>> types = new HashSet<>();
        types.add(JAXBCollection.class);
        for (T o : c)
        {
            if (o != null)
            {
                types.add(o.getClass());
            }
        }
        return types.toArray(new Class[0]);
    }

    /**
     * Create a JAXBElement containing a JAXBCollection. Needed for
     * marshalling a generic collection without a seperate wrapper
     * class.
     *
     * @param rootName Name of the XML root element
     * @param c
     * @return JAXBElement containing the given Collection, wrapped in
     * a JAXBCollection.
     */
    protected static <T> JAXBElement<?> createCollectionElement(String rootName, Collection<T> c)
    {
        JAXBCollection<?> collection = new JAXBCollection<>(c);
        return new JAXBElement<>(new QName(rootName), JAXBCollection.class, collection);
    }

	public static <T> Node marshal(T obj, Class<T> cl, boolean showNamespace) throws JAXBException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(showNamespace);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Marshaller m = JAXBContext.newInstance(cl).createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(obj, doc);
        return doc.getDocumentElement();
    }

    public static <T> Node marshal(T obj, Class<T> cl) throws JAXBException, ParserConfigurationException {
        return marshal(obj, cl, true);
    }

    public static Document cleanNameSpace(Document doc) {

        NodeList list = doc.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            removeNameSpace(list.item(i), "");
        }
        return doc;
    }

    public static void removeNameSpace(Node node, String nameSpaceURI) {
        removeNameSpace(node, nameSpaceURI, Collections.emptyList());
    }

    public static void removeNameSpace(Node node, String nameSpaceURI, List<String> names) {
        if (node.getNodeType() == Node.ELEMENT_NODE && !names.contains(node.getLocalName())) {
            Document ownerDoc = node.getOwnerDocument();
            NamedNodeMap map = node.getAttributes();
            Node n;
            int mapSize = map.getLength();
            for (int i = 0; i < mapSize; i++) {
                n = map.item(0);
                map.removeNamedItemNS(n.getNamespaceURI(), n.getLocalName());
            }
            ownerDoc.renameNode(node, nameSpaceURI, node.getLocalName());
        }
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            removeNameSpace(list.item(i), nameSpaceURI, names);
        }
    }
}
