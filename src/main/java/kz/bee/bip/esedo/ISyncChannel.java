
package kz.bee.bip.esedo;

import javax.jws.*;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * Интерфейс для работы с синхронным каналом
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ISyncChannel", targetNamespace = "http://bip.bee.kz/SyncChannel/v10/Interfaces")

@HandlerChain(file = "/handler_validator.xml")
public interface ISyncChannel {


    /**
     * Метод отправки сообщения по синхронному каналу
     * 
     * @param request
     * @return
     *     returns kz.bee.bip.esedo.SyncSendMessageResponse
     * @throws SendMessageSendMessageFaultMsg
     */
    @WebMethod(operationName = "SendMessage")
    @WebResult(name = "response", targetNamespace = "")
    @RequestWrapper(
            localName = "SendMessage",
            targetNamespace = "http://bip.bee.kz/SyncChannel/v10/Types",
            className = "kz.bee.bip.esedo.SendMessage")
    @ResponseWrapper(
            localName = "SendMessageResponse",
            targetNamespace = "http://bip.bee.kz/SyncChannel/v10/Types",
            className = "kz.bee.bip.esedo.SendMessageResponse")
    public SyncSendMessageResponse sendMessage(
        @WebParam(name = "request", targetNamespace = "")
        SyncSendMessageRequest request)
        throws SendMessageSendMessageFaultMsg
    ;

}
