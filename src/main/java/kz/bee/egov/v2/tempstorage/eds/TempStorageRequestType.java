
package kz.bee.egov.v2.tempstorage.eds;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TempStorageRequestType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TempStorageRequestType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UPLOAD"/>
 *     &lt;enumeration value="DOWNLOAD"/>
 *     &lt;enumeration value="CONFIRM"/>
 *     &lt;enumeration value="GET_FILE_INFO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TempStorageRequestType")
@XmlEnum
public enum TempStorageRequestType {

    UPLOAD,
    DOWNLOAD,
    CONFIRM,
    GET_FILE_INFO;

    public String value() {
        return name();
    }

    public static TempStorageRequestType fromValue(String v) {
        return valueOf(v);
    }

}
