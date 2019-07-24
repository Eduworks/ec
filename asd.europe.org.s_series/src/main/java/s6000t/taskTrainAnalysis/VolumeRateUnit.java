
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for volumeRateUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="volumeRateUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="/BF"/>
 *     &lt;enumeration value="/CL"/>
 *     &lt;enumeration value="/CC"/>
 *     &lt;enumeration value="/CV"/>
 *     &lt;enumeration value="/CF"/>
 *     &lt;enumeration value="/CZ"/>
 *     &lt;enumeration value="/CD"/>
 *     &lt;enumeration value="/DB"/>
 *     &lt;enumeration value="/DL"/>
 *     &lt;enumeration value="/FZ"/>
 *     &lt;enumeration value="/GC"/>
 *     &lt;enumeration value="/HL"/>
 *     &lt;enumeration value="/HC"/>
 *     &lt;enumeration value="/GI"/>
 *     &lt;enumeration value="/PB"/>
 *     &lt;enumeration value="/QB"/>
 *     &lt;enumeration value="/LI"/>
 *     &lt;enumeration value="/ML"/>
 *     &lt;enumeration value="/MC"/>
 *     &lt;enumeration value="/TL"/>
 *     &lt;enumeration value="/GL"/>
 *     &lt;enumeration value="/PT"/>
 *     &lt;enumeration value="/QT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "volumeRateUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum VolumeRateUnit {

    @XmlEnumValue("/BF")
    BF("/BF"),
    @XmlEnumValue("/CL")
    CL("/CL"),
    @XmlEnumValue("/CC")
    CC("/CC"),
    @XmlEnumValue("/CV")
    CV("/CV"),
    @XmlEnumValue("/CF")
    CF("/CF"),
    @XmlEnumValue("/CZ")
    CZ("/CZ"),
    @XmlEnumValue("/CD")
    CD("/CD"),
    @XmlEnumValue("/DB")
    DB("/DB"),
    @XmlEnumValue("/DL")
    DL("/DL"),
    @XmlEnumValue("/FZ")
    FZ("/FZ"),
    @XmlEnumValue("/GC")
    GC("/GC"),
    @XmlEnumValue("/HL")
    HL("/HL"),
    @XmlEnumValue("/HC")
    HC("/HC"),
    @XmlEnumValue("/GI")
    GI("/GI"),
    @XmlEnumValue("/PB")
    PB("/PB"),
    @XmlEnumValue("/QB")
    QB("/QB"),
    @XmlEnumValue("/LI")
    LI("/LI"),
    @XmlEnumValue("/ML")
    ML("/ML"),
    @XmlEnumValue("/MC")
    MC("/MC"),
    @XmlEnumValue("/TL")
    TL("/TL"),
    @XmlEnumValue("/GL")
    GL("/GL"),
    @XmlEnumValue("/PT")
    PT("/PT"),
    @XmlEnumValue("/QT")
    QT("/QT");
    private final String value;

    VolumeRateUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VolumeRateUnit fromValue(String v) {
        for (VolumeRateUnit c: VolumeRateUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
