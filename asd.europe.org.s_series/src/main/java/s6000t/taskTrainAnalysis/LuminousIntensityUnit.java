
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for luminousIntensityUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="luminousIntensityUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "luminousIntensityUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum LuminousIntensityUnit {

    CD;

    public String value() {
        return name();
    }

    public static LuminousIntensityUnit fromValue(String v) {
        return valueOf(v);
    }

}
