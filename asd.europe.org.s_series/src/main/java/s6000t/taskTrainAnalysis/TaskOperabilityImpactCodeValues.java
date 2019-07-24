
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskOperabilityImpactCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="taskOperabilityImpactCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEQM"/>
 *     &lt;enumeration value="OPEQM"/>
 *     &lt;enumeration value="PMISS"/>
 *     &lt;enumeration value="FMISS"/>
 *     &lt;enumeration value="NMISS"/>
 *     &lt;enumeration value="TA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "taskOperabilityImpactCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TaskOperabilityImpactCodeValues {

    NEQM,
    OPEQM,
    PMISS,
    FMISS,
    NMISS,
    TA;

    public String value() {
        return name();
    }

    public static TaskOperabilityImpactCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
