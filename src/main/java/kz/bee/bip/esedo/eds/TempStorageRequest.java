
package kz.bee.bip.esedo.eds;

import kz.bee.bip.esedo.SenderInfo;

import javax.xml.bind.annotation.*;


/**
 * Запрос ко временному хранилищу
 * 
 * <p>Java class for TempStorageRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TempStorageRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="type" type="{http://egov.bee.kz/eds/tempstorage/v2/}TempStorageRequestType"/&gt;
 *         &lt;element name="uploadRequest" type="{http://egov.bee.kz/eds/tempstorage/v2/}UploadRequest" minOccurs="0"/&gt;
 *         &lt;element name="downloadRequest" type="{http://egov.bee.kz/eds/tempstorage/v2/}DownloadRequest" minOccurs="0"/&gt;
 *         &lt;element name="confirmRequest" type="{http://egov.bee.kz/eds/tempstorage/v2/}ConfirmRequest" minOccurs="0"/&gt;
 *         &lt;element name="getFileInfoRequest" type="{http://egov.bee.kz/eds/tempstorage/v2/}GetFileInfoRequest" minOccurs="0"/&gt;
 *         &lt;element name="credentials" type="{http://egov.bee.kz/eds/tempstorage/v2/}SenderInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TempStorageRequest", propOrder = {
    "type",
    "uploadRequest",
    "downloadRequest",
    "confirmRequest",
    "getFileInfoRequest",
    "credentials"
})
public class TempStorageRequest {

    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", required = true)
    @XmlSchemaType(name = "string")
    protected TempStorageRequestType type;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected UploadRequest uploadRequest;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected DownloadRequest downloadRequest;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected ConfirmRequest confirmRequest;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/")
    protected GetFileInfoRequest getFileInfoRequest;
    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", required = true)
    protected SenderInfo credentials;

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
     * Gets the value of the uploadRequest property.
     * 
     * @return
     *     possible object is
     *     {@link UploadRequest }
     *     
     */
    public UploadRequest getUploadRequest() {
        return uploadRequest;
    }

    /**
     * Sets the value of the uploadRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link UploadRequest }
     *     
     */
    public void setUploadRequest(UploadRequest value) {
        this.uploadRequest = value;
    }

    /**
     * Gets the value of the downloadRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadRequest }
     *     
     */
    public DownloadRequest getDownloadRequest() {
        return downloadRequest;
    }

    /**
     * Sets the value of the downloadRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadRequest }
     *     
     */
    public void setDownloadRequest(DownloadRequest value) {
        this.downloadRequest = value;
    }

    /**
     * Gets the value of the confirmRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ConfirmRequest }
     *     
     */
    public ConfirmRequest getConfirmRequest() {
        return confirmRequest;
    }

    /**
     * Sets the value of the confirmRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfirmRequest }
     *     
     */
    public void setConfirmRequest(ConfirmRequest value) {
        this.confirmRequest = value;
    }

    /**
     * Gets the value of the getFileInfoRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetFileInfoRequest }
     *     
     */
    public GetFileInfoRequest getGetFileInfoRequest() {
        return getFileInfoRequest;
    }

    /**
     * Sets the value of the getFileInfoRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFileInfoRequest }
     *     
     */
    public void setGetFileInfoRequest(GetFileInfoRequest value) {
        this.getFileInfoRequest = value;
    }

    /**
     * Gets the value of the credentials property.
     * 
     * @return
     *     possible object is
     *     {@link SenderInfo }
     *     
     */
    public SenderInfo getCredentials() {
        return credentials;
    }

    /**
     * Sets the value of the credentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link SenderInfo }
     *     
     */
    public void setCredentials(SenderInfo value) {
        this.credentials = value;
    }

}
