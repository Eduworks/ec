
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for torqueUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="torqueUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "torqueUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TorqueUnit {

    NM;

    public String value() {
        return name();
    }

    public static TorqueUnit fromValue(String v) {
        return valueOf(v);
    }

}
