
package kz.bee.bip.AsyncChannel.v10.Types;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * Интерфейс сервиса на ШЭП, для работы с асинхронным каналом
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IAsyncChannel", targetNamespace = "http://bip.bee.kz/AsyncChannel/v10/Interfaces")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IAsyncChannel {


    /**
     * Метод для отправки сообщений на асинхронный канал ШЭП
     * 
     * @param request
     * @return
     *     returns kz.bee.bip.AsyncChannel.v10.Types.AsyncSendMessageResponse
     * @throws SendMessageSendMessageFaultMsg
     */
    @WebMethod
    @WebResult(name = "response", targetNamespace = "")
    @RequestWrapper(localName = "sendMessage", targetNamespace = "http://bip.bee.kz/AsyncChannel/v10/Types", className = "kz.bee.bip.AsyncChannel.v10.Types.SendMessage")
    @ResponseWrapper(localName = "sendMessageResponse", targetNamespace = "http://bip.bee.kz/AsyncChannel/v10/Types", className = "kz.bee.bip.AsyncChannel.v10.Types.SendMessageResponse")
    public AsyncSendMessageResponse sendMessage(
        @WebParam(name = "request", targetNamespace = "")
        AsyncSendMessageRequest request)
        throws SendMessageSendMessageFaultMsg
    ;

    /**
     * Метод отправки уведомления на ШЭП о доставке или не доставке сообщения н
     * 
     * @param request
     * @return
     *     returns kz.bee.bip.AsyncChannel.v10.Types.AsyncSendDeliveryNotificationResponse
     * @throws SendDeliveryNotificationSendDeliveryNotificationFaultMsg
     */
    @WebMethod
    @WebResult(name = "response", targetNamespace = "")
    @RequestWrapper(localName = "sendDeliveryNotification", targetNamespace = "http://bip.bee.kz/AsyncChannel/v10/Types", className = "kz.bee.bip.AsyncChannel.v10.Types.SendDeliveryNotification")
    @ResponseWrapper(localName = "sendDeliveryNotificationResponse", targetNamespace = "http://bip.bee.kz/AsyncChannel/v10/Types", className = "kz.bee.bip.AsyncChannel.v10.Types.SendDeliveryNotificationResponse")
    public AsyncSendDeliveryNotificationResponse sendDeliveryNotification(
        @WebParam(name = "request", targetNamespace = "")
        AsyncSendDeliveryNotificationRequest request)
        throws SendDeliveryNotificationSendDeliveryNotificationFaultMsg
    ;

    /**
     * Метод получения статуса сообщения с ШЭП
     * 
     * @param request
     * @return
     *     returns kz.bee.bip.AsyncChannel.v10.Types.AsyncGetMessageStatusResponse
     * @throws GetMessageStatusGetMessageStatusFaultMsg
     */
    @WebMethod
    @WebResult(name = "response", targetNamespace = "")
    @RequestWrapper(localName = "getMessageStatus", targetNamespace = "http://bip.bee.kz/AsyncChannel/v10/Types", className = "kz.bee.bip.AsyncChannel.v10.Types.GetMessageStatus")
    @ResponseWrapper(localName = "getMessageStatusResponse", targetNamespace = "http://bip.bee.kz/AsyncChannel/v10/Types", className = "kz.bee.bip.AsyncChannel.v10.Types.GetMessageStatusResponse")
    public AsyncGetMessageStatusResponse getMessageStatus(
        @WebParam(name = "request", targetNamespace = "")
        AsyncGetMessageStatusRequest request)
        throws GetMessageStatusGetMessageStatusFaultMsg
    ;

    /**
     * Метод выборки сообщений с ШЭП по следующим параметрам:
     * -идентификатору сообщения+получателю(только для запрасившего)+идентификатору сервиса
     * -идентификатору цепочки сообщений+получателю(только для запрасившего)+идентификатору сервиса
     * -получателю(только для запрасившего)+идентификатору сервиса
     * 
     * @param request
     * @return
     *     returns kz.bee.bip.AsyncChannel.v10.Types.AsyncGetMessagesResponse
     * @throws GetMessagesGetMessagesFaultMsg
     */
    @WebMethod
    @WebResult(name = "response", targetNamespace = "")
    @RequestWrapper(localName = "getMessages", targetNamespace = "http://bip.bee.kz/AsyncChannel/v10/Types", className = "kz.bee.bip.AsyncChannel.v10.Types.GetMessages")
    @ResponseWrapper(localName = "getMessagesResponse", targetNamespace = "http://bip.bee.kz/AsyncChannel/v10/Types", className = "kz.bee.bip.AsyncChannel.v10.Types.GetMessagesResponse")
    public AsyncGetMessagesResponse getMessages(
        @WebParam(name = "request", targetNamespace = "")
        AsyncGetMessagesRequest request)
        throws GetMessagesGetMessagesFaultMsg
    ;

}
