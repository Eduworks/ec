
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for publicationModuleCodeClassValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="publicationModuleCodeClassValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PMC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "publicationModuleCodeClassValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum PublicationModuleCodeClassValues {

    PMC;

    public String value() {
        return name();
    }

    public static PublicationModuleCodeClassValues fromValue(String v) {
        return valueOf(v);
    }

}
