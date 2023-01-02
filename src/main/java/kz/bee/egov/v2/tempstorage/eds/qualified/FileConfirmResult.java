
package kz.bee.egov.v2.tempstorage.eds.qualified;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Информация о результате подтверждения скачивания файла
 * 
 * <p>Java class for FileConfirmResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileConfirmResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://egov.bee.kz/eds/tempstorage/v2/}ProcessStatus"/>
 *         &lt;element name="fileIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileConfirmResult", propOrder = {
    "status",
    "fileIdentifier"
})
public class FileConfirmResult {

    @XmlElement(required = true)
    protected ProcessStatus status;
    @XmlElement(required = true)
    protected String fileIdentifier;

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

}
