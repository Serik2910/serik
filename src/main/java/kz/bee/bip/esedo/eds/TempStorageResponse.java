
package kz.bee.bip.esedo.eds;

import javax.xml.bind.annotation.*;


/**
 * Результат выполнения запроса ко временному хранилищу
 * 
 * <p>Java class for TempStorageResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TempStorageResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="type" type="{http://egov.bee.kz/eds/tempstorage/v2/}TempStorageRequestType"/&gt;
 *         &lt;element name="uploadResponse" type="{http://egov.bee.kz/eds/tempstorage/v2/}UploadResponse" minOccurs="0"/&gt;
 *         &lt;element name="downloadResponse" type="{http://egov.bee.kz/eds/tempstorage/v2/}DownloadResponse" minOccurs="0"/&gt;
 *         &lt;element name="confirmResponse" type="{http://egov.bee.kz/eds/tempstorage/v2/}ConfirmResponse" minOccurs="0"/&gt;
 *         &lt;element name="getFileInfoResponse" type="{http://egov.bee.kz/eds/tempstorage/v2/}GetFileInfoResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TempStorageResponse", propOrder = {
    "type",
    "uploadResponse",
    "downloadResponse",
    "confirmResponse",
    "getFileInfoResponse"
})
public class TempStorageResponse {

    @XmlElement( required = true)
    @XmlSchemaType(name = "string")
    protected TempStorageRequestType type;

    protected UploadResponse uploadResponse;

    protected DownloadResponse downloadResponse;

    protected ConfirmResponse confirmResponse;

    protected GetFileInfoResponse getFileInfoResponse;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TempStorageRequestType }
     *     
     */
    public TempStorageRequestType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TempStorageRequestType }
     *     
     */
    public void setType(TempStorageRequestType value) {
        this.type = value;
    }

    /**
     * Gets the value of the uploadResponse property.
     * 
     * @return
     *     possible object is
     *     {@link UploadResponse }
     *     
     */
    public UploadResponse getUploadResponse() {
        return uploadResponse;
    }

    /**
     * Sets the value of the uploadResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link UploadResponse }
     *     
     */
    public void setUploadResponse(UploadResponse value) {
        this.uploadResponse = value;
    }

    /**
     * Gets the value of the downloadResponse property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadResponse }
     *     
     */
    public DownloadResponse getDownloadResponse() {
        return downloadResponse;
    }

    /**
     * Sets the value of the downloadResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadResponse }
     *     
     */
    public void setDownloadResponse(DownloadResponse value) {
        this.downloadResponse = value;
    }

    /**
     * Gets the value of the confirmResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ConfirmResponse }
     *     
     */
    public ConfirmResponse getConfirmResponse() {
        return confirmResponse;
    }

    /**
     * Sets the value of the confirmResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfirmResponse }
     *     
     */
    public void setConfirmResponse(ConfirmResponse value) {
        this.confirmResponse = value;
    }

    /**
     * Gets the value of the getFileInfoResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetFileInfoResponse }
     *     
     */
    public GetFileInfoResponse getGetFileInfoResponse() {
        return getFileInfoResponse;
    }

    /**
     * Sets the value of the getFileInfoResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFileInfoResponse }
     *     
     */
    public void setGetFileInfoResponse(GetFileInfoResponse value) {
        this.getFileInfoResponse = value;
    }

}
