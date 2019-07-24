
package s6000t.taskTrainAnalysis;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for breakdownElementUsageInBreakdown complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="breakdownElementUsageInBreakdown">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beRef" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementRevisionReference"/>
 *         &lt;element name="beChild" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="inZone" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementInZoneRelationship" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}productVariantItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="beu[1-9][0-9]*"/>
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
@XmlType(name = "breakdownElementUsageInBreakdown", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "beRef",
    "beChild",
    "inZone",
    "usableOnList",
    "rmks"
})
public class BreakdownElementUsageInBreakdown {

    @XmlElement(required = true)
    protected BreakdownElementRevisionReference beRef;
    @XmlElement(nillable = true)
    protected List<BreakdownElementStructure> beChild;
    @XmlElementRef(name = "inZone", type = JAXBElement.class, required = false)
    protected JAXBElement<BreakdownElementInZoneRelationship> inZone;
    @XmlElementRef(name = "usableOnList", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.HardwareElementPartRealization.UsableOnList> usableOnList;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the beRef property.
     * 
     * @return
     *     possible object is
     *     {@link BreakdownElementRevisionReference }
     *     
     */
    public BreakdownElementRevisionReference getBeRef() {
        return beRef;
    }

    /**
     * Sets the value of the beRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link BreakdownElementRevisionReference }
     *     
     */
    public void setBeRef(BreakdownElementRevisionReference value) {
        this.beRef = value;
    }

    /**
     * Gets the value of the beChild property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the beChild property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBeChild().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BreakdownElementStructure }
     * 
     * 
     */
    public List<BreakdownElementStructure> getBeChild() {
        if (beChild == null) {
            beChild = new ArrayList<BreakdownElementStructure>();
        }
        return this.beChild;
    }

    /**
     * Gets the value of the inZone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BreakdownElementInZoneRelationship }{@code >}
     *     
     */
    public JAXBElement<BreakdownElementInZoneRelationship> getInZone() {
        return inZone;
    }

    /**
     * Sets the value of the inZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BreakdownElementInZoneRelationship }{@code >}
     *     
     */
    public void setInZone(JAXBElement<BreakdownElementInZoneRelationship> value) {
        this.inZone = value;
    }

    /**
     * Gets the value of the usableOnList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.HardwareElementPartRealization.UsableOnList }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.HardwareElementPartRealization.UsableOnList> getUsableOnList() {
        return usableOnList;
    }

    /**
     * Sets the value of the usableOnList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.HardwareElementPartRealization.UsableOnList }{@code >}
     *     
     */
    public void setUsableOnList(JAXBElement<s6000t.taskTrainAnalysis.HardwareElementPartRealization.UsableOnList> value) {
        this.usableOnList = value;
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
