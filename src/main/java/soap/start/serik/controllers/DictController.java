package soap.start.serik.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import kz.nitec.unidic.Types.SenderInfo;
import kz.nitec.unidic.Types.StatusInfo;
import kz.nitec.unidic.Types.SyncMessageInfo;
import kz.nitec.unidic.Types.SyncMessageInfoResponse;
import kz.nitec.unidic.Types.request.Data;
import kz.nitec.unidic.Types.request.RequestData;
import kz.nitec.unidic.Types.request.SyncSendMessageRequest;
import kz.nitec.unidic.Types.response.ResponseData;
import kz.nitec.unidic.Types.response.SyncSendMessageResponse;
import kz.nitec.unidic.binding2.ISyncChannel;
import kz.nitec.unidic.binding2.ISyncChannelHttpService;
import kz.nitec.unidic.items.Items;
import kz.nitec.unidic.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import soap.start.serik.Utils.EsedoConnection;
import kz.nitec.unidic.request.Request;

import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import static soap.start.serik.models.Const.*;

@RestController
@RequestMapping("/dict")
public class DictController {
    private static final Logger LOG = LogManager.getLogger(DictController.class);

    @PostMapping(
            value = "/download_dict",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Items> downloadDict(
            @RequestBody Request dictionaryRequest,
            @RequestHeader(HttpHeaders.CONTENT_TYPE) String type) {
        SyncSendMessageResponse syncSendMessageResponse = null;
        Items items = null;
        final HttpHeaders httpHeaders= new HttpHeaders();
        LOG.info("Incoming message");
        try {
            switch (type){
                case MediaType.APPLICATION_XML_VALUE:
                    StringWriter sw = new StringWriter();
                    JAXBContext jc = JAXBContext.newInstance(Request.class);
                    Marshaller marshaller = jc.createMarshaller();
                    marshaller.marshal(dictionaryRequest,sw);
                    String xmlStringToLog = sw.toString();
                    httpHeaders.setContentType(MediaType.APPLICATION_XML);
                    LOG.info(xmlStringToLog);
                    break;
                case MediaType.APPLICATION_JSON_VALUE:
                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String json = ow.writeValueAsString(dictionaryRequest);
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    LOG.info(json);
                    break;
            }
            syncSendMessageResponse = sendSyncMessage(dictionaryRequest);
            Object content =  syncSendMessageResponse.getResponseData().getData();
            JAXBContext context = JAXBContext.newInstance(Response.class);
            Unmarshaller um = context.createUnmarshaller();
            Response response_ = (Response) um.unmarshal(((Node)content).getFirstChild());
            List<Object> list=  response_.getResultData().getData().getContent();
            context = JAXBContext.newInstance(Items.class);
            um= context.createUnmarshaller();
            StringReader reader = new StringReader(list.get(0).toString());
            items = (Items) um.unmarshal(reader);

        } catch (DatatypeConfigurationException e) {
            LOG.error("Error on request : "+ e.getMessage());
        } catch (JsonProcessingException e) {
            LOG.error("Error on JSON request : "+ e.getMessage());
        } catch (JAXBException e) {
            LOG.error("Error on JAXB request : "+ e.getMessage());
        }
        return new ResponseEntity<Items>(items, httpHeaders, HttpStatus.OK);
    }
    private SyncSendMessageResponse sendSyncMessage(Request data) throws DatatypeConfigurationException {
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
            messageInfo.setServiceId(NSI_SERVICE_ID);
            messageInfo.setMessageId(UUID.randomUUID().toString());
            messageInfo.setMessageDate(xmlGregorianCalendar);
            senderInfo.setSenderId(SENDER_ID);
            senderInfo.setPassword(SENDER_PASS);
            messageInfo.setSender(senderInfo);
            request.setRequestInfo(messageInfo);
            RequestData requestData = new RequestData();
            Data data_ = new Data();
            data_.setRequest(data);

            requestData.setData_(data_);
            request.setRequestData(requestData);
            ISyncChannelHttpService service = new ISyncChannelHttpService();
            ISyncChannel iSyncChannelPort = service.getSyncChannelHttpPort();
            EsedoConnection.setEndpointAddressNSI(iSyncChannelPort);
            response = iSyncChannelPort.sendMessage(request);


            LOG.info("response with session id =" + response.getResponseInfo().getSessionId());
        }catch (Exception e){

            SyncMessageInfoResponse messageInfoResponse = new
                    SyncMessageInfoResponse();

            StatusInfo statusInfo = new  StatusInfo();
            statusInfo.setCode("0");
            statusInfo.setMessage("error");
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
