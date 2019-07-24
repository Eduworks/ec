
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for messageRelationshipTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="messageRelationshipTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="O"/>
 *     &lt;enumeration value="U"/>
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="R"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "messageRelationshipTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum MessageRelationshipTypeCodeValues {

    O,
    U,
    A,
    R;

    public String value() {
        return name();
    }

    public static MessageRelationshipTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
