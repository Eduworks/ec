
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskRevisionStatusCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="taskRevisionStatusCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="IW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "taskRevisionStatusCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TaskRevisionStatusCodeValues {

    A,
    IW;

    public String value() {
        return name();
    }

    public static TaskRevisionStatusCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
