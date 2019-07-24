
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
 * <p>Java class for repeatTimeLimit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="repeatTimeLimit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="thld" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}thresholdDefinitionNonAbstractClasses"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="subseqRep" type="{http://www.asd-europe.org/s-series/s3000l}subsequentRepeatRelationship" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}samplingItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="reptl[1-9][0-9]*"/>
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
@XmlType(name = "repeatTimeLimit", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "thld",
    "subseqRep",
    "samplByDef",
    "samplByValue",
    "samplByRo"
})
public class RepeatTimeLimit {

    @XmlElement(nillable = true)
    protected List<RepeatTimeLimit.Thld> thld;
    @XmlElementRef(name = "subseqRep", type = JAXBElement.class, required = false)
    protected JAXBElement<SubsequentRepeatRelationship> subseqRep;
    @XmlElementRef(name = "samplByDef", type = JAXBElement.class, required = false)
    protected JAXBElement<SamplingDefinition> samplByDef;
    @XmlElementRef(name = "samplByValue", type = JAXBElement.class, required = false)
    protected JAXBElement<SamplingDefinitionByValue> samplByValue;
    @XmlElementRef(name = "samplByRo", type = JAXBElement.class, required = false)
    protected JAXBElement<SamplingDefinitionByRatio> samplByRo;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the thld property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thld property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThld().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RepeatTimeLimit.Thld }
     * 
     * 
     */
    public List<RepeatTimeLimit.Thld> getThld() {
        if (thld == null) {
            thld = new ArrayList<RepeatTimeLimit.Thld>();
        }
        return this.thld;
    }

    /**
     * Gets the value of the subseqRep property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubsequentRepeatRelationship }{@code >}
     *     
     */
    public JAXBElement<SubsequentRepeatRelationship> getSubseqRep() {
        return subseqRep;
    }

    /**
     * Sets the value of the subseqRep property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubsequentRepeatRelationship }{@code >}
     *     
     */
    public void setSubseqRep(JAXBElement<SubsequentRepeatRelationship> value) {
        this.subseqRep = value;
    }

    /**
     * Gets the value of the samplByDef property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SamplingDefinition }{@code >}
     *     
     */
    public JAXBElement<SamplingDefinition> getSamplByDef() {
        return samplByDef;
    }

    /**
     * Sets the value of the samplByDef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SamplingDefinition }{@code >}
     *     
     */
    public void setSamplByDef(JAXBElement<SamplingDefinition> value) {
        this.samplByDef = value;
    }

    /**
     * Gets the value of the samplByValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SamplingDefinitionByValue }{@code >}
     *     
     */
    public JAXBElement<SamplingDefinitionByValue> getSamplByValue() {
        return samplByValue;
    }

    /**
     * Sets the value of the samplByValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SamplingDefinitionByValue }{@code >}
     *     
     */
    public void setSamplByValue(JAXBElement<SamplingDefinitionByValue> value) {
        this.samplByValue = value;
    }

    /**
     * Gets the value of the samplByRo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SamplingDefinitionByRatio }{@code >}
     *     
     */
    public JAXBElement<SamplingDefinitionByRatio> getSamplByRo() {
        return samplByRo;
    }

    /**
     * Sets the value of the samplByRo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SamplingDefinitionByRatio }{@code >}
     *     
     */
    public void setSamplByRo(JAXBElement<SamplingDefinitionByRatio> value) {
        this.samplByRo = value;
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
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}thresholdDefinitionNonAbstractClasses"/>
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
        "paramThld",
        "taskThld",
        "sEvntThld",
        "fmThld"
    })
    public static class Thld {

        @XmlElementRef(name = "paramThld", type = JAXBElement.class, required = false)
        protected JAXBElement<ParameterThresholdDefinition> paramThld;
        @XmlElementRef(name = "taskThld", type = JAXBElement.class, required = false)
        protected JAXBElement<TaskThresholdDefinition> taskThld;
        @XmlElementRef(name = "sEvntThld", type = JAXBElement.class, required = false)
        protected JAXBElement<SpecialEventThresholdDefinition> sEvntThld;
        @XmlElementRef(name = "fmThld", type = JAXBElement.class, required = false)
        protected JAXBElement<FailureModeThresholdDefinition> fmThld;

        /**
         * Gets the value of the paramThld property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link ParameterThresholdDefinition }{@code >}
         *     
         */
        public JAXBElement<ParameterThresholdDefinition> getParamThld() {
            return paramThld;
        }

        /**
         * Sets the value of the paramThld property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link ParameterThresholdDefinition }{@code >}
         *     
         */
        public void setParamThld(JAXBElement<ParameterThresholdDefinition> value) {
            this.paramThld = value;
        }

        /**
         * Gets the value of the taskThld property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link TaskThresholdDefinition }{@code >}
         *     
         */
        public JAXBElement<TaskThresholdDefinition> getTaskThld() {
            return taskThld;
        }

        /**
         * Sets the value of the taskThld property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link TaskThresholdDefinition }{@code >}
         *     
         */
        public void setTaskThld(JAXBElement<TaskThresholdDefinition> value) {
            this.taskThld = value;
        }

        /**
         * Gets the value of the sEvntThld property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link SpecialEventThresholdDefinition }{@code >}
         *     
         */
        public JAXBElement<SpecialEventThresholdDefinition> getSEvntThld() {
            return sEvntThld;
        }

        /**
         * Sets the value of the sEvntThld property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link SpecialEventThresholdDefinition }{@code >}
         *     
         */
        public void setSEvntThld(JAXBElement<SpecialEventThresholdDefinition> value) {
            this.sEvntThld = value;
        }

        /**
         * Gets the value of the fmThld property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link FailureModeThresholdDefinition }{@code >}
         *     
         */
        public JAXBElement<FailureModeThresholdDefinition> getFmThld() {
            return fmThld;
        }

        /**
         * Sets the value of the fmThld property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link FailureModeThresholdDefinition }{@code >}
         *     
         */
        public void setFmThld(JAXBElement<FailureModeThresholdDefinition> value) {
            this.fmThld = value;
        }

    }

}
