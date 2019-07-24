
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
 * <p>Java class for partAsDesignedPartsListEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="partAsDesignedPartsListEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="qty" type="{http://www.asd-europe.org/s-series/s3000l}quantityOfChildElement" minOccurs="0"/>
 *         &lt;element name="rfd" type="{http://www.asd-europe.org/s-series/s3000l}referenceDesignator" minOccurs="0"/>
 *         &lt;element name="posId" type="{http://www.asd-europe.org/s-series/s3000l}partsListEntryIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="repl" type="{http://www.asd-europe.org/s-series/s3000l}physicalReplaceability" minOccurs="0"/>
 *         &lt;element name="rly" type="{http://www.asd-europe.org/s-series/s3000l}physicalReplaceabilityStrategy" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="partRef" type="{http://www.asd-europe.org/s-series/s3000l}partAsDesignedReference"/>
 *         &lt;element name="substPart" type="{http://www.asd-europe.org/s-series/s3000l}substitutePartAsDesignedRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}allowedProductConfigurationItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="ple[1-9][0-9]*"/>
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
@XmlType(name = "partAsDesignedPartsListEntry", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "qty",
    "rfd",
    "posId",
    "repl",
    "rly",
    "partRef",
    "substPart",
    "apcEfys",
    "docs",
    "rmks"
})
public class PartAsDesignedPartsListEntry {

    @XmlElementRef(name = "qty", type = JAXBElement.class, required = false)
    protected JAXBElement<QuantityOfChildElement> qty;
    @XmlElementRef(name = "rfd", type = JAXBElement.class, required = false)
    protected JAXBElement<ReferenceDesignator> rfd;
    @XmlElement(nillable = true)
    protected List<PartsListEntryIdentifier> posId;
    @XmlElementRef(name = "repl", type = JAXBElement.class, required = false)
    protected JAXBElement<PhysicalReplaceability> repl;
    @XmlElement(nillable = true)
    protected List<PhysicalReplaceabilityStrategy> rly;
    @XmlElement(required = true)
    protected PartAsDesignedReference partRef;
    @XmlElement(nillable = true)
    protected List<SubstitutePartAsDesignedRelationship> substPart;
    @XmlElementRef(name = "apcEfys", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.PartAsDesignedPartsList.ApcEfys> apcEfys;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
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
     * Gets the value of the rfd property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ReferenceDesignator }{@code >}
     *     
     */
    public JAXBElement<ReferenceDesignator> getRfd() {
        return rfd;
    }

    /**
     * Sets the value of the rfd property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ReferenceDesignator }{@code >}
     *     
     */
    public void setRfd(JAXBElement<ReferenceDesignator> value) {
        this.rfd = value;
    }

    /**
     * Gets the value of the posId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the posId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPosId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartsListEntryIdentifier }
     * 
     * 
     */
    public List<PartsListEntryIdentifier> getPosId() {
        if (posId == null) {
            posId = new ArrayList<PartsListEntryIdentifier>();
        }
        return this.posId;
    }

    /**
     * Gets the value of the repl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PhysicalReplaceability }{@code >}
     *     
     */
    public JAXBElement<PhysicalReplaceability> getRepl() {
        return repl;
    }

    /**
     * Sets the value of the repl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PhysicalReplaceability }{@code >}
     *     
     */
    public void setRepl(JAXBElement<PhysicalReplaceability> value) {
        this.repl = value;
    }

    /**
     * Gets the value of the rly property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rly property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRly().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhysicalReplaceabilityStrategy }
     * 
     * 
     */
    public List<PhysicalReplaceabilityStrategy> getRly() {
        if (rly == null) {
            rly = new ArrayList<PhysicalReplaceabilityStrategy>();
        }
        return this.rly;
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
     * Gets the value of the substPart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the substPart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubstPart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubstitutePartAsDesignedRelationship }
     * 
     * 
     */
    public List<SubstitutePartAsDesignedRelationship> getSubstPart() {
        if (substPart == null) {
            substPart = new ArrayList<SubstitutePartAsDesignedRelationship>();
        }
        return this.substPart;
    }

    /**
     * Gets the value of the apcEfys property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.PartAsDesignedPartsList.ApcEfys }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.PartAsDesignedPartsList.ApcEfys> getApcEfys() {
        return apcEfys;
    }

    /**
     * Sets the value of the apcEfys property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.PartAsDesignedPartsList.ApcEfys }{@code >}
     *     
     */
    public void setApcEfys(JAXBElement<s6000t.taskTrainAnalysis.PartAsDesignedPartsList.ApcEfys> value) {
        this.apcEfys = value;
    }

    /**
     * Gets the value of the docs property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ConditionInstance.Docs }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> getDocs() {
        return docs;
    }

    /**
     * Sets the value of the docs property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ConditionInstance.Docs }{@code >}
     *     
     */
    public void setDocs(JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> value) {
        this.docs = value;
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
