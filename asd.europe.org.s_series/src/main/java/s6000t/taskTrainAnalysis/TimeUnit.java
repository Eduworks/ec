
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for timeUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="timeUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MS"/>
 *     &lt;enumeration value="SEC"/>
 *     &lt;enumeration value="MIN"/>
 *     &lt;enumeration value="HR"/>
 *     &lt;enumeration value="DAY"/>
 *     &lt;enumeration value="WK"/>
 *     &lt;enumeration value="MON"/>
 *     &lt;enumeration value="QR"/>
 *     &lt;enumeration value="YR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "timeUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TimeUnit {

    MS,
    SEC,
    MIN,
    HR,
    DAY,
    WK,
    MON,
    QR,
    YR;

    public String value() {
        return name();
    }

    public static TimeUnit fromValue(String v) {
        return valueOf(v);
    }

}
