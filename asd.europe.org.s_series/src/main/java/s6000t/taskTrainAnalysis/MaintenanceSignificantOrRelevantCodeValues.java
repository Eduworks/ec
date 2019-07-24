
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for maintenanceSignificantOrRelevantCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="maintenanceSignificantOrRelevantCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MR"/>
 *     &lt;enumeration value="MS"/>
 *     &lt;enumeration value="NA"/>
 *     &lt;enumeration value="NM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "maintenanceSignificantOrRelevantCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum MaintenanceSignificantOrRelevantCodeValues {

    MR,
    MS,
    NA,
    NM;

    public String value() {
        return name();
    }

    public static MaintenanceSignificantOrRelevantCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
