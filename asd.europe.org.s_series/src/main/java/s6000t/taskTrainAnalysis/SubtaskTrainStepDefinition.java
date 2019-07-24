
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
 * <p>Java class for subtaskTrainStepDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subtaskTrainStepDefinition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stepId" type="{http://www.asd-europe.org/s-series/s3000l}subtaskTrainStepIdentifier"/>
 *         &lt;element name="stepDescr" type="{http://www.asd-europe.org/s-series/s3000l}subtaskTrainStepDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="stepPerfStd" type="{http://www.asd-europe.org/s-series/s3000l}subtaskStepPerformanceStandard" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}levelOfLearningItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="subtst[1-9][0-9]*"/>
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
@XmlType(name = "subtaskTrainStepDefinition", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "stepId",
    "stepDescr",
    "stepPerfStd",
    "orgInfos",
    "docs",
    "rmks",
    "levOfLearn"
})
public class SubtaskTrainStepDefinition {

    @XmlElement(required = true)
    protected SubtaskTrainStepIdentifier stepId;
    @XmlElement(nillable = true)
    protected List<SubtaskTrainStepDescription> stepDescr;
    @XmlElement(nillable = true)
    protected List<SubtaskStepPerformanceStandard> stepPerfStd;
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
     * Gets the value of the stepDescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stepDescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStepDescr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtaskTrainStepDescription }
     * 
     * 
     */
    public List<SubtaskTrainStepDescription> getStepDescr() {
        if (stepDescr == null) {
            stepDescr = new ArrayList<SubtaskTrainStepDescription>();
        }
        return this.stepDescr;
    }

    /**
     * Gets the value of the stepPerfStd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stepPerfStd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStepPerfStd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtaskStepPerformanceStandard }
     * 
     * 
     */
    public List<SubtaskStepPerformanceStandard> getStepPerfStd() {
        if (stepPerfStd == null) {
            stepPerfStd = new ArrayList<SubtaskStepPerformanceStandard>();
        }
        return this.stepPerfStd;
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
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}levelOfLearningIterationNonAbstractClasses" maxOccurs="unbounded"/>
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
        "levelOfLearningIterationNonAbstractClasses"
    })
    public static class LevOfLearn {

        @XmlElements({
            @XmlElement(name = "affecLoL", type = AffectiveLevelOfLearningIteration.class, nillable = true),
            @XmlElement(name = "cognLoL", type = CognitiveLevelOfLearningIteration.class, nillable = true),
            @XmlElement(name = "psychLoL", type = PsychomotorLevelOfLearningIteration.class, nillable = true)
        })
        protected List<Object> levelOfLearningIterationNonAbstractClasses;

        /**
         * Gets the value of the levelOfLearningIterationNonAbstractClasses property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the levelOfLearningIterationNonAbstractClasses property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLevelOfLearningIterationNonAbstractClasses().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AffectiveLevelOfLearningIteration }
         * {@link CognitiveLevelOfLearningIteration }
         * {@link PsychomotorLevelOfLearningIteration }
         * 
         * 
         */
        public List<Object> getLevelOfLearningIterationNonAbstractClasses() {
            if (levelOfLearningIterationNonAbstractClasses == null) {
                levelOfLearningIterationNonAbstractClasses = new ArrayList<Object>();
            }
            return this.levelOfLearningIterationNonAbstractClasses;
        }

    }

}
