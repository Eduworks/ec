
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskMaterialResourceCategoryCodeValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="taskMaterialResourceCategoryCodeValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SPE"/>
 *     &lt;enumeration value="SSPE"/>
 *     &lt;enumeration value="SPA"/>
 *     &lt;enumeration value="SPY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "taskMaterialResourceCategoryCodeValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum TaskMaterialResourceCategoryCodeValues {

    SPE,
    SSPE,
    SPA,
    SPY;

    public String value() {
        return name();
    }

    public static TaskMaterialResourceCategoryCodeValues fromValue(String v) {
        return valueOf(v);
    }

}
