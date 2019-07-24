
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subtaskRoleCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="subtaskRoleCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ST"/>
 *     &lt;enumeration value="COR"/>
 *     &lt;enumeration value="CON"/>
 *     &lt;enumeration value="CL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "subtaskRoleCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SubtaskRoleCodeValues {

    ST,
    COR,
    CON,
    CL;

    public String value() {
        return name();
    }

    public static SubtaskRoleCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
