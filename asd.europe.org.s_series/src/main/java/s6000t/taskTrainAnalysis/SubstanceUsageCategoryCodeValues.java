
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for substanceUsageCategoryCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="substanceUsageCategoryCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="F"/>
 *     &lt;enumeration value="AL"/>
 *     &lt;enumeration value="A"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "substanceUsageCategoryCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SubstanceUsageCategoryCodeValues {

    F,
    AL,
    A;

    public String value() {
        return name();
    }

    public static SubstanceUsageCategoryCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
