
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for breakdownRevisionStatusCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="breakdownRevisionStatusCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="IW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "breakdownRevisionStatusCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum BreakdownRevisionStatusCodeValues {

    A,
    IW;

    public String value() {
        return name();
    }

    public static BreakdownRevisionStatusCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
