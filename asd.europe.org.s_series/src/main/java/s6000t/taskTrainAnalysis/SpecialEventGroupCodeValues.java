
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for specialEventGroupCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="specialEventGroupCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EXT"/>
 *     &lt;enumeration value="NPH"/>
 *     &lt;enumeration value="MET"/>
 *     &lt;enumeration value="ANI"/>
 *     &lt;enumeration value="HUM"/>
 *     &lt;enumeration value="CBT"/>
 *     &lt;enumeration value="MNU"/>
 *     &lt;enumeration value="INT"/>
 *     &lt;enumeration value="DYS"/>
 *     &lt;enumeration value="HET"/>
 *     &lt;enumeration value="VIB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "specialEventGroupCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SpecialEventGroupCodeValues {

    EXT,
    NPH,
    MET,
    ANI,
    HUM,
    CBT,
    MNU,
    INT,
    DYS,
    HET,
    VIB;

    public String value() {
        return name();
    }

    public static SpecialEventGroupCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
