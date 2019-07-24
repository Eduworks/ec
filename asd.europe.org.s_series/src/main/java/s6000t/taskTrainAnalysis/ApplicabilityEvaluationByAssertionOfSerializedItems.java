
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
 * <p>Java class for applicabilityEvaluationByAssertionOfSerializedItems complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="applicabilityEvaluationByAssertionOfSerializedItems">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}blockOfSerializedItems"/>
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
@XmlType(name = "applicabilityEvaluationByAssertionOfSerializedItems", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "range",
    "partRef",
    "prodRef",
    "prodVarRef",
    "rmks"
})
public class ApplicabilityEvaluationByAssertionOfSerializedItems {

    @XmlElement(required = true)
    protected ApplicableSerialNumberRange range;
    protected PartAsDesignedReference partRef;
    protected ProductReference prodRef;
    protected ProductVariantReference prodVarRef;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the range property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicableSerialNumberRange }
     *     
     */
    public ApplicableSerialNumberRange getRange() {
        return range;
    }

    /**
     * Sets the value of the range property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicableSerialNumberRange }
     *     
     */
    public void setRange(ApplicableSerialNumberRange value) {
        this.range = value;
    }

    /**
     * Gets the value of the partRef property.
     * 
     * @return
     *     possible object is
     *     {@link PartAsDesignedReference }
     *     
     */
    public PartAsDesignedReference getPartRef() {
        return partRef;
    }

    /**
     * Sets the value of the partRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartAsDesignedReference }
     *     
     */
    public void setPartRef(PartAsDesignedReference value) {
        this.partRef = value;
    }

    /**
     * Gets the value of the prodRef property.
     * 
     * @return
     *     possible object is
     *     {@link ProductReference }
     *     
     */
    public ProductReference getProdRef() {
        return prodRef;
    }

    /**
     * Sets the value of the prodRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductReference }
     *     
     */
    public void setProdRef(ProductReference value) {
        this.prodRef = value;
    }

    /**
     * Gets the value of the prodVarRef property.
     * 
     * @return
     *     possible object is
     *     {@link ProductVariantReference }
     *     
     */
    public ProductVariantReference getProdVarRef() {
        return prodVarRef;
    }

    /**
     * Sets the value of the prodVarRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductVariantReference }
     *     
     */
    public void setProdVarRef(ProductVariantReference value) {
        this.prodVarRef = value;
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
