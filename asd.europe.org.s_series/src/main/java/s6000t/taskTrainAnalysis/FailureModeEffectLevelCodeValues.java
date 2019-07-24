
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for failureModeEffectLevelCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="failureModeEffectLevelCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NH"/>
 *     &lt;enumeration value="EI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "failureModeEffectLevelCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum FailureModeEffectLevelCodeValues {

    NH,
    EI;

    public String value() {
        return name();
    }

    public static FailureModeEffectLevelCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
