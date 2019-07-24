
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hardwarePartEnvironmentalAspectInUseClassCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="hardwarePartEnvironmentalAspectInUseClassCodeValues">
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
@XmlType(name = "hardwarePartEnvironmentalAspectInUseClassCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum HardwarePartEnvironmentalAspectInUseClassCodeValues {

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

    public static HardwarePartEnvironmentalAspectInUseClassCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
