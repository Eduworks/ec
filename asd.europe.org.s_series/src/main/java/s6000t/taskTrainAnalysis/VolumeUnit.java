
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for volumeUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="volumeUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BF"/>
 *     &lt;enumeration value="CL"/>
 *     &lt;enumeration value="CC"/>
 *     &lt;enumeration value="CV"/>
 *     &lt;enumeration value="CF"/>
 *     &lt;enumeration value="CZ"/>
 *     &lt;enumeration value="CD"/>
 *     &lt;enumeration value="DB"/>
 *     &lt;enumeration value="DL"/>
 *     &lt;enumeration value="FZ"/>
 *     &lt;enumeration value="GC"/>
 *     &lt;enumeration value="HL"/>
 *     &lt;enumeration value="HC"/>
 *     &lt;enumeration value="GI"/>
 *     &lt;enumeration value="PB"/>
 *     &lt;enumeration value="QB"/>
 *     &lt;enumeration value="LI"/>
 *     &lt;enumeration value="ML"/>
 *     &lt;enumeration value="MC"/>
 *     &lt;enumeration value="TL"/>
 *     &lt;enumeration value="GL"/>
 *     &lt;enumeration value="PT"/>
 *     &lt;enumeration value="QT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "volumeUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum VolumeUnit {

    BF,
    CL,
    CC,
    CV,
    CF,
    CZ,
    CD,
    DB,
    DL,
    FZ,
    GC,
    HL,
    HC,
    GI,
    PB,
    QB,
    LI,
    ML,
    MC,
    TL,
    GL,
    PT,
    QT;

    public String value() {
        return name();
    }

    public static VolumeUnit fromValue(String v) {
        return valueOf(v);
    }

}
