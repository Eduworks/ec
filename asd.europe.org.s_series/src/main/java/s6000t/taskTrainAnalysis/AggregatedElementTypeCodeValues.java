
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for aggregatedElementTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="aggregatedElementTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FA"/>
 *     &lt;enumeration value="FU"/>
 *     &lt;enumeration value="SL"/>
 *     &lt;enumeration value="SY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "aggregatedElementTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum AggregatedElementTypeCodeValues {

    FA,
    FU,
    SL,
    SY;

    public String value() {
        return name();
    }

    public static AggregatedElementTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
