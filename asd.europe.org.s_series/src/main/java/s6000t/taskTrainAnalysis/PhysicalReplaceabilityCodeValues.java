
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for physicalReplaceabilityCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="physicalReplaceabilityCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="NA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "physicalReplaceabilityCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum PhysicalReplaceabilityCodeValues {

    N,
    R,
    NA;

    public String value() {
        return name();
    }

    public static PhysicalReplaceabilityCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
