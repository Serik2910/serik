
package kz.bee.bip.esedo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Перенаправление обращения лица
 * 
 * <p>Java class for docOL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docOL"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://esedo.nitec.kz/service/model}message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="appendCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="carrierType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="character" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="citizenship" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="controlTypeOuterCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="controlTypeOuterNameKz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="controlTypeOuterNameRu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deliveryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docDateR" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="docKind" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="docLang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docNoR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docReqAuthor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="documentType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="executionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="idPortalInternal" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="juridicallyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="middlename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="portalSign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="preparedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="regDateOL" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="regNumberOL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="secondSignData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="secondSignEnabled" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sheetCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="signerNameKz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="signerNameRu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="socialOrder" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uniqueNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "docOL", namespace = "http://esedo.nitec.kz/service/model/document", propOrder = {
    "address",
    "appendCount",
    "carrierType",
    "character",
    "citizenship",
    "controlTypeOuterCode",
    "controlTypeOuterNameKz",
    "controlTypeOuterNameRu",
    "deliveryDate",
    "description",
    "docDateR",
    "docKind",
    "docLang",
    "docNoR",
    "docReqAuthor",
    "documentType",
    "email",
    "executionDate",
    "idPortalInternal",
    "juridicallyName",
    "middlename",
    "name",
    "note",
    "phone",
    "portalSign",
    "preparedDate",
    "regDateOL",
    "regNumberOL",
    "region",
    "secondSignData",
    "secondSignEnabled",
    "sheetCount",
    "signerNameKz",
    "signerNameRu",
    "socialOrder",
    "surname",
    "uniqueNumber",
    "userUin"
})
public class DocOL
    extends Message
{

    protected String address;
    protected String appendCount;
    protected String carrierType;
    protected Long character;
    protected String citizenship;
    protected String controlTypeOuterCode;
    protected String controlTypeOuterNameKz;
    protected String controlTypeOuterNameRu;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deliveryDate;
    protected String description;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar docDateR;
    protected Long docKind;
    protected String docLang;
    protected String docNoR;
    protected String docReqAuthor;
    protected Long documentType;
    protected String email;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar executionDate;
    protected Long idPortalInternal;
    protected String juridicallyName;
    protected String middlename;
    protected String name;
    protected String note;
    protected String phone;
    protected String portalSign;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar preparedDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar regDateOL;
    protected String regNumberOL;
    protected String region;
    protected String secondSignData;
    protected String secondSignEnabled;
    protected String sheetCount;
    protected String signerNameKz;
    protected String signerNameRu;
    protected Long socialOrder;
    protected String surname;
    protected String uniqueNumber;
    protected String userUin;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the appendCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppendCount() {
        return appendCount;
    }

    /**
     * Sets the value of the appendCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppendCount(String value) {
        this.appendCount = value;
    }

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
     * Gets the value of the citizenship property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCitizenship() {
        return citizenship;
    }

    /**
     * Sets the value of the citizenship property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCitizenship(String value) {
        this.citizenship = value;
    }

    /**
     * Gets the value of the controlTypeOuterCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlTypeOuterCode() {
        return controlTypeOuterCode;
    }

    /**
     * Sets the value of the controlTypeOuterCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlTypeOuterCode(String value) {
        this.controlTypeOuterCode = value;
    }

    /**
     * Gets the value of the controlTypeOuterNameKz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlTypeOuterNameKz() {
        return controlTypeOuterNameKz;
    }

    /**
     * Sets the value of the controlTypeOuterNameKz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlTypeOuterNameKz(String value) {
        this.controlTypeOuterNameKz = value;
    }

    /**
     * Gets the value of the controlTypeOuterNameRu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlTypeOuterNameRu() {
        return controlTypeOuterNameRu;
    }

    /**
     * Sets the value of the controlTypeOuterNameRu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlTypeOuterNameRu(String value) {
        this.controlTypeOuterNameRu = value;
    }

    /**
     * Gets the value of the deliveryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the value of the deliveryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeliveryDate(XMLGregorianCalendar value) {
        this.deliveryDate = value;
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
     * Gets the value of the docDateR property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDocDateR() {
        return docDateR;
    }

    /**
     * Sets the value of the docDateR property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDocDateR(XMLGregorianCalendar value) {
        this.docDateR = value;
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
     * Gets the value of the docLang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocLang() {
        return docLang;
    }

    /**
     * Sets the value of the docLang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocLang(String value) {
        this.docLang = value;
    }

    /**
     * Gets the value of the docNoR property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNoR() {
        return docNoR;
    }

    /**
     * Sets the value of the docNoR property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNoR(String value) {
        this.docNoR = value;
    }

    /**
     * Gets the value of the docReqAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocReqAuthor() {
        return docReqAuthor;
    }

    /**
     * Sets the value of the docReqAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocReqAuthor(String value) {
        this.docReqAuthor = value;
    }

    /**
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDocumentType(Long value) {
        this.documentType = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
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
     * Gets the value of the juridicallyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJuridicallyName() {
        return juridicallyName;
    }

    /**
     * Sets the value of the juridicallyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJuridicallyName(String value) {
        this.juridicallyName = value;
    }

    /**
     * Gets the value of the middlename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddlename() {
        return middlename;
    }

    /**
     * Sets the value of the middlename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddlename(String value) {
        this.middlename = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the portalSign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortalSign() {
        return portalSign;
    }

    /**
     * Sets the value of the portalSign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortalSign(String value) {
        this.portalSign = value;
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
     * Gets the value of the regDateOL property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRegDateOL() {
        return regDateOL;
    }

    /**
     * Sets the value of the regDateOL property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegDateOL(XMLGregorianCalendar value) {
        this.regDateOL = value;
    }

    /**
     * Gets the value of the regNumberOL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegNumberOL() {
        return regNumberOL;
    }

    /**
     * Sets the value of the regNumberOL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegNumberOL(String value) {
        this.regNumberOL = value;
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
     * Gets the value of the secondSignData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondSignData() {
        return secondSignData;
    }

    /**
     * Sets the value of the secondSignData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondSignData(String value) {
        this.secondSignData = value;
    }

    /**
     * Gets the value of the secondSignEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondSignEnabled() {
        return secondSignEnabled;
    }

    /**
     * Sets the value of the secondSignEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondSignEnabled(String value) {
        this.secondSignEnabled = value;
    }

    /**
     * Gets the value of the sheetCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSheetCount() {
        return sheetCount;
    }

    /**
     * Sets the value of the sheetCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSheetCount(String value) {
        this.sheetCount = value;
    }

    /**
     * Gets the value of the signerNameKz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignerNameKz() {
        return signerNameKz;
    }

    /**
     * Sets the value of the signerNameKz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignerNameKz(String value) {
        this.signerNameKz = value;
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

    /**
     * Gets the value of the socialOrder property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSocialOrder() {
        return socialOrder;
    }

    /**
     * Sets the value of the socialOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSocialOrder(Long value) {
        this.socialOrder = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the uniqueNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniqueNumber() {
        return uniqueNumber;
    }

    /**
     * Sets the value of the uniqueNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniqueNumber(String value) {
        this.uniqueNumber = value;
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
