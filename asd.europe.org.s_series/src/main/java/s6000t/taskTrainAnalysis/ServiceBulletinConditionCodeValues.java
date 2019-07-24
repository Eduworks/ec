
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for serviceBulletinConditionCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="serviceBulletinConditionCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PRE"/>
 *     &lt;enumeration value="POST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "serviceBulletinConditionCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum ServiceBulletinConditionCodeValues {

    PRE,
    POST;

    public String value() {
        return name();
    }

    public static ServiceBulletinConditionCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
