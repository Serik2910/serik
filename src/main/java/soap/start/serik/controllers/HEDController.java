package soap.start.serik.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;



import kz.bee.bip.SyncChannel.v10.Types.StatusInfo;
import kz.bee.bip.SyncChannel.v10.Types.SyncMessageInfo;
import kz.bee.bip.SyncChannel.v10.Types.SyncMessageInfoResponse;
import kz.bee.bip.SyncChannel.v10.Types.request.RequestData;
import kz.bee.bip.SyncChannel.v10.Types.request.SyncSendMessageRequest;

import kz.bee.bip.SyncChannel.v10.Types.request.Data;
import kz.bee.bip.SyncChannel.v10.Types.response.ResponseData;
import kz.bee.bip.SyncChannel.v10.Types.response.SyncSendMessageResponse;


import kz.bee.egov.v2.tempstorage.eds.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import soap.start.serik.Utils.EsedoConnection;

import org.springframework.web.bind.annotation.*;
import soap.start.serik.models.UploadRequestDTO;

import javax.xml.bind.JAXB;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

import static soap.start.serik.models.Const.*;

@RestController
@RequestMapping("/hed")
public class HEDController {
    private static final Logger LOG = LogManager.getLogger(HEDController.class);

    @PostMapping(
            value = "/HEDUpload",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SyncSendMessageResponse> hedUpload(
            @RequestBody UploadRequestDTO uploadFilesDTO,
            @RequestHeader (HttpHeaders.CONTENT_TYPE) String type
    ){
        TempStorageRequest request = new TempStorageRequest();
        final HttpHeaders httpHeaders= new HttpHeaders();
        SyncSendMessageResponse syncSendMessageResponse = null;
        UploadRequest uploadRequest;
        LOG.info("Incoming message to upload to HED");
        try {
            uploadRequest = UploadRequestDTO.getUploadRequestFromDTO(uploadFilesDTO);
            UploadRequestDTO uploadFilesDTO_WO_Content = UploadRequestDTO.getUpRequest_WO_Content(uploadFilesDTO);
            request.setUploadRequest(uploadRequest);
            switch (type){
                case MediaType.APPLICATION_XML_VALUE:
                    StringWriter sw = new StringWriter();
                    JAXB.marshal(uploadFilesDTO_WO_Content,sw);
                    String xmlStringToLog = sw.toString();
                    httpHeaders.setContentType(MediaType.APPLICATION_XML);
                    LOG.info(xmlStringToLog);
                    break;
                case MediaType.APPLICATION_JSON_VALUE:
                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String json = ow.writeValueAsString(uploadFilesDTO_WO_Content);
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    LOG.info(json);
                    break;
            }
            SenderInfo senderInfo = new SenderInfo();
            senderInfo.setSenderId(SENDER_ID_CRED);
            senderInfo.setPassword(SENDER_PASS_CRED);
            request.setCredentials(senderInfo);
            request.setType(TempStorageRequestType.UPLOAD);
            syncSendMessageResponse = sendSyncMessage(request);


        } catch (DatatypeConfigurationException e) {
            LOG.error("Error on request : "+ e.getMessage());
        } catch (JsonProcessingException e) {
            LOG.error("Error on JSON request : "+ e.getMessage());
        } catch (UnsupportedEncodingException e) {
            LOG.error("Error on encoding request : "+ e.getMessage());
        }
        if(syncSendMessageResponse!=null) {
            StringWriter sw = new StringWriter();
            JAXB.marshal(syncSendMessageResponse, sw);
            String xmlStringToLog = sw.toString();
            httpHeaders.setContentType(MediaType.APPLICATION_XML);
            LOG.info(xmlStringToLog);
        }
        return new ResponseEntity<SyncSendMessageResponse>(syncSendMessageResponse,httpHeaders, HttpStatus.OK);
    }
    @PostMapping(
            value = "/HEDDownload",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SyncSendMessageResponse> hedDownload(
            @RequestBody DownloadRequest downloadRequest,
            @RequestHeader (HttpHeaders.CONTENT_TYPE) String type
    ){
        TempStorageRequest request = new TempStorageRequest();
        final HttpHeaders httpHeaders= new HttpHeaders();
        SyncSendMessageResponse syncSendMessageResponse = null;
        LOG.info("Incoming message to download from HED: ");
        try {
            request.setDownloadRequest(downloadRequest);
            switch (type){
                case MediaType.APPLICATION_XML_VALUE:
                    StringWriter sw = new StringWriter();
                    JAXB.marshal(downloadRequest,sw);
                    String xmlStringToLog = sw.toString();
                    httpHeaders.setContentType(MediaType.APPLICATION_XML);
                    LOG.info(xmlStringToLog);
                    break;
                case MediaType.APPLICATION_JSON_VALUE:
                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String json = ow.writeValueAsString(downloadRequest);
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    LOG.info(json);
                    break;
            }
            SenderInfo senderInfo = new SenderInfo();
            senderInfo.setSenderId(SENDER_ID_CRED);
            senderInfo.setPassword(SENDER_PASS_CRED);
            request.setCredentials(senderInfo);
            request.setType(TempStorageRequestType.DOWNLOAD);
            syncSendMessageResponse = sendSyncMessage(request);
        } catch (DatatypeConfigurationException e) {
            LOG.error("Error on request : "+ e.getMessage());
        } catch (JsonProcessingException e) {
            LOG.error("Error on JSON request : "+ e.getMessage());
        }
        
        return new ResponseEntity<SyncSendMessageResponse>(syncSendMessageResponse,httpHeaders, HttpStatus.OK);
    }

    @PostMapping(
            value = "/HEDFileInfo",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SyncSendMessageResponse> hedFileInfo(
            @RequestBody GetFileInfoRequest getFileInfoRequest,
            @RequestHeader (HttpHeaders.CONTENT_TYPE) String type
    ){
        TempStorageRequest request = new TempStorageRequest();
        final HttpHeaders httpHeaders= new HttpHeaders();
        SyncSendMessageResponse syncSendMessageResponse = null;
        LOG.info("Incoming message to download from HED: ");
        try {
            request.setGetFileInfoRequest(getFileInfoRequest);
            switch (type){
                case MediaType.APPLICATION_XML_VALUE:
                    StringWriter sw = new StringWriter();
                    JAXB.marshal(getFileInfoRequest,sw);
                    String xmlStringToLog = sw.toString();
                    httpHeaders.setContentType(MediaType.APPLICATION_XML);
                    LOG.info(xmlStringToLog);
                    break;
                case MediaType.APPLICATION_JSON_VALUE:
                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String json = ow.writeValueAsString(getFileInfoRequest);
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    LOG.info(json);
                    break;
            }
            SenderInfo senderInfo = new SenderInfo();
            senderInfo.setSenderId(SENDER_ID_CRED);
            senderInfo.setPassword(SENDER_PASS_CRED);
            request.setCredentials(senderInfo);
            request.setType(TempStorageRequestType.GET_FILE_INFO);
            syncSendMessageResponse = sendSyncMessage(request);
        } catch (DatatypeConfigurationException e) {
            LOG.error("Error on request : "+ e.getMessage());
        } catch (JsonProcessingException e) {
            LOG.error("Error on JSON request : "+ e.getMessage());
        }
        return new ResponseEntity<SyncSendMessageResponse>(syncSendMessageResponse,httpHeaders, HttpStatus.OK);
    }


    private SyncSendMessageResponse sendSyncMessage( Object object) throws DatatypeConfigurationException {
        SyncSendMessageResponse response = new SyncSendMessageResponse();
        String uuid = UUID.randomUUID().toString();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date());
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        try {
            SyncSendMessageRequest request = new SyncSendMessageRequest();
            SyncMessageInfo messageInfo = new SyncMessageInfo();
            kz.bee.bip.SyncChannel.v10.Types.SenderInfo senderInfo = new kz.bee.bip.SyncChannel.v10.Types.SenderInfo();
            messageInfo.setServiceId(HED_SERVICE_ID);
            messageInfo.setMessageId(uuid);
            messageInfo.setSessionId(uuid);
            messageInfo.setMessageDate(xmlGregorianCalendar);
            senderInfo.setSenderId(SENDER_ID);
            senderInfo.setPassword(SENDER_PASS);
            messageInfo.setSender(senderInfo);
            request.setRequestInfo(messageInfo);

            RequestData requestData = new RequestData();
            Data data = new Data();
            data.setTempStorageRequest(object);

            requestData.setData_(data);
            request.setRequestData(requestData);
            kz.bee.bip.SyncChannel.v10.Interfaces.binding2.ISyncChannelHttpService service = new kz.bee.bip.SyncChannel.v10.Interfaces.binding2.ISyncChannelHttpService();
            kz.bee.bip.SyncChannel.v10.Interfaces.binding2.ISyncChannel iSyncChannelPort = service.getSyncChannelHttpPort();
            EsedoConnection.setEndpointAddressHED(iSyncChannelPort);

            response = iSyncChannelPort.sendMessage(request);

            LOG.info("response : " +response.getResponseInfo().getResponseDate());


        }catch (Exception e){

            SyncMessageInfoResponse messageInfoResponse = new
                    SyncMessageInfoResponse();

            StatusInfo statusInfo = new
                    StatusInfo();
            statusInfo.setCode("0");
            statusInfo.setMessage("error");
            messageInfoResponse.setStatus(statusInfo);
            messageInfoResponse.setSessionId(uuid);
            messageInfoResponse.setMessageId(uuid);
            messageInfoResponse.setResponseDate(xmlGregorianCalendar);

            response.setResponseInfo(messageInfoResponse);

            ResponseData responseData = new
                    ResponseData();
            responseData.setData(e.getMessage());
            response.setResponseData(responseData);
            LOG.info("end of exception response " + e.getMessage());
            e.printStackTrace();
        }
        return response;
    }


}
