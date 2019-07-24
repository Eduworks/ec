
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for learningObjectiveRelationshipTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="learningObjectiveRelationshipTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CON"/>
 *     &lt;enumeration value="PRE"/>
 *     &lt;enumeration value="ENB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "learningObjectiveRelationshipTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum LearningObjectiveRelationshipTypeCodeValues {

    CON,
    PRE,
    ENB;

    public String value() {
        return name();
    }

    public static LearningObjectiveRelationshipTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
