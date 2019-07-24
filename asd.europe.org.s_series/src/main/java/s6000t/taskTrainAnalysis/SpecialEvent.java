
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
 * <p>Java class for specialEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="specialEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="evntTitle" type="{http://www.asd-europe.org/s-series/s3000l}specialEventTitle"/>
 *         &lt;element name="evntDescr" type="{http://www.asd-europe.org/s-series/s3000l}specialEventDescription" minOccurs="0"/>
 *         &lt;element name="evntGrp" type="{http://www.asd-europe.org/s-series/s3000l}specialEventGroup" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}specialEventOccurrenceNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="spee[1-9][0-9]*"/>
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
@XmlType(name = "specialEvent", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "evntTitle",
    "evntDescr",
    "evntGrp",
    "specialEventOccurrenceNonAbstractClasses",
    "docs",
    "rmks"
})
public class SpecialEvent {

    @XmlElement(required = true)
    protected SpecialEventTitle evntTitle;
    @XmlElementRef(name = "evntDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<SpecialEventDescription> evntDescr;
    @XmlElementRef(name = "evntGrp", type = JAXBElement.class, required = false)
    protected JAXBElement<SpecialEventGroup> evntGrp;
    @XmlElements({
        @XmlElement(name = "ratedEvntOcc", type = RatedSpecialEventOccurrence.class, nillable = true),
        @XmlElement(name = "quantEvntOcc", type = QuantifiedSpecialEventOccurrence.class, nillable = true)
    })
    protected List<Object> specialEventOccurrenceNonAbstractClasses;
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
     * Gets the value of the evntTitle property.
     * 
     * @return
     *     possible object is
     *     {@link SpecialEventTitle }
     *     
     */
    public SpecialEventTitle getEvntTitle() {
        return evntTitle;
    }

    /**
     * Sets the value of the evntTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialEventTitle }
     *     
     */
    public void setEvntTitle(SpecialEventTitle value) {
        this.evntTitle = value;
    }

    /**
     * Gets the value of the evntDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SpecialEventDescription }{@code >}
     *     
     */
    public JAXBElement<SpecialEventDescription> getEvntDescr() {
        return evntDescr;
    }

    /**
     * Sets the value of the evntDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SpecialEventDescription }{@code >}
     *     
     */
    public void setEvntDescr(JAXBElement<SpecialEventDescription> value) {
        this.evntDescr = value;
    }

    /**
     * Gets the value of the evntGrp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SpecialEventGroup }{@code >}
     *     
     */
    public JAXBElement<SpecialEventGroup> getEvntGrp() {
        return evntGrp;
    }

    /**
     * Sets the value of the evntGrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SpecialEventGroup }{@code >}
     *     
     */
    public void setEvntGrp(JAXBElement<SpecialEventGroup> value) {
        this.evntGrp = value;
    }

    /**
     * Gets the value of the specialEventOccurrenceNonAbstractClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialEventOccurrenceNonAbstractClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialEventOccurrenceNonAbstractClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RatedSpecialEventOccurrence }
     * {@link QuantifiedSpecialEventOccurrence }
     * 
     * 
     */
    public List<Object> getSpecialEventOccurrenceNonAbstractClasses() {
        if (specialEventOccurrenceNonAbstractClasses == null) {
            specialEventOccurrenceNonAbstractClasses = new ArrayList<Object>();
        }
        return this.specialEventOccurrenceNonAbstractClasses;
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
