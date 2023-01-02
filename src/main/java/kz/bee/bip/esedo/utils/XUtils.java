package kz.bee.bip.esedo.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;

/**
 * Сборник XML utilites для целей Проекта
 *
 * Примечание: для вывода логов commons-logging использовать параметры запуска java:
 * -Dorg.apache.commons.logging.Log=org.apache.commons.logging.impl.SimpleLog -Dorg.apache.commons.logging.simplelog.defaultlog=debug
 */
public class XUtils {
    private static final Logger LOGGER = LogManager.getLogger(XUtils.class);

    public static Document createDocument(String filename) {
        Document d = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            d = db.parse(new FileInputStream(filename));
            return d;
        } catch (ParserConfigurationException e) {
            LOGGER.error(e.getMessage());
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (SAXException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return d;
    }

    public static Document createDocument(Node signNode) {
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            doc = documentBuilder.newDocument();
            Node importedNode = doc.importNode(signNode, true);
            doc.appendChild(importedNode);
            return doc;
        } catch (ParserConfigurationException e) {
            LOGGER.error(e.getMessage());
        }
        return doc;
    }

    public static Document createXmlDocumentFromString(String xmlString) {
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder documentBuilder;
            documentBuilder = dbf.newDocumentBuilder();
            doc = documentBuilder.parse(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
        } catch (ParserConfigurationException e) {
            LOGGER.error(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(e.getMessage());
        } catch (SAXException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return doc;
    }

    public static void dumpXMLDocument(Node doc) throws TransformerException {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            StringWriter os = new StringWriter();
            trans.transform(new DOMSource(doc), new StreamResult(os));
            LOGGER.debug(os.toString());
        } catch (TransformerConfigurationException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (TransformerException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    public static String nodeToString(Node doc) throws TransformerException {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            //            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            //            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            StringWriter os = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(os));
            return os.toString();
        } catch (TransformerConfigurationException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (TransformerException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    public static Node getNode(Document doc, String xpath) throws XPathExpressionException {
        XPath xPath =  XPathFactory.newInstance().newXPath();
        return (Node)xPath.compile(xpath).evaluate(doc, XPathConstants.NODE);
    }

    public static  Node cleanNameSpace(Node doc, String namespaceUri) {
        NodeList list = doc.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            removeNamSpace(list.item(i), namespaceUri);
        }
        return doc;
    }

    public static void removeNamSpace(Node node, String namespaceUri) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Document ownerDoc = node.getOwnerDocument();
            NamedNodeMap map = node.getAttributes();
            Node n = map.item(0);
            map.removeNamedItemNS(n.getNamespaceURI(), n.getLocalName());
            ownerDoc.renameNode(node, namespaceUri, node.getLocalName());
        }
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            removeNamSpace(list.item(i), namespaceUri);
        }
    }

    public static void cleanFistNode(Node node, String namespaceUri) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Document ownerDoc = node.getOwnerDocument();
            NamedNodeMap map = node.getAttributes();
            Node n = map.item(0);
            map.removeNamedItemNS(n.getNamespaceURI(), n.getLocalName());
            ownerDoc.renameNode(node, namespaceUri, node.getLocalName());
        }
    }
}
