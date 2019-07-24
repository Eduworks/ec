
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for angleUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="angleUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DGR"/>
 *     &lt;enumeration value="RD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "angleUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum AngleUnit {

    DGR,
    RD;

    public String value() {
        return name();
    }

    public static AngleUnit fromValue(String v) {
        return valueOf(v);
    }

}
