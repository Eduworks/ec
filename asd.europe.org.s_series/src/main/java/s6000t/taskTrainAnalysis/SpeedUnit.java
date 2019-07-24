
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for speedUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="speedUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MS"/>
 *     &lt;enumeration value="KMH"/>
 *     &lt;enumeration value="KMS"/>
 *     &lt;enumeration value="KT"/>
 *     &lt;enumeration value="MPH"/>
 *     &lt;enumeration value="MPS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "speedUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SpeedUnit {

    MS,
    KMH,
    KMS,
    KT,
    MPH,
    MPS;

    public String value() {
        return name();
    }

    public static SpeedUnit fromValue(String v) {
        return valueOf(v);
    }

}
