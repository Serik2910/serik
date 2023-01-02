
package kz.bee.bip.esedo;

import kz.bee.bip.SyncChannel.v10.Types.SyncMessageInfo;
import kz.bee.bip.SyncChannel.v10.Types.SyncMessageInfoResponse;
import kz.bee.bip.common.v10.Types.ErrorInfo;
import kz.bee.bip.esedo.eds.*;
import kz.bee.bip.esedo.nsi.DictionaryElement;
import kz.bee.bip.esedo.nsi.DictionaryRequest;
import kz.bee.bip.esedo.nsi.DictionaryResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the kz.bee.bip.esedo package. 
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

    private final static QName _SendMessageFault1SendMessageFault_QNAME = new QName("http://bip.bee.kz/SyncChannel/v10/Types", "SendMessageFault1_SendMessageFault");
    private final static QName _TempStorageRequest_QNAME = new QName("http://egov.bee.kz/eds/tempstorage/v2/", "tempStorageRequest");
    private final static QName _TempStorageResponse_QNAME = new QName("http://egov.bee.kz/eds/tempstorage/v2/", "tempStorageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: kz.bee.bip.esedo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendMessage }
     * 
     */
    public SendMessage createSendMessage() {
        return new SendMessage();
    }

    /**
     * Create an instance of {@link SyncSendMessageRequest }
     * 
     */
    public SyncSendMessageRequest createSyncSendMessageRequest() {
        return new SyncSendMessageRequest();
    }

    /**
     * Create an instance of {@link SendMessageResponse }
     * 
     */
    public SendMessageResponse createSendMessageResponse() {
        return new SendMessageResponse();
    }

    /**
     * Create an instance of {@link SyncSendMessageResponse }
     * 
     */
    public SyncSendMessageResponse createSyncSendMessageResponse() {
        return new SyncSendMessageResponse();
    }

    /**
     * Create an instance of {@link ErrorInfo }
     * 
     */
    public ErrorInfo createErrorInfo() {
        return new ErrorInfo();
    }

    /**
     * Create an instance of {@link SyncMessageInfo }
     * 
     */
    public SyncMessageInfo createSyncMessageInfo() {
        return new SyncMessageInfo();
    }

    /**
     * Create an instance of {@link SyncMessageInfoResponse }
     * 
     */
    public SyncMessageInfoResponse createSyncMessageInfoResponse() {
        return new SyncMessageInfoResponse();
    }

    /**
     * Create an instance of {@link DictionaryRequest }
     * 
     */
    public DictionaryRequest createDictionaryRequest() {
        return new DictionaryRequest();
    }

    /**
     * Create an instance of {@link DictionaryResponse }
     * 
     */
    public DictionaryResponse createDictionaryResponse() {
        return new DictionaryResponse();
    }

    /**
     * Create an instance of {@link DictionaryElement }
     * 
     */
    public DictionaryElement createDictionaryElement() {
        return new DictionaryElement();
    }

    /**
     * Create an instance of {@link Attachment }
     * 
     */
    public Attachment createAttachment() {
        return new Attachment();
    }

    /**
     * Create an instance of {@link MetadataSystem }
     * 
     */
    public MetadataSystem createMetadataSystem() {
        return new MetadataSystem();
    }

    /**
     * Create an instance of {@link DocSection }
     * 
     */
    public DocSection createDocSection() {
        return new DocSection();
    }

    /**
     * Create an instance of {@link DocAppeal }
     * 
     */
    public DocAppeal createDocAppeal() {
        return new DocAppeal();
    }

    /**
     * Create an instance of {@link DocOL }
     * 
     */
    public DocOL createDocOL() {
        return new DocOL();
    }

    /**
     * Create an instance of {@link DocOutgoing }
     * 
     */
    public DocOutgoing createDocOutgoing() {
        return new DocOutgoing();
    }

    /**
     * Create an instance of {@link EECBApprovalData }
     * 
     */
    public EECBApprovalData createEECBApprovalData() {
        return new EECBApprovalData();
    }

    /**
     * Create an instance of {@link EECBPublication }
     * 
     */
    public EECBPublication createEECBPublication() {
        return new EECBPublication();
    }

    /**
     * Create an instance of {@link EECBDocumentMetadata }
     * 
     */
    public EECBDocumentMetadata createEECBDocumentMetadata() {
        return new EECBDocumentMetadata();
    }

    /**
     * Create an instance of {@link StateFinished }
     * 
     */
    public StateFinished createStateFinished() {
        return new StateFinished();
    }

    /**
     * Create an instance of {@link StateProlongExDate }
     * 
     */
    public StateProlongExDate createStateProlongExDate() {
        return new StateProlongExDate();
    }

    /**
     * Create an instance of {@link StateNewExDate }
     * 
     */
    public StateNewExDate createStateNewExDate() {
        return new StateNewExDate();
    }

    /**
     * Create an instance of {@link StateTakeOfControl }
     * 
     */
    public StateTakeOfControl createStateTakeOfControl() {
        return new StateTakeOfControl();
    }

    /**
     * Create an instance of {@link StateNotValid }
     * 
     */
    public StateNotValid createStateNotValid() {
        return new StateNotValid();
    }

    /**
     * Create an instance of {@link StateNewControl }
     * 
     */
    public StateNewControl createStateNewControl() {
        return new StateNewControl();
    }

    /**
     * Create an instance of {@link StateDelivered }
     * 
     */
    public StateDelivered createStateDelivered() {
        return new StateDelivered();
    }

    /**
     * Create an instance of {@link StateNewControlWrong }
     * 
     */
    public StateNewControlWrong createStateNewControlWrong() {
        return new StateNewControlWrong();
    }

    /**
     * Create an instance of {@link StateRegistered }
     * 
     */
    public StateRegistered createStateRegistered() {
        return new StateRegistered();
    }

    /**
     * Create an instance of {@link StateStartProcessResponse }
     * 
     */
    public StateStartProcessResponse createStateStartProcessResponse() {
        return new StateStartProcessResponse();
    }

    /**
     * Create an instance of {@link StateExecution }
     * 
     */
    public StateExecution createStateExecution() {
        return new StateExecution();
    }

    /**
     * Create an instance of {@link StateTakeOfControlWrong }
     * 
     */
    public StateTakeOfControlWrong createStateTakeOfControlWrong() {
        return new StateTakeOfControlWrong();
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
     * Create an instance of {@link ConfirmRequest }
     * 
     */
    public ConfirmRequest createConfirmRequest() {
        return new ConfirmRequest();
    }

    /**
     * Create an instance of {@link ConfirmResponse }
     * 
     */
    public ConfirmResponse createConfirmResponse() {
        return new ConfirmResponse();
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
     * Create an instance of {@link FileConfirmResult }
     * 
     */
    public FileConfirmResult createFileConfirmResult() {
        return new FileConfirmResult();
    }

    /**
     * Create an instance of {@link FileDownloadResult }
     * 
     */
    public FileDownloadResult createFileDownloadResult() {
        return new FileDownloadResult();
    }

    /**
     * Create an instance of {@link FileInfo }
     * 
     */
    public FileInfo createFileInfo() {
        return new FileInfo();
    }

    /**
     * Create an instance of {@link FileInfoResult }
     * 
     */
    public FileInfoResult createFileInfoResult() {
        return new FileInfoResult();
    }

    /**
     * Create an instance of {@link FileUploadResult }
     * 
     */
    public FileUploadResult createFileUploadResult() {
        return new FileUploadResult();
    }

    /**
     * Create an instance of {@link GetFileInfoRequest }
     * 
     */
    public GetFileInfoRequest createGetFileInfoRequest() {
        return new GetFileInfoRequest();
    }

    /**
     * Create an instance of {@link GetFileInfoResponse }
     * 
     */
    public GetFileInfoResponse createGetFileInfoResponse() {
        return new GetFileInfoResponse();
    }

    /**
     * Create an instance of {@link ProcessStatus }
     * 
     */
    public ProcessStatus createProcessStatus() {
        return new ProcessStatus();
    }

    /**
     * Create an instance of {@link SenderInfo }
     * 
     */
    public SenderInfo createSenderInfo() {
        return new SenderInfo();
    }

    /**
     * Create an instance of {@link System }
     * 
     */
    public System createSystem() {
        return new System();
    }

    /**
     * Create an instance of {@link UploadFileRequest }
     * 
     */
    public UploadFileRequest createUploadFileRequest() {
        return new UploadFileRequest();
    }

    /**
     * Create an instance of {@link UploadRequest }
     * 
     */
    public UploadRequest createUploadRequest() {
        return new UploadRequest();
    }

    /**
     * Create an instance of {@link UploadResponse }
     * 
     */
    public UploadResponse createUploadResponse() {
        return new UploadResponse();
    }

    /**
     * Create an instance of {@link RequestData }
     * 
     */
    public RequestData createRequestData() {
        return new RequestData();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link StatusInfo }
     * 
     */
    public StatusInfo createStatusInfo() {
        return new StatusInfo();
    }

    /**
     * Create an instance of {@link ResponseData }
     * 
     */
    public ResponseData createResponseData() {
        return new ResponseData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ErrorInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://bip.bee.kz/SyncChannel/v10/Types", name = "SendMessageFault_SendMessageFault")
    public JAXBElement<ErrorInfo> createSendMessageFault1SendMessageFault(ErrorInfo value) {
        return new JAXBElement<ErrorInfo>(_SendMessageFault1SendMessageFault_QNAME, ErrorInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TempStorageRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TempStorageRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", name = "tempStorageRequest")
    public JAXBElement<TempStorageRequest> createTempStorageRequest(TempStorageRequest value) {
        return new JAXBElement<TempStorageRequest>(_TempStorageRequest_QNAME, TempStorageRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TempStorageResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TempStorageResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", name = "tempStorageResponse")
    public JAXBElement<TempStorageResponse> createTempStorageResponse(TempStorageResponse value) {
        return new JAXBElement<TempStorageResponse>(_TempStorageResponse_QNAME, TempStorageResponse.class, null, value);
    }

}
