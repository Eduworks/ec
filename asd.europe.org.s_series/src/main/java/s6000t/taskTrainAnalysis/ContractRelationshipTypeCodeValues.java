
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contractRelationshipTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="contractRelationshipTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUBC"/>
 *     &lt;enumeration value="RELC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "contractRelationshipTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum ContractRelationshipTypeCodeValues {

    SUBC,
    RELC;

    public String value() {
        return name();
    }

    public static ContractRelationshipTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
