
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
 * <p>Java class for contractedProductVariant complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contractedProductVariant">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="qty" type="{http://www.asd-europe.org/s-series/s3000l}quantityOfContractedProductVariant" minOccurs="0"/>
 *         &lt;element name="block" type="{http://www.asd-europe.org/s-series/s3000l}contractedBlockOfSerializedItems" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="prodVarRef" type="{http://www.asd-europe.org/s-series/s3000l}productVariantReference"/>
 *         &lt;element name="user" type="{http://www.asd-europe.org/s-series/s3000l}userOfContractedProductVariant" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="atOpLocType" type="{http://www.asd-europe.org/s-series/s3000l}contractedProductVariantAtOperatingLocationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="atOpLoc" type="{http://www.asd-europe.org/s-series/s3000l}contractedProductVariantAtOperatingLocation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="contrpv[1-9][0-9]*"/>
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
@XmlType(name = "contractedProductVariant", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "qty",
    "block",
    "prodVarRef",
    "user",
    "atOpLocType",
    "atOpLoc",
    "docs",
    "rmks"
})
public class ContractedProductVariant {

    @XmlElementRef(name = "qty", type = JAXBElement.class, required = false)
    protected JAXBElement<QuantityOfContractedProductVariant> qty;
    @XmlElement(nillable = true)
    protected List<ContractedBlockOfSerializedItems> block;
    @XmlElement(required = true)
    protected ProductVariantReference prodVarRef;
    @XmlElement(nillable = true)
    protected List<UserOfContractedProductVariant> user;
    @XmlElement(nillable = true)
    protected List<ContractedProductVariantAtOperatingLocationType> atOpLocType;
    @XmlElement(nillable = true)
    protected List<ContractedProductVariantAtOperatingLocation> atOpLoc;
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
     *     {@link JAXBElement }{@code <}{@link QuantityOfContractedProductVariant }{@code >}
     *     
     */
    public JAXBElement<QuantityOfContractedProductVariant> getQty() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link QuantityOfContractedProductVariant }{@code >}
     *     
     */
    public void setQty(JAXBElement<QuantityOfContractedProductVariant> value) {
        this.qty = value;
    }

    /**
     * Gets the value of the block property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the block property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContractedBlockOfSerializedItems }
     * 
     * 
     */
    public List<ContractedBlockOfSerializedItems> getBlock() {
        if (block == null) {
            block = new ArrayList<ContractedBlockOfSerializedItems>();
        }
        return this.block;
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
     * Gets the value of the user property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the user property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserOfContractedProductVariant }
     * 
     * 
     */
    public List<UserOfContractedProductVariant> getUser() {
        if (user == null) {
            user = new ArrayList<UserOfContractedProductVariant>();
        }
        return this.user;
    }

    /**
     * Gets the value of the atOpLocType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the atOpLocType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAtOpLocType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContractedProductVariantAtOperatingLocationType }
     * 
     * 
     */
    public List<ContractedProductVariantAtOperatingLocationType> getAtOpLocType() {
        if (atOpLocType == null) {
            atOpLocType = new ArrayList<ContractedProductVariantAtOperatingLocationType>();
        }
        return this.atOpLocType;
    }

    /**
     * Gets the value of the atOpLoc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the atOpLoc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAtOpLoc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContractedProductVariantAtOperatingLocation }
     * 
     * 
     */
    public List<ContractedProductVariantAtOperatingLocation> getAtOpLoc() {
        if (atOpLoc == null) {
            atOpLoc = new ArrayList<ContractedProductVariantAtOperatingLocation>();
        }
        return this.atOpLoc;
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
