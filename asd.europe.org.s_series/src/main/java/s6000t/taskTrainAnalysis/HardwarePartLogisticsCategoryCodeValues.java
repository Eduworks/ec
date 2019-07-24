
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hardwarePartLogisticsCategoryCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="hardwarePartLogisticsCategoryCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="E"/>
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="SE"/>
 *     &lt;enumeration value="SP"/>
 *     &lt;enumeration value="SY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "hardwarePartLogisticsCategoryCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum HardwarePartLogisticsCategoryCodeValues {

    C,
    D,
    E,
    M,
    R,
    SE,
    SP,
    SY;

    public String value() {
        return name();
    }

    public static HardwarePartLogisticsCategoryCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
