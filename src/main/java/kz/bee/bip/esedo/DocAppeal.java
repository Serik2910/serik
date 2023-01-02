
package kz.bee.bip.esedo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Обращение лица
 * 
 * <p>Java class for docAppeal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docAppeal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://esedo.nitec.kz/service/model}message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="correspondent" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="deliveryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="documentType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idPortalInternal" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="juridicallyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="middlename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="outDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="outNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userUin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="timeStampData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ocspData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "docAppeal", namespace = "http://esedo.nitec.kz/service/model/document", propOrder = {
    "address",
    "correspondent",
    "deliveryDate",
    "description",
    "documentType",
    "email",
    "idPortalInternal",
    "juridicallyName",
    "middlename",
    "name",
    "outDate",
    "outNumber",
    "phone",
    "sign",
    "surname",
    "userUin",
    "timeStampData",
    "ocspData"
})
public class DocAppeal
    extends Message
{

    protected String address;
    protected Long correspondent;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deliveryDate;
    protected String description;
    protected Long documentType;
    protected String email;
    protected Long idPortalInternal;
    protected String juridicallyName;
    protected String middlename;
    protected String name;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar outDate;
    protected String outNumber;
    protected String phone;
    protected String sign;
    protected String surname;
    protected String userUin;
    protected String timeStampData;
    protected String ocspData;

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
     * Gets the value of the correspondent property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCorrespondent() {
        return correspondent;
    }

    /**
     * Sets the value of the correspondent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCorrespondent(Long value) {
        this.correspondent = value;
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
     * Gets the value of the outDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOutDate() {
        return outDate;
    }

    /**
     * Sets the value of the outDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOutDate(XMLGregorianCalendar value) {
        this.outDate = value;
    }

    /**
     * Gets the value of the outNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutNumber() {
        return outNumber;
    }

    /**
     * Sets the value of the outNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutNumber(String value) {
        this.outNumber = value;
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
     * Gets the value of the sign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSign() {
        return sign;
    }

    /**
     * Sets the value of the sign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSign(String value) {
        this.sign = value;
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
     * Gets the value of the timeStampData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStampData() {
        return timeStampData;
    }

    /**
     * Sets the value of the timeStampData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStampData(String value) {
        this.timeStampData = value;
    }

    /**
     * Gets the value of the ocspData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOcspData() {
        return ocspData;
    }

    /**
     * Sets the value of the ocspData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOcspData(String value) {
        this.ocspData = value;
    }

}
