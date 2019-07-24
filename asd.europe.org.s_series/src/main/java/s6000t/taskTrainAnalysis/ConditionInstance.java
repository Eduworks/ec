
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
 * <p>Java class for conditionInstance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conditionInstance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="condInstId" type="{http://www.asd-europe.org/s-series/s3000l}conditionInstanceIdentifier"/>
 *         &lt;element name="name" type="{http://www.asd-europe.org/s-series/s3000l}conditionInstanceName" minOccurs="0"/>
 *         &lt;element name="condInstDescr" type="{http://www.asd-europe.org/s-series/s3000l}conditionInstanceDescription" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="condi[1-9][0-9]*"/>
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
@XmlType(name = "conditionInstance", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "condInstId",
    "name",
    "condInstDescr",
    "docs",
    "rmks"
})
public class ConditionInstance {

    @XmlElement(required = true)
    protected ConditionInstanceIdentifier condInstId;
    @XmlElementRef(name = "name", type = JAXBElement.class, required = false)
    protected JAXBElement<ConditionInstanceName> name;
    @XmlElementRef(name = "condInstDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<ConditionInstanceDescription> condInstDescr;
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
     * Gets the value of the condInstId property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionInstanceIdentifier }
     *     
     */
    public ConditionInstanceIdentifier getCondInstId() {
        return condInstId;
    }

    /**
     * Sets the value of the condInstId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionInstanceIdentifier }
     *     
     */
    public void setCondInstId(ConditionInstanceIdentifier value) {
        this.condInstId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConditionInstanceName }{@code >}
     *     
     */
    public JAXBElement<ConditionInstanceName> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConditionInstanceName }{@code >}
     *     
     */
    public void setName(JAXBElement<ConditionInstanceName> value) {
        this.name = value;
    }

    /**
     * Gets the value of the condInstDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConditionInstanceDescription }{@code >}
     *     
     */
    public JAXBElement<ConditionInstanceDescription> getCondInstDescr() {
        return condInstDescr;
    }

    /**
     * Sets the value of the condInstDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConditionInstanceDescription }{@code >}
     *     
     */
    public void setCondInstDescr(JAXBElement<ConditionInstanceDescription> value) {
        this.condInstDescr = value;
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
     *         &lt;element name="doc" type="{http://www.asd-europe.org/s-series/s3000l}documentAssignment" maxOccurs="unbounded"/>
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
        "doc"
    })
    public static class Docs {

        @XmlElement(required = true)
        protected List<DocumentAssignment> doc;

        /**
         * Gets the value of the doc property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the doc property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDoc().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocumentAssignment }
         * 
         * 
         */
        public List<DocumentAssignment> getDoc() {
            if (doc == null) {
                doc = new ArrayList<DocumentAssignment>();
            }
            return this.doc;
        }

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
     *         &lt;element name="rmk" type="{http://www.asd-europe.org/s-series/s3000l}remark" maxOccurs="unbounded"/>
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
        "rmk"
    })
    public static class Rmks {

        @XmlElement(required = true)
        protected List<Remark> rmk;

        /**
         * Gets the value of the rmk property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the rmk property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRmk().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Remark }
         * 
         * 
         */
        public List<Remark> getRmk() {
            if (rmk == null) {
                rmk = new ArrayList<Remark>();
            }
            return this.rmk;
        }

    }

}
