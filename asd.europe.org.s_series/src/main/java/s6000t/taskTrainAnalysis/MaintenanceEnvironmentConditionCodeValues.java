
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for maintenanceEnvironmentConditionCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="maintenanceEnvironmentConditionCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DOC"/>
 *     &lt;enumeration value="IN"/>
 *     &lt;enumeration value="OUT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "maintenanceEnvironmentConditionCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum MaintenanceEnvironmentConditionCodeValues {

    DOC,
    IN,
    OUT;

    public String value() {
        return name();
    }

    public static MaintenanceEnvironmentConditionCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
