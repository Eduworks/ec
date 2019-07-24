
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
 * <p>Java class for itemInAllowedProductConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="itemInAllowedProductConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}nonConformanceData"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}allowedProductConfigurationInterfaceRealizedByRef"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}serialNumberApplicabilityItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="iipc[1-9][0-9]*"/>
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
@XmlType(name = "itemInAllowedProductConfiguration", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "nonConf",
    "hwConfPartRef",
    "prodConfRef",
    "rangeEfys",
    "docs",
    "rmks"
})
public class ItemInAllowedProductConfiguration {

    @XmlElement(nillable = true)
    protected List<ItemInAllowedProductConfiguration.NonConf> nonConf;
    @XmlElementRef(name = "hwConfPartRef", type = JAXBElement.class, required = false)
    protected JAXBElement<PartAsDesignedReference> hwConfPartRef;
    @XmlElementRef(name = "prodConfRef", type = JAXBElement.class, required = false)
    protected JAXBElement<AllowedProductConfigurationByConfigurationIdentifierReference> prodConfRef;
    @XmlElementRef(name = "rangeEfys", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ItemInProductVariant.RangeEfys> rangeEfys;
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
     * Gets the value of the nonConf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nonConf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNonConf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemInAllowedProductConfiguration.NonConf }
     * 
     * 
     */
    public List<ItemInAllowedProductConfiguration.NonConf> getNonConf() {
        if (nonConf == null) {
            nonConf = new ArrayList<ItemInAllowedProductConfiguration.NonConf>();
        }
        return this.nonConf;
    }

    /**
     * Gets the value of the hwConfPartRef property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PartAsDesignedReference }{@code >}
     *     
     */
    public JAXBElement<PartAsDesignedReference> getHwConfPartRef() {
        return hwConfPartRef;
    }

    /**
     * Sets the value of the hwConfPartRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PartAsDesignedReference }{@code >}
     *     
     */
    public void setHwConfPartRef(JAXBElement<PartAsDesignedReference> value) {
        this.hwConfPartRef = value;
    }

    /**
     * Gets the value of the prodConfRef property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AllowedProductConfigurationByConfigurationIdentifierReference }{@code >}
     *     
     */
    public JAXBElement<AllowedProductConfigurationByConfigurationIdentifierReference> getProdConfRef() {
        return prodConfRef;
    }

    /**
     * Sets the value of the prodConfRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AllowedProductConfigurationByConfigurationIdentifierReference }{@code >}
     *     
     */
    public void setProdConfRef(JAXBElement<AllowedProductConfigurationByConfigurationIdentifierReference> value) {
        this.prodConfRef = value;
    }

    /**
     * Gets the value of the rangeEfys property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ItemInProductVariant.RangeEfys }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.ItemInProductVariant.RangeEfys> getRangeEfys() {
        return rangeEfys;
    }

    /**
     * Sets the value of the rangeEfys property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ItemInProductVariant.RangeEfys }{@code >}
     *     
     */
    public void setRangeEfys(JAXBElement<s6000t.taskTrainAnalysis.ItemInProductVariant.RangeEfys> value) {
        this.rangeEfys = value;
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
     *         &lt;element name="nonConfType" type="{http://www.asd-europe.org/s-series/s3000l}nonConformanceType"/>
     *         &lt;element name="nonConfDescr" type="{http://www.asd-europe.org/s-series/s3000l}nonConformanceDescription" minOccurs="0"/>
     *         &lt;element name="nonConfRestr" type="{http://www.asd-europe.org/s-series/s3000l}nonConformanceRestriction" maxOccurs="unbounded" minOccurs="0"/>
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
        "nonConfType",
        "nonConfDescr",
        "nonConfRestr"
    })
    public static class NonConf {

        @XmlElement(required = true)
        protected NonConformanceType nonConfType;
        @XmlElementRef(name = "nonConfDescr", type = JAXBElement.class, required = false)
        protected JAXBElement<NonConformanceDescription> nonConfDescr;
        @XmlElement(nillable = true)
        protected List<NonConformanceRestriction> nonConfRestr;

        /**
         * Gets the value of the nonConfType property.
         * 
         * @return
         *     possible object is
         *     {@link NonConformanceType }
         *     
         */
        public NonConformanceType getNonConfType() {
            return nonConfType;
        }

        /**
         * Sets the value of the nonConfType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NonConformanceType }
         *     
         */
        public void setNonConfType(NonConformanceType value) {
            this.nonConfType = value;
        }

        /**
         * Gets the value of the nonConfDescr property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link NonConformanceDescription }{@code >}
         *     
         */
        public JAXBElement<NonConformanceDescription> getNonConfDescr() {
            return nonConfDescr;
        }

        /**
         * Sets the value of the nonConfDescr property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link NonConformanceDescription }{@code >}
         *     
         */
        public void setNonConfDescr(JAXBElement<NonConformanceDescription> value) {
            this.nonConfDescr = value;
        }

        /**
         * Gets the value of the nonConfRestr property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nonConfRestr property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNonConfRestr().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NonConformanceRestriction }
         * 
         * 
         */
        public List<NonConformanceRestriction> getNonConfRestr() {
            if (nonConfRestr == null) {
                nonConfRestr = new ArrayList<NonConformanceRestriction>();
            }
            return this.nonConfRestr;
        }

    }

}
