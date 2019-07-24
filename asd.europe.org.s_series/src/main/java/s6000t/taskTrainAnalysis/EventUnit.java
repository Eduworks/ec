
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eventUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eventUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="DL"/>
 *     &lt;enumeration value="DT"/>
 *     &lt;enumeration value="EM"/>
 *     &lt;enumeration value="ES"/>
 *     &lt;enumeration value="FI"/>
 *     &lt;enumeration value="FC"/>
 *     &lt;enumeration value="FH"/>
 *     &lt;enumeration value="LD"/>
 *     &lt;enumeration value="LA"/>
 *     &lt;enumeration value="OH"/>
 *     &lt;enumeration value="OP"/>
 *     &lt;enumeration value="OV"/>
 *     &lt;enumeration value="OC"/>
 *     &lt;enumeration value="RD"/>
 *     &lt;enumeration value="SD"/>
 *     &lt;enumeration value="SO"/>
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="ST"/>
 *     &lt;enumeration value="SN"/>
 *     &lt;enumeration value="TO"/>
 *     &lt;enumeration value="TA"/>
 *     &lt;enumeration value="VL"/>
 *     &lt;enumeration value="VT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eventUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum EventUnit {

    A,
    C,
    DL,
    DT,
    EM,
    ES,
    FI,
    FC,
    FH,
    LD,
    LA,
    OH,
    OP,
    OV,
    OC,
    RD,
    SD,
    SO,
    S,
    ST,
    SN,
    TO,
    TA,
    VL,
    VT;

    public String value() {
        return name();
    }

    public static EventUnit fromValue(String v) {
        return valueOf(v);
    }

}
