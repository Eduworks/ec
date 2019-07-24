
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conditionTypeNameCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="conditionTypeNameCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SB"/>
 *     &lt;enumeration value="AA"/>
 *     &lt;enumeration value="OP"/>
 *     &lt;enumeration value="MA"/>
 *     &lt;enumeration value="WS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "conditionTypeNameCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum ConditionTypeNameCodeValues {

    SB,
    AA,
    OP,
    MA,
    WS;

    public String value() {
        return name();
    }

    public static ConditionTypeNameCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
