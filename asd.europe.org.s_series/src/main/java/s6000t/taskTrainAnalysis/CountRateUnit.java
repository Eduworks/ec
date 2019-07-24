
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for countRateUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="countRateUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="/AY"/>
 *     &lt;enumeration value="/AT"/>
 *     &lt;enumeration value="/EA"/>
 *     &lt;enumeration value="/DZ"/>
 *     &lt;enumeration value="/LL"/>
 *     &lt;enumeration value="/FV"/>
 *     &lt;enumeration value="/VC"/>
 *     &lt;enumeration value="/GN"/>
 *     &lt;enumeration value="/GR"/>
 *     &lt;enumeration value="/GP"/>
 *     &lt;enumeration value="/HD"/>
 *     &lt;enumeration value="/LO"/>
 *     &lt;enumeration value="/ME"/>
 *     &lt;enumeration value="/OT"/>
 *     &lt;enumeration value="/PR"/>
 *     &lt;enumeration value="/PM"/>
 *     &lt;enumeration value="/QR"/>
 *     &lt;enumeration value="/RA"/>
 *     &lt;enumeration value="/RM"/>
 *     &lt;enumeration value="/SE"/>
 *     &lt;enumeration value="/SH"/>
 *     &lt;enumeration value="/SO"/>
 *     &lt;enumeration value="/SK"/>
 *     &lt;enumeration value="/TE"/>
 *     &lt;enumeration value="/TS"/>
 *     &lt;enumeration value="/MX"/>
 *     &lt;enumeration value="/AX"/>
 *     &lt;enumeration value="/TF"/>
 *     &lt;enumeration value="/TD"/>
 *     &lt;enumeration value="/AA"/>
 *     &lt;enumeration value="/IU"/>
 *     &lt;enumeration value="/WI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "countRateUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum CountRateUnit {

    @XmlEnumValue("/AY")
    AY("/AY"),
    @XmlEnumValue("/AT")
    AT("/AT"),
    @XmlEnumValue("/EA")
    EA("/EA"),
    @XmlEnumValue("/DZ")
    DZ("/DZ"),
    @XmlEnumValue("/LL")
    LL("/LL"),
    @XmlEnumValue("/FV")
    FV("/FV"),
    @XmlEnumValue("/VC")
    VC("/VC"),
    @XmlEnumValue("/GN")
    GN("/GN"),
    @XmlEnumValue("/GR")
    GR("/GR"),
    @XmlEnumValue("/GP")
    GP("/GP"),
    @XmlEnumValue("/HD")
    HD("/HD"),
    @XmlEnumValue("/LO")
    LO("/LO"),
    @XmlEnumValue("/ME")
    ME("/ME"),
    @XmlEnumValue("/OT")
    OT("/OT"),
    @XmlEnumValue("/PR")
    PR("/PR"),
    @XmlEnumValue("/PM")
    PM("/PM"),
    @XmlEnumValue("/QR")
    QR("/QR"),
    @XmlEnumValue("/RA")
    RA("/RA"),
    @XmlEnumValue("/RM")
    RM("/RM"),
    @XmlEnumValue("/SE")
    SE("/SE"),
    @XmlEnumValue("/SH")
    SH("/SH"),
    @XmlEnumValue("/SO")
    SO("/SO"),
    @XmlEnumValue("/SK")
    SK("/SK"),
    @XmlEnumValue("/TE")
    TE("/TE"),
    @XmlEnumValue("/TS")
    TS("/TS"),
    @XmlEnumValue("/MX")
    MX("/MX"),
    @XmlEnumValue("/AX")
    AX("/AX"),
    @XmlEnumValue("/TF")
    TF("/TF"),
    @XmlEnumValue("/TD")
    TD("/TD"),
    @XmlEnumValue("/AA")
    AA("/AA"),
    @XmlEnumValue("/IU")
    IU("/IU"),
    @XmlEnumValue("/WI")
    WI("/WI");
    private final String value;

    CountRateUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CountRateUnit fromValue(String v) {
        for (CountRateUnit c: CountRateUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
