
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hardwareElementTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="hardwareElementTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AP"/>
 *     &lt;enumeration value="DO"/>
 *     &lt;enumeration value="EP"/>
 *     &lt;enumeration value="PN"/>
 *     &lt;enumeration value="EQ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "hardwareElementTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum HardwareElementTypeCodeValues {

    AP,
    DO,
    EP,
    PN,
    EQ;

    public String value() {
        return name();
    }

    public static HardwareElementTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
