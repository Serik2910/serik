package soap.start.serik.models;

import kz.bee.bip.esedo.MetadataSystem;
import kz.bee.bip.esedo.StateExecution;
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
@Table(name = "state_execution")
public class StateExecutionDTO {
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
    private Date execDate;
    @Column
    private String executive;
    @Column
    private String executivePhone;
    @Column
    private String userUin;
    @Column
    private Long idPortalInternal;
    @Column
    private Boolean isSent;
    public StateExecutionDTO(StateExecution stateExecution){
        this.activityId = stateExecution.getMetadataSystem().getActivityId();
        this.from = stateExecution.getMetadataSystem().getFrom();
        this.href = stateExecution.getMetadataSystem().getHref();
        this.performers = stateExecution.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = stateExecution.getMetadataSystem().getSenderOrg();
        XMLGregorianCalendar date = stateExecution.getDate();
        if (date!=null){
            this.date = date.toGregorianCalendar().getTime();
        }
        XMLGregorianCalendar execDate = stateExecution.getExecDate();
        if (execDate!=null){
            this.execDate = execDate.toGregorianCalendar().getTime();
        }
        this.executive = stateExecution.getExecutive();
        this.executivePhone = stateExecution.getExecutivePhone();
        this.idPortalInternal = stateExecution.getIdPortalInternal();
        this.userUin = stateExecution.getUserUin();
    }
    public StateExecution toStateExecution() throws DatatypeConfigurationException {
        StateExecution stateExecution = new StateExecution();
        MetadataSystem metadataSystem = new MetadataSystem();
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        stateExecution.setMetadataSystem(metadataSystem);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.date);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        stateExecution.setDate(xmlGregorianCalendar);

        gregorianCalendar.setTime(this.execDate);
        xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        stateExecution.setExecDate(xmlGregorianCalendar);

        stateExecution.setExecutive(this.executive);
        stateExecution.setExecutivePhone(this.executivePhone);
        stateExecution.setIdPortalInternal(this.idPortalInternal);
        stateExecution.setUserUin(this.userUin);
        return stateExecution;
    }
}
