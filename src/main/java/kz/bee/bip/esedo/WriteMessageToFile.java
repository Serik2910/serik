package kz.bee.bip.esedo;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class WriteMessageToFile {

    public void writeMessage(SOAPMessage message, String boundType) throws IOException, SOAPException {
       //FileOutputStream fos = new FileOutputStream(new File(
         //       String.format("/Users/janalinov/Desktop/308/logmsg/%s_%s.xml", boundType,
           //            UUID.randomUUID().toString())));
         FileOutputStream fos = new FileOutputStream(new File(
                String.format("/home/simbase/%s_%s.xml", boundType,
                        UUID.randomUUID().toString())));
        message.writeTo(fos);
        fos.close();
    }
}
