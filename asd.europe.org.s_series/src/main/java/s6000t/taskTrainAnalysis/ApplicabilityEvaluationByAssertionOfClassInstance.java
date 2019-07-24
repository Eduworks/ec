
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
 * <p>Java class for applicabilityEvaluationByAssertionOfClassInstance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="applicabilityEvaluationByAssertionOfClassInstance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssertItem"/>
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
@XmlType(name = "applicabilityEvaluationByAssertionOfClassInstance", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "prodVarRef",
    "hwElemRealRef",
    "swElemRealRef",
    "orgRef",
    "opLocRef",
    "opTypeRef",
    "mlvRef",
    "mLocRef",
    "beRef",
    "usagePhaseRef",
    "contrRef",
    "partRef",
    "prodConfRef",
    "rmks"
})
public class ApplicabilityEvaluationByAssertionOfClassInstance {

    protected ProductVariantReference prodVarRef;
    protected HardwareElementPartRealizationReference hwElemRealRef;
    protected SoftwareElementPartRealizationReference swElemRealRef;
    protected OrganizationReference orgRef;
    protected OperatingLocationReference opLocRef;
    protected OperatingLocationTypeReference opTypeRef;
    protected MaintenanceLevelReference mlvRef;
    protected MaintenanceLocationReference mLocRef;
    protected BreakdownElementReference beRef;
    protected ProductUsagePhaseReference usagePhaseRef;
    protected ContractReference contrRef;
    protected PartAsDesignedReference partRef;
    protected AllowedProductConfigurationByConfigurationIdentifierReference prodConfRef;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

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
     * Gets the value of the hwElemRealRef property.
     * 
     * @return
     *     possible object is
     *     {@link HardwareElementPartRealizationReference }
     *     
     */
    public HardwareElementPartRealizationReference getHwElemRealRef() {
        return hwElemRealRef;
    }

    /**
     * Sets the value of the hwElemRealRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link HardwareElementPartRealizationReference }
     *     
     */
    public void setHwElemRealRef(HardwareElementPartRealizationReference value) {
        this.hwElemRealRef = value;
    }

    /**
     * Gets the value of the swElemRealRef property.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareElementPartRealizationReference }
     *     
     */
    public SoftwareElementPartRealizationReference getSwElemRealRef() {
        return swElemRealRef;
    }

    /**
     * Sets the value of the swElemRealRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareElementPartRealizationReference }
     *     
     */
    public void setSwElemRealRef(SoftwareElementPartRealizationReference value) {
        this.swElemRealRef = value;
    }

    /**
     * Gets the value of the orgRef property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationReference }
     *     
     */
    public OrganizationReference getOrgRef() {
        return orgRef;
    }

    /**
     * Sets the value of the orgRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationReference }
     *     
     */
    public void setOrgRef(OrganizationReference value) {
        this.orgRef = value;
    }

    /**
     * Gets the value of the opLocRef property.
     * 
     * @return
     *     possible object is
     *     {@link OperatingLocationReference }
     *     
     */
    public OperatingLocationReference getOpLocRef() {
        return opLocRef;
    }

    /**
     * Sets the value of the opLocRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingLocationReference }
     *     
     */
    public void setOpLocRef(OperatingLocationReference value) {
        this.opLocRef = value;
    }

    /**
     * Gets the value of the opTypeRef property.
     * 
     * @return
     *     possible object is
     *     {@link OperatingLocationTypeReference }
     *     
     */
    public OperatingLocationTypeReference getOpTypeRef() {
        return opTypeRef;
    }

    /**
     * Sets the value of the opTypeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingLocationTypeReference }
     *     
     */
    public void setOpTypeRef(OperatingLocationTypeReference value) {
        this.opTypeRef = value;
    }

    /**
     * Gets the value of the mlvRef property.
     * 
     * @return
     *     possible object is
     *     {@link MaintenanceLevelReference }
     *     
     */
    public MaintenanceLevelReference getMlvRef() {
        return mlvRef;
    }

    /**
     * Sets the value of the mlvRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaintenanceLevelReference }
     *     
     */
    public void setMlvRef(MaintenanceLevelReference value) {
        this.mlvRef = value;
    }

    /**
     * Gets the value of the mLocRef property.
     * 
     * @return
     *     possible object is
     *     {@link MaintenanceLocationReference }
     *     
     */
    public MaintenanceLocationReference getMLocRef() {
        return mLocRef;
    }

    /**
     * Sets the value of the mLocRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaintenanceLocationReference }
     *     
     */
    public void setMLocRef(MaintenanceLocationReference value) {
        this.mLocRef = value;
    }

    /**
     * Gets the value of the beRef property.
     * 
     * @return
     *     possible object is
     *     {@link BreakdownElementReference }
     *     
     */
    public BreakdownElementReference getBeRef() {
        return beRef;
    }

    /**
     * Sets the value of the beRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link BreakdownElementReference }
     *     
     */
    public void setBeRef(BreakdownElementReference value) {
        this.beRef = value;
    }

    /**
     * Gets the value of the usagePhaseRef property.
     * 
     * @return
     *     possible object is
     *     {@link ProductUsagePhaseReference }
     *     
     */
    public ProductUsagePhaseReference getUsagePhaseRef() {
        return usagePhaseRef;
    }

    /**
     * Sets the value of the usagePhaseRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductUsagePhaseReference }
     *     
     */
    public void setUsagePhaseRef(ProductUsagePhaseReference value) {
        this.usagePhaseRef = value;
    }

    /**
     * Gets the value of the contrRef property.
     * 
     * @return
     *     possible object is
     *     {@link ContractReference }
     *     
     */
    public ContractReference getContrRef() {
        return contrRef;
    }

    /**
     * Sets the value of the contrRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractReference }
     *     
     */
    public void setContrRef(ContractReference value) {
        this.contrRef = value;
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
     * Gets the value of the prodConfRef property.
     * 
     * @return
     *     possible object is
     *     {@link AllowedProductConfigurationByConfigurationIdentifierReference }
     *     
     */
    public AllowedProductConfigurationByConfigurationIdentifierReference getProdConfRef() {
        return prodConfRef;
    }

    /**
     * Sets the value of the prodConfRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowedProductConfigurationByConfigurationIdentifierReference }
     *     
     */
    public void setProdConfRef(AllowedProductConfigurationByConfigurationIdentifierReference value) {
        this.prodConfRef = value;
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
