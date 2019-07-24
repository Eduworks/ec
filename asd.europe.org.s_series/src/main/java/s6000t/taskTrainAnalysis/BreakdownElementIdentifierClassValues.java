
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for breakdownElementIdentifierClassValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="breakdownElementIdentifierClassValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ASD"/>
 *     &lt;enumeration value="BEI"/>
 *     &lt;enumeration value="LCN"/>
 *     &lt;enumeration value="SNS"/>
 *     &lt;enumeration value="ISN"/>
 *     &lt;enumeration value="CSN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "breakdownElementIdentifierClassValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum BreakdownElementIdentifierClassValues {

    ASD,
    BEI,
    LCN,
    SNS,
    ISN,
    CSN;

    public String value() {
        return name();
    }

    public static BreakdownElementIdentifierClassValues fromValue(String v) {
        return valueOf(v);
    }

}
