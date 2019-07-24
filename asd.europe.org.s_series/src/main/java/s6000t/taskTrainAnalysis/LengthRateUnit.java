
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lengthRateUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="lengthRateUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="/CM"/>
 *     &lt;enumeration value="/DA"/>
 *     &lt;enumeration value="/DE"/>
 *     &lt;enumeration value="/FM"/>
 *     &lt;enumeration value="/FT"/>
 *     &lt;enumeration value="/HM"/>
 *     &lt;enumeration value="/HF"/>
 *     &lt;enumeration value="/HY"/>
 *     &lt;enumeration value="/IN"/>
 *     &lt;enumeration value="/LM"/>
 *     &lt;enumeration value="/KM"/>
 *     &lt;enumeration value="/NM"/>
 *     &lt;enumeration value="/MR"/>
 *     &lt;enumeration value="/MI"/>
 *     &lt;enumeration value="/MM"/>
 *     &lt;enumeration value="/MF"/>
 *     &lt;enumeration value="/YD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "lengthRateUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum LengthRateUnit {

    @XmlEnumValue("/CM")
    CM("/CM"),
    @XmlEnumValue("/DA")
    DA("/DA"),
    @XmlEnumValue("/DE")
    DE("/DE"),
    @XmlEnumValue("/FM")
    FM("/FM"),
    @XmlEnumValue("/FT")
    FT("/FT"),
    @XmlEnumValue("/HM")
    HM("/HM"),
    @XmlEnumValue("/HF")
    HF("/HF"),
    @XmlEnumValue("/HY")
    HY("/HY"),
    @XmlEnumValue("/IN")
    IN("/IN"),
    @XmlEnumValue("/LM")
    LM("/LM"),
    @XmlEnumValue("/KM")
    KM("/KM"),
    @XmlEnumValue("/NM")
    NM("/NM"),
    @XmlEnumValue("/MR")
    MR("/MR"),
    @XmlEnumValue("/MI")
    MI("/MI"),
    @XmlEnumValue("/MM")
    MM("/MM"),
    @XmlEnumValue("/MF")
    MF("/MF"),
    @XmlEnumValue("/YD")
    YD("/YD");
    private final String value;

    LengthRateUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LengthRateUnit fromValue(String v) {
        for (LengthRateUnit c: LengthRateUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
