
package kz.bee.bip.esedo.eds;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Данные запроса на подтверждение скачивания файлов
 * 
 * <p>Java class for ConfirmRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfirmRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fileIdentifiers" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmRequest", propOrder = {
    "fileIdentifiers"
})
public class ConfirmRequest {

    @XmlElement(namespace = "http://egov.bee.kz/eds/tempstorage/v2/", required = true)
    protected List<String> fileIdentifiers;

    /**
     * Gets the value of the fileIdentifiers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileIdentifiers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileIdentifiers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFileIdentifiers() {
        if (fileIdentifiers == null) {
            fileIdentifiers = new ArrayList<String>();
        }
        return this.fileIdentifiers;
    }

}
