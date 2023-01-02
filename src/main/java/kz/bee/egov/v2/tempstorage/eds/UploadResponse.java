
package kz.bee.egov.v2.tempstorage.eds;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Результат запроса на загрузку файлов
 * 
 * <p>Java class for UploadResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UploadResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uploadFileResults" type="{http://egov.bee.kz/eds/tempstorage/v2/}FileUploadResult" maxOccurs="unbounded"/>
 *         &lt;element name="status" type="{http://egov.bee.kz/eds/tempstorage/v2/}ProcessStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadResponse", propOrder = {
    "uploadFileResults",
    "status"
})
public class UploadResponse {

    @XmlElement(required = true)
    protected List<FileUploadResult> uploadFileResults;
    @XmlElement(required = true)
    protected ProcessStatus status;

    /**
     * Gets the value of the uploadFileResults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uploadFileResults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUploadFileResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileUploadResult }
     * 
     * 
     */
    public List<FileUploadResult> getUploadFileResults() {
        if (uploadFileResults == null) {
            uploadFileResults = new ArrayList<FileUploadResult>();
        }
        return this.uploadFileResults;
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

}
