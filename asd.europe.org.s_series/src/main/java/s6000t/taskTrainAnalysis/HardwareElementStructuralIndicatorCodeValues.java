
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hardwareElementStructuralIndicatorCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="hardwareElementStructuralIndicatorCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SSI"/>
 *     &lt;enumeration value="SI"/>
 *     &lt;enumeration value="SD"/>
 *     &lt;enumeration value="NA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "hardwareElementStructuralIndicatorCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum HardwareElementStructuralIndicatorCodeValues {

    SSI,
    SI,
    SD,
    NA;

    public String value() {
        return name();
    }

    public static HardwareElementStructuralIndicatorCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
