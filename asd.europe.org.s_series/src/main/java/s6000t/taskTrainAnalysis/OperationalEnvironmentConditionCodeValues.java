
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operationalEnvironmentConditionCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="operationalEnvironmentConditionCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ARC"/>
 *     &lt;enumeration value="DES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "operationalEnvironmentConditionCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum OperationalEnvironmentConditionCodeValues {

    ARC,
    DES;

    public String value() {
        return name();
    }

    public static OperationalEnvironmentConditionCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
