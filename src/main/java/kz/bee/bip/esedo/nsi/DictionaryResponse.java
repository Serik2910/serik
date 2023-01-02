
package kz.bee.bip.esedo.nsi;

import kz.bee.bip.esedo.Message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ответ на запрос выдаче справочника
 * 
 * <p>Java class for dictionaryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dictionaryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://esedo.nitec.kz/service/model}message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="createdDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dictionaryType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dictionaryResponse", namespace = "http://esedo.nitec.kz/service/model/dictionary", propOrder = {
    "createdDate",
    "dictionaryType"
})
public class DictionaryResponse
    extends Message
{

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    protected String dictionaryType;

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the dictionaryType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDictionaryType() {
        return dictionaryType;
    }

    /**
     * Sets the value of the dictionaryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDictionaryType(String value) {
        this.dictionaryType = value;
    }

}
