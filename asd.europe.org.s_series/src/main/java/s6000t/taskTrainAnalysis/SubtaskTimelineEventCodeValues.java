
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subtaskTimelineEventCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="subtaskTimelineEventCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="START"/>
 *     &lt;enumeration value="END"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "subtaskTimelineEventCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SubtaskTimelineEventCodeValues {

    START,
    END;

    public String value() {
        return name();
    }

    public static SubtaskTimelineEventCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
