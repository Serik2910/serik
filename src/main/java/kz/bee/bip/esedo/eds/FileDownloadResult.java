
package kz.bee.bip.esedo.eds;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Информация о скачиваемом файле и его содержимое
 * 
 * <p>Java class for FileDownloadResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileDownloadResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="status" type="{http://egov.bee.kz/eds/tempstorage/v2/}ProcessStatus"/&gt;
 *         &lt;element name="fileIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="meta" type="{http://egov.bee.kz/eds/tempstorage/v2/}FileInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileDownloadResult", propOrder = {
    "status",
    "fileIdentifier",
    "content",
    "meta"
})
public class FileDownloadResult {

    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", required = true)
    protected ProcessStatus status;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", required = true)
    protected String fileIdentifier;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected byte[] content;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected FileInfo meta;

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
     * Gets the value of the meta property.
     * 
     * @return
     *     possible object is
     *     {@link FileInfo }
     *     
     */
    public FileInfo getMeta() {
        return meta;
    }

    /**
     * Sets the value of the meta property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileInfo }
     *     
     */
    public void setMeta(FileInfo value) {
        this.meta = value;
    }

}
