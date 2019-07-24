
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for partMaturityClassCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="partMaturityClassCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEW"/>
 *     &lt;enumeration value="MOD-L"/>
 *     &lt;enumeration value="MOD-M"/>
 *     &lt;enumeration value="COTS"/>
 *     &lt;enumeration value="CFE"/>
 *     &lt;enumeration value="OBS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "partMaturityClassCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum PartMaturityClassCodeValues {

    NEW("NEW"),
    @XmlEnumValue("MOD-L")
    MOD_L("MOD-L"),
    @XmlEnumValue("MOD-M")
    MOD_M("MOD-M"),
    COTS("COTS"),
    CFE("CFE"),
    OBS("OBS");
    private final String value;

    PartMaturityClassCodeValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PartMaturityClassCodeValues fromValue(String v) {
        for (PartMaturityClassCodeValues c: PartMaturityClassCodeValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
