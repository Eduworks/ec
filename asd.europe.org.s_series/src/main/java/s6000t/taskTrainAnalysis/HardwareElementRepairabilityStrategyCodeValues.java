
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hardwareElementRepairabilityStrategyCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="hardwareElementRepairabilityStrategyCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="REP"/>
 *     &lt;enumeration value="DISC"/>
 *     &lt;enumeration value="NA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "hardwareElementRepairabilityStrategyCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum HardwareElementRepairabilityStrategyCodeValues {

    REP,
    DISC,
    NA;

    public String value() {
        return name();
    }

    public static HardwareElementRepairabilityStrategyCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
