
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskTrainingDifficultyCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="taskTrainingDifficultyCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="V"/>
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="N"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "taskTrainingDifficultyCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TaskTrainingDifficultyCodeValues {

    V,
    M,
    N;

    public String value() {
        return name();
    }

    public static TaskTrainingDifficultyCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
