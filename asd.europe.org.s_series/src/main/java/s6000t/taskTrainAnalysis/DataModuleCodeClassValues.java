
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataModuleCodeClassValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dataModuleCodeClassValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DMC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dataModuleCodeClassValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum DataModuleCodeClassValues {

    DMC;

    public String value() {
        return name();
    }

    public static DataModuleCodeClassValues fromValue(String v) {
        return valueOf(v);
    }

}
