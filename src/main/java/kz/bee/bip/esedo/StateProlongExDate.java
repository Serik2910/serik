
package kz.bee.bip.esedo;

import kz.bee.bip.esedo.Message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Описание уведомления-квитанции о продлении срока исполнения
 * 
 * <p>Java class for stateProlongExDate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stateProlongExDate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://esedo.nitec.kz/service/model}message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="controlTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="controlTypeNameKz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="controlTypeNameRu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="execDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stateProlongExDate", namespace = "http://esedo.nitec.kz/service/model/notification", propOrder = {
    "controlTypeCode",
    "controlTypeNameKz",
    "controlTypeNameRu",
    "execDate"
})
public class StateProlongExDate
    extends Message
{

    protected String controlTypeCode;
    protected String controlTypeNameKz;
    protected String controlTypeNameRu;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar execDate;

    /**
     * Gets the value of the controlTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlTypeCode() {
        return controlTypeCode;
    }

    /**
     * Sets the value of the controlTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlTypeCode(String value) {
        this.controlTypeCode = value;
    }

    /**
     * Gets the value of the controlTypeNameKz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlTypeNameKz() {
        return controlTypeNameKz;
    }

    /**
     * Sets the value of the controlTypeNameKz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlTypeNameKz(String value) {
        this.controlTypeNameKz = value;
    }

    /**
     * Gets the value of the controlTypeNameRu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlTypeNameRu() {
        return controlTypeNameRu;
    }

    /**
     * Sets the value of the controlTypeNameRu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlTypeNameRu(String value) {
        this.controlTypeNameRu = value;
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

}
