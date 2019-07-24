
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskFrequencyCategoryCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="taskFrequencyCategoryCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="V"/>
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="I"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "taskFrequencyCategoryCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TaskFrequencyCategoryCodeValues {

    V,
    M,
    I;

    public String value() {
        return name();
    }

    public static TaskFrequencyCategoryCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
