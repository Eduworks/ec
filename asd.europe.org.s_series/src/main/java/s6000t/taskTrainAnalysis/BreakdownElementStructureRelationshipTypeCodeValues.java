
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for breakdownElementStructureRelationshipTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="breakdownElementStructureRelationshipTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MUST"/>
 *     &lt;enumeration value="NOT"/>
 *     &lt;enumeration value="ALT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "breakdownElementStructureRelationshipTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum BreakdownElementStructureRelationshipTypeCodeValues {

    MUST,
    NOT,
    ALT;

    public String value() {
        return name();
    }

    public static BreakdownElementStructureRelationshipTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
