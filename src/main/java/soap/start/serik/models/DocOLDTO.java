package soap.start.serik.models;

import kz.bee.bip.esedo.Attachment;
import kz.bee.bip.esedo.DocOL;
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
@Table(name = "doc_ol")
public class DocOLDTO {
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
    private String address;
    @Column
    private String appendCount;
    @Column
    private String carrierType;
    @Column
    private Long character;
    @Column
    private String citizenship;
    @Column
    private String controlTypeOuterCode;
    @Column
    private String controlTypeOuterNameKz;
    @Column
    private String controlTypeOuterNameRu;
    @Column
    private Date deliveryDate;
    @Column(length = 5000)
    private String description;
    @Column
    private Date docDateR;
    @Column
    private Long docKind;
    @Column
    private String docLang;
    @Column
    private String docNoR;
    @Column
    private String docReqAuthor;
    @Column
    private Long documentType;
    @Column
    private String email;
    @Column
    private Date executionDate;
    @Column
    private Long idPortalInternal;
    @Column
    private String juridicallyName;
    @Column
    private String middlename;
    @Column
    private String name;
    @Column
    private String note;
    @Column
    private String phone;
    @Column(length = 20000)
    private String portalSign;
    @Column
    private Date preparedDate;
    @Column
    private Date regDateOL;
    @Column
    private String regNumberOL;
    @Column
    private String region;
    @Column(length = 20000)
    private String secondSignData;
    @Column
    private String secondSignEnabled;
    @Column
    private String sheetCount;
    @Column
    private String signerNameKz;
    @Column
    private String signerNameRu;
    @Column
    private Long socialOrder;
    @Column
    private String surname;
    @Column
    private String uniqueNumber;
    @Column
    private String userUin;
    @Column
    private Boolean isSent;
    public DocOLDTO(DocOL docOL){
        this.setAttachments(new ArrayList<>());
        for(Attachment attachment : docOL.getAttachments() ){
            AttachmentDTO attachmentDTO = new AttachmentDTO();
            attachmentDTO.setFileIdentifier(attachment.getFileIdentifier());
            this.getAttachments().add(attachmentDTO);
        }
        this.activityId = docOL.getMetadataSystem().getActivityId();
        this.from = docOL.getMetadataSystem().getFrom();
        this.href = docOL.getMetadataSystem().getHref();
        this.performers = docOL.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = docOL.getMetadataSystem().getSenderOrg();

        this.address = docOL.getAddress();
        this.appendCount = docOL.getAppendCount();
        this.carrierType = docOL.getCarrierType();
        this.character = docOL.getCharacter();
        this.citizenship = docOL.getCitizenship();
        this.controlTypeOuterCode = docOL.getControlTypeOuterCode();
        this.controlTypeOuterNameKz = docOL.getControlTypeOuterNameKz();
        this.controlTypeOuterNameRu = docOL.getControlTypeOuterNameRu();
        XMLGregorianCalendar deliveryDate = docOL.getDeliveryDate();
        if(deliveryDate!=null) {
            this.deliveryDate = deliveryDate.toGregorianCalendar().getTime();
        }
        this.description = docOL.getDescription();
        XMLGregorianCalendar docDateR = docOL.getDocDateR();
        if(docDateR!=null) {
            this.docDateR = docDateR.toGregorianCalendar().getTime();
        }
        this.docKind = docOL.getDocKind();
        this.docLang = docOL.getDocLang();
        this.docNoR = docOL.getDocNoR();
        this.docReqAuthor = docOL.getDocReqAuthor();
        this.documentType = docOL.getDocumentType();
        this.email = docOL.getEmail();
        XMLGregorianCalendar executionDate = docOL.getExecutionDate();
        if(executionDate!=null) {
            this.executionDate = executionDate.toGregorianCalendar().getTime();
        }
        this.idPortalInternal = docOL.getIdPortalInternal();
        this.juridicallyName = docOL.getJuridicallyName();
        this.name = docOL.getName();
        this.middlename = docOL.getMiddlename();
        this.note = docOL.getNote();
        this.phone = docOL.getPhone();
        this.portalSign = docOL.getPortalSign();
        XMLGregorianCalendar preparedDate = docOL.getPreparedDate();
        if(preparedDate!=null) {
            this.preparedDate = preparedDate.toGregorianCalendar().getTime();
        }
        XMLGregorianCalendar regDateOL = docOL.getRegDateOL();
        if(regDateOL!=null) {
            this.regDateOL = regDateOL.toGregorianCalendar().getTime();
        }
        this.regNumberOL = docOL.getRegNumberOL();
        this.region = docOL.getRegion();
        this.secondSignData = docOL.getSecondSignData();
        this.secondSignEnabled = docOL.getSecondSignEnabled();
        this.sheetCount = docOL.getSheetCount();
        this.signerNameKz = docOL.getSignerNameKz();
        this.signerNameRu = docOL.getSignerNameRu();
        this.socialOrder = docOL.getSocialOrder();
        this.surname = docOL.getSurname();
        this.uniqueNumber = docOL.getUniqueNumber();
        this.userUin = docOL.getUserUin();
    }

    public DocOL toDocOL(DocOLDTO docOLDTO) throws DatatypeConfigurationException {
        DocOL docOL = new DocOL();
        MetadataSystem metadataSystem = new MetadataSystem();
        for(AttachmentDTO attachmentDTO : this.attachments ){
            Attachment attachment = new Attachment();
            attachment.setFileIdentifier(attachmentDTO.getFileIdentifier());
            docOL.getAttachments().add(attachment);
        }
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        docOL.setMetadataSystem(metadataSystem);

        docOL.setAddress(this.address);
        docOL.setAppendCount(this.appendCount);
        docOL.setCarrierType(this.carrierType);
        docOL.setCharacter(this.character);
        docOL.setCitizenship(this.citizenship);
        docOL.setControlTypeOuterCode(this.controlTypeOuterCode);
        docOL.setControlTypeOuterNameKz(this.controlTypeOuterNameKz);
        docOL.setControlTypeOuterNameRu(this.controlTypeOuterNameRu);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.deliveryDate);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docOL.setDeliveryDate(xmlGregorianCalendar);
        docOL.setDescription(this.description);

        gregorianCalendar.setTime(this.docDateR);
        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docOL.setDocDateR(xmlGregorianCalendar);

        docOL.setDocKind(this.docKind);
        docOL.setDocLang(this.docLang);
        docOL.setDocNoR(this.docNoR);
        docOL.setDocReqAuthor(this.docReqAuthor);
        docOL.setDocumentType(this.documentType);
        docOL.setEmail(this.email);

        gregorianCalendar.setTime(this.executionDate);
        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docOL.setExecutionDate(xmlGregorianCalendar);

        docOL.setIdPortalInternal(this.idPortalInternal);
        docOL.setJuridicallyName(this.juridicallyName);
        docOL.setMiddlename(this.middlename);
        docOL.setName(this.name);
        docOL.setNote(this.note);
        docOL.setPhone(this.phone);
        docOL.setPortalSign(this.portalSign);

        gregorianCalendar.setTime(this.preparedDate);
        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docOL.setPreparedDate(xmlGregorianCalendar);

        gregorianCalendar.setTime(this.regDateOL);
        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docOL.setRegDateOL(xmlGregorianCalendar);

        docOL.setRegNumberOL(this.regNumberOL);
        docOL.setRegion(this.region);
        docOL.setSecondSignData(this.secondSignData);
        docOL.setSecondSignEnabled(this.secondSignEnabled);
        docOL.setSheetCount(this.sheetCount);
        docOL.setSignerNameKz(this.signerNameKz);
        docOL.setSignerNameRu(this.signerNameRu);
        docOL.setSocialOrder(this.socialOrder);
        docOL.setSurname(this.surname);
        docOL.setUniqueNumber(this.uniqueNumber);
        docOL.setUserUin(this.userUin);
        return docOL;
    }
}
