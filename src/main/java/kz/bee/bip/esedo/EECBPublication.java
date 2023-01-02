
package kz.bee.bip.esedo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Источник опубликования НПА
 * 
 * <p>Java class for EECBPublication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EECBPublication"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sourcePub" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="issuePub" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="datePub" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EECBPublication", namespace = "http://esedo.nitec.kz/service/model/extension/eecbParts", propOrder = {
    "sourcePub",
    "issuePub",
    "datePub"
})
public class EECBPublication {

    @XmlElement(required = true, nillable = true)
    protected String sourcePub;
    @XmlElement(required = true, nillable = true)
    protected String issuePub;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datePub;

    /**
     * Gets the value of the sourcePub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourcePub() {
        return sourcePub;
    }

    /**
     * Sets the value of the sourcePub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourcePub(String value) {
        this.sourcePub = value;
    }

    /**
     * Gets the value of the issuePub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuePub() {
        return issuePub;
    }

    /**
     * Sets the value of the issuePub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuePub(String value) {
        this.issuePub = value;
    }

    /**
     * Gets the value of the datePub property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatePub() {
        return datePub;
    }

    /**
     * Sets the value of the datePub property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatePub(XMLGregorianCalendar value) {
        this.datePub = value;
    }

}
