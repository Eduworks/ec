
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for keyPerformanceIndicatorStatusCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="keyPerformanceIndicatorStatusCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PREL"/>
 *     &lt;enumeration value="ACCEPT"/>
 *     &lt;enumeration value="REL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "keyPerformanceIndicatorStatusCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum KeyPerformanceIndicatorStatusCodeValues {

    PREL,
    ACCEPT,
    REL;

    public String value() {
        return name();
    }

    public static KeyPerformanceIndicatorStatusCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
