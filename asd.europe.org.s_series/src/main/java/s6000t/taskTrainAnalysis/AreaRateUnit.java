
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for areaRateUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="areaRateUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="/FM"/>
 *     &lt;enumeration value="/HS"/>
 *     &lt;enumeration value="/QC"/>
 *     &lt;enumeration value="/QD"/>
 *     &lt;enumeration value="/SF"/>
 *     &lt;enumeration value="/SI"/>
 *     &lt;enumeration value="/SM"/>
 *     &lt;enumeration value="/MN"/>
 *     &lt;enumeration value="/SY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "areaRateUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum AreaRateUnit {

    @XmlEnumValue("/FM")
    FM("/FM"),
    @XmlEnumValue("/HS")
    HS("/HS"),
    @XmlEnumValue("/QC")
    QC("/QC"),
    @XmlEnumValue("/QD")
    QD("/QD"),
    @XmlEnumValue("/SF")
    SF("/SF"),
    @XmlEnumValue("/SI")
    SI("/SI"),
    @XmlEnumValue("/SM")
    SM("/SM"),
    @XmlEnumValue("/MN")
    MN("/MN"),
    @XmlEnumValue("/SY")
    SY("/SY");
    private final String value;

    AreaRateUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AreaRateUnit fromValue(String v) {
        for (AreaRateUnit c: AreaRateUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
