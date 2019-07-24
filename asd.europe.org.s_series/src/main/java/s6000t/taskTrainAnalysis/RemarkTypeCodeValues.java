
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for remarkTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="remarkTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COM"/>
 *     &lt;enumeration value="RSP"/>
 *     &lt;enumeration value="NTE"/>
 *     &lt;enumeration value="REM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "remarkTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum RemarkTypeCodeValues {

    COM,
    RSP,
    NTE,
    REM;

    public String value() {
        return name();
    }

    public static RemarkTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
