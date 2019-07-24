
package s6000t.taskTrainAnalysis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for not complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="not">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityEvaluationNonAbstractClasses"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="not[1-9][0-9]*"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="crud" type="{http://www.asd-europe.org/s-series/s3000l}crudCodeValues" default="I" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "not", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "and",
    "not",
    "or",
    "assertInst",
    "assertCond",
    "nestedApplic",
    "assertSi"
})
public class Not {

    @XmlElementRef(name = "and", type = JAXBElement.class, required = false)
    protected JAXBElement<And> and;
    @XmlElementRef(name = "not", type = JAXBElement.class, required = false)
    protected JAXBElement<Not> not;
    @XmlElementRef(name = "or", type = JAXBElement.class, required = false)
    protected JAXBElement<Or> or;
    @XmlElementRef(name = "assertInst", type = JAXBElement.class, required = false)
    protected JAXBElement<ApplicabilityEvaluationByAssertionOfClassInstance> assertInst;
    @XmlElementRef(name = "assertCond", type = JAXBElement.class, required = false)
    protected JAXBElement<ApplicabilityEvaluationByAssertionOfCondition> assertCond;
    @XmlElementRef(name = "nestedApplic", type = JAXBElement.class, required = false)
    protected JAXBElement<ApplicabilityEvaluationByApplicabilityStatementReference> nestedApplic;
    @XmlElementRef(name = "assertSi", type = JAXBElement.class, required = false)
    protected JAXBElement<ApplicabilityEvaluationByAssertionOfSerializedItems> assertSi;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the and property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link And }{@code >}
     *     
     */
    public JAXBElement<And> getAnd() {
        return and;
    }

    /**
     * Sets the value of the and property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link And }{@code >}
     *     
     */
    public void setAnd(JAXBElement<And> value) {
        this.and = value;
    }

    /**
     * Gets the value of the not property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Not }{@code >}
     *     
     */
    public JAXBElement<Not> getNot() {
        return not;
    }

    /**
     * Sets the value of the not property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Not }{@code >}
     *     
     */
    public void setNot(JAXBElement<Not> value) {
        this.not = value;
    }

    /**
     * Gets the value of the or property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Or }{@code >}
     *     
     */
    public JAXBElement<Or> getOr() {
        return or;
    }

    /**
     * Sets the value of the or property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Or }{@code >}
     *     
     */
    public void setOr(JAXBElement<Or> value) {
        this.or = value;
    }

    /**
     * Gets the value of the assertInst property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ApplicabilityEvaluationByAssertionOfClassInstance }{@code >}
     *     
     */
    public JAXBElement<ApplicabilityEvaluationByAssertionOfClassInstance> getAssertInst() {
        return assertInst;
    }

    /**
     * Sets the value of the assertInst property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ApplicabilityEvaluationByAssertionOfClassInstance }{@code >}
     *     
     */
    public void setAssertInst(JAXBElement<ApplicabilityEvaluationByAssertionOfClassInstance> value) {
        this.assertInst = value;
    }

    /**
     * Gets the value of the assertCond property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ApplicabilityEvaluationByAssertionOfCondition }{@code >}
     *     
     */
    public JAXBElement<ApplicabilityEvaluationByAssertionOfCondition> getAssertCond() {
        return assertCond;
    }

    /**
     * Sets the value of the assertCond property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ApplicabilityEvaluationByAssertionOfCondition }{@code >}
     *     
     */
    public void setAssertCond(JAXBElement<ApplicabilityEvaluationByAssertionOfCondition> value) {
        this.assertCond = value;
    }

    /**
     * Gets the value of the nestedApplic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ApplicabilityEvaluationByApplicabilityStatementReference }{@code >}
     *     
     */
    public JAXBElement<ApplicabilityEvaluationByApplicabilityStatementReference> getNestedApplic() {
        return nestedApplic;
    }

    /**
     * Sets the value of the nestedApplic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ApplicabilityEvaluationByApplicabilityStatementReference }{@code >}
     *     
     */
    public void setNestedApplic(JAXBElement<ApplicabilityEvaluationByApplicabilityStatementReference> value) {
        this.nestedApplic = value;
    }

    /**
     * Gets the value of the assertSi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ApplicabilityEvaluationByAssertionOfSerializedItems }{@code >}
     *     
     */
    public JAXBElement<ApplicabilityEvaluationByAssertionOfSerializedItems> getAssertSi() {
        return assertSi;
    }

    /**
     * Sets the value of the assertSi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ApplicabilityEvaluationByAssertionOfSerializedItems }{@code >}
     *     
     */
    public void setAssertSi(JAXBElement<ApplicabilityEvaluationByAssertionOfSerializedItems> value) {
        this.assertSi = value;
    }

    /**
     * Gets the value of the uid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * Gets the value of the crud property.
     * 
     * @return
     *     possible object is
     *     {@link CrudCodeValues }
     *     
     */
    public CrudCodeValues getCrud() {
        if (crud == null) {
            return CrudCodeValues.I;
        } else {
            return crud;
        }
    }

    /**
     * Sets the value of the crud property.
     * 
     * @param value
     *     allowed object is
     *     {@link CrudCodeValues }
     *     
     */
    public void setCrud(CrudCodeValues value) {
        this.crud = value;
    }

}
