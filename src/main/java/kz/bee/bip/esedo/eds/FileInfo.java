
package kz.bee.bip.esedo.eds;

import kz.bee.bip.esedo.System;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Информация о файле
 * 
 * <p>Java class for FileInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uploadDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="uploaderSystem" type="{http://egov.bee.kz/eds/tempstorage/v2/}System"/&gt;
 *         &lt;element name="expirationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="needToBeConfirmed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="deleted" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="deletionTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="confirmed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="confirmedSystem" type="{http://egov.bee.kz/eds/tempstorage/v2/}System" minOccurs="0"/&gt;
 *         &lt;element name="confirmationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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

    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected String name;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected String mime;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar uploadDate;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", required = true)
    protected System uploaderSystem;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationTime;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected Boolean needToBeConfirmed;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected long size;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected boolean deleted;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deletionTime;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected boolean confirmed;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected System confirmedSystem;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
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
