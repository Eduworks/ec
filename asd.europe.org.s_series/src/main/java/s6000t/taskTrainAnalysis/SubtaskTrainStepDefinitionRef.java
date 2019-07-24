
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subtaskTrainStepDefinitionRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subtaskTrainStepDefinitionRef">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="taskId" type="{http://www.asd-europe.org/s-series/s3000l}taskIdentifier"/>
 *         &lt;element name="taskRevId" type="{http://www.asd-europe.org/s-series/s3000l}taskRevisionIdentifier"/>
 *         &lt;element name="trainIterationId" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainDecisionIterationIdentifier"/>
 *         &lt;element name="subtTrainId" type="{http://www.asd-europe.org/s-series/s3000l}subtaskTrainIdentifier"/>
 *         &lt;element name="stepId" type="{http://www.asd-europe.org/s-series/s3000l}subtaskTrainStepIdentifier"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uidRef">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.asd-europe.org/s-series/s3000l}uidRef">
 *             &lt;pattern value="subtst[1-9][0-9]*"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subtaskTrainStepDefinitionRef", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "taskId",
    "taskRevId",
    "trainIterationId",
    "subtTrainId",
    "stepId"
})
public class SubtaskTrainStepDefinitionRef {

    protected TaskIdentifier taskId;
    protected TaskRevisionIdentifier taskRevId;
    protected TaskTrainDecisionIterationIdentifier trainIterationId;
    protected SubtaskTrainIdentifier subtTrainId;
    protected SubtaskTrainStepIdentifier stepId;
    @XmlAttribute(name = "uidRef")
    @XmlIDREF
    protected Object uidRef;

    /**
     * Gets the value of the taskId property.
     * 
     * @return
     *     possible object is
     *     {@link TaskIdentifier }
     *     
     */
    public TaskIdentifier getTaskId() {
        return taskId;
    }

    /**
     * Sets the value of the taskId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskIdentifier }
     *     
     */
    public void setTaskId(TaskIdentifier value) {
        this.taskId = value;
    }

    /**
     * Gets the value of the taskRevId property.
     * 
     * @return
     *     possible object is
     *     {@link TaskRevisionIdentifier }
     *     
     */
    public TaskRevisionIdentifier getTaskRevId() {
        return taskRevId;
    }

    /**
     * Sets the value of the taskRevId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskRevisionIdentifier }
     *     
     */
    public void setTaskRevId(TaskRevisionIdentifier value) {
        this.taskRevId = value;
    }

    /**
     * Gets the value of the trainIterationId property.
     * 
     * @return
     *     possible object is
     *     {@link TaskTrainDecisionIterationIdentifier }
     *     
     */
    public TaskTrainDecisionIterationIdentifier getTrainIterationId() {
        return trainIterationId;
    }

    /**
     * Sets the value of the trainIterationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskTrainDecisionIterationIdentifier }
     *     
     */
    public void setTrainIterationId(TaskTrainDecisionIterationIdentifier value) {
        this.trainIterationId = value;
    }

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
     * Gets the value of the stepId property.
     * 
     * @return
     *     possible object is
     *     {@link SubtaskTrainStepIdentifier }
     *     
     */
    public SubtaskTrainStepIdentifier getStepId() {
        return stepId;
    }

    /**
     * Sets the value of the stepId property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubtaskTrainStepIdentifier }
     *     
     */
    public void setStepId(SubtaskTrainStepIdentifier value) {
        this.stepId = value;
    }

    /**
     * Gets the value of the uidRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getUidRef() {
        return uidRef;
    }

    /**
     * Sets the value of the uidRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setUidRef(Object value) {
        this.uidRef = value;
    }

}
