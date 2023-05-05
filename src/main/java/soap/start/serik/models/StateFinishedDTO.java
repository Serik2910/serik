package soap.start.serik.models;

import kz.bee.bip.esedo.MetadataSystem;
import kz.bee.bip.esedo.StateFinished;
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
@Table(name = "state_finished")
public class StateFinishedDTO {
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
    private Date realDate;
    @Column
    private String resultCode;
    @Column
    private String resultText;
    @Column
    private String userUin;
    @Column
    private Boolean isSent;
    public StateFinishedDTO(StateFinished stateFinished){
        this.activityId = stateFinished.getMetadataSystem().getActivityId();
        this.from = stateFinished.getMetadataSystem().getFrom();
        this.href = stateFinished.getMetadataSystem().getHref();
        this.performers = stateFinished.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = stateFinished.getMetadataSystem().getSenderOrg();

        XMLGregorianCalendar realDate = stateFinished.getRealDate();
        if (realDate!=null){
            this.realDate = realDate.toGregorianCalendar().getTime();
        }

        this.resultCode = stateFinished.getResultCode();
        this.resultText = stateFinished.getResultText();
        this.userUin = stateFinished.getUserUin();
    }
    public StateFinished toStateFinished() throws DatatypeConfigurationException{
        StateFinished stateFinished = new StateFinished();
        MetadataSystem metadataSystem = new MetadataSystem();
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        stateFinished.setMetadataSystem(metadataSystem);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.realDate);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        stateFinished.setRealDate(xmlGregorianCalendar);

        stateFinished.setResultCode(this.resultCode);
        stateFinished.setResultText(this.resultText);
        stateFinished.setUserUin(this.userUin);

        return stateFinished;
    }
}
