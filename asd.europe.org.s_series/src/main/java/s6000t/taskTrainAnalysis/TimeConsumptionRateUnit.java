
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for timeConsumptionRateUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="timeConsumptionRateUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="/MM"/>
 *     &lt;enumeration value="/MH"/>
 *     &lt;enumeration value="/MW"/>
 *     &lt;enumeration value="/MD"/>
 *     &lt;enumeration value="/MY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "timeConsumptionRateUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TimeConsumptionRateUnit {

    @XmlEnumValue("/MM")
    MM("/MM"),
    @XmlEnumValue("/MH")
    MH("/MH"),
    @XmlEnumValue("/MW")
    MW("/MW"),
    @XmlEnumValue("/MD")
    MD("/MD"),
    @XmlEnumValue("/MY")
    MY("/MY");
    private final String value;

    TimeConsumptionRateUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TimeConsumptionRateUnit fromValue(String v) {
        for (TimeConsumptionRateUnit c: TimeConsumptionRateUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
