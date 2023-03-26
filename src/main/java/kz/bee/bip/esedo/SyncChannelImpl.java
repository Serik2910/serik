package kz.bee.bip.esedo;



import org.springframework.stereotype.Service;
import simbase.SbapiResponse;
import soap.start.serik.models.SimbaseClient;
import soap.start.serik.service.IxmlDsigUtil;
import soap.start.serik.service.SimbasClientService;


import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.StringReader;
import java.util.Date;
import java.util.GregorianCalendar;

@WebService(
        serviceName = "ria",
        targetNamespace = "http://bip.bee.kz/SyncChannel/v10/Interfaces",
        endpointInterface = "kz.bee.bip.esedo.ISyncChannel",
        portName = "SyncChannelHttpPort"
)
@Service
public class SyncChannelImpl implements ISyncChannel {
    private final SimbasClientService service;
    private final IxmlDsigUtil dsigUtil;
    public SyncChannelImpl(SimbasClientService service, IxmlDsigUtil dsigUtil) {
        this.service = service;
        this.dsigUtil = dsigUtil;
    }

    public SyncChannelImpl() {
        this.dsigUtil = null;
        service = null;
    }

    @Override
    public SyncSendMessageResponse sendMessage(SyncSendMessageRequest request) throws
            Exception {
        Object data = request.getRequestData().getData();
        Boolean error=false;
        if(data instanceof Message){
            Message message = (Message) data;
            Long id = message.getMetadataSystem().getPerformers().get(0);
            SimbaseClient simbaseClient = null;
            if(id != null){
                simbaseClient = service.findFirst(id);
                if (simbaseClient== null){
                    simbaseClient = service.findFirst(17466374L);
                }
                String response = simbaseClient.sendDocToSimbase(request);
                StringReader stringReader = new StringReader(response);
                JAXBContext jaxbContext  = JAXBContext.newInstance(SbapiResponse.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                SbapiResponse sbapiResponse = (SbapiResponse) unmarshaller.unmarshal(stringReader);
                java.lang.System.out.println(response);
            }
            if (data instanceof DocOutgoing){

            }
        }


        SyncSendMessageResponse messageResponse = new SyncSendMessageResponse();
        SyncMessageInfoResponse responseInfo = new SyncMessageInfoResponse();
        responseInfo.setMessageId(request.getRequestInfo().getMessageId());

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());

        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        responseInfo.setResponseDate(date2);
        responseInfo.setSessionId(request.getRequestInfo().getMessageId());
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setCode("SCSS001");
        statusInfo.setMessage("Message has been processed successfully");
        responseInfo.setStatus(statusInfo);
        messageResponse.setResponseInfo(responseInfo);
        ResponseData responseData = new ResponseData();

        messageResponse.setResponseData(responseData);
        return messageResponse;
    }

}
