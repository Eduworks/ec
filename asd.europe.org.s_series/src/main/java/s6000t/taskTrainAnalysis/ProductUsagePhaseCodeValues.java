
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productUsagePhaseCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="productUsagePhaseCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OPER"/>
 *     &lt;enumeration value="TOFF"/>
 *     &lt;enumeration value="FLIGHT"/>
 *     &lt;enumeration value="MAINT"/>
 *     &lt;enumeration value="STOR"/>
 *     &lt;enumeration value="TRAN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "productUsagePhaseCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum ProductUsagePhaseCodeValues {

    OPER,
    TOFF,
    FLIGHT,
    MAINT,
    STOR,
    TRAN;

    public String value() {
        return name();
    }

    public static ProductUsagePhaseCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
