package soap.start.serik.models;

import kz.bee.bip.esedo.MetadataSystem;
import kz.bee.bip.esedo.StateNewControl;
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
public class StateNewControlDTO {
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
    public StateNewControlDTO(StateNewControl stateNewControl){
        this.activityId = stateNewControl.getMetadataSystem().getActivityId();
        this.from = stateNewControl.getMetadataSystem().getFrom();
        this.href = stateNewControl.getMetadataSystem().getHref();
        this.performers = stateNewControl.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = stateNewControl.getMetadataSystem().getSenderOrg();
        this.controlTypeCode = stateNewControl.getControlTypeCode();
        this.controlTypeNameKz = stateNewControl.getControlTypeNameKz();
        this.controlTypeNameRu = stateNewControl.getControlTypeNameRu();

        XMLGregorianCalendar execDate = stateNewControl.getExecDate();
        if (execDate!=null){
            this.execDate = execDate.toGregorianCalendar().getTime();
        }
    }
    public StateNewControl toStateNewControl() throws DatatypeConfigurationException {
        StateNewControl stateNewControl = new StateNewControl();
        MetadataSystem metadataSystem = new MetadataSystem();
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        stateNewControl.setMetadataSystem(metadataSystem);
        stateNewControl.setControlTypeCode(this.controlTypeCode);
        stateNewControl.setControlTypeNameKz(this.controlTypeNameKz);
        stateNewControl.setControlTypeNameRu(this.controlTypeNameRu);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.execDate);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        stateNewControl.setExecDate(xmlGregorianCalendar);

        return stateNewControl;
    }
}
