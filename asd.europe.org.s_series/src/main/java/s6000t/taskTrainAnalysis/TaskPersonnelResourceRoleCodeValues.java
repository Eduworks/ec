
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskPersonnelResourceRoleCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="taskPersonnelResourceRoleCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MAN-A"/>
 *     &lt;enumeration value="MAN-B"/>
 *     &lt;enumeration value="PERF"/>
 *     &lt;enumeration value="SUP"/>
 *     &lt;enumeration value="QA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "taskPersonnelResourceRoleCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TaskPersonnelResourceRoleCodeValues {

    @XmlEnumValue("MAN-A")
    MAN_A("MAN-A"),
    @XmlEnumValue("MAN-B")
    MAN_B("MAN-B"),
    PERF("PERF"),
    SUP("SUP"),
    QA("QA");
    private final String value;

    TaskPersonnelResourceRoleCodeValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskPersonnelResourceRoleCodeValues fromValue(String v) {
        for (TaskPersonnelResourceRoleCodeValues c: TaskPersonnelResourceRoleCodeValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
