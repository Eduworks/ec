
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for circuitBreakerStateCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="circuitBreakerStateCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="O"/>
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="VO"/>
 *     &lt;enumeration value="VC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "circuitBreakerStateCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum CircuitBreakerStateCodeValues {

    O,
    C,
    VO,
    VC;

    public String value() {
        return name();
    }

    public static CircuitBreakerStateCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
