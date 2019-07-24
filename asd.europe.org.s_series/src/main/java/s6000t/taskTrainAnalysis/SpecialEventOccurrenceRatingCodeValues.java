
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for specialEventOccurrenceRatingCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="specialEventOccurrenceRatingCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EUN"/>
 *     &lt;enumeration value="REM"/>
 *     &lt;enumeration value="OCC"/>
 *     &lt;enumeration value="PROB"/>
 *     &lt;enumeration value="FREQ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "specialEventOccurrenceRatingCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum SpecialEventOccurrenceRatingCodeValues {

    EUN,
    REM,
    OCC,
    PROB,
    FREQ;

    public String value() {
        return name();
    }

    public static SpecialEventOccurrenceRatingCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
