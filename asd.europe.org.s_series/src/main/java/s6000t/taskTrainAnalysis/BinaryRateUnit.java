
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for binaryRateUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="binaryRateUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="/BIT"/>
 *     &lt;enumeration value="/B"/>
 *     &lt;enumeration value="/GB"/>
 *     &lt;enumeration value="/KB"/>
 *     &lt;enumeration value="/MB"/>
 *     &lt;enumeration value="/OC"/>
 *     &lt;enumeration value="/PB"/>
 *     &lt;enumeration value="/TB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "binaryRateUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum BinaryRateUnit {

    @XmlEnumValue("/BIT")
    BIT("/BIT"),
    @XmlEnumValue("/B")
    B("/B"),
    @XmlEnumValue("/GB")
    GB("/GB"),
    @XmlEnumValue("/KB")
    KB("/KB"),
    @XmlEnumValue("/MB")
    MB("/MB"),
    @XmlEnumValue("/OC")
    OC("/OC"),
    @XmlEnumValue("/PB")
    PB("/PB"),
    @XmlEnumValue("/TB")
    TB("/TB");
    private final String value;

    BinaryRateUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BinaryRateUnit fromValue(String v) {
        for (BinaryRateUnit c: BinaryRateUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
