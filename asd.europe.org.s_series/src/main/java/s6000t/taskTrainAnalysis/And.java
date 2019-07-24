
package s6000t.taskTrainAnalysis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for and complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="and">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityEvaluationNonAbstractClasses" maxOccurs="unbounded" minOccurs="2"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="and[1-9][0-9]*"/>
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
@XmlType(name = "and", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "applicabilityEvaluationNonAbstractClasses"
})
public class And {

    @XmlElements({
        @XmlElement(name = "and", type = And.class, nillable = true),
        @XmlElement(name = "not", type = Not.class, nillable = true),
        @XmlElement(name = "or", type = Or.class, nillable = true),
        @XmlElement(name = "assertInst", type = ApplicabilityEvaluationByAssertionOfClassInstance.class, nillable = true),
        @XmlElement(name = "assertCond", type = ApplicabilityEvaluationByAssertionOfCondition.class, nillable = true),
        @XmlElement(name = "nestedApplic", type = ApplicabilityEvaluationByApplicabilityStatementReference.class, nillable = true),
        @XmlElement(name = "assertSi", type = ApplicabilityEvaluationByAssertionOfSerializedItems.class, nillable = true)
    })
    protected List<Object> applicabilityEvaluationNonAbstractClasses;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the applicabilityEvaluationNonAbstractClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicabilityEvaluationNonAbstractClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicabilityEvaluationNonAbstractClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link And }
     * {@link Not }
     * {@link Or }
     * {@link ApplicabilityEvaluationByAssertionOfClassInstance }
     * {@link ApplicabilityEvaluationByAssertionOfCondition }
     * {@link ApplicabilityEvaluationByApplicabilityStatementReference }
     * {@link ApplicabilityEvaluationByAssertionOfSerializedItems }
     * 
     * 
     */
    public List<Object> getApplicabilityEvaluationNonAbstractClasses() {
        if (applicabilityEvaluationNonAbstractClasses == null) {
            applicabilityEvaluationNonAbstractClasses = new ArrayList<Object>();
        }
        return this.applicabilityEvaluationNonAbstractClasses;
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
