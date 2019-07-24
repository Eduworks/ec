
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for softwareTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="softwareTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="E"/>
 *     &lt;enumeration value="L"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "softwareTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SoftwareTypeCodeValues {

    D,
    E,
    L;

    public String value() {
        return name();
    }

    public static SoftwareTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
