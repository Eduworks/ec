
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
 * <p>Java class for subsequentRepeatRelationship complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subsequentRepeatRelationship">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trig" maxOccurs="unbounded" minOccurs="0">
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
 *         &lt;element name="repeatRef" type="{http://www.asd-europe.org/s-series/s3000l}repeatTimeLimitReference"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="subsre[1-9][0-9]*"/>
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
@XmlType(name = "subsequentRepeatRelationship", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "trig",
    "repeatRef"
})
public class SubsequentRepeatRelationship {

    @XmlElement(nillable = true)
    protected List<SubsequentRepeatRelationship.Trig> trig;
    @XmlElement(required = true)
    protected RepeatTimeLimitReference repeatRef;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the trig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubsequentRepeatRelationship.Trig }
     * 
     * 
     */
    public List<SubsequentRepeatRelationship.Trig> getTrig() {
        if (trig == null) {
            trig = new ArrayList<SubsequentRepeatRelationship.Trig>();
        }
        return this.trig;
    }

    /**
     * Gets the value of the repeatRef property.
     * 
     * @return
     *     possible object is
     *     {@link RepeatTimeLimitReference }
     *     
     */
    public RepeatTimeLimitReference getRepeatRef() {
        return repeatRef;
    }

    /**
     * Sets the value of the repeatRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepeatTimeLimitReference }
     *     
     */
    public void setRepeatRef(RepeatTimeLimitReference value) {
        this.repeatRef = value;
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
    public static class Trig {

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
