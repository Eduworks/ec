
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
 * <p>Java class for taskRevision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskRevision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="taskRevId" type="{http://www.asd-europe.org/s-series/s3000l}taskRevisionIdentifier"/>
 *         &lt;element name="name" type="{http://www.asd-europe.org/s-series/s3000l}taskName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.asd-europe.org/s-series/s3000l}taskRevisionStatus" minOccurs="0"/>
 *         &lt;element name="revChangeDescr" type="{http://www.asd-europe.org/s-series/s3000l}taskRevisionChangeDescription" minOccurs="0"/>
 *         &lt;element name="infoCode" type="{http://www.asd-europe.org/s-series/s3000l}informationCode" minOccurs="0"/>
 *         &lt;element name="persSafety" type="{http://www.asd-europe.org/s-series/s3000l}taskPersonnelSafetyCriticality" minOccurs="0"/>
 *         &lt;element name="prodIntegr" type="{http://www.asd-europe.org/s-series/s3000l}taskProductIntegrityCriticality" minOccurs="0"/>
 *         &lt;element name="opImpact" type="{http://www.asd-europe.org/s-series/s3000l}taskOperabilityImpact" minOccurs="0"/>
 *         &lt;element name="duration" type="{http://www.asd-europe.org/s-series/s3000l}taskDuration" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="laborTime" type="{http://www.asd-europe.org/s-series/s3000l}taskTotalLaborTime" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}subtaskNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}taskTrainDecisionNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wcn" type="{http://www.asd-europe.org/s-series/s3000l}taskRevisionWarningCautionNote" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="taskJust" type="{http://www.asd-europe.org/s-series/s3000l}taskJustification" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dm" type="{http://www.asd-europe.org/s-series/s3000l}dataModuleScope" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}taskResourceItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="taskrev[1-9][0-9]*"/>
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
@XmlType(name = "taskRevision", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "taskRevId",
    "name",
    "status",
    "revChangeDescr",
    "infoCode",
    "persSafety",
    "prodIntegr",
    "opImpact",
    "duration",
    "laborTime",
    "subtaskNonAbstractClasses",
    "taskTrainDecisionNonAbstractClasses",
    "wcn",
    "taskJust",
    "dm",
    "resources",
    "docs",
    "rmks"
})
public class TaskRevision {

    @XmlElement(required = true)
    protected TaskRevisionIdentifier taskRevId;
    @XmlElement(nillable = true)
    protected List<TaskName> name;
    @XmlElementRef(name = "status", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskRevisionStatus> status;
    @XmlElementRef(name = "revChangeDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskRevisionChangeDescription> revChangeDescr;
    @XmlElementRef(name = "infoCode", type = JAXBElement.class, required = false)
    protected JAXBElement<InformationCode> infoCode;
    @XmlElementRef(name = "persSafety", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskPersonnelSafetyCriticality> persSafety;
    @XmlElementRef(name = "prodIntegr", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskProductIntegrityCriticality> prodIntegr;
    @XmlElementRef(name = "opImpact", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskOperabilityImpact> opImpact;
    @XmlElement(nillable = true)
    protected List<TaskDuration> duration;
    @XmlElement(nillable = true)
    protected List<TaskTotalLaborTime> laborTime;
    @XmlElements({
        @XmlElement(name = "subtByDef", type = SubtaskByDefinition.class, nillable = true),
        @XmlElement(name = "subtByExtRef", type = SubtaskByExternalReference.class, nillable = true),
        @XmlElement(name = "subtByRef", type = SubtaskByTaskReference.class, nillable = true)
    })
    protected List<Object> subtaskNonAbstractClasses;
    @XmlElements({
        @XmlElement(name = "trainDecByGroup", type = TaskTrainDecisionByTaskGrouping.class, nillable = true),
        @XmlElement(name = "trainDecByPrev", type = TaskTrainDecisionByPreviousTaskRevision.class, nillable = true),
        @XmlElement(name = "trainDecByDef", type = TaskTrainDecisionByEvaluation.class, nillable = true)
    })
    protected List<Object> taskTrainDecisionNonAbstractClasses;
    @XmlElement(nillable = true)
    protected List<TaskRevisionWarningCautionNote> wcn;
    @XmlElement(nillable = true)
    protected List<TaskJustification> taskJust;
    @XmlElement(nillable = true)
    protected List<DataModuleScope> dm;
    @XmlElementRef(name = "resources", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskRevision.Resources> resources;
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
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskName }
     * 
     * 
     */
    public List<TaskName> getName() {
        if (name == null) {
            name = new ArrayList<TaskName>();
        }
        return this.name;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskRevisionStatus }{@code >}
     *     
     */
    public JAXBElement<TaskRevisionStatus> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskRevisionStatus }{@code >}
     *     
     */
    public void setStatus(JAXBElement<TaskRevisionStatus> value) {
        this.status = value;
    }

    /**
     * Gets the value of the revChangeDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskRevisionChangeDescription }{@code >}
     *     
     */
    public JAXBElement<TaskRevisionChangeDescription> getRevChangeDescr() {
        return revChangeDescr;
    }

    /**
     * Sets the value of the revChangeDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskRevisionChangeDescription }{@code >}
     *     
     */
    public void setRevChangeDescr(JAXBElement<TaskRevisionChangeDescription> value) {
        this.revChangeDescr = value;
    }

    /**
     * Gets the value of the infoCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link InformationCode }{@code >}
     *     
     */
    public JAXBElement<InformationCode> getInfoCode() {
        return infoCode;
    }

    /**
     * Sets the value of the infoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link InformationCode }{@code >}
     *     
     */
    public void setInfoCode(JAXBElement<InformationCode> value) {
        this.infoCode = value;
    }

    /**
     * Gets the value of the persSafety property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskPersonnelSafetyCriticality }{@code >}
     *     
     */
    public JAXBElement<TaskPersonnelSafetyCriticality> getPersSafety() {
        return persSafety;
    }

    /**
     * Sets the value of the persSafety property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskPersonnelSafetyCriticality }{@code >}
     *     
     */
    public void setPersSafety(JAXBElement<TaskPersonnelSafetyCriticality> value) {
        this.persSafety = value;
    }

    /**
     * Gets the value of the prodIntegr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskProductIntegrityCriticality }{@code >}
     *     
     */
    public JAXBElement<TaskProductIntegrityCriticality> getProdIntegr() {
        return prodIntegr;
    }

    /**
     * Sets the value of the prodIntegr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskProductIntegrityCriticality }{@code >}
     *     
     */
    public void setProdIntegr(JAXBElement<TaskProductIntegrityCriticality> value) {
        this.prodIntegr = value;
    }

    /**
     * Gets the value of the opImpact property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskOperabilityImpact }{@code >}
     *     
     */
    public JAXBElement<TaskOperabilityImpact> getOpImpact() {
        return opImpact;
    }

    /**
     * Sets the value of the opImpact property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskOperabilityImpact }{@code >}
     *     
     */
    public void setOpImpact(JAXBElement<TaskOperabilityImpact> value) {
        this.opImpact = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the duration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDuration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskDuration }
     * 
     * 
     */
    public List<TaskDuration> getDuration() {
        if (duration == null) {
            duration = new ArrayList<TaskDuration>();
        }
        return this.duration;
    }

    /**
     * Gets the value of the laborTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the laborTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLaborTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskTotalLaborTime }
     * 
     * 
     */
    public List<TaskTotalLaborTime> getLaborTime() {
        if (laborTime == null) {
            laborTime = new ArrayList<TaskTotalLaborTime>();
        }
        return this.laborTime;
    }

    /**
     * Gets the value of the subtaskNonAbstractClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subtaskNonAbstractClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubtaskNonAbstractClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtaskByDefinition }
     * {@link SubtaskByExternalReference }
     * {@link SubtaskByTaskReference }
     * 
     * 
     */
    public List<Object> getSubtaskNonAbstractClasses() {
        if (subtaskNonAbstractClasses == null) {
            subtaskNonAbstractClasses = new ArrayList<Object>();
        }
        return this.subtaskNonAbstractClasses;
    }

    /**
     * Gets the value of the taskTrainDecisionNonAbstractClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskTrainDecisionNonAbstractClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskTrainDecisionNonAbstractClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskTrainDecisionByTaskGrouping }
     * {@link TaskTrainDecisionByPreviousTaskRevision }
     * {@link TaskTrainDecisionByEvaluation }
     * 
     * 
     */
    public List<Object> getTaskTrainDecisionNonAbstractClasses() {
        if (taskTrainDecisionNonAbstractClasses == null) {
            taskTrainDecisionNonAbstractClasses = new ArrayList<Object>();
        }
        return this.taskTrainDecisionNonAbstractClasses;
    }

    /**
     * Gets the value of the wcn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wcn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWcn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskRevisionWarningCautionNote }
     * 
     * 
     */
    public List<TaskRevisionWarningCautionNote> getWcn() {
        if (wcn == null) {
            wcn = new ArrayList<TaskRevisionWarningCautionNote>();
        }
        return this.wcn;
    }

    /**
     * Gets the value of the taskJust property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskJust property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskJust().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskJustification }
     * 
     * 
     */
    public List<TaskJustification> getTaskJust() {
        if (taskJust == null) {
            taskJust = new ArrayList<TaskJustification>();
        }
        return this.taskJust;
    }

    /**
     * Gets the value of the dm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataModuleScope }
     * 
     * 
     */
    public List<DataModuleScope> getDm() {
        if (dm == null) {
            dm = new ArrayList<DataModuleScope>();
        }
        return this.dm;
    }

    /**
     * Gets the value of the resources property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaskRevision.Resources }{@code >}
     *     
     */
    public JAXBElement<TaskRevision.Resources> getResources() {
        return resources;
    }

    /**
     * Sets the value of the resources property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaskRevision.Resources }{@code >}
     *     
     */
    public void setResources(JAXBElement<TaskRevision.Resources> value) {
        this.resources = value;
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
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}taskResourceNonAbstractClasses" maxOccurs="unbounded"/>
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
        "taskResourceNonAbstractClasses"
    })
    public static class Resources {

        @XmlElements({
            @XmlElement(name = "doc", type = TaskDocumentResource.class, nillable = true),
            @XmlElement(name = "pers", type = TaskPersonnelResource.class, nillable = true),
            @XmlElement(name = "facSpec", type = TaskFacilityResourceBySpecification.class, nillable = true),
            @XmlElement(name = "facPart", type = TaskFacilityResourceByReference.class, nillable = true),
            @XmlElement(name = "mtrlSpec", type = TaskMaterialResourceBySpecification.class, nillable = true),
            @XmlElement(name = "part", type = TaskMaterialResourceByReference.class, nillable = true)
        })
        protected List<Object> taskResourceNonAbstractClasses;

        /**
         * Gets the value of the taskResourceNonAbstractClasses property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the taskResourceNonAbstractClasses property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTaskResourceNonAbstractClasses().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TaskDocumentResource }
         * {@link TaskPersonnelResource }
         * {@link TaskFacilityResourceBySpecification }
         * {@link TaskFacilityResourceByReference }
         * {@link TaskMaterialResourceBySpecification }
         * {@link TaskMaterialResourceByReference }
         * 
         * 
         */
        public List<Object> getTaskResourceNonAbstractClasses() {
            if (taskResourceNonAbstractClasses == null) {
                taskResourceNonAbstractClasses = new ArrayList<Object>();
            }
            return this.taskResourceNonAbstractClasses;
        }

    }

}
