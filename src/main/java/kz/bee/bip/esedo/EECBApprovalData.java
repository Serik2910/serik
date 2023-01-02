
package kz.bee.bip.esedo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Данные принятия НПА
 * 
 * <p>Java class for EECBApprovalData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EECBApprovalData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="approvingStateAgency" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="stateAgencyDocNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="stateAgencyApprovalDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EECBApprovalData", namespace = "http://esedo.nitec.kz/service/model/extension/eecbParts", propOrder = {
    "approvingStateAgency",
    "stateAgencyDocNumber",
    "stateAgencyApprovalDate"
})
public class EECBApprovalData {

    protected long approvingStateAgency;
    @XmlElement(required = true)
    protected String stateAgencyDocNumber;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar stateAgencyApprovalDate;

    /**
     * Gets the value of the approvingStateAgency property.
     * 
     */
    public long getApprovingStateAgency() {
        return approvingStateAgency;
    }

    /**
     * Sets the value of the approvingStateAgency property.
     * 
     */
    public void setApprovingStateAgency(long value) {
        this.approvingStateAgency = value;
    }

    /**
     * Gets the value of the stateAgencyDocNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateAgencyDocNumber() {
        return stateAgencyDocNumber;
    }

    /**
     * Sets the value of the stateAgencyDocNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateAgencyDocNumber(String value) {
        this.stateAgencyDocNumber = value;
    }

    /**
     * Gets the value of the stateAgencyApprovalDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStateAgencyApprovalDate() {
        return stateAgencyApprovalDate;
    }

    /**
     * Sets the value of the stateAgencyApprovalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStateAgencyApprovalDate(XMLGregorianCalendar value) {
        this.stateAgencyApprovalDate = value;
    }

}
