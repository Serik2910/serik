package soap.start.serik.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadFileRequestDTO", propOrder = {
        "fileProcessIdentifier",
        "content",
        "name",
        "mime",
        "lifeTime",
        "needToBeConfirmed"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadFileRequestDTO {

    @XmlElement(required = true)
    protected String fileProcessIdentifier;
    @XmlElement(required = true)
    protected String content;
    protected String name;
    protected String mime;
    protected Long lifeTime;
    protected Boolean needToBeConfirmed;

}
