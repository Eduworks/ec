
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subtaskRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subtaskRef">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="taskId" type="{http://www.asd-europe.org/s-series/s3000l}taskIdentifier"/>
 *         &lt;element name="taskRevId" type="{http://www.asd-europe.org/s-series/s3000l}taskRevisionIdentifier"/>
 *         &lt;element name="subtId" type="{http://www.asd-europe.org/s-series/s3000l}subtaskIdentifier"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uidRef">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.asd-europe.org/s-series/s3000l}uidRef">
 *             &lt;pattern value="subt[1-9][0-9]*"/>
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
@XmlType(name = "subtaskRef", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "taskId",
    "taskRevId",
    "subtId"
})
public class SubtaskRef {

    protected TaskIdentifier taskId;
    protected TaskRevisionIdentifier taskRevId;
    protected SubtaskIdentifier subtId;
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
     * Gets the value of the subtId property.
     * 
     * @return
     *     possible object is
     *     {@link SubtaskIdentifier }
     *     
     */
    public SubtaskIdentifier getSubtId() {
        return subtId;
    }

    /**
     * Sets the value of the subtId property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubtaskIdentifier }
     *     
     */
    public void setSubtId(SubtaskIdentifier value) {
        this.subtId = value;
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
