
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conditionTypeValueReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conditionTypeValueReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;choice>
 *           &lt;element name="code" type="{http://www.asd-europe.org/spec/validValues}conditionTypeClassValueCodeValues"/>
 *           &lt;element name="propValue" type="{http://www.asd-europe.org/s-series/s3000l}conditionTypePropertyValue"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="uidRef">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.asd-europe.org/s-series/s3000l}uidRef">
 *             &lt;pattern value="condv[1-9][0-9]*"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conditionTypeValueReference", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "code",
    "propValue"
})
public class ConditionTypeValueReference {

    protected String code;
    protected ConditionTypePropertyValue propValue;
    @XmlAttribute(name = "uidRef")
    @XmlIDREF
    protected Object uidRef;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the propValue property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionTypePropertyValue }
     *     
     */
    public ConditionTypePropertyValue getPropValue() {
        return propValue;
    }

    /**
     * Sets the value of the propValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionTypePropertyValue }
     *     
     */
    public void setPropValue(ConditionTypePropertyValue value) {
        this.propValue = value;
    }

    /**
     * Gets the value of the uidRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getUidRef() {
        return uidRef;
    }

    /**
     * Sets the value of the uidRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setUidRef(Object value) {
        this.uidRef = value;
    }

}
