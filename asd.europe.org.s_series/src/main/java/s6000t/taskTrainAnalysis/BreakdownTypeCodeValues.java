
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for breakdownTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="breakdownTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ASD"/>
 *     &lt;enumeration value="FAM"/>
 *     &lt;enumeration value="FU"/>
 *     &lt;enumeration value="HY"/>
 *     &lt;enumeration value="IP"/>
 *     &lt;enumeration value="PH"/>
 *     &lt;enumeration value="SY"/>
 *     &lt;enumeration value="ZONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "breakdownTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum BreakdownTypeCodeValues {

    ASD,
    FAM,
    FU,
    HY,
    IP,
    PH,
    SY,
    ZONE;

    public String value() {
        return name();
    }

    public static BreakdownTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
