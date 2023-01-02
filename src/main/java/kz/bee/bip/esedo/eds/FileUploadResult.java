
package kz.bee.bip.esedo.eds;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Результат загрузки файла в ХЭД
 * 
 * <p>Java class for FileUploadResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileUploadResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fileProcessIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="status" type="{http://egov.bee.kz/eds/tempstorage/v2/}ProcessStatus"/&gt;
 *         &lt;element name="fileIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lifeTime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileUploadResult", propOrder = {
    "fileProcessIdentifier",
    "status",
    "fileIdentifier",
    "lifeTime"
})
public class FileUploadResult {

    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", required = true)
    protected String fileProcessIdentifier;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", required = true)
    protected ProcessStatus status;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected String fileIdentifier;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected Long lifeTime;

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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessStatus }
     *     
     */
    public ProcessStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessStatus }
     *     
     */
    public void setStatus(ProcessStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the fileIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileIdentifier() {
        return fileIdentifier;
    }

    /**
     * Sets the value of the fileIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileIdentifier(String value) {
        this.fileIdentifier = value;
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

}
