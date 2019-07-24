
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
 * <p>Java class for taskTrainDecisionByEvaluation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskTrainDecisionByEvaluation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iterationId" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainDecisionIterationIdentifier"/>
 *         &lt;element name="dcsnRtnle" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainDecisionRationale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="iterRtnle" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainDecisionIterationRationale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="iterDate" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainDecisionIterationDate" minOccurs="0"/>
 *         &lt;element name="audience" type="{http://www.asd-europe.org/s-series/s3000l}taskTargetAudience" minOccurs="0"/>
 *         &lt;element name="coordCat" type="{http://www.asd-europe.org/s-series/s3000l}taskHumanInteractionRequirement" minOccurs="0"/>
 *         &lt;element name="taskDiff" type="{http://www.asd-europe.org/s-series/s3000l}taskDifficultyCategory" minOccurs="0"/>
 *         &lt;element name="taskImp" type="{http://www.asd-europe.org/s-series/s3000l}taskImportanceCategory" minOccurs="0"/>
 *         &lt;element name="taskFreq" type="{http://www.asd-europe.org/s-series/s3000l}taskFrequencyCategory" minOccurs="0"/>
 *         &lt;element name="trainLev" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainLevel" minOccurs="0"/>
 *         &lt;element name="trainLevRtnle" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainLevelRationale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trainDiff" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainingDifficulty" minOccurs="0"/>
 *         &lt;element name="trainTask" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainingDecision" minOccurs="0"/>
 *         &lt;element name="trainRtnle" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainingDecisionRationale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="perfObj" type="{http://www.asd-europe.org/s-series/s3000l}taskPerformanceObjective" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="algTrainLev" type="{http://www.asd-europe.org/s-series/s3000l}algorithmDerivedTaskTrainLevel" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}subtaskTrainDecisionNonAbstractClasses" maxOccurs="unbounded"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}levelOfLearningItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="ttd[1-9][0-9]*"/>
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
@XmlType(name = "taskTrainDecisionByEvaluation", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "iterationId",
    "dcsnRtnle",
    "iterRtnle",
    "iterDate",
    "audience",
    "coordCat",
    "taskDiff",
    "taskImp",
    "taskFreq",
    "trainLev",
    "trainLevRtnle",
    "trainDiff",
    "trainTask",
    "trainRtnle",
    "perfObj",
    "algTrainLev",
    "subtaskTrainDecisionNonAbstractClasses",
    "orgInfos",
    "docs",
    "rmks",
    "levOfLearn"
})
public class TaskTrainDecisionByEvaluation {

    @XmlElement(required = true)
    protected TaskTrainDecisionIterationIdentifier iterationId;
    @XmlElement(nillable = true)
    protected List<TaskTrainDecisionRationale> dcsnRtnle;
    @XmlElement(nillable = true)
    protected List<TaskTrainDecisionIterationRationale> iterRtnle;
    @XmlElementRef(name = "iterDate", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskTrainDecisionIterationDate> iterDate;
    @XmlElementRef(name = "audience", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskTargetAudience> audience;
    @XmlElementRef(name = "coordCat", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskHumanInteractionRequirement> coordCat;
    @XmlElementRef(name = "taskDiff", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskDifficultyCategory> taskDiff;
    @XmlElementRef(name = "taskImp", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskImportanceCategory> taskImp;
    @XmlElementRef(name = "taskFreq", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskFrequencyCategory> taskFreq;
    @XmlElementRef(name = "trainLev", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskTrainLevel> trainLev;
    @XmlElement(nillable = true)
    protected List<TaskTrainLevelRationale> trainLevRtnle;
    @XmlElementRef(name = "trainDiff", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskTrainingDifficulty> trainDiff;
    @XmlElementRef(name = "trainTask", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskTrainingDecision> trainTask;
    @XmlElement(nillable = true)
    protected List<TaskTrainingDecisionRationale> trainRtnle;
    @XmlElement(nillable = true)
    protected List<TaskPerformanceObjective> perfObj;
    @XmlElementRef(name = "algTrainLev", type = JAXBElement.class, required = false)
    protected JAXBElement<AlgorithmDerivedTaskTrainLevel> algTrainLev;
    @XmlElements({
        @XmlElement(name = "subtTrainDec", type = SubtaskTrainDecisionDefinition.class, nillable = true),
        @XmlElement(name = "subtTrainRef", type = SubtaskTrainDecisionReference.class, nillable = true)
    })
    protected List<Object> subtaskTrainDecisionNonAbstractClasses;
    @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> orgInfos;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlElementRef(name = "levOfLearn", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.SubtaskTrainStepDefinition.LevOfLearn> levOfLearn;
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
     * Gets the value of the iterationId property.
     * 
     * @return
     *     possible object is
     *     {@link TaskTrainDecisionIterationIdentifier }
     *     
     */
    public TaskTrainDecisionIterationIdentifier getIterationId() {
        return iterationId;
    }

    /**
     * Sets the value of the iterationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskTrainDecisionIterationIdentifier }
     *     
     */
    public void setIterationId(TaskTrainDecisionIterationIdentifier value) {
        this.iterationId = value;
    }

    /**
     * Gets the value of the dcsnRtnle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dcsnRtnle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDcsnRtnle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskTrainDecisionRationale }
     * 
     * 
     */
    public List<TaskTrainDecisionRationale> getDcsnRtnle() {
        if (dcsnRtnle == null) {
            dcsnRtnle = new ArrayList<TaskTrainDecisionRationale>();
        }
        return this.dcsnRtnle;
    }

    /**
     * Gets the value of the iterRtnle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iterRtnle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIterRtnle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskTrainDecisionIterationRationale }
     * 
     * 
     */
    public List<TaskTrainDecisionIterationRationale> getIterRtnle() {
        if (iterRtnle == null) {
            iterRtnle = new ArrayList<TaskTrainDecisionIterationRationale>();
        }
        return this.iterRtnle;
    }

    /**
     * Gets the value of the iterDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskTrainDecisionIterationDate }{@code >}
     *     
     */
    public JAXBElement<TaskTrainDecisionIterationDate> getIterDate() {
        return iterDate;
    }

    /**
     * Sets the value of the iterDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskTrainDecisionIterationDate }{@code >}
     *     
     */
    public void setIterDate(JAXBElement<TaskTrainDecisionIterationDate> value) {
        this.iterDate = value;
    }

    /**
     * Gets the value of the audience property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskTargetAudience }{@code >}
     *     
     */
    public JAXBElement<TaskTargetAudience> getAudience() {
        return audience;
    }

    /**
     * Sets the value of the audience property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskTargetAudience }{@code >}
     *     
     */
    public void setAudience(JAXBElement<TaskTargetAudience> value) {
        this.audience = value;
    }

    /**
     * Gets the value of the coordCat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskHumanInteractionRequirement }{@code >}
     *     
     */
    public JAXBElement<TaskHumanInteractionRequirement> getCoordCat() {
        return coordCat;
    }

    /**
     * Sets the value of the coordCat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskHumanInteractionRequirement }{@code >}
     *     
     */
    public void setCoordCat(JAXBElement<TaskHumanInteractionRequirement> value) {
        this.coordCat = value;
    }

    /**
     * Gets the value of the taskDiff property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskDifficultyCategory }{@code >}
     *     
     */
    public JAXBElement<TaskDifficultyCategory> getTaskDiff() {
        return taskDiff;
    }

    /**
     * Sets the value of the taskDiff property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskDifficultyCategory }{@code >}
     *     
     */
    public void setTaskDiff(JAXBElement<TaskDifficultyCategory> value) {
        this.taskDiff = value;
    }

    /**
     * Gets the value of the taskImp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskImportanceCategory }{@code >}
     *     
     */
    public JAXBElement<TaskImportanceCategory> getTaskImp() {
        return taskImp;
    }

    /**
     * Sets the value of the taskImp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskImportanceCategory }{@code >}
     *     
     */
    public void setTaskImp(JAXBElement<TaskImportanceCategory> value) {
        this.taskImp = value;
    }

    /**
     * Gets the value of the taskFreq property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskFrequencyCategory }{@code >}
     *     
     */
    public JAXBElement<TaskFrequencyCategory> getTaskFreq() {
        return taskFreq;
    }

    /**
     * Sets the value of the taskFreq property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskFrequencyCategory }{@code >}
     *     
     */
    public void setTaskFreq(JAXBElement<TaskFrequencyCategory> value) {
        this.taskFreq = value;
    }

    /**
     * Gets the value of the trainLev property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskTrainLevel }{@code >}
     *     
     */
    public JAXBElement<TaskTrainLevel> getTrainLev() {
        return trainLev;
    }

    /**
     * Sets the value of the trainLev property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskTrainLevel }{@code >}
     *     
     */
    public void setTrainLev(JAXBElement<TaskTrainLevel> value) {
        this.trainLev = value;
    }

    /**
     * Gets the value of the trainLevRtnle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trainLevRtnle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrainLevRtnle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskTrainLevelRationale }
     * 
     * 
     */
    public List<TaskTrainLevelRationale> getTrainLevRtnle() {
        if (trainLevRtnle == null) {
            trainLevRtnle = new ArrayList<TaskTrainLevelRationale>();
        }
        return this.trainLevRtnle;
    }

    /**
     * Gets the value of the trainDiff property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskTrainingDifficulty }{@code >}
     *     
     */
    public JAXBElement<TaskTrainingDifficulty> getTrainDiff() {
        return trainDiff;
    }

    /**
     * Sets the value of the trainDiff property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskTrainingDifficulty }{@code >}
     *     
     */
    public void setTrainDiff(JAXBElement<TaskTrainingDifficulty> value) {
        this.trainDiff = value;
    }

    /**
     * Gets the value of the trainTask property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskTrainingDecision }{@code >}
     *     
     */
    public JAXBElement<TaskTrainingDecision> getTrainTask() {
        return trainTask;
    }

    /**
     * Sets the value of the trainTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskTrainingDecision }{@code >}
     *     
     */
    public void setTrainTask(JAXBElement<TaskTrainingDecision> value) {
        this.trainTask = value;
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
     * {@link TaskTrainingDecisionRationale }
     * 
     * 
     */
    public List<TaskTrainingDecisionRationale> getTrainRtnle() {
        if (trainRtnle == null) {
            trainRtnle = new ArrayList<TaskTrainingDecisionRationale>();
        }
        return this.trainRtnle;
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
     * {@link TaskPerformanceObjective }
     * 
     * 
     */
    public List<TaskPerformanceObjective> getPerfObj() {
        if (perfObj == null) {
            perfObj = new ArrayList<TaskPerformanceObjective>();
        }
        return this.perfObj;
    }

    /**
     * Gets the value of the algTrainLev property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AlgorithmDerivedTaskTrainLevel }{@code >}
     *     
     */
    public JAXBElement<AlgorithmDerivedTaskTrainLevel> getAlgTrainLev() {
        return algTrainLev;
    }

    /**
     * Sets the value of the algTrainLev property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AlgorithmDerivedTaskTrainLevel }{@code >}
     *     
     */
    public void setAlgTrainLev(JAXBElement<AlgorithmDerivedTaskTrainLevel> value) {
        this.algTrainLev = value;
    }

    /**
     * Gets the value of the subtaskTrainDecisionNonAbstractClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subtaskTrainDecisionNonAbstractClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubtaskTrainDecisionNonAbstractClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtaskTrainDecisionDefinition }
     * {@link SubtaskTrainDecisionReference }
     * 
     * 
     */
    public List<Object> getSubtaskTrainDecisionNonAbstractClasses() {
        if (subtaskTrainDecisionNonAbstractClasses == null) {
            subtaskTrainDecisionNonAbstractClasses = new ArrayList<Object>();
        }
        return this.subtaskTrainDecisionNonAbstractClasses;
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
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.SubtaskTrainStepDefinition.LevOfLearn }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.SubtaskTrainStepDefinition.LevOfLearn> getLevOfLearn() {
        return levOfLearn;
    }

    /**
     * Sets the value of the levOfLearn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.SubtaskTrainStepDefinition.LevOfLearn }{@code >}
     *     
     */
    public void setLevOfLearn(JAXBElement<s6000t.taskTrainAnalysis.SubtaskTrainStepDefinition.LevOfLearn> value) {
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
