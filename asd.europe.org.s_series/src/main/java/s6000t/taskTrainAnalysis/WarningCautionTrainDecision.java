
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
 * <p>Java class for warningCautionTrainDecision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="warningCautionTrainDecision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iterationId" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionTrainDecisionIterationIdentifier"/>
 *         &lt;element name="trainLev" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionTrainLevel" minOccurs="0"/>
 *         &lt;element name="trainLevRtnle" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionTrainLevelRationale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="iterRtnle" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionTrainDecisionIterationRationale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="iterDate" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionTrainDecisionIterationDate" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}levelOfLearningItem"/>
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
@XmlType(name = "warningCautionTrainDecision", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "iterationId",
    "trainLev",
    "trainLevRtnle",
    "iterRtnle",
    "iterDate",
    "orgInfos",
    "docs",
    "rmks",
    "levOfLearn"
})
public class WarningCautionTrainDecision {

    @XmlElement(required = true)
    protected WarningCautionTrainDecisionIterationIdentifier iterationId;
    @XmlElementRef(name = "trainLev", type = JAXBElement.class, required = false)
    protected JAXBElement<WarningCautionTrainLevel> trainLev;
    @XmlElement(nillable = true)
    protected List<WarningCautionTrainLevelRationale> trainLevRtnle;
    @XmlElement(nillable = true)
    protected List<WarningCautionTrainDecisionIterationRationale> iterRtnle;
    @XmlElementRef(name = "iterDate", type = JAXBElement.class, required = false)
    protected JAXBElement<WarningCautionTrainDecisionIterationDate> iterDate;
    @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> orgInfos;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlElementRef(name = "levOfLearn", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.SubtaskTrainStepDefinition.LevOfLearn> levOfLearn;
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
     *     {@link WarningCautionTrainDecisionIterationIdentifier }
     *     
     */
    public WarningCautionTrainDecisionIterationIdentifier getIterationId() {
        return iterationId;
    }

    /**
     * Sets the value of the iterationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link WarningCautionTrainDecisionIterationIdentifier }
     *     
     */
    public void setIterationId(WarningCautionTrainDecisionIterationIdentifier value) {
        this.iterationId = value;
    }

    /**
     * Gets the value of the trainLev property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WarningCautionTrainLevel }{@code >}
     *     
     */
    public JAXBElement<WarningCautionTrainLevel> getTrainLev() {
        return trainLev;
    }

    /**
     * Sets the value of the trainLev property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WarningCautionTrainLevel }{@code >}
     *     
     */
    public void setTrainLev(JAXBElement<WarningCautionTrainLevel> value) {
        this.trainLev = value;
    }

    /**
     * Gets the value of the trainLevRtnle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trainLevRtnle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrainLevRtnle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WarningCautionTrainLevelRationale }
     * 
     * 
     */
    public List<WarningCautionTrainLevelRationale> getTrainLevRtnle() {
        if (trainLevRtnle == null) {
            trainLevRtnle = new ArrayList<WarningCautionTrainLevelRationale>();
        }
        return this.trainLevRtnle;
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
     * {@link WarningCautionTrainDecisionIterationRationale }
     * 
     * 
     */
    public List<WarningCautionTrainDecisionIterationRationale> getIterRtnle() {
        if (iterRtnle == null) {
            iterRtnle = new ArrayList<WarningCautionTrainDecisionIterationRationale>();
        }
        return this.iterRtnle;
    }

    /**
     * Gets the value of the iterDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WarningCautionTrainDecisionIterationDate }{@code >}
     *     
     */
    public JAXBElement<WarningCautionTrainDecisionIterationDate> getIterDate() {
        return iterDate;
    }

    /**
     * Sets the value of the iterDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WarningCautionTrainDecisionIterationDate }{@code >}
     *     
     */
    public void setIterDate(JAXBElement<WarningCautionTrainDecisionIterationDate> value) {
        this.iterDate = value;
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
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.SubtaskTrainStepDefinition.LevOfLearn }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.SubtaskTrainStepDefinition.LevOfLearn> getLevOfLearn() {
        return levOfLearn;
    }

    /**
     * Sets the value of the levOfLearn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.SubtaskTrainStepDefinition.LevOfLearn }{@code >}
     *     
     */
    public void setLevOfLearn(JAXBElement<s6000t.taskTrainAnalysis.SubtaskTrainStepDefinition.LevOfLearn> value) {
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

}
