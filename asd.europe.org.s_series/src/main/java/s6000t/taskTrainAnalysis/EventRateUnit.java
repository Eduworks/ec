
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eventRateUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eventRateUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="/A"/>
 *     &lt;enumeration value="/C"/>
 *     &lt;enumeration value="/DL"/>
 *     &lt;enumeration value="/DT"/>
 *     &lt;enumeration value="/EM"/>
 *     &lt;enumeration value="/ES"/>
 *     &lt;enumeration value="/FI"/>
 *     &lt;enumeration value="/FC"/>
 *     &lt;enumeration value="/FH"/>
 *     &lt;enumeration value="/LD"/>
 *     &lt;enumeration value="/LA"/>
 *     &lt;enumeration value="/OH"/>
 *     &lt;enumeration value="/OV"/>
 *     &lt;enumeration value="/OC"/>
 *     &lt;enumeration value="/OP"/>
 *     &lt;enumeration value="/RD"/>
 *     &lt;enumeration value="/SD"/>
 *     &lt;enumeration value="/SO"/>
 *     &lt;enumeration value="/S"/>
 *     &lt;enumeration value="/ST"/>
 *     &lt;enumeration value="/SN"/>
 *     &lt;enumeration value="/TO"/>
 *     &lt;enumeration value="/TA"/>
 *     &lt;enumeration value="/TV"/>
 *     &lt;enumeration value="/VL"/>
 *     &lt;enumeration value="/VT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eventRateUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum EventRateUnit {

    @XmlEnumValue("/A")
    A("/A"),
    @XmlEnumValue("/C")
    C("/C"),
    @XmlEnumValue("/DL")
    DL("/DL"),
    @XmlEnumValue("/DT")
    DT("/DT"),
    @XmlEnumValue("/EM")
    EM("/EM"),
    @XmlEnumValue("/ES")
    ES("/ES"),
    @XmlEnumValue("/FI")
    FI("/FI"),
    @XmlEnumValue("/FC")
    FC("/FC"),
    @XmlEnumValue("/FH")
    FH("/FH"),
    @XmlEnumValue("/LD")
    LD("/LD"),
    @XmlEnumValue("/LA")
    LA("/LA"),
    @XmlEnumValue("/OH")
    OH("/OH"),
    @XmlEnumValue("/OV")
    OV("/OV"),
    @XmlEnumValue("/OC")
    OC("/OC"),
    @XmlEnumValue("/OP")
    OP("/OP"),
    @XmlEnumValue("/RD")
    RD("/RD"),
    @XmlEnumValue("/SD")
    SD("/SD"),
    @XmlEnumValue("/SO")
    SO("/SO"),
    @XmlEnumValue("/S")
    S("/S"),
    @XmlEnumValue("/ST")
    ST("/ST"),
    @XmlEnumValue("/SN")
    SN("/SN"),
    @XmlEnumValue("/TO")
    TO("/TO"),
    @XmlEnumValue("/TA")
    TA("/TA"),
    @XmlEnumValue("/TV")
    TV("/TV"),
    @XmlEnumValue("/VL")
    VL("/VL"),
    @XmlEnumValue("/VT")
    VT("/VT");
    private final String value;

    EventRateUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EventRateUnit fromValue(String v) {
        for (EventRateUnit c: EventRateUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
