
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for partIdentifierClassValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="partIdentifierClassValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CPNO"/>
 *     &lt;enumeration value="OEM"/>
 *     &lt;enumeration value="PNO"/>
 *     &lt;enumeration value="SPNO"/>
 *     &lt;enumeration value="REF"/>
 *     &lt;enumeration value="NSN"/>
 *     &lt;enumeration value="STD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "partIdentifierClassValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum PartIdentifierClassValues {

    CPNO,
    OEM,
    PNO,
    SPNO,
    REF,
    NSN,
    STD;

    public String value() {
        return name();
    }

    public static PartIdentifierClassValues fromValue(String v) {
        return valueOf(v);
    }

}
