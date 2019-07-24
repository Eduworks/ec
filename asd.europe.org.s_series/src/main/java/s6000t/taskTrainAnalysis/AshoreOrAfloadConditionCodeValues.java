
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ashoreOrAfloadConditionCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ashoreOrAfloadConditionCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ASH"/>
 *     &lt;enumeration value="AFL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ashoreOrAfloadConditionCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum AshoreOrAfloadConditionCodeValues {

    ASH,
    AFL;

    public String value() {
        return name();
    }

    public static AshoreOrAfloadConditionCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
