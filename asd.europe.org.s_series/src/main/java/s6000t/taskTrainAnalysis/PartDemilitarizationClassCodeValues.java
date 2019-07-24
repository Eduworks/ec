
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for partDemilitarizationClassCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="partDemilitarizationClassCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="N/A"/>
 *     &lt;enumeration value="TSC"/>
 *     &lt;enumeration value="KEY"/>
 *     &lt;enumeration value="MUT"/>
 *     &lt;enumeration value="NAT"/>
 *     &lt;enumeration value="TBD"/>
 *     &lt;enumeration value="PRI"/>
 *     &lt;enumeration value="SEC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "partDemilitarizationClassCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum PartDemilitarizationClassCodeValues {

    @XmlEnumValue("N/A")
    N_A("N/A"),
    TSC("TSC"),
    KEY("KEY"),
    MUT("MUT"),
    NAT("NAT"),
    TBD("TBD"),
    PRI("PRI"),
    SEC("SEC");
    private final String value;

    PartDemilitarizationClassCodeValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PartDemilitarizationClassCodeValues fromValue(String v) {
        for (PartDemilitarizationClassCodeValues c: PartDemilitarizationClassCodeValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
