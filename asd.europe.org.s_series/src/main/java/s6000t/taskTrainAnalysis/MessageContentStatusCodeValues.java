
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for messageContentStatusCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="messageContentStatusCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="F"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "messageContentStatusCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum MessageContentStatusCodeValues {

    D,
    P,
    F;

    public String value() {
        return name();
    }

    public static MessageContentStatusCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
