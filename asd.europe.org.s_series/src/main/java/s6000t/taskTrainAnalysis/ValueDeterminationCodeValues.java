
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for valueDeterminationCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="valueDeterminationCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALC"/>
 *     &lt;enumeration value="CALC"/>
 *     &lt;enumeration value="CONTR"/>
 *     &lt;enumeration value="DSG"/>
 *     &lt;enumeration value="EMP"/>
 *     &lt;enumeration value="EST"/>
 *     &lt;enumeration value="MEAS"/>
 *     &lt;enumeration value="PLAN"/>
 *     &lt;enumeration value="REQ"/>
 *     &lt;enumeration value="SET"/>
 *     &lt;enumeration value="SPEC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "valueDeterminationCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum ValueDeterminationCodeValues {

    ALC,
    CALC,
    CONTR,
    DSG,
    EMP,
    EST,
    MEAS,
    PLAN,
    REQ,
    SET,
    SPEC;

    public String value() {
        return name();
    }

    public static ValueDeterminationCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
