package soap.start.serik.models;





import kz.bee.egov.v2.tempstorage.eds.UploadFileRequest;
import kz.bee.egov.v2.tempstorage.eds.UploadRequest;
import org.apache.commons.codec.binary.Base64;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadRequestDTO", propOrder = {
        "fileUploadRequests"
})
public class UploadRequestDTO {


    @XmlElement(required = true)
    protected List<UploadFileRequestDTO> fileUploadRequests;

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
    public static UploadRequest getUploadRequestFromDTO(UploadRequestDTO uploadRequesrDTO) throws UnsupportedEncodingException {
        UploadRequest uploadRequest = new UploadRequest();
        List<UploadFileRequest> fileRequestList = uploadRequest.getFileUploadRequests();
        for (UploadFileRequestDTO j:
                uploadRequesrDTO.getFileUploadRequests()) {
            UploadFileRequest uploadFileRequest = new UploadFileRequest();
            uploadFileRequest.setMime(j.getMime());
            uploadFileRequest.setName(j.getName());
            uploadFileRequest.setFileProcessIdentifier(j.getFileProcessIdentifier());
            uploadFileRequest.setNeedToBeConfirmed(j.getNeedToBeConfirmed());
            uploadFileRequest.setContent(Base64.decodeBase64(j.getContent().getBytes("UTF-8")));
            uploadFileRequest.setLifeTime(j.lifeTime);
            fileRequestList.add(uploadFileRequest);
        }
        uploadRequest.setFileUploadRequests(fileRequestList);
        return uploadRequest;
    }

    public List<UploadFileRequestDTO> getFileUploadRequests() {
        if (fileUploadRequests == null) {
            fileUploadRequests = new ArrayList<UploadFileRequestDTO>();
        }
        return this.fileUploadRequests;
    }

}
