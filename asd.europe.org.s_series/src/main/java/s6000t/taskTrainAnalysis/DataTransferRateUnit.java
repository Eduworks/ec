
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataTransferRateUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dataTransferRateUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BIPS"/>
 *     &lt;enumeration value="BPS"/>
 *     &lt;enumeration value="KBIS"/>
 *     &lt;enumeration value="KBS"/>
 *     &lt;enumeration value="MBIS"/>
 *     &lt;enumeration value="MBS"/>
 *     &lt;enumeration value="GBIS"/>
 *     &lt;enumeration value="GBS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dataTransferRateUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum DataTransferRateUnit {

    BIPS,
    BPS,
    KBIS,
    KBS,
    MBIS,
    MBS,
    GBIS,
    GBS;

    public String value() {
        return name();
    }

    public static DataTransferRateUnit fromValue(String v) {
        return valueOf(v);
    }

}
