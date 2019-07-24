
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for allowedProductConfigurationIdentifierClassValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="allowedProductConfigurationIdentifierClassValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "allowedProductConfigurationIdentifierClassValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum AllowedProductConfigurationIdentifierClassValues {

    CID;

    public String value() {
        return name();
    }

    public static AllowedProductConfigurationIdentifierClassValues fromValue(String v) {
        return valueOf(v);
    }

}
