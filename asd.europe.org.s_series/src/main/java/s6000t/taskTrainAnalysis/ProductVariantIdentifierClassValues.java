
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productVariantIdentifierClassValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="productVariantIdentifierClassValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MOI"/>
 *     &lt;enumeration value="MOV"/>
 *     &lt;enumeration value="PVC"/>
 *     &lt;enumeration value="UOC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "productVariantIdentifierClassValues", namespace = "http://www.asd-europe.org/spec/validValues")
@XmlEnum
public enum ProductVariantIdentifierClassValues {

    MOI,
    MOV,
    PVC,
    UOC;

    public String value() {
        return name();
    }

    public static ProductVariantIdentifierClassValues fromValue(String v) {
        return valueOf(v);
    }

}
