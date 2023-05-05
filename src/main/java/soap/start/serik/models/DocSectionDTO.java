package soap.start.serik.models;

import kz.bee.bip.esedo.Attachment;
import kz.bee.bip.esedo.DocSection;
import kz.bee.bip.esedo.MetadataSystem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
@Table(name = "doc_section")
public class DocSectionDTO {
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
    private String carrierType;
    @Column
    private Long character;
    @Column
    private String controlTypeCode;
    @Column
    private String controlTypeNameKz;
    @Column
    private String controlTypeNameRu;
    @Column(length = 5000)
    private String description;
    @Column
    private String dirordNumberKpm;
    @Column
    private Date docDate;
    @Column
    private Long docKind;
    @Column
    private String docNumber;
    @Column
    private String docSection;
    @Column
    private String documentSectionId;
    @Column
    private String employeePhone;
    @Column
    private Date executionDate;
    @Column
    private String executor;
    @Column
    private Date inDate;
    @Column
    private Date preparedDate;
    @Column
    private String sectionId;
    @Column
    private String signerNameRu;
    @Column
    private Boolean isSent;
    public DocSectionDTO(DocSection docSection){
        this.setAttachments(new ArrayList<>());
        for(Attachment attachment : docSection.getAttachments() ){
            AttachmentDTO attachmentDTO = new AttachmentDTO();
            attachmentDTO.setFileIdentifier(attachment.getFileIdentifier());
            this.getAttachments().add(attachmentDTO);
        }
        this.activityId = docSection.getMetadataSystem().getActivityId();
        this.from = docSection.getMetadataSystem().getFrom();
        this.href = docSection.getMetadataSystem().getHref();
        this.performers = docSection.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = docSection.getMetadataSystem().getSenderOrg();

        this.carrierType = docSection.getCarrierType();
        this.character = docSection.getCharacter();
        this.controlTypeCode = docSection.getControlTypeCode();
        this.controlTypeNameKz = docSection.getControlTypeNameKz();
        this.controlTypeNameRu = docSection.getControlTypeNameRu();
        this.description = docSection.getDescription();
        this.dirordNumberKpm = docSection.getDirordNumberKpm();
        XMLGregorianCalendar docDate = docSection.getDocDate();
        if(docDate!=null) {
            this.docDate = docDate.toGregorianCalendar().getTime();
        }
        this.docKind = docSection.getDocKind();
        this.docNumber = docSection.getDocNumber();
        this.docSection = docSection.getDocSection();
        this.documentSectionId = docSection.getDocumentSectionId();
        this.employeePhone = docSection.getEmployeePhone();
        XMLGregorianCalendar executionDate = docSection.getExecutionDate();
        if(executionDate!=null) {
            this.executionDate = executionDate.toGregorianCalendar().getTime();
        }
        this.executor = docSection.getExecutor();
        XMLGregorianCalendar inDate = docSection.getInDate();
        if(inDate!=null) {
            this.inDate = inDate.toGregorianCalendar().getTime();
        }
        XMLGregorianCalendar preparedDate = docSection.getPreparedDate();
        if(preparedDate!=null) {
            this.preparedDate = preparedDate.toGregorianCalendar().getTime();
        }
        this.sectionId = docSection.getSectionId();
        this.signerNameRu = docSection.getSignerNameRu();
    }
    public DocSection toDocSection() throws DatatypeConfigurationException {
        DocSection docSection = new DocSection();
        MetadataSystem metadataSystem = new MetadataSystem();
        for(AttachmentDTO attachmentDTO : this.attachments ){
            Attachment attachment = new Attachment();
            attachment.setFileIdentifier(attachmentDTO.getFileIdentifier());
            docSection.getAttachments().add(attachment);
        }
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        docSection.setMetadataSystem(metadataSystem);
        docSection.setCarrierType(this.carrierType);
        docSection.setCharacter(this.character);
        docSection.setControlTypeCode(this.controlTypeCode);
        docSection.setControlTypeNameKz(this.controlTypeNameKz);
        docSection.setControlTypeNameRu(this.controlTypeNameRu);
        docSection.setDescription(this.description);
        docSection.setDirordNumberKpm(this.dirordNumberKpm);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.docDate);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docSection.setDocDate(xmlGregorianCalendar);

        docSection.setDocKind(this.docKind);
        docSection.setDocNumber(this.docNumber);
        docSection.setDocSection(this.docSection);
        docSection.setDocumentSectionId(this.documentSectionId);
        docSection.setEmployeePhone(this.employeePhone);

        gregorianCalendar.setTime(this.executionDate);
        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docSection.setExecutionDate(xmlGregorianCalendar);

        docSection.setExecutor(this.executor);

        gregorianCalendar.setTime(this.inDate);
        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docSection.setInDate(xmlGregorianCalendar);

        gregorianCalendar.setTime(this.preparedDate);
        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docSection.setPreparedDate(xmlGregorianCalendar);

        docSection.setSectionId(this.sectionId);
        docSection.setSignerNameRu(this.signerNameRu);

        return docSection;
    }
}
