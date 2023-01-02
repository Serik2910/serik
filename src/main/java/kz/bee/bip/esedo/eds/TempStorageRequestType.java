
package kz.bee.bip.esedo.eds;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TempStorageRequestType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TempStorageRequestType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="UPLOAD"/&gt;
 *     &lt;enumeration value="DOWNLOAD"/&gt;
 *     &lt;enumeration value="CONFIRM"/&gt;
 *     &lt;enumeration value="GET_FILE_INFO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
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
