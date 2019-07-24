
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for breakdownElementRelationshipTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="breakdownElementRelationshipTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALT"/>
 *     &lt;enumeration value="FUPH"/>
 *     &lt;enumeration value="AP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "breakdownElementRelationshipTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum BreakdownElementRelationshipTypeCodeValues {

    ALT,
    FUPH,
    AP;

    public String value() {
        return name();
    }

    public static BreakdownElementRelationshipTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
