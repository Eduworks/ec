
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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for taskTrainDecisionByTaskGrouping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskTrainDecisionByTaskGrouping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iterationId" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainDecisionIterationIdentifier"/>
 *         &lt;element name="dcsnRtnle" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainDecisionRationale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="iterRtnle" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainDecisionIterationRationale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="iterDate" type="{http://www.asd-europe.org/s-series/s3000l}taskTrainDecisionIterationDate" minOccurs="0"/>
 *         &lt;element name="perfObj" type="{http://www.asd-europe.org/s-series/s3000l}taskPerformanceObjective" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="taskRef" type="{http://www.asd-europe.org/s-series/s3000l}taskRef"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
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
@XmlType(name = "taskTrainDecisionByTaskGrouping", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "iterationId",
    "dcsnRtnle",
    "iterRtnle",
    "iterDate",
    "perfObj",
    "taskRef",
    "orgInfos",
    "docs",
    "rmks"
})
public class TaskTrainDecisionByTaskGrouping {

    @XmlElement(required = true)
    protected TaskTrainDecisionIterationIdentifier iterationId;
    @XmlElement(nillable = true)
    protected List<TaskTrainDecisionRationale> dcsnRtnle;
    @XmlElement(nillable = true)
    protected List<TaskTrainDecisionIterationRationale> iterRtnle;
    @XmlElementRef(name = "iterDate", type = JAXBElement.class, required = false)
    protected JAXBElement<TaskTrainDecisionIterationDate> iterDate;
    @XmlElement(nillable = true)
    protected List<TaskPerformanceObjective> perfObj;
    @XmlElement(required = true, nillable = true)
    protected TaskRef taskRef;
    @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> orgInfos;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
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
