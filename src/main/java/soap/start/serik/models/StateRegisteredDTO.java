package soap.start.serik.models;

import kz.bee.bip.esedo.MetadataSystem;
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
@Table(name = "state_registered")
public class StateRegisteredDTO {
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
    private String regNo;
    @Column(length = 20000)
    private String secondSignNotifData;
    @Column
    private String userUin;
    @Column
    private Long idPortalInternal;
    @Column
    private Boolean isSent;
    public StateRegisteredDTO(StateRegistered stateRegistered){
        this.activityId = stateRegistered.getMetadataSystem().getActivityId();
        this.from = stateRegistered.getMetadataSystem().getFrom();
        this.href = stateRegistered.getMetadataSystem().getHref();
        this.performers = stateRegistered.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = stateRegistered.getMetadataSystem().getSenderOrg();
        XMLGregorianCalendar date = stateRegistered.getDate();
        if (date!=null){
            this.date = date.toGregorianCalendar().getTime();
        }
        this.regNo = stateRegistered.getRegNo();
        this.secondSignNotifData = stateRegistered.getSecondSignNotifData();
        this.idPortalInternal = stateRegistered.getIdPortalInternal();
        this.userUin = stateRegistered.getUserUin();
    }
    public StateRegistered toStateRegistered() throws DatatypeConfigurationException{
        StateRegistered stateRegistered = new StateRegistered();
        MetadataSystem metadataSystem = new MetadataSystem();
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        stateRegistered.setMetadataSystem(metadataSystem);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.date);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        stateRegistered.setDate(xmlGregorianCalendar);

        stateRegistered.setRegNo(this.regNo);
        stateRegistered.setSecondSignNotifData(this.getSecondSignNotifData());
        stateRegistered.setIdPortalInternal(this.idPortalInternal);
        stateRegistered.setUserUin(this.userUin);
        return stateRegistered;
    }
}
