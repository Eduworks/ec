
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subtaskMaintenanceLocationCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="subtaskMaintenanceLocationCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="B"/>
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="C"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "subtaskMaintenanceLocationCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SubtaskMaintenanceLocationCodeValues {

    A,
    B,
    C;

    public String value() {
        return name();
    }

    public static SubtaskMaintenanceLocationCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
