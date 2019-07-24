
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for electricCurrentUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="electricCurrentUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="MA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "electricCurrentUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum ElectricCurrentUnit {

    A,
    MA;

    public String value() {
        return name();
    }

    public static ElectricCurrentUnit fromValue(String v) {
        return valueOf(v);
    }

}
