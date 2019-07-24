
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hardwarePartMaintenanceStartCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="hardwarePartMaintenanceStartCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="START"/>
 *     &lt;enumeration value="PROD"/>
 *     &lt;enumeration value="DELIV"/>
 *     &lt;enumeration value="ASSY"/>
 *     &lt;enumeration value="ENDITEM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "hardwarePartMaintenanceStartCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum HardwarePartMaintenanceStartCodeValues {

    START,
    PROD,
    DELIV,
    ASSY,
    ENDITEM;

    public String value() {
        return name();
    }

    public static HardwarePartMaintenanceStartCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
