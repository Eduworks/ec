
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
 * <p>Java class for allocatedMaintenanceLevel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="allocatedMaintenanceLevel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}allocatedMaintenanceLevelItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="allmlv[1-9][0-9]*"/>
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
@XmlType(name = "allocatedMaintenanceLevel", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "opLocRef",
    "opTypeRef",
    "mlvRef",
    "mLocRef",
    "rmks",
    "applic"
})
public class AllocatedMaintenanceLevel {

    protected OperatingLocationReference opLocRef;
    protected OperatingLocationTypeReference opTypeRef;
    protected MaintenanceLevelReference mlvRef;
    protected MaintenanceLocationReference mLocRef;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

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
     * Gets the value of the applic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ProductName.Applic }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> getApplic() {
        return applic;
    }

    /**
     * Sets the value of the applic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ProductName.Applic }{@code >}
     *     
     */
    public void setApplic(JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> value) {
        this.applic = value;
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
