
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for detectionMeanTypeCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="detectionMeanTypeCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PBIT"/>
 *     &lt;enumeration value="CBIT"/>
 *     &lt;enumeration value="IBIT"/>
 *     &lt;enumeration value="GSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "detectionMeanTypeCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum DetectionMeanTypeCodeValues {

    PBIT,
    CBIT,
    IBIT,
    GSE;

    public String value() {
        return name();
    }

    public static DetectionMeanTypeCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
