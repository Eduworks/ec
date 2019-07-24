
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for candidateItemAnalysisActivityIndicatorCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="candidateItemAnalysisActivityIndicatorCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="O"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "candidateItemAnalysisActivityIndicatorCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum CandidateItemAnalysisActivityIndicatorCodeValues {

    S,
    R,
    O;

    public String value() {
        return name();
    }

    public static CandidateItemAnalysisActivityIndicatorCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
