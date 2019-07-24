
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for securityClassCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="securityClassCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="CC"/>
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="TS"/>
 *     &lt;enumeration value="UC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "securityClassCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SecurityClassCodeValues {

    C,
    CC,
    R,
    S,
    TS,
    UC;

    public String value() {
        return name();
    }

    public static SecurityClassCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
