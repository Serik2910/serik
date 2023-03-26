package soap.start.serik.service;

public interface IxmlDsigUtil {
    String signXML(String xmlString);
    boolean verifyXml(String xmlString);

}
