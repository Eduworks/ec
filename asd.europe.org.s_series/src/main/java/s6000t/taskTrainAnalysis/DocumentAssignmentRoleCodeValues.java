
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for documentAssignmentRoleCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="documentAssignmentRoleCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="REF"/>
 *     &lt;enumeration value="DRW"/>
 *     &lt;enumeration value="DSG"/>
 *     &lt;enumeration value="DIR"/>
 *     &lt;enumeration value="SCE"/>
 *     &lt;enumeration value="VER"/>
 *     &lt;enumeration value="SRCE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "documentAssignmentRoleCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum DocumentAssignmentRoleCodeValues {

    REF,
    DRW,
    DSG,
    DIR,
    SCE,
    VER,
    SRCE;

    public String value() {
        return name();
    }

    public static DocumentAssignmentRoleCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
