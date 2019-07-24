
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for candidateItemAnalysisActivityStatusCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="candidateItemAnalysisActivityStatusCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NS"/>
 *     &lt;enumeration value="O"/>
 *     &lt;enumeration value="C"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "candidateItemAnalysisActivityStatusCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum CandidateItemAnalysisActivityStatusCodeValues {

    NS,
    O,
    C;

    public String value() {
        return name();
    }

    public static CandidateItemAnalysisActivityStatusCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
