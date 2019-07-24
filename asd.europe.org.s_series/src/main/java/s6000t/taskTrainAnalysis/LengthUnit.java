
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lengthUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="lengthUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CM"/>
 *     &lt;enumeration value="DA"/>
 *     &lt;enumeration value="DE"/>
 *     &lt;enumeration value="FM"/>
 *     &lt;enumeration value="FT"/>
 *     &lt;enumeration value="HM"/>
 *     &lt;enumeration value="HF"/>
 *     &lt;enumeration value="HY"/>
 *     &lt;enumeration value="IN"/>
 *     &lt;enumeration value="LM"/>
 *     &lt;enumeration value="KM"/>
 *     &lt;enumeration value="NM"/>
 *     &lt;enumeration value="MR"/>
 *     &lt;enumeration value="MI"/>
 *     &lt;enumeration value="MM"/>
 *     &lt;enumeration value="MF"/>
 *     &lt;enumeration value="YD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "lengthUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum LengthUnit {

    CM,
    DA,
    DE,
    FM,
    FT,
    HM,
    HF,
    HY,
    IN,
    LM,
    KM,
    NM,
    MR,
    MI,
    MM,
    MF,
    YD;

    public String value() {
        return name();
    }

    public static LengthUnit fromValue(String v) {
        return valueOf(v);
    }

}
