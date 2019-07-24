
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
 * <p>Java class for cognitiveLevelOfLearningIteration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cognitiveLevelOfLearningIteration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iterId" type="{http://www.asd-europe.org/s-series/s3000l}levelOfLearningIterationIdentifier"/>
 *         &lt;element name="knowlLev" type="{http://www.asd-europe.org/s-series/s3000l}levelOfLearningKnowledge" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lolRtnle" type="{http://www.asd-europe.org/s-series/s3000l}levelOfLearningRationale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="iterRtnle" type="{http://www.asd-europe.org/s-series/s3000l}levelOfLearningIterationRationale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="iterDate" type="{http://www.asd-europe.org/s-series/s3000l}levelOfLearningIterationDate" minOccurs="0"/>
 *         &lt;element name="lol" type="{http://www.asd-europe.org/s-series/s3000l}cognitiveLevelOfLearning" minOccurs="0"/>
 *         &lt;element name="learnObj" type="{http://www.asd-europe.org/s-series/s3000l}levelOfLearningLearningObjective" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="lolit[1-9][0-9]*"/>
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
@XmlType(name = "cognitiveLevelOfLearningIteration", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "iterId",
    "knowlLev",
    "lolRtnle",
    "iterRtnle",
    "iterDate",
    "lol",
    "learnObj",
    "orgInfos",
    "docs",
    "rmks"
})
public class CognitiveLevelOfLearningIteration {

    @XmlElement(required = true)
    protected LevelOfLearningIterationIdentifier iterId;
    @XmlElement(nillable = true)
    protected List<LevelOfLearningKnowledge> knowlLev;
    @XmlElement(nillable = true)
    protected List<LevelOfLearningRationale> lolRtnle;
    @XmlElement(nillable = true)
    protected List<LevelOfLearningIterationRationale> iterRtnle;
    @XmlElementRef(name = "iterDate", type = JAXBElement.class, required = false)
    protected JAXBElement<LevelOfLearningIterationDate> iterDate;
    @XmlElementRef(name = "lol", type = JAXBElement.class, required = false)
    protected JAXBElement<CognitiveLevelOfLearning> lol;
    protected List<LevelOfLearningLearningObjective> learnObj;
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
     * Gets the value of the iterId property.
     * 
     * @return
     *     possible object is
     *     {@link LevelOfLearningIterationIdentifier }
     *     
     */
    public LevelOfLearningIterationIdentifier getIterId() {
        return iterId;
    }

    /**
     * Sets the value of the iterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link LevelOfLearningIterationIdentifier }
     *     
     */
    public void setIterId(LevelOfLearningIterationIdentifier value) {
        this.iterId = value;
    }

    /**
     * Gets the value of the knowlLev property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the knowlLev property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKnowlLev().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LevelOfLearningKnowledge }
     * 
     * 
     */
    public List<LevelOfLearningKnowledge> getKnowlLev() {
        if (knowlLev == null) {
            knowlLev = new ArrayList<LevelOfLearningKnowledge>();
        }
        return this.knowlLev;
    }

    /**
     * Gets the value of the lolRtnle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lolRtnle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLolRtnle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LevelOfLearningRationale }
     * 
     * 
     */
    public List<LevelOfLearningRationale> getLolRtnle() {
        if (lolRtnle == null) {
            lolRtnle = new ArrayList<LevelOfLearningRationale>();
        }
        return this.lolRtnle;
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
     * {@link LevelOfLearningIterationRationale }
     * 
     * 
     */
    public List<LevelOfLearningIterationRationale> getIterRtnle() {
        if (iterRtnle == null) {
            iterRtnle = new ArrayList<LevelOfLearningIterationRationale>();
        }
        return this.iterRtnle;
    }

    /**
     * Gets the value of the iterDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LevelOfLearningIterationDate }{@code >}
     *     
     */
    public JAXBElement<LevelOfLearningIterationDate> getIterDate() {
        return iterDate;
    }

    /**
     * Sets the value of the iterDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LevelOfLearningIterationDate }{@code >}
     *     
     */
    public void setIterDate(JAXBElement<LevelOfLearningIterationDate> value) {
        this.iterDate = value;
    }

    /**
     * Gets the value of the lol property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CognitiveLevelOfLearning }{@code >}
     *     
     */
    public JAXBElement<CognitiveLevelOfLearning> getLol() {
        return lol;
    }

    /**
     * Sets the value of the lol property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CognitiveLevelOfLearning }{@code >}
     *     
     */
    public void setLol(JAXBElement<CognitiveLevelOfLearning> value) {
        this.lol = value;
    }

    /**
     * Gets the value of the learnObj property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the learnObj property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLearnObj().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LevelOfLearningLearningObjective }
     * 
     * 
     */
    public List<LevelOfLearningLearningObjective> getLearnObj() {
        if (learnObj == null) {
            learnObj = new ArrayList<LevelOfLearningLearningObjective>();
        }
        return this.learnObj;
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
