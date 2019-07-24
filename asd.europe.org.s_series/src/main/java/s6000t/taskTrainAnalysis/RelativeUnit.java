
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for relativeUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="relativeUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PCT"/>
 *     &lt;enumeration value="PME"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "relativeUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum RelativeUnit {

    PCT,
    PME;

    public String value() {
        return name();
    }

    public static RelativeUnit fromValue(String v) {
        return valueOf(v);
    }

}
