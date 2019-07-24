
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
 * <p>Java class for contractedProductVariantAtOperatingLocation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contractedProductVariantAtOperatingLocation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="qty" type="{http://www.asd-europe.org/s-series/s3000l}quantityOfProductVariantAtOperatingLocation" minOccurs="0"/>
 *         &lt;element name="opReq" type="{http://www.asd-europe.org/s-series/s3000l}operatingRequirementAtOperatingLocation" minOccurs="0"/>
 *         &lt;element name="theaterOfOp" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocationReference"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="cpvol[1-9][0-9]*"/>
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
@XmlType(name = "contractedProductVariantAtOperatingLocation", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "qty",
    "opReq",
    "theaterOfOp",
    "rmks"
})
public class ContractedProductVariantAtOperatingLocation {

    @XmlElementRef(name = "qty", type = JAXBElement.class, required = false)
    protected JAXBElement<QuantityOfProductVariantAtOperatingLocation> qty;
    @XmlElementRef(name = "opReq", type = JAXBElement.class, required = false)
    protected JAXBElement<OperatingRequirementAtOperatingLocation> opReq;
    @XmlElement(required = true)
    protected OperatingLocationReference theaterOfOp;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the qty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link QuantityOfProductVariantAtOperatingLocation }{@code >}
     *     
     */
    public JAXBElement<QuantityOfProductVariantAtOperatingLocation> getQty() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link QuantityOfProductVariantAtOperatingLocation }{@code >}
     *     
     */
    public void setQty(JAXBElement<QuantityOfProductVariantAtOperatingLocation> value) {
        this.qty = value;
    }

    /**
     * Gets the value of the opReq property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OperatingRequirementAtOperatingLocation }{@code >}
     *     
     */
    public JAXBElement<OperatingRequirementAtOperatingLocation> getOpReq() {
        return opReq;
    }

    /**
     * Sets the value of the opReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OperatingRequirementAtOperatingLocation }{@code >}
     *     
     */
    public void setOpReq(JAXBElement<OperatingRequirementAtOperatingLocation> value) {
        this.opReq = value;
    }

    /**
     * Gets the value of the theaterOfOp property.
     * 
     * @return
     *     possible object is
     *     {@link OperatingLocationReference }
     *     
     */
    public OperatingLocationReference getTheaterOfOp() {
        return theaterOfOp;
    }

    /**
     * Sets the value of the theaterOfOp property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingLocationReference }
     *     
     */
    public void setTheaterOfOp(OperatingLocationReference value) {
        this.theaterOfOp = value;
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
