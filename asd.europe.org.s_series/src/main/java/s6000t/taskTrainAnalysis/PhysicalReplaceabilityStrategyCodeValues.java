
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for physicalReplaceabilityStrategyCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="physicalReplaceabilityStrategyCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LRU"/>
 *     &lt;enumeration value="SRU"/>
 *     &lt;enumeration value="NA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "physicalReplaceabilityStrategyCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum PhysicalReplaceabilityStrategyCodeValues {

    LRU,
    SRU,
    NA;

    public String value() {
        return name();
    }

    public static PhysicalReplaceabilityStrategyCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
