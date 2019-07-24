
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for failureModeLocalizationAbilityRatingCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="failureModeLocalizationAbilityRatingCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HIGH"/>
 *     &lt;enumeration value="MHIGH"/>
 *     &lt;enumeration value="MED"/>
 *     &lt;enumeration value="MLOW"/>
 *     &lt;enumeration value="LOW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "failureModeLocalizationAbilityRatingCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum FailureModeLocalizationAbilityRatingCodeValues {

    HIGH,
    MHIGH,
    MED,
    MLOW,
    LOW;

    public String value() {
        return name();
    }

    public static FailureModeLocalizationAbilityRatingCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
