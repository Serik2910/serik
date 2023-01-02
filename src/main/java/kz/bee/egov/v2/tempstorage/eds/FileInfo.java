
package kz.bee.egov.v2.tempstorage.eds;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Информация о файле
 * 
 * <p>Java class for FileInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uploadDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="uploaderSystem" type="{http://egov.bee.kz/eds/tempstorage/v2/}System"/>
 *         &lt;element name="expirationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="needToBeConfirmed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="deleted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="deletionTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="confirmed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="confirmedSystem" type="{http://egov.bee.kz/eds/tempstorage/v2/}System" minOccurs="0"/>
 *         &lt;element name="confirmationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileInfo", propOrder = {
    "name",
    "mime",
    "uploadDate",
    "uploaderSystem",
    "expirationTime",
    "needToBeConfirmed",
    "size",
    "deleted",
    "deletionTime",
    "confirmed",
    "confirmedSystem",
    "confirmationTime"
})
public class FileInfo {

    protected String name;
    protected String mime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar uploadDate;
    @XmlElement(required = true)
    protected System uploaderSystem;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationTime;
    protected Boolean needToBeConfirmed;
    protected long size;
    protected boolean deleted;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deletionTime;
    protected boolean confirmed;
    protected System confirmedSystem;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar confirmationTime;

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
     * Gets the value of the mime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMime() {
        return mime;
    }

    /**
     * Sets the value of the mime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMime(String value) {
        this.mime = value;
    }

    /**
     * Gets the value of the uploadDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUploadDate() {
        return uploadDate;
    }

    /**
     * Sets the value of the uploadDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUploadDate(XMLGregorianCalendar value) {
        this.uploadDate = value;
    }

    /**
     * Gets the value of the uploaderSystem property.
     * 
     * @return
     *     possible object is
     *     {@link System }
     *     
     */
    public System getUploaderSystem() {
        return uploaderSystem;
    }

    /**
     * Sets the value of the uploaderSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link System }
     *     
     */
    public void setUploaderSystem(System value) {
        this.uploaderSystem = value;
    }

    /**
     * Gets the value of the expirationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationTime() {
        return expirationTime;
    }

    /**
     * Sets the value of the expirationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationTime(XMLGregorianCalendar value) {
        this.expirationTime = value;
    }

    /**
     * Gets the value of the needToBeConfirmed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedToBeConfirmed() {
        return needToBeConfirmed;
    }

    /**
     * Sets the value of the needToBeConfirmed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedToBeConfirmed(Boolean value) {
        this.needToBeConfirmed = value;
    }

    /**
     * Gets the value of the size property.
     * 
     */
    public long getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     */
    public void setSize(long value) {
        this.size = value;
    }

    /**
     * Gets the value of the deleted property.
     * 
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets the value of the deleted property.
     * 
     */
    public void setDeleted(boolean value) {
        this.deleted = value;
    }

    /**
     * Gets the value of the deletionTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeletionTime() {
        return deletionTime;
    }

    /**
     * Sets the value of the deletionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeletionTime(XMLGregorianCalendar value) {
        this.deletionTime = value;
    }

    /**
     * Gets the value of the confirmed property.
     * 
     */
    public boolean isConfirmed() {
        return confirmed;
    }

    /**
     * Sets the value of the confirmed property.
     * 
     */
    public void setConfirmed(boolean value) {
        this.confirmed = value;
    }

    /**
     * Gets the value of the confirmedSystem property.
     * 
     * @return
     *     possible object is
     *     {@link System }
     *     
     */
    public System getConfirmedSystem() {
        return confirmedSystem;
    }

    /**
     * Sets the value of the confirmedSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link System }
     *     
     */
    public void setConfirmedSystem(System value) {
        this.confirmedSystem = value;
    }

    /**
     * Gets the value of the confirmationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getConfirmationTime() {
        return confirmationTime;
    }

    /**
     * Sets the value of the confirmationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setConfirmationTime(XMLGregorianCalendar value) {
        this.confirmationTime = value;
    }

}
