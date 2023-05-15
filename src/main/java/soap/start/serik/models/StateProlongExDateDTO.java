package soap.start.serik.models;

import kz.bee.bip.esedo.MetadataSystem;
import kz.bee.bip.esedo.StateNewExDate;
import kz.bee.bip.esedo.StateProlongExDate;
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
@Table(name = "state_prolong_ex_date")
public class StateProlongExDateDTO {
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
    public StateProlongExDateDTO(StateProlongExDate stateProlongExDate){
        this.activityId = stateProlongExDate.getMetadataSystem().getActivityId();
        this.from = stateProlongExDate.getMetadataSystem().getFrom();
        this.href = stateProlongExDate.getMetadataSystem().getHref();
        this.performers = stateProlongExDate.getMetadataSystem().getPerformers().get(0);
        this.senderOrg = stateProlongExDate.getMetadataSystem().getSenderOrg();
        XMLGregorianCalendar execDate = stateProlongExDate.getExecDate();
        if (execDate!=null){
            this.execDate = execDate.toGregorianCalendar().getTime();
        }
        this.controlTypeCode = stateProlongExDate.getControlTypeCode();
        this.controlTypeNameKz = stateProlongExDate.getControlTypeNameKz();
        this.controlTypeNameRu = stateProlongExDate.getControlTypeNameRu();
    }
    public StateProlongExDate toStateProlongExDate() throws DatatypeConfigurationException {
        StateProlongExDate stateProlongExDate = new StateProlongExDate();
        MetadataSystem metadataSystem = new MetadataSystem();
        metadataSystem.setActivityId(this.activityId);
        metadataSystem.setFrom(this.from);
        metadataSystem.setHref(this.href);
        metadataSystem.getPerformers().add(this.performers);
        metadataSystem.setSenderOrg(this.senderOrg);
        stateProlongExDate.setMetadataSystem(metadataSystem);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.execDate);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        stateProlongExDate.setExecDate(xmlGregorianCalendar);

        stateProlongExDate.setControlTypeCode(this.controlTypeCode);
        stateProlongExDate.setControlTypeNameKz(this.controlTypeNameKz);
        stateProlongExDate.setControlTypeNameRu(this.controlTypeNameRu);
        return stateProlongExDate;
    }
}
