package kz.bee.bip.esedo;

import kz.bee.bip.SyncChannel.v10.Types.SendMessage;
import kz.bee.bip.SyncChannel.v10.Types.request.SyncSendMessageRequest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class JaxbExample
{
    Object data;
    public JaxbExample(Object data){
        this.data = data;
    }
    String xmlContent;
    public  String jaxbObjectToXML(Object data)
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(SendMessage.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print XML String to Console
            StringWriter sw = new StringWriter();

            //Write XML to StringWriter
            jaxbMarshaller.marshal(data, sw);

            //Verify XML Content
             xmlContent = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlContent;
    }
}
