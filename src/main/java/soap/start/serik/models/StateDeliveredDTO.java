package soap.start.serik.models;

import kz.bee.bip.esedo.MetadataSystem;
import kz.bee.bip.esedo.StateDelivered;
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
@Table(name = "state_delivered")
public class StateDeliveredDTO {
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
    private String userUin;
    @Column
    private Long idPortalInternal;
    @Column
    private Boolean isSent;
    public StateDeliveredDTO(StateDelivered stateDelivered){
        this.activityId = stateDelivered.getMetadataSystem().getActivityId();
        this.from = stateDelivered.getMetadataSystem().getFrom();
        this.href = stateDelivered.getMetadataSystem().getHref();
        this.performers = stateDelivered.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = stateDelivered.getMetadataSystem().getSenderOrg();
        XMLGregorianCalendar date = stateDelivered.getDate();
        if (date!=null){
            this.date = date.toGregorianCalendar().getTime();
        }
        this.idPortalInternal = stateDelivered.getIdPortalInternal();
        this.userUin = stateDelivered.getUserUin();
    }
    public StateDelivered toStateDelivered() throws DatatypeConfigurationException {
        StateDelivered stateDelivered = new StateDelivered();
        MetadataSystem metadataSystem = new MetadataSystem();
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        stateDelivered.setMetadataSystem(metadataSystem);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.date);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        stateDelivered.setDate(xmlGregorianCalendar);
        stateDelivered.setIdPortalInternal(this.idPortalInternal);
        stateDelivered.setUserUin(this.userUin);
        return stateDelivered;
    }
}
