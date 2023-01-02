
package kz.bee.bip.esedo;

import kz.bee.bip.esedo.nsi.DictionaryElement;
import kz.bee.bip.esedo.nsi.DictionaryRequest;
import kz.bee.bip.esedo.nsi.DictionaryResponse;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Абстрактный класс Message
 * 
 * <p>Java class for message complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="message"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attachments" type="{http://esedo.nitec.kz/service/model/extension}attachment" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="metadataSystem" type="{http://esedo.nitec.kz/service/model/extension}metadataSystem" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message", namespace = "http://esedo.nitec.kz/service/model", propOrder = {
    "attachments",
    "metadataSystem"
})
@XmlSeeAlso({
    DictionaryRequest.class,
    DictionaryResponse.class,
    DictionaryElement.class,
    DocSection.class,
    DocAppeal.class,
    DocOL.class,
    DocOutgoing.class,
    StateFinished.class,
    StateProlongExDate.class,
    StateNewExDate.class,
    StateTakeOfControl.class,
    StateNotValid.class,
    StateNewControl.class,
    StateDelivered.class,
    StateNewControlWrong.class,
    StateRegistered.class,
    StateStartProcessResponse.class,
    StateExecution.class,
    StateTakeOfControlWrong.class
})
public abstract class Message {

    @XmlElement(nillable = true)
    protected List<Attachment> attachments;
    protected MetadataSystem metadataSystem;

    /**
     * Gets the value of the attachments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attachment }
     * 
     * 
     */
    public List<Attachment> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<Attachment>();
        }
        return this.attachments;
    }

    /**
     * Gets the value of the metadataSystem property.
     * 
     * @return
     *     possible object is
     *     {@link MetadataSystem }
     *     
     */
    public MetadataSystem getMetadataSystem() {
        return metadataSystem;
    }

    /**
     * Sets the value of the metadataSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataSystem }
     *     
     */
    public void setMetadataSystem(MetadataSystem value) {
        this.metadataSystem = value;
    }

}
