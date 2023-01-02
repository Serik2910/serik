
package kz.bee.bip.AsyncChannel.v10.Types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="response" type="{http://bip.bee.kz/AsyncChannel/v10/ITypes}AsyncGetMessageStatusResponse"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "response"
})
@XmlRootElement(name = "getMessageStatusResponse", namespace = "http://bip.bee.kz/AsyncChannel/v10/Types")
public class GetMessageStatusResponse {

    @XmlElement(required = true, nillable = true)
    protected AsyncGetMessageStatusResponse response;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link AsyncGetMessageStatusResponse }
     *     
     */
    public AsyncGetMessageStatusResponse getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link AsyncGetMessageStatusResponse }
     *     
     */
    public void setResponse(AsyncGetMessageStatusResponse value) {
        this.response = value;
    }

}
