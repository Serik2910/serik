
package kz.bee.bip.esedo;

import kz.bee.bip.esedo.Message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Описание уведомления-квитанции об ошибочном снятии с контроля
 * 
 * <p>Java class for stateTakeOfControlWrong complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stateTakeOfControlWrong"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://esedo.nitec.kz/service/model}message"&gt;
 *       &lt;sequence&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stateTakeOfControlWrong", namespace = "http://esedo.nitec.kz/service/model/notification")
public class StateTakeOfControlWrong
    extends Message
{


}
