
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subtaskEndItemObjectiveStateCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="subtaskEndItemObjectiveStateCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TC"/>
 *     &lt;enumeration value="JC"/>
 *     &lt;enumeration value="UJ"/>
 *     &lt;enumeration value="SY"/>
 *     &lt;enumeration value="EL"/>
 *     &lt;enumeration value="EEL"/>
 *     &lt;enumeration value="AEL"/>
 *     &lt;enumeration value="EEL"/>
 *     &lt;enumeration value="IEL"/>
 *     &lt;enumeration value="HPE"/>
 *     &lt;enumeration value="AS"/>
 *     &lt;enumeration value="FU"/>
 *     &lt;enumeration value="DF"/>
 *     &lt;enumeration value="WS"/>
 *     &lt;enumeration value="CS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "subtaskEndItemObjectiveStateCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SubtaskEndItemObjectiveStateCodeValues {

    TC,
    JC,
    UJ,
    SY,
    EL,
    EEL,
    AEL,
    IEL,
    HPE,
    AS,
    FU,
    DF,
    WS,
    CS;

    public String value() {
        return name();
    }

    public static SubtaskEndItemObjectiveStateCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
