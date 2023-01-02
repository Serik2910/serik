
package kz.bee.bip.esedo;

import kz.bee.bip.esedo.Message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Описание уведомления-квитанции об отклонении в регистрации
 * 
 * <p>Java class for stateNotValid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stateNotValid"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://esedo.nitec.kz/service/model}message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="idPortalInternal" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="isValidReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="secondSignNotifData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userUin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stateNotValid", namespace = "http://esedo.nitec.kz/service/model/notification", propOrder = {
    "date",
    "idPortalInternal",
    "isValidReason",
    "secondSignNotifData",
    "userUin"
})
public class StateNotValid
    extends Message
{

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected Long idPortalInternal;
    protected String isValidReason;
    protected String secondSignNotifData;
    protected String userUin;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the idPortalInternal property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPortalInternal() {
        return idPortalInternal;
    }

    /**
     * Sets the value of the idPortalInternal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPortalInternal(Long value) {
        this.idPortalInternal = value;
    }

    /**
     * Gets the value of the isValidReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsValidReason() {
        return isValidReason;
    }

    /**
     * Sets the value of the isValidReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsValidReason(String value) {
        this.isValidReason = value;
    }

    /**
     * Gets the value of the secondSignNotifData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondSignNotifData() {
        return secondSignNotifData;
    }

    /**
     * Sets the value of the secondSignNotifData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondSignNotifData(String value) {
        this.secondSignNotifData = value;
    }

    /**
     * Gets the value of the userUin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserUin() {
        return userUin;
    }

    /**
     * Sets the value of the userUin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserUin(String value) {
        this.userUin = value;
    }

}
