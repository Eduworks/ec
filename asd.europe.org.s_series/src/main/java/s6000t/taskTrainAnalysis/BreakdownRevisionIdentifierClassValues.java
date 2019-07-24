
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for breakdownRevisionIdentifierClassValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="breakdownRevisionIdentifierClassValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="REV"/>
 *     &lt;enumeration value="ISS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "breakdownRevisionIdentifierClassValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum BreakdownRevisionIdentifierClassValues {

    REV,
    ISS;

    public String value() {
        return name();
    }

    public static BreakdownRevisionIdentifierClassValues fromValue(String v) {
        return valueOf(v);
    }

}
