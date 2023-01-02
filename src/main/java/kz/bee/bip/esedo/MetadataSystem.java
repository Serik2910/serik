
package kz.bee.bip.esedo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Метаданные
 * 
 * <p>Java class for metadataSystem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="metadataSystem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="activityId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="href" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="performers" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="senderOrg" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metadataSystem", namespace = "http://esedo.nitec.kz/service/model/extension", propOrder = {
    "activityId",
    "from",
    "href",
    "performers",
    "senderOrg"
})
public class MetadataSystem {

    protected String activityId;
    protected Long from;
    protected String href;
    @XmlElement(nillable = true)
    protected List<Long> performers;
    protected Long senderOrg;

    /**
     * Gets the value of the activityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityId() {
        return activityId;
    }

    /**
     * Sets the value of the activityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityId(String value) {
        this.activityId = value;
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFrom(Long value) {
        this.from = value;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Gets the value of the performers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the performers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerformers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getPerformers() {
        if (performers == null) {
            performers = new ArrayList<Long>();
        }
        return this.performers;
    }

    /**
     * Gets the value of the senderOrg property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSenderOrg() {
        return senderOrg;
    }

    /**
     * Sets the value of the senderOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSenderOrg(Long value) {
        this.senderOrg = value;
    }

}
