
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for maintenanceLevelIdentifierClassValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="maintenanceLevelIdentifierClassValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MLID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "maintenanceLevelIdentifierClassValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum MaintenanceLevelIdentifierClassValues {

    MLID;

    public String value() {
        return name();
    }

    public static MaintenanceLevelIdentifierClassValues fromValue(String v) {
        return valueOf(v);
    }

}
