
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lsaFailureModeDistributionRatingCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="lsaFailureModeDistributionRatingCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MHIGH"/>
 *     &lt;enumeration value="MED"/>
 *     &lt;enumeration value="MLOW"/>
 *     &lt;enumeration value="LOW"/>
 *     &lt;enumeration value="VLOW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "lsaFailureModeDistributionRatingCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum LsaFailureModeDistributionRatingCodeValues {

    MHIGH,
    MED,
    MLOW,
    LOW,
    VLOW;

    public String value() {
        return name();
    }

    public static LsaFailureModeDistributionRatingCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
