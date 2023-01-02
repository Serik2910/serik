
package kz.bee.bip.SyncChannel.v10.Interfaces;

import kz.bee.bip.esedo.EECBDocumentMetadata;
import kz.bee.bip.esedo.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Исходящий\Входящий документ 
 * 
 * <p>Java class for docOutgoing complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docOutgoing"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://esedo.nitec.kz/service/model}message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="appendCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="authorNameKz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="authorNameRu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="carrierType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="character" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="controlTypeOuterCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="controlTypeOuterNameKz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="controlTypeOuterNameRu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="docKind" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="docLang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docNoR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docRecPostKz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docRecPostRu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docToNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="documentReceiverKz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="documentReceiverRu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="documentSectionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="employeePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="executionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="executor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idPortalInternal" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="outTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="portalSign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="preparedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="resolutionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="secondSignData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="secondSignEnabled" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sectionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sheetCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="signerNameKz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="signerNameRu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userUin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="eecbDocumentMetadata" type="{http://esedo.nitec.kz/service/model/extension/eecbParts}EECBDocumentMetadata" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@XmlType(name = "docOutgoing", namespace = "http://esedo.nitec.kz/service/model/document", propOrder = {
    "appendCount",
    "authorNameKz",
    "authorNameRu",
    "carrierType",
    "character",
    "controlTypeOuterCode",
    "controlTypeOuterNameKz",
    "controlTypeOuterNameRu",
    "description",
    "docDate",
    "docKind",
    "docLang",
    "docNo",
    "docNoR",
    "docRecPostKz",
    "docRecPostRu",
    "docToNumber",
    "documentReceiverKz",
    "documentReceiverRu",
    "documentSectionId",
    "employeePhone",
    "executionDate",
    "executor",
    "idPortalInternal",
    "outTime",
    "portalSign",
    "preparedDate",
    "resolutionText",
    "secondSignData",
    "secondSignEnabled",
    "sectionId",
    "sheetCount",
    "signerNameKz",
    "signerNameRu",
    "userUin",
    "eecbDocumentMetadata"
})
public class DocOutgoing
    extends Message
{
    protected String appendCount;

    protected String authorNameKz;
    protected String authorNameRu;

    protected String carrierType;

    protected Long character;

    protected String controlTypeOuterCode;

    protected String controlTypeOuterNameKz;

    protected String controlTypeOuterNameRu;

    protected String description;

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar docDate;

    protected Long docKind;

    protected String docLang;

    protected String docNo;

    protected String docNoR;

    protected String docRecPostKz;

    protected String docRecPostRu;

    protected String docToNumber;

    protected String documentReceiverKz;

    protected String documentReceiverRu;

    protected String documentSectionId;

    protected String employeePhone;

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar executionDate;

    protected String executor;

    protected Long idPortalInternal;

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar outTime;

    protected String portalSign;

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar preparedDate;

    protected String resolutionText;

    protected String secondSignData;

    protected String secondSignEnabled;

    protected String sectionId;

    protected String sheetCount;

    protected String signerNameKz;

    protected String signerNameRu;

    protected String userUin;

    protected EECBDocumentMetadata eecbDocumentMetadata;

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
     * Gets the value of the authorNameKz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorNameKz() {
        return authorNameKz;
    }

    /**
     * Sets the value of the authorNameKz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorNameKz(String value) {
        this.authorNameKz = value;
    }

    /**
     * Gets the value of the authorNameRu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorNameRu() {
        return authorNameRu;
    }

    /**
     * Sets the value of the authorNameRu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorNameRu(String value) {
        this.authorNameRu = value;
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
     * Gets the value of the docNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNo() {
        return docNo;
    }

    /**
     * Sets the value of the docNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNo(String value) {
        this.docNo = value;
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
     * Gets the value of the docRecPostKz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocRecPostKz() {
        return docRecPostKz;
    }

    /**
     * Sets the value of the docRecPostKz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocRecPostKz(String value) {
        this.docRecPostKz = value;
    }

    /**
     * Gets the value of the docRecPostRu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocRecPostRu() {
        return docRecPostRu;
    }

    /**
     * Sets the value of the docRecPostRu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocRecPostRu(String value) {
        this.docRecPostRu = value;
    }

    /**
     * Gets the value of the docToNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocToNumber() {
        return docToNumber;
    }

    /**
     * Sets the value of the docToNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocToNumber(String value) {
        this.docToNumber = value;
    }

    /**
     * Gets the value of the documentReceiverKz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentReceiverKz() {
        return documentReceiverKz;
    }

    /**
     * Sets the value of the documentReceiverKz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentReceiverKz(String value) {
        this.documentReceiverKz = value;
    }

    /**
     * Gets the value of the documentReceiverRu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentReceiverRu() {
        return documentReceiverRu;
    }

    /**
     * Sets the value of the documentReceiverRu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentReceiverRu(String value) {
        this.documentReceiverRu = value;
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
     * Gets the value of the outTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOutTime() {
        return outTime;
    }

    /**
     * Sets the value of the outTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOutTime(XMLGregorianCalendar value) {
        this.outTime = value;
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
     * Gets the value of the resolutionText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolutionText() {
        return resolutionText;
    }

    /**
     * Sets the value of the resolutionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolutionText(String value) {
        this.resolutionText = value;
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

    /**
     * Gets the value of the eecbDocumentMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link EECBDocumentMetadata }
     *     
     */
    public EECBDocumentMetadata getEecbDocumentMetadata() {
        return eecbDocumentMetadata;
    }

    /**
     * Sets the value of the eecbDocumentMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link EECBDocumentMetadata }
     *     
     */
    public void setEecbDocumentMetadata(EECBDocumentMetadata value) {
        this.eecbDocumentMetadata = value;
    }


    public String toString() {
        return "DocOutgoing{" +
                "attachments=" + attachments +
                ", appendCount='" + appendCount + '\'' +
                ", authorNameKz='" + authorNameKz + '\'' +
                ", authorNameRu='" + authorNameRu + '\'' +
                ", carrierType=" + carrierType +
                ", character=" + character +
                ", controlTypeOuterCode='" + controlTypeOuterCode + '\'' +
                ", controlTypeOuterNameKz='" + controlTypeOuterNameKz + '\'' +
                ", controlTypeOuterNameRu='" + controlTypeOuterNameRu + '\'' +
                ", description='" + this.description + '\'' +
                ", docDate=" + docDate +
                ", docKind=" + docKind +
                ", docLang='" + docLang + '\'' +
                ", docNo='" + docNo + '\'' +
                ", docNoR='" + docNoR + '\'' +
                ", docRecPostKz='" + docRecPostKz + '\'' +
                ", docRecPostRu='" + docRecPostRu + '\'' +
                ", docToNumber='" + docToNumber + '\'' +
                ", documentReceiverKz='" + documentReceiverKz + '\'' +
                ", documentReceiverRu='" + documentReceiverRu + '\'' +
                ", documentSectionId='" + documentSectionId + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", executor='" + executor + '\'' +
                ", idPortalInternal=" + idPortalInternal +
                ", portalSign='" + portalSign + '\'' +
                ", preparedDate=" + preparedDate +
                ", resolutionText='" + resolutionText + '\'' +
                ", secondSignData='" + secondSignData + '\'' +
                ", secondSignEnabled=" + secondSignEnabled +
                ", sectionId='" + sectionId + '\'' +
                ", sheetCount='" + sheetCount + '\'' +
                ", signerNameKz='" + signerNameKz + '\'' +
                ", signerNameRu='" + signerNameRu + '\'' +
                ", userUin='" + userUin + '\'' +
                '}';
    }


}
