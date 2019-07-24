
package s6000t.taskTrainAnalysis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for applicabilityEvaluationByAssertionOfCondition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="applicabilityEvaluationByAssertionOfCondition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}conditionDefinitionItem"/>
 *         &lt;element name="assertValue" type="{http://www.asd-europe.org/s-series/s3000l}conditionTypeValueReference"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="applev[1-9][0-9]*"/>
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
@XmlType(name = "applicabilityEvaluationByAssertionOfCondition", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "condTypeRef",
    "condInstRef",
    "assertValue",
    "rmks"
})
public class ApplicabilityEvaluationByAssertionOfCondition {

    protected ConditionTypeReference condTypeRef;
    protected ConditionInstanceReference condInstRef;
    @XmlElement(required = true)
    protected ConditionTypeValueReference assertValue;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the condTypeRef property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionTypeReference }
     *     
     */
    public ConditionTypeReference getCondTypeRef() {
        return condTypeRef;
    }

    /**
     * Sets the value of the condTypeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionTypeReference }
     *     
     */
    public void setCondTypeRef(ConditionTypeReference value) {
        this.condTypeRef = value;
    }

    /**
     * Gets the value of the condInstRef property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionInstanceReference }
     *     
     */
    public ConditionInstanceReference getCondInstRef() {
        return condInstRef;
    }

    /**
     * Sets the value of the condInstRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionInstanceReference }
     *     
     */
    public void setCondInstRef(ConditionInstanceReference value) {
        this.condInstRef = value;
    }

    /**
     * Gets the value of the assertValue property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionTypeValueReference }
     *     
     */
    public ConditionTypeValueReference getAssertValue() {
        return assertValue;
    }

    /**
     * Sets the value of the assertValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionTypeValueReference }
     *     
     */
    public void setAssertValue(ConditionTypeValueReference value) {
        this.assertValue = value;
    }

    /**
     * Gets the value of the rmks property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ConditionInstance.Rmks }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> getRmks() {
        return rmks;
    }

    /**
     * Sets the value of the rmks property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ConditionInstance.Rmks }{@code >}
     *     
     */
    public void setRmks(JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> value) {
        this.rmks = value;
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
