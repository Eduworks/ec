
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for skillLevelNameCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="skillLevelNameCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="I"/>
 *     &lt;enumeration value="B"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "skillLevelNameCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SkillLevelNameCodeValues {

    A,
    I,
    B;

    public String value() {
        return name();
    }

    public static SkillLevelNameCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
