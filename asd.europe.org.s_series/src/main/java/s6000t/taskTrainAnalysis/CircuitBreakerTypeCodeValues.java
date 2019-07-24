
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for circuitBreakerTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="circuitBreakerTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ELTRO"/>
 *     &lt;enumeration value="ELMEC"/>
 *     &lt;enumeration value="CLIP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "circuitBreakerTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum CircuitBreakerTypeCodeValues {

    ELTRO,
    ELMEC,
    CLIP;

    public String value() {
        return name();
    }

    public static CircuitBreakerTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
