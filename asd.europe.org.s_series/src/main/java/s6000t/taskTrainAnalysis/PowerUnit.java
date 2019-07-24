
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for powerUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="powerUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HP"/>
 *     &lt;enumeration value="W"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "powerUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum PowerUnit {

    HP,
    W;

    public String value() {
        return name();
    }

    public static PowerUnit fromValue(String v) {
        return valueOf(v);
    }

}
