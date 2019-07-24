
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lsaCandidateIndicatorCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="lsaCandidateIndicatorCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="F"/>
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="O"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "lsaCandidateIndicatorCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum LsaCandidateIndicatorCodeValues {

    F,
    P,
    N,
    O;

    public String value() {
        return name();
    }

    public static LsaCandidateIndicatorCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
