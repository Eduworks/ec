
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for timeRateUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="timeRateUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="/MS"/>
 *     &lt;enumeration value="/SEC"/>
 *     &lt;enumeration value="/MIN"/>
 *     &lt;enumeration value="/HR"/>
 *     &lt;enumeration value="/DAY"/>
 *     &lt;enumeration value="/WK"/>
 *     &lt;enumeration value="/MON"/>
 *     &lt;enumeration value="/QR"/>
 *     &lt;enumeration value="/YR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "timeRateUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TimeRateUnit {

    @XmlEnumValue("/MS")
    MS("/MS"),
    @XmlEnumValue("/SEC")
    SEC("/SEC"),
    @XmlEnumValue("/MIN")
    MIN("/MIN"),
    @XmlEnumValue("/HR")
    HR("/HR"),
    @XmlEnumValue("/DAY")
    DAY("/DAY"),
    @XmlEnumValue("/WK")
    WK("/WK"),
    @XmlEnumValue("/MON")
    MON("/MON"),
    @XmlEnumValue("/QR")
    QR("/QR"),
    @XmlEnumValue("/YR")
    YR("/YR");
    private final String value;

    TimeRateUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TimeRateUnit fromValue(String v) {
        for (TimeRateUnit c: TimeRateUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
