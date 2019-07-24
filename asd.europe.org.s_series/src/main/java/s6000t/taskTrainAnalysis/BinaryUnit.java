
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for binaryUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="binaryUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BIT"/>
 *     &lt;enumeration value="B"/>
 *     &lt;enumeration value="GB"/>
 *     &lt;enumeration value="KB"/>
 *     &lt;enumeration value="MB"/>
 *     &lt;enumeration value="OC"/>
 *     &lt;enumeration value="PB"/>
 *     &lt;enumeration value="TB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "binaryUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum BinaryUnit {

    BIT,
    B,
    GB,
    KB,
    MB,
    OC,
    PB,
    TB;

    public String value() {
        return name();
    }

    public static BinaryUnit fromValue(String v) {
        return valueOf(v);
    }

}
