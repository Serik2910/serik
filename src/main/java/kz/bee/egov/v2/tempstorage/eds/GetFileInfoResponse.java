
package kz.bee.egov.v2.tempstorage.eds;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Результат запроса метаинформации файлов
 * 
 * <p>Java class for GetFileInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFileInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileInfoResults" type="{http://egov.bee.kz/eds/tempstorage/v2/}FileInfoResult" maxOccurs="unbounded"/>
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
@XmlType(name = "GetFileInfoResponse", propOrder = {
    "fileInfoResults",
    "status"
})
public class GetFileInfoResponse {

    @XmlElement(required = true)
    protected List<FileInfoResult> fileInfoResults;
    @XmlElement(required = true)
    protected ProcessStatus status;

    /**
     * Gets the value of the fileInfoResults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileInfoResults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileInfoResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileInfoResult }
     * 
     * 
     */
    public List<FileInfoResult> getFileInfoResults() {
        if (fileInfoResults == null) {
            fileInfoResults = new ArrayList<FileInfoResult>();
        }
        return this.fileInfoResults;
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
