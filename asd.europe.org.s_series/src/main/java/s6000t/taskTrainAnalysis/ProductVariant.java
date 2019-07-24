
package s6000t.taskTrainAnalysis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for productVariant complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productVariant">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prodVarId" type="{http://www.asd-europe.org/s-series/s3000l}productVariantIdentifier" maxOccurs="unbounded"/>
 *         &lt;element name="name" type="{http://www.asd-europe.org/s-series/s3000l}productVariantName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}allowedProductConfigurationInterfaceRealizedBy" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nestedPV" type="{http://www.asd-europe.org/s-series/s3000l}nestedProductVariantRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}breakdownItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="prodv[1-9][0-9]*"/>
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
@XmlType(name = "productVariant", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "prodVarId",
    "name",
    "allowedProductConfigurationInterfaceRealizedBy",
    "nestedPV",
    "bkdns",
    "orgInfos",
    "docs",
    "rmks"
})
public class ProductVariant {

    @XmlElement(required = true)
    protected List<ProductVariantIdentifier> prodVarId;
    @XmlElement(nillable = true)
    protected List<ProductVariantName> name;
    @XmlElements({
        @XmlElement(name = "hwConfPart", type = AllowedProductConfigurationHardwarePartAsDesigned.class, nillable = true),
        @XmlElement(name = "prodConf", type = AllowedProductConfigurationByConfigurationIdentifier.class, nillable = true)
    })
    protected List<Object> allowedProductConfigurationInterfaceRealizedBy;
    @XmlElement(nillable = true)
    protected List<NestedProductVariantRelationship> nestedPV;
    @XmlElementRef(name = "bkdns", type = JAXBElement.class, required = false)
    protected JAXBElement<ProductVariant.Bkdns> bkdns;
    @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> orgInfos;
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
     * Gets the value of the prodVarId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prodVarId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProdVarId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductVariantIdentifier }
     * 
     * 
     */
    public List<ProductVariantIdentifier> getProdVarId() {
        if (prodVarId == null) {
            prodVarId = new ArrayList<ProductVariantIdentifier>();
        }
        return this.prodVarId;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductVariantName }
     * 
     * 
     */
    public List<ProductVariantName> getName() {
        if (name == null) {
            name = new ArrayList<ProductVariantName>();
        }
        return this.name;
    }

    /**
     * Gets the value of the allowedProductConfigurationInterfaceRealizedBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedProductConfigurationInterfaceRealizedBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedProductConfigurationInterfaceRealizedBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowedProductConfigurationHardwarePartAsDesigned }
     * {@link AllowedProductConfigurationByConfigurationIdentifier }
     * 
     * 
     */
    public List<Object> getAllowedProductConfigurationInterfaceRealizedBy() {
        if (allowedProductConfigurationInterfaceRealizedBy == null) {
            allowedProductConfigurationInterfaceRealizedBy = new ArrayList<Object>();
        }
        return this.allowedProductConfigurationInterfaceRealizedBy;
    }

    /**
     * Gets the value of the nestedPV property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nestedPV property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNestedPV().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NestedProductVariantRelationship }
     * 
     * 
     */
    public List<NestedProductVariantRelationship> getNestedPV() {
        if (nestedPV == null) {
            nestedPV = new ArrayList<NestedProductVariantRelationship>();
        }
        return this.nestedPV;
    }

    /**
     * Gets the value of the bkdns property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductVariant.Bkdns }{@code >}
     *     
     */
    public JAXBElement<ProductVariant.Bkdns> getBkdns() {
        return bkdns;
    }

    /**
     * Sets the value of the bkdns property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductVariant.Bkdns }{@code >}
     *     
     */
    public void setBkdns(JAXBElement<ProductVariant.Bkdns> value) {
        this.bkdns = value;
    }

    /**
     * Gets the value of the orgInfos property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.DownTime.OrgInfos }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> getOrgInfos() {
        return orgInfos;
    }

    /**
     * Sets the value of the orgInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.DownTime.OrgInfos }{@code >}
     *     
     */
    public void setOrgInfos(JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> value) {
        this.orgInfos = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="bkdn" type="{http://www.asd-europe.org/s-series/s3000l}breakdown" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bkdn"
    })
    public static class Bkdns {

        @XmlElement(required = true)
        protected List<Breakdown> bkdn;

        /**
         * Gets the value of the bkdn property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bkdn property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBkdn().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Breakdown }
         * 
         * 
         */
        public List<Breakdown> getBkdn() {
            if (bkdn == null) {
                bkdn = new ArrayList<Breakdown>();
            }
            return this.bkdn;
        }

    }

}
