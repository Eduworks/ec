
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for massRateUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="massRateUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="/CG"/>
 *     &lt;enumeration value="/DC"/>
 *     &lt;enumeration value="/DG"/>
 *     &lt;enumeration value="/DM"/>
 *     &lt;enumeration value="/HG"/>
 *     &lt;enumeration value="/GM"/>
 *     &lt;enumeration value="/HW"/>
 *     &lt;enumeration value="/KG"/>
 *     &lt;enumeration value="/LT"/>
 *     &lt;enumeration value="/MG"/>
 *     &lt;enumeration value="/TM"/>
 *     &lt;enumeration value="/OZ"/>
 *     &lt;enumeration value="/QK"/>
 *     &lt;enumeration value="/QN"/>
 *     &lt;enumeration value="/LB"/>
 *     &lt;enumeration value="/TO"/>
 *     &lt;enumeration value="/TN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "massRateUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum MassRateUnit {

    @XmlEnumValue("/CG")
    CG("/CG"),
    @XmlEnumValue("/DC")
    DC("/DC"),
    @XmlEnumValue("/DG")
    DG("/DG"),
    @XmlEnumValue("/DM")
    DM("/DM"),
    @XmlEnumValue("/HG")
    HG("/HG"),
    @XmlEnumValue("/GM")
    GM("/GM"),
    @XmlEnumValue("/HW")
    HW("/HW"),
    @XmlEnumValue("/KG")
    KG("/KG"),
    @XmlEnumValue("/LT")
    LT("/LT"),
    @XmlEnumValue("/MG")
    MG("/MG"),
    @XmlEnumValue("/TM")
    TM("/TM"),
    @XmlEnumValue("/OZ")
    OZ("/OZ"),
    @XmlEnumValue("/QK")
    QK("/QK"),
    @XmlEnumValue("/QN")
    QN("/QN"),
    @XmlEnumValue("/LB")
    LB("/LB"),
    @XmlEnumValue("/TO")
    TO("/TO"),
    @XmlEnumValue("/TN")
    TN("/TN");
    private final String value;

    MassRateUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MassRateUnit fromValue(String v) {
        for (MassRateUnit c: MassRateUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
