
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
 * <p>Java class for supportingTaskTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="supportingTaskTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}taskFrequency"/>
 *         &lt;element name="taskRef" type="{http://www.asd-europe.org/s-series/s3000l}taskRef"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="tasktg[1-9][0-9]*"/>
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
@XmlType(name = "supportingTaskTarget", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "taskFreq",
    "taskRef",
    "orgInfos",
    "docs",
    "rmks",
    "applic"
})
public class SupportingTaskTarget {

    @XmlElement(nillable = true)
    protected List<SupportingTaskTarget.TaskFreq> taskFreq;
    @XmlElement(required = true)
    protected TaskRef taskRef;
    @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> orgInfos;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the taskFreq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskFreq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskFreq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupportingTaskTarget.TaskFreq }
     * 
     * 
     */
    public List<SupportingTaskTarget.TaskFreq> getTaskFreq() {
        if (taskFreq == null) {
            taskFreq = new ArrayList<SupportingTaskTarget.TaskFreq>();
        }
        return this.taskFreq;
    }

    /**
     * Gets the value of the taskRef property.
     * 
     * @return
     *     possible object is
     *     {@link TaskRef }
     *     
     */
    public TaskRef getTaskRef() {
        return taskRef;
    }

    /**
     * Sets the value of the taskRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskRef }
     *     
     */
    public void setTaskRef(TaskRef value) {
        this.taskRef = value;
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
     * Gets the value of the applic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ProductName.Applic }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> getApplic() {
        return applic;
    }

    /**
     * Sets the value of the applic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ProductName.Applic }{@code >}
     *     
     */
    public void setApplic(JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> value) {
        this.applic = value;
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
     *         &lt;element name="frequency" type="{http://www.asd-europe.org/s-series/s3000l}taskFrequency" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="calcMthd" type="{http://www.asd-europe.org/s-series/s3000l}taskFrequencyCalculationMethod" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
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
        "frequency",
        "calcMthd",
        "docs",
        "rmks",
        "applic"
    })
    public static class TaskFreq {

        @XmlElement(nillable = true)
        protected List<TaskFrequency> frequency;
        @XmlElementRef(name = "calcMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<TaskFrequencyCalculationMethod> calcMthd;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the frequency property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the frequency property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFrequency().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TaskFrequency }
         * 
         * 
         */
        public List<TaskFrequency> getFrequency() {
            if (frequency == null) {
                frequency = new ArrayList<TaskFrequency>();
            }
            return this.frequency;
        }

        /**
         * Gets the value of the calcMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link TaskFrequencyCalculationMethod }{@code >}
         *     
         */
        public JAXBElement<TaskFrequencyCalculationMethod> getCalcMthd() {
            return calcMthd;
        }

        /**
         * Sets the value of the calcMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link TaskFrequencyCalculationMethod }{@code >}
         *     
         */
        public void setCalcMthd(JAXBElement<TaskFrequencyCalculationMethod> value) {
            this.calcMthd = value;
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
         * Gets the value of the applic property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ProductName.Applic }{@code >}
         *     
         */
        public JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> getApplic() {
            return applic;
        }

        /**
         * Sets the value of the applic property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ProductName.Applic }{@code >}
         *     
         */
        public void setApplic(JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> value) {
            this.applic = value;
        }

    }

}
