
package kz.bee.egov.v2.tempstorage.eds;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Запрос на загрузку файлов
 * 
 * <p>Java class for UploadRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UploadRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileUploadRequests" type="{http://egov.bee.kz/eds/tempstorage/v2/}UploadFileRequest" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadRequest", propOrder = {
    "fileUploadRequests"
})
public class UploadRequest {

    @XmlElement(required = true)
    protected List<UploadFileRequest> fileUploadRequests;

    /**
     * Gets the value of the fileUploadRequests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileUploadRequests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileUploadRequests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UploadFileRequest }
     * 
     * 
     */
    public List<UploadFileRequest> getFileUploadRequests() {
        if (fileUploadRequests == null) {
            fileUploadRequests = new ArrayList<UploadFileRequest>();
        }
        return this.fileUploadRequests;
    }

    public void setFileUploadRequests(List<UploadFileRequest> fileRequestList) {
        fileUploadRequests = fileRequestList;
    }
}
