
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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for subtaskTrainDecisionDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subtaskTrainDecisionDefinition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subtTrainId" type="{http://www.asd-europe.org/s-series/s3000l}subtaskTrainIdentifier"/>
 *         &lt;element name="trainDecision" type="{http://www.asd-europe.org/s-series/s3000l}subtaskTrainDecision" minOccurs="0"/>
 *         &lt;element name="trainRtnle" type="{http://www.asd-europe.org/s-series/s3000l}subtaskTrainDecisionRationale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trainDecisionChgDescr" type="{http://www.asd-europe.org/s-series/s3000l}subtaskTrainDecisionChangeDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="perfObj" type="{http://www.asd-europe.org/s-series/s3000l}subtaskPerformanceObjective" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}subtaskTrainStepNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subtRef" type="{http://www.asd-europe.org/s-series/s3000l}subtaskRef" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}levelOfLearningItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="std[1-9][0-9]*"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="uri" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="crud" type="{http://www.asd-europe.org/s-series/s3000l}crudCodeValues" default="I" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subtaskTrainDecisionDefinition", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "subtTrainId",
    "trainDecision",
    "trainRtnle",
    "trainDecisionChgDescr",
    "perfObj",
    "subtaskTrainStepNonAbstractClasses",
    "subtRef",
    "orgInfos",
    "docs",
    "rmks",
    "levOfLearn"
})
public class SubtaskTrainDecisionDefinition {

    @XmlElement(required = true)
    protected SubtaskTrainIdentifier subtTrainId;
    @XmlElementRef(name = "trainDecision", type = JAXBElement.class, required = false)
    protected JAXBElement<SubtaskTrainDecision> trainDecision;
    @XmlElement(nillable = true)
    protected List<SubtaskTrainDecisionRationale> trainRtnle;
    @XmlElement(nillable = true)
    protected List<SubtaskTrainDecisionChangeDescription> trainDecisionChgDescr;
    @XmlElement(nillable = true)
    protected List<SubtaskPerformanceObjective> perfObj;
    @XmlElements({
        @XmlElement(name = "trainStepDef", type = SubtaskTrainStepDefinition.class, nillable = true),
        @XmlElement(name = "trainStepRef", type = SubtaskTrainStepReference.class, nillable = true)
    })
    protected List<Object> subtaskTrainStepNonAbstractClasses;
    @XmlElementRef(name = "subtRef", type = JAXBElement.class, required = false)
    protected JAXBElement<SubtaskRef> subtRef;
    @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> orgInfos;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlElementRef(name = "levOfLearn", type = JAXBElement.class, required = false)
    protected JAXBElement<SubtaskTrainStepDefinition.LevOfLearn> levOfLearn;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected String uri;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the subtTrainId property.
     * 
     * @return
     *     possible object is
     *     {@link SubtaskTrainIdentifier }
     *     
     */
    public SubtaskTrainIdentifier getSubtTrainId() {
        return subtTrainId;
    }

    /**
     * Sets the value of the subtTrainId property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubtaskTrainIdentifier }
     *     
     */
    public void setSubtTrainId(SubtaskTrainIdentifier value) {
        this.subtTrainId = value;
    }

    /**
     * Gets the value of the trainDecision property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubtaskTrainDecision }{@code >}
     *     
     */
    public JAXBElement<SubtaskTrainDecision> getTrainDecision() {
        return trainDecision;
    }

    /**
     * Sets the value of the trainDecision property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubtaskTrainDecision }{@code >}
     *     
     */
    public void setTrainDecision(JAXBElement<SubtaskTrainDecision> value) {
        this.trainDecision = value;
    }

    /**
     * Gets the value of the trainRtnle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trainRtnle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrainRtnle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtaskTrainDecisionRationale }
     * 
     * 
     */
    public List<SubtaskTrainDecisionRationale> getTrainRtnle() {
        if (trainRtnle == null) {
            trainRtnle = new ArrayList<SubtaskTrainDecisionRationale>();
        }
        return this.trainRtnle;
    }

    /**
     * Gets the value of the trainDecisionChgDescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trainDecisionChgDescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrainDecisionChgDescr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtaskTrainDecisionChangeDescription }
     * 
     * 
     */
    public List<SubtaskTrainDecisionChangeDescription> getTrainDecisionChgDescr() {
        if (trainDecisionChgDescr == null) {
            trainDecisionChgDescr = new ArrayList<SubtaskTrainDecisionChangeDescription>();
        }
        return this.trainDecisionChgDescr;
    }

    /**
     * Gets the value of the perfObj property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the perfObj property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerfObj().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtaskPerformanceObjective }
     * 
     * 
     */
    public List<SubtaskPerformanceObjective> getPerfObj() {
        if (perfObj == null) {
            perfObj = new ArrayList<SubtaskPerformanceObjective>();
        }
        return this.perfObj;
    }

    /**
     * Gets the value of the subtaskTrainStepNonAbstractClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subtaskTrainStepNonAbstractClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubtaskTrainStepNonAbstractClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtaskTrainStepDefinition }
     * {@link SubtaskTrainStepReference }
     * 
     * 
     */
    public List<Object> getSubtaskTrainStepNonAbstractClasses() {
        if (subtaskTrainStepNonAbstractClasses == null) {
            subtaskTrainStepNonAbstractClasses = new ArrayList<Object>();
        }
        return this.subtaskTrainStepNonAbstractClasses;
    }

    /**
     * Gets the value of the subtRef property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubtaskRef }{@code >}
     *     
     */
    public JAXBElement<SubtaskRef> getSubtRef() {
        return subtRef;
    }

    /**
     * Sets the value of the subtRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubtaskRef }{@code >}
     *     
     */
    public void setSubtRef(JAXBElement<SubtaskRef> value) {
        this.subtRef = value;
    }

    /**
     * Gets the value of the orgInfos property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.DownTime.OrgInfos }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> getOrgInfos() {
        return orgInfos;
    }

    /**
     * Sets the value of the orgInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.DownTime.OrgInfos }{@code >}
     *     
     */
    public void setOrgInfos(JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> value) {
        this.orgInfos = value;
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
     * Gets the value of the levOfLearn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubtaskTrainStepDefinition.LevOfLearn }{@code >}
     *     
     */
    public JAXBElement<SubtaskTrainStepDefinition.LevOfLearn> getLevOfLearn() {
        return levOfLearn;
    }

    /**
     * Sets the value of the levOfLearn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubtaskTrainStepDefinition.LevOfLearn }{@code >}
     *     
     */
    public void setLevOfLearn(JAXBElement<SubtaskTrainStepDefinition.LevOfLearn> value) {
        this.levOfLearn = value;
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
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUri(String value) {
        this.uri = value;
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
