
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
 * <p>Java class for taskMaterialResourceBySpecification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskMaterialResourceBySpecification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fixed" type="{http://www.asd-europe.org/s-series/s3000l}fixedResourceMarker" minOccurs="0"/>
 *         &lt;element name="duration" type="{http://www.asd-europe.org/s-series/s3000l}taskResourceDuration" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="qty" type="{http://www.asd-europe.org/s-series/s3000l}taskMaterialResourceQuantity" minOccurs="0"/>
 *         &lt;element name="cat" type="{http://www.asd-europe.org/s-series/s3000l}taskMaterialResourceCategory" minOccurs="0"/>
 *         &lt;element name="relRes" type="{http://www.asd-europe.org/s-series/s3000l}taskResourceRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="specRef" type="{http://www.asd-europe.org/s-series/s3000l}resourceSpecificationReference"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="taskres[1-9][0-9]*"/>
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
@XmlType(name = "taskMaterialResourceBySpecification", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "fixed",
    "duration",
    "qty",
    "cat",
    "relRes",
    "specRef",
    "docs",
    "rmks",
    "applic"
})
public class TaskMaterialResourceBySpecification {

    @XmlElementRef(name = "fixed", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> fixed;
    @XmlElement(nillable = true)
    protected List<TaskResourceDuration> duration;
    @XmlElementRef(name = "qty", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskMaterialResourceQuantity> qty;
    @XmlElementRef(name = "cat", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskMaterialResourceCategory> cat;
    @XmlElement(nillable = true)
    protected List<TaskResourceRelationship> relRes;
    @XmlElement(required = true)
    protected ResourceSpecificationReference specRef;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the fixed property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getFixed() {
        return fixed;
    }

    /**
     * Sets the value of the fixed property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setFixed(JAXBElement<Boolean> value) {
        this.fixed = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the duration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDuration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskResourceDuration }
     * 
     * 
     */
    public List<TaskResourceDuration> getDuration() {
        if (duration == null) {
            duration = new ArrayList<TaskResourceDuration>();
        }
        return this.duration;
    }

    /**
     * Gets the value of the qty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskMaterialResourceQuantity }{@code >}
     *     
     */
    public JAXBElement<TaskMaterialResourceQuantity> getQty() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskMaterialResourceQuantity }{@code >}
     *     
     */
    public void setQty(JAXBElement<TaskMaterialResourceQuantity> value) {
        this.qty = value;
    }

    /**
     * Gets the value of the cat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskMaterialResourceCategory }{@code >}
     *     
     */
    public JAXBElement<TaskMaterialResourceCategory> getCat() {
        return cat;
    }

    /**
     * Sets the value of the cat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskMaterialResourceCategory }{@code >}
     *     
     */
    public void setCat(JAXBElement<TaskMaterialResourceCategory> value) {
        this.cat = value;
    }

    /**
     * Gets the value of the relRes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relRes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelRes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskResourceRelationship }
     * 
     * 
     */
    public List<TaskResourceRelationship> getRelRes() {
        if (relRes == null) {
            relRes = new ArrayList<TaskResourceRelationship>();
        }
        return this.relRes;
    }

    /**
     * Gets the value of the specRef property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceSpecificationReference }
     *     
     */
    public ResourceSpecificationReference getSpecRef() {
        return specRef;
    }

    /**
     * Sets the value of the specRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceSpecificationReference }
     *     
     */
    public void setSpecRef(ResourceSpecificationReference value) {
        this.specRef = value;
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
     * Gets the value of the applic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ProductName.Applic }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> getApplic() {
        return applic;
    }

    /**
     * Sets the value of the applic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ProductName.Applic }{@code >}
     *     
     */
    public void setApplic(JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> value) {
        this.applic = value;
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
