
package kz.bee.bip.esedo;

import kz.bee.bip.esedo.Message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Описание уведомления-квитанции о передаче на исполнение
 * 
 * <p>Java class for stateExecution complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stateExecution"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://esedo.nitec.kz/service/model}message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="execDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="executive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="executivePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idPortalInternal" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
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
@XmlType(name = "stateExecution", namespace = "http://esedo.nitec.kz/service/model/notification", propOrder = {
    "date",
    "execDate",
    "executive",
    "executivePhone",
    "idPortalInternal",
    "userUin"
})
public class StateExecution
    extends Message
{

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar execDate;
    protected String executive;
    protected String executivePhone;
    protected Long idPortalInternal;
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
     * Gets the value of the execDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExecDate() {
        return execDate;
    }

    /**
     * Sets the value of the execDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExecDate(XMLGregorianCalendar value) {
        this.execDate = value;
    }

    /**
     * Gets the value of the executive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutive() {
        return executive;
    }

    /**
     * Sets the value of the executive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutive(String value) {
        this.executive = value;
    }

    /**
     * Gets the value of the executivePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutivePhone() {
        return executivePhone;
    }

    /**
     * Sets the value of the executivePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutivePhone(String value) {
        this.executivePhone = value;
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
