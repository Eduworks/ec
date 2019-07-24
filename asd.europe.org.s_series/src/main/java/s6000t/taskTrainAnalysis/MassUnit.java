
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for massUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="massUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CG"/>
 *     &lt;enumeration value="DC"/>
 *     &lt;enumeration value="DG"/>
 *     &lt;enumeration value="DM"/>
 *     &lt;enumeration value="GM"/>
 *     &lt;enumeration value="HG"/>
 *     &lt;enumeration value="HW"/>
 *     &lt;enumeration value="KG"/>
 *     &lt;enumeration value="LT"/>
 *     &lt;enumeration value="MG"/>
 *     &lt;enumeration value="TM"/>
 *     &lt;enumeration value="OZ"/>
 *     &lt;enumeration value="QK"/>
 *     &lt;enumeration value="QN"/>
 *     &lt;enumeration value="LB"/>
 *     &lt;enumeration value="TO"/>
 *     &lt;enumeration value="TN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "massUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum MassUnit {

    CG,
    DC,
    DG,
    DM,
    GM,
    HG,
    HW,
    KG,
    LT,
    MG,
    TM,
    OZ,
    QK,
    QN,
    LB,
    TO,
    TN;

    public String value() {
        return name();
    }

    public static MassUnit fromValue(String v) {
        return valueOf(v);
    }

}
