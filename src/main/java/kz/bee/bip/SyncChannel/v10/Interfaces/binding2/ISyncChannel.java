
package kz.bee.bip.SyncChannel.v10.Interfaces.binding2;

import kz.bee.bip.SyncChannel.v10.Types.request.SyncSendMessageRequest;
import kz.bee.bip.SyncChannel.v10.Types.response.SyncSendMessageResponse;

import javax.jws.*;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * Интерфейс для работы с синхронным каналом
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ISyncChannel", targetNamespace = "http://bip.bee.kz/SyncChannel/v10/Interfaces")
@XmlSeeAlso({
        kz.bee.bip.SyncChannel.v10.Types.ObjectFactory.class,
        kz.bee.egov.v2.tempstorage.eds.ObjectFactory.class

})

public interface ISyncChannel {


    /**
     * Метод отправки сообщения по синхронному каналу
     * 
     * @param request
     * @return
     *     returns kz.bee.bip.syncchannel.v10.types.response.SyncSendMessageResponse
     * @throws SendMessageSendMessageFaultMsg
     */
    @WebMethod(operationName = "SendMessage")
    @WebResult(name = "response", targetNamespace = "")
    @RequestWrapper(localName = "SendMessage",
            targetNamespace = "http://bip.bee.kz/SyncChannel/v10/Types",
            className = "kz.bee.bip.SyncChannel.v10.Types.SendMessage")
    @ResponseWrapper(localName = "SendMessageResponse",
            targetNamespace = "http://bip.bee.kz/SyncChannel/v10/Types",
            className = "kz.bee.bip.SyncChannel.v10.Types.SendMessageResponse")
    public SyncSendMessageResponse sendMessage(
        @WebParam(name = "request", targetNamespace = "")
        SyncSendMessageRequest request)
        throws SendMessageSendMessageFaultMsg
    ;

}