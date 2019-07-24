
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tradeNameCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tradeNameCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="E"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tradeNameCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TradeNameCodeValues {

    M,
    E;

    public String value() {
        return name();
    }

    public static TradeNameCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
