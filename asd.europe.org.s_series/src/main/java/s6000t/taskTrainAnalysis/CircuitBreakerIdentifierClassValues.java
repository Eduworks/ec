
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for circuitBreakerIdentifierClassValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="circuitBreakerIdentifierClassValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CBID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "circuitBreakerIdentifierClassValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum CircuitBreakerIdentifierClassValues {

    CBID;

    public String value() {
        return name();
    }

    public static CircuitBreakerIdentifierClassValues fromValue(String v) {
        return valueOf(v);
    }

}
