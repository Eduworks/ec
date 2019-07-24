
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
 * <p>Java class for subtaskByDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subtaskByDefinition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subtId" type="{http://www.asd-europe.org/s-series/s3000l}subtaskIdentifier"/>
 *         &lt;element name="subtRole" type="{http://www.asd-europe.org/s-series/s3000l}subtaskRole" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.asd-europe.org/s-series/s3000l}subtaskName" minOccurs="0"/>
 *         &lt;element name="infoCode" type="{http://www.asd-europe.org/s-series/s3000l}informationCode" minOccurs="0"/>
 *         &lt;element name="subtDescr" type="{http://www.asd-europe.org/s-series/s3000l}subtaskDescription" minOccurs="0"/>
 *         &lt;element name="duration" type="{http://www.asd-europe.org/s-series/s3000l}subtaskDuration" minOccurs="0"/>
 *         &lt;element name="maintLoc" type="{http://www.asd-europe.org/s-series/s3000l}subtaskMaintenanceLocation" minOccurs="0"/>
 *         &lt;element name="eiObjState" type="{http://www.asd-europe.org/s-series/s3000l}subtaskEndItemObjectiveState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}subtaskAcceptanceParameter"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}subtaskCircuitBreakerSettingsNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wcn" type="{http://www.asd-europe.org/s-series/s3000l}subtaskWarningCautionNote" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="precSubt" type="{http://www.asd-europe.org/s-series/s3000l}subtaskTimeline" minOccurs="0"/>
 *         &lt;element name="inZone" type="{http://www.asd-europe.org/s-series/s3000l}subtaskInZone" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subtTgt" type="{http://www.asd-europe.org/s-series/s3000l}subtaskTarget" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}securityClassificationItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}taskResourceItem"/>
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
@XmlType(name = "subtaskByDefinition", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "subtId",
    "subtRole",
    "name",
    "infoCode",
    "subtDescr",
    "duration",
    "maintLoc",
    "eiObjState",
    "accParam",
    "subtaskCircuitBreakerSettingsNonAbstractClasses",
    "wcn",
    "precSubt",
    "inZone",
    "subtTgt",
    "secs",
    "docs",
    "rmks",
    "applic",
    "resources"
})
public class SubtaskByDefinition {

    @XmlElement(required = true)
    protected SubtaskIdentifier subtId;
    @XmlElementRef(name = "subtRole", type = JAXBElement.class, required = false)
    protected JAXBElement<SubtaskRole> subtRole;
    @XmlElementRef(name = "name", type = JAXBElement.class, required = false)
    protected JAXBElement<SubtaskName> name;
    @XmlElementRef(name = "infoCode", type = JAXBElement.class, required = false)
    protected JAXBElement<InformationCode> infoCode;
    @XmlElementRef(name = "subtDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<SubtaskDescription> subtDescr;
    @XmlElementRef(name = "duration", type = JAXBElement.class, required = false)
    protected JAXBElement<SubtaskDuration> duration;
    @XmlElementRef(name = "maintLoc", type = JAXBElement.class, required = false)
    protected JAXBElement<SubtaskMaintenanceLocation> maintLoc;
    @XmlElement(nillable = true)
    protected List<SubtaskEndItemObjectiveState> eiObjState;
    @XmlElement(nillable = true)
    protected List<s6000t.taskTrainAnalysis.SubtaskByExternalReference.AccParam> accParam;
    @XmlElements({
        @XmlElement(name = "ordCbSet", type = OrderedSubtaskCircuitBreakerSettings.class, nillable = true),
        @XmlElement(name = "rndmCbSet", type = RandomSubtaskCircuitBreakerSettings.class, nillable = true)
    })
    protected List<Object> subtaskCircuitBreakerSettingsNonAbstractClasses;
    @XmlElement(nillable = true)
    protected List<SubtaskWarningCautionNote> wcn;
    @XmlElementRef(name = "precSubt", type = JAXBElement.class, required = false)
    protected JAXBElement<SubtaskTimeline> precSubt;
    @XmlElement(nillable = true)
    protected List<SubtaskInZone> inZone;
    @XmlElement(nillable = true)
    protected List<SubtaskTarget> subtTgt;
    @XmlElementRef(name = "secs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.OperationalTask.Secs> secs;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;
    @XmlElementRef(name = "resources", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.TaskRevision.Resources> resources;
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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubtaskName }{@code >}
     *     
     */
    public JAXBElement<SubtaskName> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubtaskName }{@code >}
     *     
     */
    public void setName(JAXBElement<SubtaskName> value) {
        this.name = value;
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
     * Gets the value of the subtDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubtaskDescription }{@code >}
     *     
     */
    public JAXBElement<SubtaskDescription> getSubtDescr() {
        return subtDescr;
    }

    /**
     * Sets the value of the subtDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubtaskDescription }{@code >}
     *     
     */
    public void setSubtDescr(JAXBElement<SubtaskDescription> value) {
        this.subtDescr = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubtaskDuration }{@code >}
     *     
     */
    public JAXBElement<SubtaskDuration> getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubtaskDuration }{@code >}
     *     
     */
    public void setDuration(JAXBElement<SubtaskDuration> value) {
        this.duration = value;
    }

    /**
     * Gets the value of the maintLoc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubtaskMaintenanceLocation }{@code >}
     *     
     */
    public JAXBElement<SubtaskMaintenanceLocation> getMaintLoc() {
        return maintLoc;
    }

    /**
     * Sets the value of the maintLoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubtaskMaintenanceLocation }{@code >}
     *     
     */
    public void setMaintLoc(JAXBElement<SubtaskMaintenanceLocation> value) {
        this.maintLoc = value;
    }

    /**
     * Gets the value of the eiObjState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eiObjState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEiObjState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtaskEndItemObjectiveState }
     * 
     * 
     */
    public List<SubtaskEndItemObjectiveState> getEiObjState() {
        if (eiObjState == null) {
            eiObjState = new ArrayList<SubtaskEndItemObjectiveState>();
        }
        return this.eiObjState;
    }

    /**
     * Gets the value of the accParam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accParam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccParam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.SubtaskByExternalReference.AccParam }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.SubtaskByExternalReference.AccParam> getAccParam() {
        if (accParam == null) {
            accParam = new ArrayList<s6000t.taskTrainAnalysis.SubtaskByExternalReference.AccParam>();
        }
        return this.accParam;
    }

    /**
     * Gets the value of the subtaskCircuitBreakerSettingsNonAbstractClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subtaskCircuitBreakerSettingsNonAbstractClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubtaskCircuitBreakerSettingsNonAbstractClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderedSubtaskCircuitBreakerSettings }
     * {@link RandomSubtaskCircuitBreakerSettings }
     * 
     * 
     */
    public List<Object> getSubtaskCircuitBreakerSettingsNonAbstractClasses() {
        if (subtaskCircuitBreakerSettingsNonAbstractClasses == null) {
            subtaskCircuitBreakerSettingsNonAbstractClasses = new ArrayList<Object>();
        }
        return this.subtaskCircuitBreakerSettingsNonAbstractClasses;
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
     * Gets the value of the inZone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inZone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInZone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtaskInZone }
     * 
     * 
     */
    public List<SubtaskInZone> getInZone() {
        if (inZone == null) {
            inZone = new ArrayList<SubtaskInZone>();
        }
        return this.inZone;
    }

    /**
     * Gets the value of the subtTgt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subtTgt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubtTgt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtaskTarget }
     * 
     * 
     */
    public List<SubtaskTarget> getSubtTgt() {
        if (subtTgt == null) {
            subtTgt = new ArrayList<SubtaskTarget>();
        }
        return this.subtTgt;
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
     * Gets the value of the resources property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.TaskRevision.Resources }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.TaskRevision.Resources> getResources() {
        return resources;
    }

    /**
     * Sets the value of the resources property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.TaskRevision.Resources }{@code >}
     *     
     */
    public void setResources(JAXBElement<s6000t.taskTrainAnalysis.TaskRevision.Resources> value) {
        this.resources = value;
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
