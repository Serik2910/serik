package soap.start.serik.models;

import kz.bee.bip.esedo.MetadataSystem;
import kz.bee.bip.esedo.StateNotValid;
import kz.bee.bip.esedo.StateRegistered;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "state_not_valid")
public class StateNotValidDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
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
    private Date date;
    @Column
    private String isValidReason;
    @Column(length = 20000)
    private String secondSignNotifData;
    @Column
    private String userUin;
    @Column
    private Long idPortalInternal;
    @Column
    private Boolean isSent;
     public StateNotValidDTO(StateNotValid stateNotValid){
        this.activityId = stateNotValid.getMetadataSystem().getActivityId();
        this.from = stateNotValid.getMetadataSystem().getFrom();
        this.href = stateNotValid.getMetadataSystem().getHref();
        this.performers = stateNotValid.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = stateNotValid.getMetadataSystem().getSenderOrg();
        XMLGregorianCalendar date = stateNotValid.getDate();
        if (date!=null){
            this.date = date.toGregorianCalendar().getTime();
        }
        this.isValidReason = stateNotValid.getIsValidReason();
        this.secondSignNotifData = stateNotValid.getSecondSignNotifData();
        this.idPortalInternal = stateNotValid.getIdPortalInternal();
        this.userUin = stateNotValid.getUserUin();
    }
    public StateNotValid toStateNotValid() throws DatatypeConfigurationException {
        StateNotValid stateNotValid = new StateNotValid();
        MetadataSystem metadataSystem = new MetadataSystem();
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        stateNotValid.setMetadataSystem(metadataSystem);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.date);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        stateNotValid.setDate(xmlGregorianCalendar);
        stateNotValid.setIsValidReason(this.isValidReason);
        stateNotValid.setSecondSignNotifData(this.getSecondSignNotifData());
        stateNotValid.setIdPortalInternal(this.idPortalInternal);
        stateNotValid.setUserUin(this.userUin);
        return stateNotValid;
    }
}
