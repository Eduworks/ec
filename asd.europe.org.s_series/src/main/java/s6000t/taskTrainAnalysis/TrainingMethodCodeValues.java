
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trainingMethodCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="trainingMethodCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CLA"/>
 *     &lt;enumeration value="CBL"/>
 *     &lt;enumeration value="CTT"/>
 *     &lt;enumeration value="OJT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "trainingMethodCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TrainingMethodCodeValues {

    CLA,
    CBL,
    CTT,
    OJT;

    public String value() {
        return name();
    }

    public static TrainingMethodCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
