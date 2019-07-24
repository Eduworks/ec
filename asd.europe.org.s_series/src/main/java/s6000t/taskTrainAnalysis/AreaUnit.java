
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for areaUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="areaUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FM"/>
 *     &lt;enumeration value="HS"/>
 *     &lt;enumeration value="QC"/>
 *     &lt;enumeration value="QD"/>
 *     &lt;enumeration value="SF"/>
 *     &lt;enumeration value="SI"/>
 *     &lt;enumeration value="SM"/>
 *     &lt;enumeration value="MN"/>
 *     &lt;enumeration value="SY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "areaUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum AreaUnit {

    FM,
    HS,
    QC,
    QD,
    SF,
    SI,
    SM,
    MN,
    SY;

    public String value() {
        return name();
    }

    public static AreaUnit fromValue(String v) {
        return valueOf(v);
    }

}
