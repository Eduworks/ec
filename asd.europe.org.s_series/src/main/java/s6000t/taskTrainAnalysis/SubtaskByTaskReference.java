
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
 * <p>Java class for subtaskByTaskReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subtaskByTaskReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subtId" type="{http://www.asd-europe.org/s-series/s3000l}subtaskIdentifier"/>
 *         &lt;element name="subtRole" type="{http://www.asd-europe.org/s-series/s3000l}subtaskRole" minOccurs="0"/>
 *         &lt;element name="wcn" type="{http://www.asd-europe.org/s-series/s3000l}subtaskWarningCautionNote" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="precSubt" type="{http://www.asd-europe.org/s-series/s3000l}subtaskTimeline" minOccurs="0"/>
 *         &lt;element name="taskRef" type="{http://www.asd-europe.org/s-series/s3000l}taskRef"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}securityClassificationItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="subt[1-9][0-9]*"/>
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
@XmlType(name = "subtaskByTaskReference", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "subtId",
    "subtRole",
    "wcn",
    "precSubt",
    "taskRef",
    "secs",
    "docs",
    "rmks",
    "applic"
})
public class SubtaskByTaskReference {

    @XmlElement(required = true)
    protected SubtaskIdentifier subtId;
    @XmlElementRef(name = "subtRole", type = JAXBElement.class, required = false)
    protected JAXBElement<SubtaskRole> subtRole;
    @XmlElement(nillable = true)
    protected List<SubtaskWarningCautionNote> wcn;
    @XmlElementRef(name = "precSubt", type = JAXBElement.class, required = false)
    protected JAXBElement<SubtaskTimeline> precSubt;
    @XmlElement(required = true)
    protected TaskRef taskRef;
    @XmlElementRef(name = "secs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.OperationalTask.Secs> secs;
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
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected String uri;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

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
     * Gets the value of the subtRole property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubtaskRole }{@code >}
     *     
     */
    public JAXBElement<SubtaskRole> getSubtRole() {
        return subtRole;
    }

    /**
     * Sets the value of the subtRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubtaskRole }{@code >}
     *     
     */
    public void setSubtRole(JAXBElement<SubtaskRole> value) {
        this.subtRole = value;
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
     * {@link SubtaskWarningCautionNote }
     * 
     * 
     */
    public List<SubtaskWarningCautionNote> getWcn() {
        if (wcn == null) {
            wcn = new ArrayList<SubtaskWarningCautionNote>();
        }
        return this.wcn;
    }

    /**
     * Gets the value of the precSubt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubtaskTimeline }{@code >}
     *     
     */
    public JAXBElement<SubtaskTimeline> getPrecSubt() {
        return precSubt;
    }

    /**
     * Sets the value of the precSubt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubtaskTimeline }{@code >}
     *     
     */
    public void setPrecSubt(JAXBElement<SubtaskTimeline> value) {
        this.precSubt = value;
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
     * Gets the value of the secs property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.OperationalTask.Secs }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.OperationalTask.Secs> getSecs() {
        return secs;
    }

    /**
     * Sets the value of the secs property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.OperationalTask.Secs }{@code >}
     *     
     */
    public void setSecs(JAXBElement<s6000t.taskTrainAnalysis.OperationalTask.Secs> value) {
        this.secs = value;
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
