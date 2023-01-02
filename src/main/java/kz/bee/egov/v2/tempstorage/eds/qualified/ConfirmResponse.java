
package kz.bee.egov.v2.tempstorage.eds.qualified;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Результат запроса на подтверждение скачивания файлов
 * 
 * <p>Java class for ConfirmResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfirmResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileConfirmResults" type="{http://egov.bee.kz/eds/tempstorage/v2/}FileConfirmResult" maxOccurs="unbounded"/>
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
@XmlType(name = "ConfirmResponse", propOrder = {
    "fileConfirmResults",
    "status"
})
public class ConfirmResponse {

    @XmlElement(required = true)
    protected List<FileConfirmResult> fileConfirmResults;
    @XmlElement(required = true)
    protected ProcessStatus status;

    /**
     * Gets the value of the fileConfirmResults property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileConfirmResults property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileConfirmResults().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileConfirmResult }
     *
     *
     */
    public List<FileConfirmResult> getFileConfirmResults() {
        if (fileConfirmResults == null) {
            fileConfirmResults = new ArrayList<FileConfirmResult>();
        }
        return this.fileConfirmResults;
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
