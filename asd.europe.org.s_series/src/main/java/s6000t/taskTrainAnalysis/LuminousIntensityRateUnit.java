
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for luminousIntensityRateUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="luminousIntensityRateUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="/CD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "luminousIntensityRateUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum LuminousIntensityRateUnit {

    @XmlEnumValue("/CD")
    CD("/CD");
    private final String value;

    LuminousIntensityRateUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LuminousIntensityRateUnit fromValue(String v) {
        for (LuminousIntensityRateUnit c: LuminousIntensityRateUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
