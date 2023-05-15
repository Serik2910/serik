package soap.start.serik.models;

import kz.bee.bip.esedo.MetadataSystem;
import kz.bee.bip.esedo.StateNewExDate;
import kz.bee.bip.esedo.StateTakeOfControl;
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
@Table(name = "state_take_of_control")
public class StateTakeOfControlDTO {
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
    private Date execDate;
    @Column
    private Boolean isSent;
    public StateTakeOfControlDTO(StateTakeOfControl stateTakeOfControl){
        this.activityId = stateTakeOfControl.getMetadataSystem().getActivityId();
        this.from = stateTakeOfControl.getMetadataSystem().getFrom();
        this.href = stateTakeOfControl.getMetadataSystem().getHref();
        this.performers = stateTakeOfControl.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = stateTakeOfControl.getMetadataSystem().getSenderOrg();
        XMLGregorianCalendar execDate = stateTakeOfControl.getExecDate();
        if (execDate!=null){
            this.execDate = execDate.toGregorianCalendar().getTime();
        }
    }
    public StateTakeOfControl toStateTakeOfControl() throws DatatypeConfigurationException {
        StateTakeOfControl stateTakeOfControl = new StateTakeOfControl();
        MetadataSystem metadataSystem = new MetadataSystem();
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        stateTakeOfControl.setMetadataSystem(metadataSystem);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.execDate);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        stateTakeOfControl.setExecDate(xmlGregorianCalendar);
        return stateTakeOfControl;
    }
}
