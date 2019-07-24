
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
 * <p>Java class for conditionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conditionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="condName" type="{http://www.asd-europe.org/s-series/s3000l}conditionTypeName"/>
 *         &lt;element name="condDescr" type="{http://www.asd-europe.org/s-series/s3000l}conditionTypeDescription" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}conditionTypeValueNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="condInst" type="{http://www.asd-europe.org/s-series/s3000l}conditionInstance" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="condt[1-9][0-9]*"/>
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
@XmlType(name = "conditionType", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "condName",
    "condDescr",
    "conditionTypeValueNonAbstractClasses",
    "condInst",
    "docs",
    "rmks"
})
public class ConditionType {

    @XmlElement(required = true)
    protected ConditionTypeName condName;
    @XmlElementRef(name = "condDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<ConditionTypeDescription> condDescr;
    @XmlElements({
        @XmlElement(name = "propValue", type = ConditionTypePropertyValue.class, nillable = true),
        @XmlElement(name = "code", type = String.class, nillable = true)
    })
    protected List<Object> conditionTypeValueNonAbstractClasses;
    @XmlElement(nillable = true)
    protected List<ConditionInstance> condInst;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<ConditionInstance.Docs> docs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<ConditionInstance.Rmks> rmks;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the condName property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionTypeName }
     *     
     */
    public ConditionTypeName getCondName() {
        return condName;
    }

    /**
     * Sets the value of the condName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionTypeName }
     *     
     */
    public void setCondName(ConditionTypeName value) {
        this.condName = value;
    }

    /**
     * Gets the value of the condDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConditionTypeDescription }{@code >}
     *     
     */
    public JAXBElement<ConditionTypeDescription> getCondDescr() {
        return condDescr;
    }

    /**
     * Sets the value of the condDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConditionTypeDescription }{@code >}
     *     
     */
    public void setCondDescr(JAXBElement<ConditionTypeDescription> value) {
        this.condDescr = value;
    }

    /**
     * Gets the value of the conditionTypeValueNonAbstractClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conditionTypeValueNonAbstractClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConditionTypeValueNonAbstractClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConditionTypePropertyValue }
     * {@link String }
     * 
     * 
     */
    public List<Object> getConditionTypeValueNonAbstractClasses() {
        if (conditionTypeValueNonAbstractClasses == null) {
            conditionTypeValueNonAbstractClasses = new ArrayList<Object>();
        }
        return this.conditionTypeValueNonAbstractClasses;
    }

    /**
     * Gets the value of the condInst property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the condInst property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCondInst().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConditionInstance }
     * 
     * 
     */
    public List<ConditionInstance> getCondInst() {
        if (condInst == null) {
            condInst = new ArrayList<ConditionInstance>();
        }
        return this.condInst;
    }

    /**
     * Gets the value of the docs property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConditionInstance.Docs }{@code >}
     *     
     */
    public JAXBElement<ConditionInstance.Docs> getDocs() {
        return docs;
    }

    /**
     * Sets the value of the docs property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConditionInstance.Docs }{@code >}
     *     
     */
    public void setDocs(JAXBElement<ConditionInstance.Docs> value) {
        this.docs = value;
    }

    /**
     * Gets the value of the rmks property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConditionInstance.Rmks }{@code >}
     *     
     */
    public JAXBElement<ConditionInstance.Rmks> getRmks() {
        return rmks;
    }

    /**
     * Sets the value of the rmks property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConditionInstance.Rmks }{@code >}
     *     
     */
    public void setRmks(JAXBElement<ConditionInstance.Rmks> value) {
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
