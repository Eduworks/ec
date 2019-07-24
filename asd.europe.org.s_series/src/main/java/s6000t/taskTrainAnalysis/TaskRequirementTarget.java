
package s6000t.taskTrainAnalysis;

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
 * <p>Java class for taskRequirementTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskRequirementTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="taskReqRef" type="{http://www.asd-europe.org/s-series/s3000l}taskRequirementReference"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}timeLimitItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="trtgt[1-9][0-9]*"/>
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
@XmlType(name = "taskRequirementTarget", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "taskReqRef",
    "timeLimits"
})
public class TaskRequirementTarget {

    @XmlElement(required = true)
    protected TaskRequirementReference taskReqRef;
    @XmlElementRef(name = "timeLimits", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.PlannedTaskTarget.TimeLimits> timeLimits;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the taskReqRef property.
     * 
     * @return
     *     possible object is
     *     {@link TaskRequirementReference }
     *     
     */
    public TaskRequirementReference getTaskReqRef() {
        return taskReqRef;
    }

    /**
     * Sets the value of the taskReqRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskRequirementReference }
     *     
     */
    public void setTaskReqRef(TaskRequirementReference value) {
        this.taskReqRef = value;
    }

    /**
     * Gets the value of the timeLimits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.PlannedTaskTarget.TimeLimits }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.PlannedTaskTarget.TimeLimits> getTimeLimits() {
        return timeLimits;
    }

    /**
     * Sets the value of the timeLimits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.PlannedTaskTarget.TimeLimits }{@code >}
     *     
     */
    public void setTimeLimits(JAXBElement<s6000t.taskTrainAnalysis.PlannedTaskTarget.TimeLimits> value) {
        this.timeLimits = value;
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
