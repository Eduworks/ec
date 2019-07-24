
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for timeConsumptionUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="timeConsumptionUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MM"/>
 *     &lt;enumeration value="MH"/>
 *     &lt;enumeration value="MW"/>
 *     &lt;enumeration value="MD"/>
 *     &lt;enumeration value="MY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "timeConsumptionUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TimeConsumptionUnit {

    MM,
    MH,
    MW,
    MD,
    MY;

    public String value() {
        return name();
    }

    public static TimeConsumptionUnit fromValue(String v) {
        return valueOf(v);
    }

}
