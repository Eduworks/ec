
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for skillCodeClassValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="skillCodeClassValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "skillCodeClassValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SkillCodeClassValues {

    SC;

    public String value() {
        return name();
    }

    public static SkillCodeClassValues fromValue(String v) {
        return valueOf(v);
    }

}
