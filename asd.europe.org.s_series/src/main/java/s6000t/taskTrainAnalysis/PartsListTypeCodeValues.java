
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for partsListTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="partsListTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EBOM"/>
 *     &lt;enumeration value="MBOM"/>
 *     &lt;enumeration value="SBOM"/>
 *     &lt;enumeration value="PBOM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "partsListTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum PartsListTypeCodeValues {

    EBOM,
    MBOM,
    SBOM,
    PBOM;

    public String value() {
        return name();
    }

    public static PartsListTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
