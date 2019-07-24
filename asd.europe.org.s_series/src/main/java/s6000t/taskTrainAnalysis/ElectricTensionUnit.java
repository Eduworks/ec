
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for electricTensionUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="electricTensionUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="V"/>
 *     &lt;enumeration value="MV"/>
 *     &lt;enumeration value="KV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "electricTensionUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum ElectricTensionUnit {

    V,
    MV,
    KV;

    public String value() {
        return name();
    }

    public static ElectricTensionUnit fromValue(String v) {
        return valueOf(v);
    }

}
