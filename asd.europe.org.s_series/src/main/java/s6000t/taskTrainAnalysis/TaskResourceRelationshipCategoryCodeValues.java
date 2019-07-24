
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskResourceRelationshipCategoryCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="taskResourceRelationshipCategoryCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="USE"/>
 *     &lt;enumeration value="ALT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "taskResourceRelationshipCategoryCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TaskResourceRelationshipCategoryCodeValues {

    USE,
    ALT;

    public String value() {
        return name();
    }

    public static TaskResourceRelationshipCategoryCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
