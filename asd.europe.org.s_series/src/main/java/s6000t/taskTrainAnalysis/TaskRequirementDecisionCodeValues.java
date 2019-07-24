
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskRequirementDecisionCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="taskRequirementDecisionCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="RJ"/>
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="RZ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "taskRequirementDecisionCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TaskRequirementDecisionCodeValues {

    A,
    RJ,
    D,
    RZ;

    public String value() {
        return name();
    }

    public static TaskRequirementDecisionCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
