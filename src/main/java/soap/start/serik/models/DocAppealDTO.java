package soap.start.serik.models;

import kz.bee.bip.esedo.Attachment;
import kz.bee.bip.esedo.DocAppeal;
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
@Table(name = "doc_appeal")
public class DocAppealDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    //attachments id
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
    private Long correspondent;
    @Column
    private Date deliveryDate;
    @Column(length = 5000)
    private String description;
    @Column
    private Long documentType;
    @Column
    private String email;
    @Column
    private Long idPortalInternal;
    @Column
    private String juridicallyName;
    @Column
    private String middlename;
    @Column
    private String name;
    @Column
    private Date outDate;
    @Column
    private String outNumber;
    @Column
    private String phone;
    @Column(length = 20000)
    private String sign;
    @Column
    private String surname;
    @Column
    private String userUin;
    @Column
    private String timeStampData;
    @Column
    private String ocspData;
    @Column
    private Boolean isSent;
    public DocAppealDTO(DocAppeal docAppeal){
        this.setAttachments(new ArrayList<>());
        for(Attachment attachment : docAppeal.getAttachments() ){
            AttachmentDTO attachmentDTO = new AttachmentDTO();
            attachmentDTO.setFileIdentifier(attachment.getFileIdentifier());
            this.getAttachments().add(attachmentDTO);
        }
        this.activityId = docAppeal.getMetadataSystem().getActivityId();
        this.from = docAppeal.getMetadataSystem().getFrom();
        this.href = docAppeal.getMetadataSystem().getHref();
        this.performers = docAppeal.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = docAppeal.getMetadataSystem().getSenderOrg();

        this.address = docAppeal.getAddress();
        this.correspondent = docAppeal.getCorrespondent();
        XMLGregorianCalendar deliveryDate = docAppeal.getDeliveryDate();
        if (deliveryDate!=null){
            this.deliveryDate = deliveryDate.toGregorianCalendar().getTime();
        }
        this.description = docAppeal.getDescription();
        this.documentType = docAppeal.getDocumentType();
        this.email = docAppeal.getEmail();
        this.idPortalInternal = docAppeal.getIdPortalInternal();
        this.juridicallyName = docAppeal.getJuridicallyName();
        this.name = docAppeal.getName();
        this.middlename = docAppeal.getMiddlename();
        XMLGregorianCalendar outDate = docAppeal.getOutDate();
        if (outDate!=null){
            this.outDate = outDate.toGregorianCalendar().getTime();
        }
        this.outNumber = docAppeal.getOutNumber();
        this.phone = docAppeal.getPhone();
        this.sign = docAppeal.getSign();
        this.surname = docAppeal.getSurname();
        this.userUin = docAppeal.getUserUin();
        this.timeStampData = docAppeal.getTimeStampData();
        this.ocspData = docAppeal.getOcspData();
    }
    public DocAppeal toDocAppeal() throws DatatypeConfigurationException {
        DocAppeal docAppeal = new DocAppeal();
        MetadataSystem metadataSystem = new MetadataSystem();
        for(AttachmentDTO attachmentDTO : this.attachments ){
            Attachment attachment = new Attachment();
            attachment.setFileIdentifier(attachmentDTO.getFileIdentifier());
            docAppeal.getAttachments().add(attachment);
        }
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        docAppeal.setMetadataSystem(metadataSystem);

        docAppeal.setAddress(this.address);
        docAppeal.setCorrespondent(this.correspondent);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.deliveryDate);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docAppeal.setDeliveryDate(xmlGregorianCalendar);
        docAppeal.setDescription(this.description);
        docAppeal.setDocumentType(this.documentType);
        docAppeal.setEmail(this.email);
        docAppeal.setIdPortalInternal(this.idPortalInternal);
        docAppeal.setJuridicallyName(this.juridicallyName);
        docAppeal.setMiddlename(this.middlename);
        docAppeal.setName(this.name);
        gregorianCalendar.setTime(this.outDate);
        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        docAppeal.setOutDate(xmlGregorianCalendar);
        docAppeal.setOutNumber(this.outNumber);
        docAppeal.setPhone(this.phone);
        docAppeal.setSign(this.sign);
        docAppeal.setSurname(this.surname);
        docAppeal.setUserUin(this.userUin);
        docAppeal.setTimeStampData(this.timeStampData);
        docAppeal.setOcspData(this.ocspData);
        return docAppeal;
    }
}
