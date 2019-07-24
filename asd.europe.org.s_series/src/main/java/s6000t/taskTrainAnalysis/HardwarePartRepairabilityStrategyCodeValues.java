
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hardwarePartRepairabilityStrategyCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="hardwarePartRepairabilityStrategyCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NREP"/>
 *     &lt;enumeration value="PREP"/>
 *     &lt;enumeration value="REP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "hardwarePartRepairabilityStrategyCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum HardwarePartRepairabilityStrategyCodeValues {

    NREP,
    PREP,
    REP;

    public String value() {
        return name();
    }

    public static HardwarePartRepairabilityStrategyCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
