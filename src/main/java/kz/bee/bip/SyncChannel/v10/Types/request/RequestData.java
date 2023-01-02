
package kz.bee.bip.SyncChannel.v10.Types.request;




import kz.bee.egov.v2.tempstorage.eds.TempStorageRequest;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for RequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestData", propOrder = {
    "data_"
})

public class RequestData {

    @XmlTransient
    protected Object data;

    @XmlElement(name = "data")
    protected Data data_;

    public Data getData_() {
        return data_;
    }

    public void setData_(Data data_) {
        this.data_ = data_;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */

    public Object getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setData(Object value) {
        this.data = value;
    }


}
