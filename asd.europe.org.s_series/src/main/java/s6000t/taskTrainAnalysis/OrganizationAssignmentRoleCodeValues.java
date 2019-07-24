
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for organizationAssignmentRoleCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="organizationAssignmentRoleCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AUTH"/>
 *     &lt;enumeration value="DESG"/>
 *     &lt;enumeration value="PUBL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "organizationAssignmentRoleCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum OrganizationAssignmentRoleCodeValues {

    AUTH,
    DESG,
    PUBL;

    public String value() {
        return name();
    }

    public static OrganizationAssignmentRoleCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
