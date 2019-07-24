
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subtaskTrainDecisionCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="subtaskTrainDecisionCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="T"/>
 *     &lt;enumeration value="N"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "subtaskTrainDecisionCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SubtaskTrainDecisionCodeValues {

    T,
    N;

    public String value() {
        return name();
    }

    public static SubtaskTrainDecisionCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
