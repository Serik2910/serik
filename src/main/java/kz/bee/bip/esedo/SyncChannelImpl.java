package kz.bee.bip.esedo;



import org.springframework.stereotype.Service;
import simbase.SbapiResponse;
import soap.start.serik.models.*;
import soap.start.serik.service.IxmlDsigUtil;
import soap.start.serik.service.SimbaseClientService;


import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.StringReader;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

@WebService(
        serviceName = "ria",
        targetNamespace = "http://bip.bee.kz/SyncChannel/v10/Interfaces",
        endpointInterface = "kz.bee.bip.esedo.ISyncChannel",
        portName = "SyncChannelHttpPort"
)
@Service
public class SyncChannelImpl implements ISyncChannel {
    private final SimbaseClientService service;
    private final IxmlDsigUtil dsigUtil;
    public SyncChannelImpl(SimbaseClientService service, IxmlDsigUtil dsigUtil) {
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
        boolean error=false;
        if(data instanceof Message){
            Message message = (Message) data;
            Long id = message.getMetadataSystem().getPerformers().get(0);
            SimbaseClient simbaseClient = null;
            if(id != null && service!=null){
                simbaseClient = service.findFirstClient(id);
                if (simbaseClient== null){
                    simbaseClient = service.findFirstClient(17466374L);
                }
                String response = simbaseClient.sendDocToSimbase(request);
                StringReader stringReader = new StringReader(response);
                JAXBContext jaxbContext  = JAXBContext.newInstance(SbapiResponse.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                SbapiResponse sbapiResponse = (SbapiResponse) unmarshaller.unmarshal(stringReader);
                String simbaseError = sbapiResponse.getHeader().getError().getId();
                String receiveError = sbapiResponse.getBody().getStatus();
                if (!Objects.equals(simbaseError, "0") || receiveError.equals("0")){
                    error=true;
                }
                if (data instanceof DocOutgoing){
                    DocOutgoingDTO docOutgoingDTO = new DocOutgoingDTO((DocOutgoing) data);
                    docOutgoingDTO.setIsSent(!error);
                    service.saveDocOutgoing(docOutgoingDTO);
                }
                if (data instanceof DocAppeal){
                    DocAppealDTO docAppealDTO = new DocAppealDTO((DocAppeal) data);
                    docAppealDTO.setIsSent(!error);
                    service.saveDocAppeal(docAppealDTO);
                }
                if (data instanceof DocOL){
                    DocOLDTO docOLDTO = new DocOLDTO((DocOL) data);
                    docOLDTO.setIsSent(!error);
                    service.saveDocOL(docOLDTO);
                }
                if (data instanceof StateDelivered){
                    StateDeliveredDTO stateDeliveredDTO = new StateDeliveredDTO((StateDelivered) data);
                    stateDeliveredDTO.setIsSent(!error);
                    service.saveStateDelivered(stateDeliveredDTO);
                }
                if (data instanceof StateRegistered){
                    StateRegisteredDTO stateRegisteredDTO = new StateRegisteredDTO((StateRegistered) data);
                    stateRegisteredDTO.setIsSent(!error);
                    service.saveStateRegistered(stateRegisteredDTO);
                }
                if (data instanceof StateNotValid){
                    StateNotValidDTO stateNotValidDTO = new StateNotValidDTO((StateNotValid) data);
                    stateNotValidDTO.setIsSent(!error);
                    service.saveStateNotValid(stateNotValidDTO);
                }
                if (data instanceof DocSection){
                    DocSectionDTO docSectionDTO = new DocSectionDTO((DocSection) data);
                    docSectionDTO.setIsSent(!error);
                    service.saveDocSection(docSectionDTO);
                }
                if (data instanceof StateExecution){
                    StateExecutionDTO stateExecutionDTO = new StateExecutionDTO((StateExecution) data);
                    stateExecutionDTO.setIsSent(!error);
                    service.saveStateExecution(stateExecutionDTO);
                }
                if (data instanceof StateFinished){
                    StateFinishedDTO stateFinishedDTO = new StateFinishedDTO((StateFinished) data);
                    stateFinishedDTO.setIsSent(!error);
                    service.saveStateFinished(stateFinishedDTO);
                }
                if (data instanceof StateNewControl){
                    StateNewControlDTO stateNewControlDTO = new StateNewControlDTO((StateNewControl) data);
                    stateNewControlDTO.setIsSent(!error);
                    service.saveStateNewControl(stateNewControlDTO);
                }
                if (data instanceof StateNewExDate){
                    StateNewExDateDTO stateNewExDateDTO = new StateNewExDateDTO((StateNewExDate) data);
                    stateNewExDateDTO.setIsSent(!error);
                    service.saveStateNewExDate(stateNewExDateDTO);
                }
                if (data instanceof StateProlongExDate){
                    StateProlongExDateDTO stateProlongExDateDTO = new StateProlongExDateDTO((StateProlongExDate) data);
                    stateProlongExDateDTO.setIsSent(!error);
                    service.saveStateProlongExDate(stateProlongExDateDTO);
                }
                if (data instanceof StateTakeOfControl){
                    StateTakeOfControlDTO stateTakeOfControlDTO = new StateTakeOfControlDTO((StateTakeOfControl) data);
                    stateTakeOfControlDTO.setIsSent(!error);
                    service.saveStateTakeOfControl(stateTakeOfControlDTO);
                }
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
