
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
 * <p>Java class for learningObjectiveRevision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="learningObjectiveRevision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loRevId" type="{http://www.asd-europe.org/s-series/s3000l}learningObjectiveRevisionIdentifier" maxOccurs="unbounded"/>
 *         &lt;element name="loRevRtnle" type="{http://www.asd-europe.org/s-series/s3000l}learningObjectiveRevisionRationale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="loDescr" type="{http://www.asd-europe.org/s-series/s3000l}learningObjectiveDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="loPerfStd" type="{http://www.asd-europe.org/s-series/s3000l}learningObjectivePerformanceStandard" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="loAssmnt" type="{http://www.asd-europe.org/s-series/s3000l}learningObjectiveAssessment" minOccurs="0"/>
 *         &lt;element name="relLO" type="{http://www.asd-europe.org/s-series/s3000l}learningObjectiveRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="lobj[1-9][0-9]*"/>
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
@XmlType(name = "learningObjectiveRevision", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "loRevId",
    "loRevRtnle",
    "loDescr",
    "loPerfStd",
    "loAssmnt",
    "relLO",
    "orgInfos",
    "docs",
    "rmks"
})
public class LearningObjectiveRevision {

    @XmlElement(required = true)
    protected List<LearningObjectiveRevisionIdentifier> loRevId;
    @XmlElement(nillable = true)
    protected List<LearningObjectiveRevisionRationale> loRevRtnle;
    @XmlElement(nillable = true)
    protected List<LearningObjectiveDescription> loDescr;
    @XmlElement(nillable = true)
    protected List<LearningObjectivePerformanceStandard> loPerfStd;
    protected LearningObjectiveAssessment loAssmnt;
    protected List<LearningObjectiveRelationship> relLO;
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
     * Gets the value of the loRevId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loRevId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoRevId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LearningObjectiveRevisionIdentifier }
     * 
     * 
     */
    public List<LearningObjectiveRevisionIdentifier> getLoRevId() {
        if (loRevId == null) {
            loRevId = new ArrayList<LearningObjectiveRevisionIdentifier>();
        }
        return this.loRevId;
    }

    /**
     * Gets the value of the loRevRtnle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loRevRtnle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoRevRtnle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LearningObjectiveRevisionRationale }
     * 
     * 
     */
    public List<LearningObjectiveRevisionRationale> getLoRevRtnle() {
        if (loRevRtnle == null) {
            loRevRtnle = new ArrayList<LearningObjectiveRevisionRationale>();
        }
        return this.loRevRtnle;
    }

    /**
     * Gets the value of the loDescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loDescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoDescr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LearningObjectiveDescription }
     * 
     * 
     */
    public List<LearningObjectiveDescription> getLoDescr() {
        if (loDescr == null) {
            loDescr = new ArrayList<LearningObjectiveDescription>();
        }
        return this.loDescr;
    }

    /**
     * Gets the value of the loPerfStd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loPerfStd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoPerfStd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LearningObjectivePerformanceStandard }
     * 
     * 
     */
    public List<LearningObjectivePerformanceStandard> getLoPerfStd() {
        if (loPerfStd == null) {
            loPerfStd = new ArrayList<LearningObjectivePerformanceStandard>();
        }
        return this.loPerfStd;
    }

    /**
     * Gets the value of the loAssmnt property.
     * 
     * @return
     *     possible object is
     *     {@link LearningObjectiveAssessment }
     *     
     */
    public LearningObjectiveAssessment getLoAssmnt() {
        return loAssmnt;
    }

    /**
     * Sets the value of the loAssmnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link LearningObjectiveAssessment }
     *     
     */
    public void setLoAssmnt(LearningObjectiveAssessment value) {
        this.loAssmnt = value;
    }

    /**
     * Gets the value of the relLO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relLO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelLO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LearningObjectiveRelationship }
     * 
     * 
     */
    public List<LearningObjectiveRelationship> getRelLO() {
        if (relLO == null) {
            relLO = new ArrayList<LearningObjectiveRelationship>();
        }
        return this.relLO;
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
