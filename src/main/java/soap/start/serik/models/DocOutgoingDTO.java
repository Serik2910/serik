package soap.start.serik.models;

import kz.bee.bip.esedo.Attachment;
import kz.bee.bip.esedo.DocOutgoing;
import kz.bee.bip.esedo.EECBDocumentMetadata;
import kz.bee.bip.esedo.MetadataSystem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doc_outgoing")
public class DocOutgoingDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade ={ CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST} )
    private List<AttachmentDTO> attachments;
    @Column
    private String activityId;
    @Column(name = "from_")
    private Long from;
    @Column
    private String href;
    @Column
    private Long performers;
    @Column
    private Long senderOrg;
    @Column
    private String appendCount;
    @Column
    private String authorNameKz;
    @Column
    private String authorNameRu;
    @Column
    private String carrierType;
    @Column
    private Long character;
    @Column
    private String controlTypeOuterCode;
    @Column
    private String controlTypeOuterNameKz;
    @Column
    private String controlTypeOuterNameRu;
    @Column(length = 5000)
    private String description;
    @Column
    private Date docDate;
    @Column
    private Long docKind;
    @Column
    private String docLang;
    @Column
    private String docNo;
    @Column
    private String docNoR;
    @Column
    private String docRecPostKz;
    @Column
    private String docRecPostRu;
    @Column
    private String docToNumber;
    @Column
    private String documentReceiverKz;
    @Column
    private String documentReceiverRu;
    @Column
    private String documentSectionId;
    @Column
    private String employeePhone;
    @Column
    private Date executionDate;
    @Column
    private String executor;
    @Column
    private Long idPortalInternal;
    @Column
    private Date outTime;
    @Column
    private String portalSign;
    @Column
    private Date preparedDate;
    @Column
    private String resolutionText;
    @Column(length = 20000)
    private String secondSignData;
    @Column
    private String secondSignEnabled;
    @Column
    private String sectionId;
    @Column
    private String sheetCount;
    @Column
    private String signerNameKz;
    @Column
    private String signerNameRu;
    @Column
    private String userUin;
    @Column
    private Boolean isSent;
    public DocOutgoingDTO(DocOutgoing docOutgoing){
        this.setAttachments(new ArrayList<>());
        for(Attachment attachment : docOutgoing.getAttachments() ){
            AttachmentDTO attachmentDTO = new AttachmentDTO();
            attachmentDTO.setFileIdentifier(attachment.getFileIdentifier());
            this.getAttachments().add(attachmentDTO);
        }
        this.activityId = docOutgoing.getMetadataSystem().getActivityId();
        this.from = docOutgoing.getMetadataSystem().getFrom();
        this.href = docOutgoing.getMetadataSystem().getHref();
        this.performers = docOutgoing.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = docOutgoing.getMetadataSystem().getSenderOrg();

        this.appendCount = docOutgoing.getAppendCount();
        this.authorNameKz = docOutgoing.getAuthorNameKz();
        this.authorNameRu = docOutgoing.getAuthorNameRu();
        this.carrierType = docOutgoing.getCarrierType();
        this.character = docOutgoing.getCharacter();
        this.controlTypeOuterCode = docOutgoing.getControlTypeOuterCode();
        this.controlTypeOuterNameKz = docOutgoing.getControlTypeOuterNameKz();
        this.controlTypeOuterNameRu = docOutgoing.getControlTypeOuterNameRu();
        this.description = docOutgoing.getDescription();

        XMLGregorianCalendar docDate = docOutgoing.getDocDate();
        if(docDate!=null) {
            this.docDate = docDate.toGregorianCalendar().getTime();
        }

        this.docKind = docOutgoing.getDocKind();
        this.docLang = docOutgoing.getDocLang();
        this.docNo = docOutgoing.getDocNo();
        this.docNoR = docOutgoing.getDocNoR();
        this.docRecPostKz = docOutgoing.getDocRecPostKz();
        this.docRecPostRu = docOutgoing.getDocRecPostRu();
        this.documentSectionId = docOutgoing.getDocumentSectionId();
        this.employeePhone = docOutgoing.getEmployeePhone();

        XMLGregorianCalendar executionDate = docOutgoing.getExecutionDate();
        if(executionDate!=null) {
            this.executionDate = executionDate.toGregorianCalendar().getTime();
        }

        this.executor = docOutgoing.getExecutor();
        this.idPortalInternal = docOutgoing.getIdPortalInternal();

        XMLGregorianCalendar outTime = docOutgoing.getOutTime();
        if(outTime!=null) {
            this.outTime = outTime.toGregorianCalendar().getTime();
        }

        this.portalSign = docOutgoing.getPortalSign();

        XMLGregorianCalendar preparedDate = docOutgoing.getPreparedDate();
        if(preparedDate!=null) {
            this.preparedDate = preparedDate.toGregorianCalendar().getTime();
        }

        this.resolutionText = docOutgoing.getResolutionText();
        this.secondSignData = docOutgoing.getSecondSignData();
        this.secondSignEnabled = docOutgoing.getSecondSignEnabled();
        this.sectionId = docOutgoing.getSectionId();
        this.sheetCount = docOutgoing.getSheetCount();
        this.signerNameKz = docOutgoing.getSignerNameKz();
        this.signerNameRu = docOutgoing.getSignerNameRu();
        this.userUin = docOutgoing.getUserUin();

    }
    public DocOutgoing toDocOutgoing() throws DatatypeConfigurationException {
        DocOutgoing docOutgoing = new DocOutgoing();
        MetadataSystem metadataSystem = new MetadataSystem();
        for(AttachmentDTO attachmentDTO : this.attachments ){
            Attachment attachment = new Attachment();
            attachment.setFileIdentifier(attachmentDTO.getFileIdentifier());
            docOutgoing.getAttachments().add(attachment);
        }
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        docOutgoing.setMetadataSystem(metadataSystem);
        docOutgoing.setAppendCount(this.appendCount);
        docOutgoing.setAuthorNameKz(this.authorNameKz);
        docOutgoing.setAuthorNameRu(this.authorNameRu);
        docOutgoing.setCarrierType(this.carrierType);
        docOutgoing.setCharacter(this.character);
        docOutgoing.setControlTypeOuterCode(this.controlTypeOuterCode);
        docOutgoing.setControlTypeOuterNameKz(this.controlTypeOuterNameKz);
        docOutgoing.setControlTypeOuterNameRu(this.controlTypeOuterNameRu);
        docOutgoing.setDescription(this.description);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.docDate);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docOutgoing.setDocDate(xmlGregorianCalendar);

        docOutgoing.setDocKind(this.docKind);
        docOutgoing.setDocLang(this.docLang);
        docOutgoing.setDocNo(this.docNo);
        docOutgoing.setDocNoR(this.docNoR);
        docOutgoing.setDocRecPostKz(this.docRecPostKz);
        docOutgoing.setDocRecPostRu(this.docRecPostRu);
        docOutgoing.setDocToNumber(this.docToNumber);
        docOutgoing.setDocumentReceiverKz(this.documentReceiverKz);
        docOutgoing.setDocumentReceiverRu(this.documentReceiverRu);
        docOutgoing.setDocumentSectionId(this.documentSectionId);
        docOutgoing.setEmployeePhone(this.employeePhone);

        gregorianCalendar.setTime(this.executionDate);
        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docOutgoing.setExecutionDate(xmlGregorianCalendar);

        docOutgoing.setExecutor(this.executor);
        docOutgoing.setIdPortalInternal(this.idPortalInternal);

        gregorianCalendar.setTime(this.outTime);
        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docOutgoing.setOutTime(xmlGregorianCalendar);

        docOutgoing.setPortalSign(this.portalSign);

        gregorianCalendar.setTime(this.preparedDate);
        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docOutgoing.setPreparedDate(xmlGregorianCalendar);

        docOutgoing.setResolutionText(this.resolutionText);
        docOutgoing.setSecondSignData(this.secondSignData);
        docOutgoing.setSecondSignEnabled(this.secondSignEnabled);
        docOutgoing.setSectionId(this.sectionId);
        docOutgoing.setSheetCount(this.sheetCount);
        docOutgoing.setSignerNameKz(this.signerNameKz);
        docOutgoing.setSignerNameRu(this.signerNameRu);
        docOutgoing.setUserUin(this.userUin);


        return docOutgoing;
    }

}
