
package kz.bee.bip.esedo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Пункт документа, является составной частью документа
 * 
 * <p>Java class for docSection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docSection"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://esedo.nitec.kz/service/model}message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="carrierType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="character" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="controlTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="controlTypeNameKz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="controlTypeNameRu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dirordNumberKpm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="docKind" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="docNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docSection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="documentSectionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="employeePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="executionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="executor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="inDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="preparedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="sectionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="signerNameRu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "docSection", namespace = "http://esedo.nitec.kz/service/model/document", propOrder = {
    "carrierType",
    "character",
    "controlTypeCode",
    "controlTypeNameKz",
    "controlTypeNameRu",
    "description",
    "dirordNumberKpm",
    "docDate",
    "docKind",
    "docNumber",
    "docSection",
    "documentSectionId",
    "employeePhone",
    "executionDate",
    "executor",
    "inDate",
    "preparedDate",
    "sectionId",
    "signerNameRu"
})
public class DocSection
    extends Message
{

    protected String carrierType;
    protected Long character;
    protected String controlTypeCode;
    protected String controlTypeNameKz;
    protected String controlTypeNameRu;
    protected String description;
    protected String dirordNumberKpm;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar docDate;
    protected Long docKind;
    protected String docNumber;
    protected String docSection;
    protected String documentSectionId;
    protected String employeePhone;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar executionDate;
    protected String executor;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar inDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar preparedDate;
    protected String sectionId;
    protected String signerNameRu;

    /**
     * Gets the value of the carrierType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrierType() {
        return carrierType;
    }

    /**
     * Sets the value of the carrierType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrierType(String value) {
        this.carrierType = value;
    }

    /**
     * Gets the value of the character property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCharacter() {
        return character;
    }

    /**
     * Sets the value of the character property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCharacter(Long value) {
        this.character = value;
    }

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the dirordNumberKpm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirordNumberKpm() {
        return dirordNumberKpm;
    }

    /**
     * Sets the value of the dirordNumberKpm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirordNumberKpm(String value) {
        this.dirordNumberKpm = value;
    }

    /**
     * Gets the value of the docDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDocDate() {
        return docDate;
    }

    /**
     * Sets the value of the docDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDocDate(XMLGregorianCalendar value) {
        this.docDate = value;
    }

    /**
     * Gets the value of the docKind property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDocKind() {
        return docKind;
    }

    /**
     * Sets the value of the docKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDocKind(Long value) {
        this.docKind = value;
    }

    /**
     * Gets the value of the docNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNumber() {
        return docNumber;
    }

    /**
     * Sets the value of the docNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNumber(String value) {
        this.docNumber = value;
    }

    /**
     * Gets the value of the docSection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocSection() {
        return docSection;
    }

    /**
     * Sets the value of the docSection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocSection(String value) {
        this.docSection = value;
    }

    /**
     * Gets the value of the documentSectionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentSectionId() {
        return documentSectionId;
    }

    /**
     * Sets the value of the documentSectionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentSectionId(String value) {
        this.documentSectionId = value;
    }

    /**
     * Gets the value of the employeePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeePhone() {
        return employeePhone;
    }

    /**
     * Sets the value of the employeePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeePhone(String value) {
        this.employeePhone = value;
    }

    /**
     * Gets the value of the executionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExecutionDate() {
        return executionDate;
    }

    /**
     * Sets the value of the executionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExecutionDate(XMLGregorianCalendar value) {
        this.executionDate = value;
    }

    /**
     * Gets the value of the executor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutor() {
        return executor;
    }

    /**
     * Sets the value of the executor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutor(String value) {
        this.executor = value;
    }

    /**
     * Gets the value of the inDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInDate() {
        return inDate;
    }

    /**
     * Sets the value of the inDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInDate(XMLGregorianCalendar value) {
        this.inDate = value;
    }

    /**
     * Gets the value of the preparedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPreparedDate() {
        return preparedDate;
    }

    /**
     * Sets the value of the preparedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPreparedDate(XMLGregorianCalendar value) {
        this.preparedDate = value;
    }

    /**
     * Gets the value of the sectionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSectionId() {
        return sectionId;
    }

    /**
     * Sets the value of the sectionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSectionId(String value) {
        this.sectionId = value;
    }

    /**
     * Gets the value of the signerNameRu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignerNameRu() {
        return signerNameRu;
    }

    /**
     * Sets the value of the signerNameRu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignerNameRu(String value) {
        this.signerNameRu = value;
    }

}
