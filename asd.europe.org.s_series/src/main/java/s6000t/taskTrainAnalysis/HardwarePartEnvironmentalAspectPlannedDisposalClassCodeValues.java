
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hardwarePartEnvironmentalAspectPlannedDisposalClassCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="hardwarePartEnvironmentalAspectPlannedDisposalClassCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HARM"/>
 *     &lt;enumeration value="ACID"/>
 *     &lt;enumeration value="OZON"/>
 *     &lt;enumeration value="GREEN"/>
 *     &lt;enumeration value="WASTE"/>
 *     &lt;enumeration value="BURN"/>
 *     &lt;enumeration value="RECY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "hardwarePartEnvironmentalAspectPlannedDisposalClassCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum HardwarePartEnvironmentalAspectPlannedDisposalClassCodeValues {

    HARM,
    ACID,
    OZON,
    GREEN,
    WASTE,
    BURN,
    RECY;

    public String value() {
        return name();
    }

    public static HardwarePartEnvironmentalAspectPlannedDisposalClassCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
