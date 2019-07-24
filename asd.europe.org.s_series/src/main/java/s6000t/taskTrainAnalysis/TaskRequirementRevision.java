
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
 * <p>Java class for taskRequirementRevision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskRequirementRevision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trRevId" type="{http://www.asd-europe.org/s-series/s3000l}taskRequirementRevisionIdentifier"/>
 *         &lt;element name="revChangeDescr" type="{http://www.asd-europe.org/s-series/s3000l}taskRequirementRevisionChangeDescription" minOccurs="0"/>
 *         &lt;element name="revDate" type="{http://www.asd-europe.org/s-series/s3000l}taskRequirementDate" minOccurs="0"/>
 *         &lt;element name="trDescr" type="{http://www.asd-europe.org/s-series/s3000l}taskRequirementDescription" minOccurs="0"/>
 *         &lt;element name="trDecision" type="{http://www.asd-europe.org/s-series/s3000l}taskRequirementDecision" minOccurs="0"/>
 *         &lt;element name="specResReq" type="{http://www.asd-europe.org/s-series/s3000l}taskRequirementSpecialResourceRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trJust" type="{http://www.asd-europe.org/s-series/s3000l}taskRequirementJustification" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="changeReq" type="{http://www.asd-europe.org/s-series/s3000l}changeRequestSource" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="trrev[1-9][0-9]*"/>
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
@XmlType(name = "taskRequirementRevision", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "trRevId",
    "revChangeDescr",
    "revDate",
    "trDescr",
    "trDecision",
    "specResReq",
    "trJust",
    "changeReq",
    "docs",
    "rmks"
})
public class TaskRequirementRevision {

    @XmlElement(required = true)
    protected TaskRequirementRevisionIdentifier trRevId;
    @XmlElementRef(name = "revChangeDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskRequirementRevisionChangeDescription> revChangeDescr;
    @XmlElementRef(name = "revDate", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskRequirementDate> revDate;
    @XmlElementRef(name = "trDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskRequirementDescription> trDescr;
    @XmlElementRef(name = "trDecision", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskRequirementDecision> trDecision;
    @XmlElement(nillable = true)
    protected List<TaskRequirementSpecialResourceRequirement> specResReq;
    @XmlElement(nillable = true)
    protected List<TaskRequirementJustification> trJust;
    @XmlElement(nillable = true)
    protected List<ChangeRequestSource> changeReq;
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
     * Gets the value of the trRevId property.
     * 
     * @return
     *     possible object is
     *     {@link TaskRequirementRevisionIdentifier }
     *     
     */
    public TaskRequirementRevisionIdentifier getTrRevId() {
        return trRevId;
    }

    /**
     * Sets the value of the trRevId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskRequirementRevisionIdentifier }
     *     
     */
    public void setTrRevId(TaskRequirementRevisionIdentifier value) {
        this.trRevId = value;
    }

    /**
     * Gets the value of the revChangeDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskRequirementRevisionChangeDescription }{@code >}
     *     
     */
    public JAXBElement<TaskRequirementRevisionChangeDescription> getRevChangeDescr() {
        return revChangeDescr;
    }

    /**
     * Sets the value of the revChangeDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskRequirementRevisionChangeDescription }{@code >}
     *     
     */
    public void setRevChangeDescr(JAXBElement<TaskRequirementRevisionChangeDescription> value) {
        this.revChangeDescr = value;
    }

    /**
     * Gets the value of the revDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskRequirementDate }{@code >}
     *     
     */
    public JAXBElement<TaskRequirementDate> getRevDate() {
        return revDate;
    }

    /**
     * Sets the value of the revDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskRequirementDate }{@code >}
     *     
     */
    public void setRevDate(JAXBElement<TaskRequirementDate> value) {
        this.revDate = value;
    }

    /**
     * Gets the value of the trDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskRequirementDescription }{@code >}
     *     
     */
    public JAXBElement<TaskRequirementDescription> getTrDescr() {
        return trDescr;
    }

    /**
     * Sets the value of the trDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskRequirementDescription }{@code >}
     *     
     */
    public void setTrDescr(JAXBElement<TaskRequirementDescription> value) {
        this.trDescr = value;
    }

    /**
     * Gets the value of the trDecision property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskRequirementDecision }{@code >}
     *     
     */
    public JAXBElement<TaskRequirementDecision> getTrDecision() {
        return trDecision;
    }

    /**
     * Sets the value of the trDecision property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskRequirementDecision }{@code >}
     *     
     */
    public void setTrDecision(JAXBElement<TaskRequirementDecision> value) {
        this.trDecision = value;
    }

    /**
     * Gets the value of the specResReq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specResReq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecResReq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskRequirementSpecialResourceRequirement }
     * 
     * 
     */
    public List<TaskRequirementSpecialResourceRequirement> getSpecResReq() {
        if (specResReq == null) {
            specResReq = new ArrayList<TaskRequirementSpecialResourceRequirement>();
        }
        return this.specResReq;
    }

    /**
     * Gets the value of the trJust property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trJust property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrJust().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskRequirementJustification }
     * 
     * 
     */
    public List<TaskRequirementJustification> getTrJust() {
        if (trJust == null) {
            trJust = new ArrayList<TaskRequirementJustification>();
        }
        return this.trJust;
    }

    /**
     * Gets the value of the changeReq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changeReq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangeReq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChangeRequestSource }
     * 
     * 
     */
    public List<ChangeRequestSource> getChangeReq() {
        if (changeReq == null) {
            changeReq = new ArrayList<ChangeRequestSource>();
        }
        return this.changeReq;
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
