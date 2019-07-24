
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for countUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="countUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AY"/>
 *     &lt;enumeration value="AT"/>
 *     &lt;enumeration value="EA"/>
 *     &lt;enumeration value="DZ"/>
 *     &lt;enumeration value="LL"/>
 *     &lt;enumeration value="FV"/>
 *     &lt;enumeration value="VC"/>
 *     &lt;enumeration value="GN"/>
 *     &lt;enumeration value="GR"/>
 *     &lt;enumeration value="GP"/>
 *     &lt;enumeration value="HD"/>
 *     &lt;enumeration value="LO"/>
 *     &lt;enumeration value="ME"/>
 *     &lt;enumeration value="OT"/>
 *     &lt;enumeration value="PR"/>
 *     &lt;enumeration value="PM"/>
 *     &lt;enumeration value="QR"/>
 *     &lt;enumeration value="RA"/>
 *     &lt;enumeration value="RM"/>
 *     &lt;enumeration value="SE"/>
 *     &lt;enumeration value="SH"/>
 *     &lt;enumeration value="SO"/>
 *     &lt;enumeration value="SK"/>
 *     &lt;enumeration value="TE"/>
 *     &lt;enumeration value="TS"/>
 *     &lt;enumeration value="MX"/>
 *     &lt;enumeration value="AX"/>
 *     &lt;enumeration value="TF"/>
 *     &lt;enumeration value="TD"/>
 *     &lt;enumeration value="AA"/>
 *     &lt;enumeration value="IU"/>
 *     &lt;enumeration value="WI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "countUnit", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum CountUnit {

    AY,
    AT,
    EA,
    DZ,
    LL,
    FV,
    VC,
    GN,
    GR,
    GP,
    HD,
    LO,
    ME,
    OT,
    PR,
    PM,
    QR,
    RA,
    RM,
    SE,
    SH,
    SO,
    SK,
    TE,
    TS,
    MX,
    AX,
    TF,
    TD,
    AA,
    IU,
    WI;

    public String value() {
        return name();
    }

    public static CountUnit fromValue(String v) {
        return valueOf(v);
    }

}
