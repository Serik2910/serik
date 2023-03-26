package soap.start.serik.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import kz.bee.bip.SyncChannel.v10.Interfaces.*;

import kz.bee.bip.SyncChannel.v10.Interfaces.ISyncChannel;
import kz.bee.bip.SyncChannel.v10.Interfaces.ISyncChannelHttpService;
import kz.bee.bip.SyncChannel.v10.Interfaces.RequestData;
import kz.bee.bip.SyncChannel.v10.Interfaces.ResponseData;
import kz.bee.bip.SyncChannel.v10.Interfaces.SenderInfo;
import kz.bee.bip.SyncChannel.v10.Interfaces.StatusInfo;
import kz.bee.bip.SyncChannel.v10.Interfaces.SyncMessageInfo;
import kz.bee.bip.SyncChannel.v10.Interfaces.SyncMessageInfoResponse;
import kz.bee.bip.SyncChannel.v10.Interfaces.SyncSendMessageRequest;
import kz.bee.bip.SyncChannel.v10.Interfaces.SyncSendMessageResponse;
import kz.bee.bip.esedo.*;
import kz.bee.bip.esedo.DocOutgoing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soap.start.serik.Utils.EsedoConnection;
import soap.start.serik.models.DocOutgoingDTO;
import soap.start.serik.service.DocOutgoingService;
import soap.start.serik.service.IDocOutgoingService;

import javax.xml.bind.JAXB;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.io.StringWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import static soap.start.serik.models.Const.*;

@RestController
@RequestMapping("/doc")
public class DocController {

    private static final Logger LOG = LogManager.getLogger(DocController.class);

    @Autowired
    private IDocOutgoingService docOutgoingService;
    @PostMapping(
            value = "/uploadStateDelivered",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SyncSendMessageResponse> uploadStateDelivered(
            @RequestBody StateDelivered stateDelivered,
            @RequestHeader (HttpHeaders.CONTENT_TYPE) String type) {
        SyncSendMessageResponse syncSendMessageResponse =  logAndSend(stateDelivered, type);
        HttpHeaders httpHeader = getHeader(type);
        return new ResponseEntity<SyncSendMessageResponse>(syncSendMessageResponse, httpHeader, HttpStatus.OK);
    }
    @PostMapping(
            value = "/uploadStateRegistered",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SyncSendMessageResponse> uploadStateRegistered(
            @RequestBody StateRegistered stateRegistered,
            @RequestHeader (HttpHeaders.CONTENT_TYPE) String type) {
        SyncSendMessageResponse syncSendMessageResponse =  logAndSend(stateRegistered, type);
        HttpHeaders httpHeader = getHeader(type);
        return new ResponseEntity<SyncSendMessageResponse>(syncSendMessageResponse, httpHeader, HttpStatus.OK);
    }

    @PostMapping(
            value = "/uploadStateNotValid",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SyncSendMessageResponse> uploadStateNotValid(
            @RequestBody StateNotValid stateNotValid,
            @RequestHeader (HttpHeaders.CONTENT_TYPE) String type) {
        SyncSendMessageResponse syncSendMessageResponse =  logAndSend(stateNotValid, type);
        HttpHeaders httpHeader = getHeader(type);
        return new ResponseEntity<SyncSendMessageResponse>(syncSendMessageResponse, httpHeader, HttpStatus.OK);
    }

    @PostMapping(
            value = "/uploadStateExecution",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SyncSendMessageResponse> uploadStateExecution(
            @RequestBody StateExecution stateExecution,
            @RequestHeader (HttpHeaders.CONTENT_TYPE) String type) {
        SyncSendMessageResponse syncSendMessageResponse =  logAndSend(stateExecution, type);
        HttpHeaders httpHeader = getHeader(type);
        return new ResponseEntity<SyncSendMessageResponse>(syncSendMessageResponse, httpHeader, HttpStatus.OK);
    }

    @PostMapping(
            value = "/uploadStateFinished",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SyncSendMessageResponse> uploadStateFinished(
            @RequestBody StateFinished stateFinished,
            @RequestHeader (HttpHeaders.CONTENT_TYPE) String type) {
        SyncSendMessageResponse syncSendMessageResponse =  logAndSend(stateFinished, type);
        HttpHeaders httpHeader = getHeader(type);
        return new ResponseEntity<SyncSendMessageResponse>(syncSendMessageResponse, httpHeader, HttpStatus.OK);
    }
    @PostMapping(
            value = "/uploadDocOL",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SyncSendMessageResponse> uploadDocOL(
            @RequestBody DocOL docOL,
            @RequestHeader (HttpHeaders.CONTENT_TYPE) String type) {
        SyncSendMessageResponse syncSendMessageResponse =  logAndSend(docOL, type);
        HttpHeaders httpHeader = getHeader(type);
        return new ResponseEntity<SyncSendMessageResponse>(syncSendMessageResponse, httpHeader, HttpStatus.OK);
    }


    @PostMapping(
            value = "/uploadDoc",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SyncSendMessageResponse> uploadDoc(
            @RequestBody DocOutgoing docOutgoing,
            @RequestHeader (HttpHeaders.CONTENT_TYPE) String type) {
        SyncSendMessageResponse syncSendMessageResponse =  logAndSend(docOutgoing, type);
        HttpHeaders httpHeader = getHeader(type);
        DocOutgoingDTO docOutgoingDTO = new DocOutgoingDTO(docOutgoing);
        if (syncSendMessageResponse!=null) {
            boolean isSent = syncSendMessageResponse.getResponseInfo().getStatus().getCode() != "SCSE001";
            docOutgoingDTO.setIsSent(isSent);
        }else{
            docOutgoingDTO.setIsSent(false);
        }
        docOutgoingService.save(docOutgoingDTO);
        return new ResponseEntity<SyncSendMessageResponse>(syncSendMessageResponse, httpHeader, HttpStatus.OK);
    }
    private HttpHeaders getHeader(String type){
        final HttpHeaders httpHeader= new HttpHeaders();
        switch (type){
            case MediaType.APPLICATION_XML_VALUE:
                httpHeader.setContentType(MediaType.APPLICATION_XML);
                break;
            case MediaType.APPLICATION_JSON_VALUE:
                httpHeader.setContentType(MediaType.APPLICATION_JSON);
                break;
        }
        return httpHeader;
    }
    private SyncSendMessageResponse logAndSend(Message message, String type){
        SyncSendMessageResponse syncSendMessageResponse = null;

        LOG.info("Incoming message");
        try {
            switch (type){
                case MediaType.APPLICATION_XML_VALUE:
                    StringWriter sw = new StringWriter();
                    JAXB.marshal(message,sw);
                    String xmlStringToLog = sw.toString();
                    LOG.info(xmlStringToLog);
                    break;
                case MediaType.APPLICATION_JSON_VALUE:
                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String json = ow.writeValueAsString(message);
                    LOG.info(json);
                    break;
            }
            syncSendMessageResponse = sendSyncMessage(message);

        } catch (DatatypeConfigurationException e) {
            LOG.error("Error on request : "+ e.getMessage());

        } catch (JsonProcessingException e) {
            LOG.error("Error on JSON request : "+ e.getMessage());
        }
        return syncSendMessageResponse;
    }

    private SyncSendMessageResponse sendSyncMessage(Message data) throws DatatypeConfigurationException {
        SyncSendMessageResponse response = new SyncSendMessageResponse();
        String uuid = UUID.randomUUID().toString();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date());
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        try {
            SyncSendMessageRequest request = new SyncSendMessageRequest();

            SyncMessageInfo messageInfo = new
                    SyncMessageInfo();
            SenderInfo senderInfo = new SenderInfo();
            messageInfo.setServiceId(DOCUMENT_STATE_SERVICE_ID);
            messageInfo.setRouteId(DOCUMENT_STATE_ROUTE_ID);
            messageInfo.setMessageId(data.getMetadataSystem().getHref());
            messageInfo.setSessionId(data.getMetadataSystem().getActivityId());
            messageInfo.setMessageDate(xmlGregorianCalendar);
            senderInfo.setSenderId(SENDER_ID);
            senderInfo.setPassword(SENDER_PASS);
            messageInfo.setSender(senderInfo);
            request.setRequestInfo(messageInfo);
            RequestData requestData = new RequestData();
            requestData.setData(data);
            request.setRequestData(requestData);
            ISyncChannelHttpService service = new ISyncChannelHttpService();
            ISyncChannel iSyncChannelPort = service.getSyncChannelHttpPort();
            EsedoConnection.setEndpointAddress(iSyncChannelPort);
            response = iSyncChannelPort.sendMessage(request);
            LOG.info("response = " +response.getResponseInfo().getResponseDate());
        }catch (Exception e){
            SyncMessageInfoResponse messageInfoResponse = new SyncMessageInfoResponse();
            StatusInfo statusInfo = new  StatusInfo();
            statusInfo.setCode("SCSE001");
            statusInfo.setMessage(e.getMessage());
            messageInfoResponse.setStatus(statusInfo);
            messageInfoResponse.setSessionId(uuid);
            messageInfoResponse.setMessageId(uuid);
            messageInfoResponse.setResponseDate(xmlGregorianCalendar);
            response.setResponseInfo(messageInfoResponse);
            ResponseData responseData = new ResponseData();
            responseData.setData(e.getMessage());
            response.setResponseData(responseData);
            LOG.info("end of exception response " + e.getMessage());
            e.printStackTrace();
        }
        return response;
    }


}
