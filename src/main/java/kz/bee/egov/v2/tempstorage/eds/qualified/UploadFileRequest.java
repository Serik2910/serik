
package kz.bee.egov.v2.tempstorage.eds.qualified;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Информация о загружаемом в ХЭД файле и его содержимое
 * 
 * <p>Java class for UploadFileRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UploadFileRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileProcessIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lifeTime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="needToBeConfirmed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadFileRequest", propOrder = {
    "fileProcessIdentifier",
    "content",
    "name",
    "mime",
    "lifeTime",
    "needToBeConfirmed"
})
public class UploadFileRequest {

    @XmlElement(required = true)
    protected String fileProcessIdentifier;
    @XmlElement(required = true)
    protected byte[] content;
    protected String name;
    protected String mime;
    protected Long lifeTime;
    protected Boolean needToBeConfirmed;

    /**
     * Gets the value of the fileProcessIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileProcessIdentifier() {
        return fileProcessIdentifier;
    }

    /**
     * Sets the value of the fileProcessIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileProcessIdentifier(String value) {
        this.fileProcessIdentifier = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setContent(byte[] value) {
        this.content = value;
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
     * Gets the value of the lifeTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLifeTime() {
        return lifeTime;
    }

    /**
     * Sets the value of the lifeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLifeTime(Long value) {
        this.lifeTime = value;
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

}
