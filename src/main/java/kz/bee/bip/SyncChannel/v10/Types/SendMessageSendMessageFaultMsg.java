
package kz.bee.bip.SyncChannel.v10.Types;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "SendMessageFault1_SendMessageFault", targetNamespace = "http://bip.bee.kz/SyncChannel/v10/Types")
public class SendMessageSendMessageFaultMsg
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ErrorInfo faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public SendMessageSendMessageFaultMsg(String message, ErrorInfo faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public SendMessageSendMessageFaultMsg(String message, ErrorInfo faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: kz.bee.bip.SyncChannel.v10.Types.ErrorInfo
     */
    public ErrorInfo getFaultInfo() {
        return faultInfo;
    }

}
