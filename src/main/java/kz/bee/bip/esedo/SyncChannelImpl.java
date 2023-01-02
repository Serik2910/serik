package kz.bee.bip.esedo;



import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;


import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

@WebService(
        serviceName = "ria",
        targetNamespace = "http://bip.bee.kz/SyncChannel/v10/Interfaces",
        endpointInterface = "kz.bee.bip.esedo.ISyncChannel",
        portName = "SyncChannelHttpPort"
)
public class SyncChannelImpl implements ISyncChannel {
    @Override
    public SyncSendMessageResponse sendMessage(SyncSendMessageRequest request) throws SendMessageSendMessageFaultMsg {
        SyncSendMessageResponse messageResponse = new SyncSendMessageResponse();
        SyncMessageInfoResponse responseInfo = new SyncMessageInfoResponse();
        responseInfo.setMessageId("response.setMessageId");
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        try {
            XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            responseInfo.setResponseDate(date2);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
        responseInfo.setSessionId("response.setSessionId");
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setCode("statusInfo.setCode");
        statusInfo.setMessage("statusInfo.setMessage");
        responseInfo.setStatus(statusInfo);
        responseInfo.setCorrelationId("response.setCorrelationId");
        messageResponse.setResponseInfo(responseInfo);
        ResponseData responseData = new ResponseData();
        responseData.setData(request.getRequestData());
        messageResponse.setResponseData(responseData);
        return messageResponse;
    }

}
