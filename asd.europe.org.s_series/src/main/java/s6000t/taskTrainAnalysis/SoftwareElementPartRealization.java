
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
 * <p>Java class for softwareElementPartRealization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="softwareElementPartRealization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="partRef" type="{http://www.asd-europe.org/s-series/s3000l}partAsDesignedReference"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}productVariantItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}allowedProductConfigurationItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="swr[1-9][0-9]*"/>
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
@XmlType(name = "softwareElementPartRealization", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "partRef",
    "usableOnList",
    "apcEfys",
    "docs",
    "rmks"
})
public class SoftwareElementPartRealization {

    @XmlElement(required = true)
    protected PartAsDesignedReference partRef;
    @XmlElementRef(name = "usableOnList", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.HardwareElementPartRealization.UsableOnList> usableOnList;
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
