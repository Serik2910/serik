
package kz.bee.bip.esedo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Метаданные НПА
 * 
 * <p>Java class for EECBDocumentMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EECBDocumentMetadata"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="titleKz" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="titleRu" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="developingStateAgency" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="approvalData" type="{http://esedo.nitec.kz/service/model/extension/eecbParts}EECBApprovalData" maxOccurs="unbounded"/&gt;
 *         &lt;element name="approvalPlace" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="judiciaryDocNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="judiciaryApprovalDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="judicialAuthority" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Publication" type="{http://esedo.nitec.kz/service/model/extension/eecbParts}EECBPublication" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EECBDocumentMetadata", namespace = "http://esedo.nitec.kz/service/model/extension/eecbParts", propOrder = {
    "titleKz",
    "titleRu",
    "developingStateAgency",
    "approvalData",
    "approvalPlace",
    "judiciaryDocNumber",
    "judiciaryApprovalDate",
    "judicialAuthority",
    "region",
    "publication"
})
public class EECBDocumentMetadata {

    @XmlElement(required = true)
    protected String titleKz;
    @XmlElement(required = true)
    protected String titleRu;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long developingStateAgency;
    @XmlElement(required = true, nillable = true)
    protected List<EECBApprovalData> approvalData;
    @XmlElement(required = true)
    protected String approvalPlace;
    @XmlElement(required = true, nillable = true)
    protected String judiciaryDocNumber;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar judiciaryApprovalDate;
    protected long judicialAuthority;
    @XmlElement(required = true)
    protected String region;
    @XmlElement(name = "Publication", nillable = true)
    protected List<EECBPublication> publication;

    /**
     * Gets the value of the titleKz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitleKz() {
        return titleKz;
    }

    /**
     * Sets the value of the titleKz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitleKz(String value) {
        this.titleKz = value;
    }

    /**
     * Gets the value of the titleRu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitleRu() {
        return titleRu;
    }

    /**
     * Sets the value of the titleRu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitleRu(String value) {
        this.titleRu = value;
    }

    /**
     * Gets the value of the developingStateAgency property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDevelopingStateAgency() {
        return developingStateAgency;
    }

    /**
     * Sets the value of the developingStateAgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDevelopingStateAgency(Long value) {
        this.developingStateAgency = value;
    }

    /**
     * Gets the value of the approvalData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approvalData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApprovalData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EECBApprovalData }
     * 
     * 
     */
    public List<EECBApprovalData> getApprovalData() {
        if (approvalData == null) {
            approvalData = new ArrayList<EECBApprovalData>();
        }
        return this.approvalData;
    }

    /**
     * Gets the value of the approvalPlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovalPlace() {
        return approvalPlace;
    }

    /**
     * Sets the value of the approvalPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovalPlace(String value) {
        this.approvalPlace = value;
    }

    /**
     * Gets the value of the judiciaryDocNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJudiciaryDocNumber() {
        return judiciaryDocNumber;
    }

    /**
     * Sets the value of the judiciaryDocNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJudiciaryDocNumber(String value) {
        this.judiciaryDocNumber = value;
    }

    /**
     * Gets the value of the judiciaryApprovalDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getJudiciaryApprovalDate() {
        return judiciaryApprovalDate;
    }

    /**
     * Sets the value of the judiciaryApprovalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setJudiciaryApprovalDate(XMLGregorianCalendar value) {
        this.judiciaryApprovalDate = value;
    }

    /**
     * Gets the value of the judicialAuthority property.
     * 
     */
    public long getJudicialAuthority() {
        return judicialAuthority;
    }

    /**
     * Sets the value of the judicialAuthority property.
     * 
     */
    public void setJudicialAuthority(long value) {
        this.judicialAuthority = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the publication property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the publication property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPublication().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EECBPublication }
     * 
     * 
     */
    public List<EECBPublication> getPublication() {
        if (publication == null) {
            publication = new ArrayList<EECBPublication>();
        }
        return this.publication;
    }

}
