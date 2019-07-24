
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
 * <p>Java class for partAsDesignedPartsList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="partAsDesignedPartsList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pListType" type="{http://www.asd-europe.org/s-series/s3000l}partsListType"/>
 *         &lt;element name="pListRevId" type="{http://www.asd-europe.org/s-series/s3000l}partsListRevisionIdentifier" minOccurs="0"/>
 *         &lt;element name="pListEntry" type="{http://www.asd-europe.org/s-series/s3000l}partAsDesignedPartsListEntry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}allowedProductConfigurationItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="plist[1-9][0-9]*"/>
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
@XmlType(name = "partAsDesignedPartsList", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "pListType",
    "pListRevId",
    "pListEntry",
    "apcEfys",
    "docs",
    "rmks"
})
public class PartAsDesignedPartsList {

    @XmlElement(required = true)
    protected PartsListType pListType;
    @XmlElementRef(name = "pListRevId", type = JAXBElement.class, required = false)
    protected JAXBElement<PartsListRevisionIdentifier> pListRevId;
    @XmlElement(nillable = true)
    protected List<PartAsDesignedPartsListEntry> pListEntry;
    @XmlElementRef(name = "apcEfys", type = JAXBElement.class, required = false)
    protected JAXBElement<PartAsDesignedPartsList.ApcEfys> apcEfys;
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
     * Gets the value of the pListType property.
     * 
     * @return
     *     possible object is
     *     {@link PartsListType }
     *     
     */
    public PartsListType getPListType() {
        return pListType;
    }

    /**
     * Sets the value of the pListType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartsListType }
     *     
     */
    public void setPListType(PartsListType value) {
        this.pListType = value;
    }

    /**
     * Gets the value of the pListRevId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PartsListRevisionIdentifier }{@code >}
     *     
     */
    public JAXBElement<PartsListRevisionIdentifier> getPListRevId() {
        return pListRevId;
    }

    /**
     * Sets the value of the pListRevId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PartsListRevisionIdentifier }{@code >}
     *     
     */
    public void setPListRevId(JAXBElement<PartsListRevisionIdentifier> value) {
        this.pListRevId = value;
    }

    /**
     * Gets the value of the pListEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pListEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPListEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartAsDesignedPartsListEntry }
     * 
     * 
     */
    public List<PartAsDesignedPartsListEntry> getPListEntry() {
        if (pListEntry == null) {
            pListEntry = new ArrayList<PartAsDesignedPartsListEntry>();
        }
        return this.pListEntry;
    }

    /**
     * Gets the value of the apcEfys property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PartAsDesignedPartsList.ApcEfys }{@code >}
     *     
     */
    public JAXBElement<PartAsDesignedPartsList.ApcEfys> getApcEfys() {
        return apcEfys;
    }

    /**
     * Sets the value of the apcEfys property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PartAsDesignedPartsList.ApcEfys }{@code >}
     *     
     */
    public void setApcEfys(JAXBElement<PartAsDesignedPartsList.ApcEfys> value) {
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
     *         &lt;element name="apcEfy" type="{http://www.asd-europe.org/s-series/s3000l}itemInAllowedProductConfiguration" maxOccurs="unbounded"/>
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
        "apcEfy"
    })
    public static class ApcEfys {

        @XmlElement(required = true)
        protected List<ItemInAllowedProductConfiguration> apcEfy;

        /**
         * Gets the value of the apcEfy property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the apcEfy property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getApcEfy().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ItemInAllowedProductConfiguration }
         * 
         * 
         */
        public List<ItemInAllowedProductConfiguration> getApcEfy() {
            if (apcEfy == null) {
                apcEfy = new ArrayList<ItemInAllowedProductConfiguration>();
            }
            return this.apcEfy;
        }

    }

}
