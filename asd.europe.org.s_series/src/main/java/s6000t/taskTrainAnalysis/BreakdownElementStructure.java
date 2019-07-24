
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
 * <p>Java class for breakdownElementStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="breakdownElementStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rfd" type="{http://www.asd-europe.org/s-series/s3000l}referenceDesignator" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="qty" type="{http://www.asd-europe.org/s-series/s3000l}quantityOfChildElement" minOccurs="0"/>
 *         &lt;element name="beChildRef" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementUsageInBreakdownReference"/>
 *         &lt;element name="relatedElem" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementStructureRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="bes[1-9][0-9]*"/>
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
@XmlType(name = "breakdownElementStructure", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "rfd",
    "qty",
    "beChildRef",
    "relatedElem"
})
public class BreakdownElementStructure {

    @XmlElement(nillable = true)
    protected List<ReferenceDesignator> rfd;
    @XmlElementRef(name = "qty", type = JAXBElement.class, required = false)
    protected JAXBElement<QuantityOfChildElement> qty;
    @XmlElement(required = true)
    protected BreakdownElementUsageInBreakdownReference beChildRef;
    @XmlElement(nillable = true)
    protected List<BreakdownElementStructureRelationship> relatedElem;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the rfd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rfd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRfd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceDesignator }
     * 
     * 
     */
    public List<ReferenceDesignator> getRfd() {
        if (rfd == null) {
            rfd = new ArrayList<ReferenceDesignator>();
        }
        return this.rfd;
    }

    /**
     * Gets the value of the qty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link QuantityOfChildElement }{@code >}
     *     
     */
    public JAXBElement<QuantityOfChildElement> getQty() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link QuantityOfChildElement }{@code >}
     *     
     */
    public void setQty(JAXBElement<QuantityOfChildElement> value) {
        this.qty = value;
    }

    /**
     * Gets the value of the beChildRef property.
     * 
     * @return
     *     possible object is
     *     {@link BreakdownElementUsageInBreakdownReference }
     *     
     */
    public BreakdownElementUsageInBreakdownReference getBeChildRef() {
        return beChildRef;
    }

    /**
     * Sets the value of the beChildRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link BreakdownElementUsageInBreakdownReference }
     *     
     */
    public void setBeChildRef(BreakdownElementUsageInBreakdownReference value) {
        this.beChildRef = value;
    }

    /**
     * Gets the value of the relatedElem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedElem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedElem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BreakdownElementStructureRelationship }
     * 
     * 
     */
    public List<BreakdownElementStructureRelationship> getRelatedElem() {
        if (relatedElem == null) {
            relatedElem = new ArrayList<BreakdownElementStructureRelationship>();
        }
        return this.relatedElem;
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
