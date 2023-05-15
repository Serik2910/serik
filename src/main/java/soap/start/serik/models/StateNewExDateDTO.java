package soap.start.serik.models;

import kz.bee.bip.esedo.MetadataSystem;
import kz.bee.bip.esedo.StateNewExDate;
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
@Table(name = "state_new_ex_date")
public class StateNewExDateDTO {
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
    private String controlTypeCode;
    @Column
    private String controlTypeNameKz;
    @Column
    private String controlTypeNameRu;
    @Column
    private Date execDate;
    @Column
    private Boolean isSent;
    public StateNewExDateDTO(StateNewExDate stateNewExDate){
        this.activityId = stateNewExDate.getMetadataSystem().getActivityId();
        this.from = stateNewExDate.getMetadataSystem().getFrom();
        this.href = stateNewExDate.getMetadataSystem().getHref();
        this.performers = stateNewExDate.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = stateNewExDate.getMetadataSystem().getSenderOrg();
        XMLGregorianCalendar execDate = stateNewExDate.getExecDate();
        if (execDate!=null){
            this.execDate = execDate.toGregorianCalendar().getTime();
        }
        this.controlTypeCode = stateNewExDate.getControlTypeCode();
        this.controlTypeNameKz = stateNewExDate.getControlTypeNameKz();
        this.controlTypeNameRu = stateNewExDate.getControlTypeNameRu();
    }
    public StateNewExDate toStateNewExDate() throws DatatypeConfigurationException {
        StateNewExDate stateNewExDate = new StateNewExDate();
        MetadataSystem metadataSystem = new MetadataSystem();
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        stateNewExDate.setMetadataSystem(metadataSystem);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.execDate);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        stateNewExDate.setExecDate(xmlGregorianCalendar);

        stateNewExDate.setControlTypeCode(this.controlTypeCode);
        stateNewExDate.setControlTypeNameKz(this.controlTypeNameKz);
        stateNewExDate.setControlTypeNameRu(this.controlTypeNameRu);
        return stateNewExDate;
    }
}
