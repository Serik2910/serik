
package kz.bee.bip.esedo.eds;



import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the kz.bee.egov.v2.tempstorage.eds package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TempStorageRequest_QNAME = new QName("http://egov.bee.kz/eds/tempstorage/v2/", "tempStorageRequest");
    private final static QName _TempStorageResponse_QNAME = new QName("http://egov.bee.kz/eds/tempstorage/v2/", "tempStorageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: kz.bee.egov.v2.tempstorage.eds
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TempStorageRequest }
     * 
     */
    public TempStorageRequest createTempStorageRequest() {
        return new TempStorageRequest();
    }

    /**
     * Create an instance of {@link TempStorageResponse }
     * 
     */
    public TempStorageResponse createTempStorageResponse() {
        return new TempStorageResponse();
    }

    /**
     * Create an instance of {@link FileInfoResult }
     * 
     */
    public FileInfoResult createFileInfoResult() {
        return new FileInfoResult();
    }


    /**
     * Create an instance of {@link ConfirmResponse }
     * 
     */
    public ConfirmResponse createConfirmResponse() {
        return new ConfirmResponse();
    }

    /**
     * Create an instance of {@link FileConfirmResult }
     * 
     */
    public FileConfirmResult createFileConfirmResult() {
        return new FileConfirmResult();
    }

    /**
     * Create an instance of {@link ProcessStatus }
     * 
     */
    public ProcessStatus createProcessStatus() {
        return new ProcessStatus();
    }

    /**
     * Create an instance of {@link DownloadRequest }
     * 
     */
    public DownloadRequest createDownloadRequest() {
        return new DownloadRequest();
    }

    /**
     * Create an instance of {@link DownloadResponse }
     * 
     */
    public DownloadResponse createDownloadResponse() {
        return new DownloadResponse();
    }



    /**
     * Create an instance of {@link UploadFileRequest }
     * 
     */
    public UploadFileRequest createUploadFileRequest() {
        return new UploadFileRequest();
    }

    /**
     * Create an instance of {@link UploadResponse }
     * 
     */
    public UploadResponse createUploadResponse() {
        return new UploadResponse();
    }

    /**
     * Create an instance of {@link FileUploadResult }
     * 
     */
    public FileUploadResult createFileUploadResult() {
        return new FileUploadResult();
    }

    /**
     * Create an instance of {@link FileInfo }
     * 
     */
    public FileInfo createFileInfo() {
        return new FileInfo();
    }

    /**
     * Create an instance of {@link GetFileInfoRequest }
     * 
     */
    public GetFileInfoRequest createGetFileInfoRequest() {
        return new GetFileInfoRequest();
    }

    /**
     * Create an instance of {@link UploadRequest }
     * 
     */
    public UploadRequest createUploadRequest() {
        return new UploadRequest();
    }

    /**
     * Create an instance of {@link GetFileInfoResponse }
     * 
     */
    public GetFileInfoResponse createGetFileInfoResponse() {
        return new GetFileInfoResponse();
    }

    /**
     * Create an instance of {@link FileDownloadResult }
     * 
     */
    public FileDownloadResult createFileDownloadResult() {
        return new FileDownloadResult();
    }

    /**
     * Create an instance of {@link ConfirmRequest }
     * 
     */
    public ConfirmRequest createConfirmRequest() {
        return new ConfirmRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TempStorageRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", name = "tempStorageRequest")
    public JAXBElement<TempStorageRequest> createTempStorageRequest(TempStorageRequest value) {
        return new JAXBElement<TempStorageRequest>(_TempStorageRequest_QNAME, TempStorageRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TempStorageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", name = "tempStorageResponse")
    public JAXBElement<TempStorageResponse> createTempStorageResponse(TempStorageResponse value) {
        return new JAXBElement<TempStorageResponse>(_TempStorageResponse_QNAME, TempStorageResponse.class, null, value);
    }

}
