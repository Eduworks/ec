
package s6000t.taskTrainAnalysis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for lsaCandidateTrainingNeedsAnalysisActivity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lsaCandidateTrainingNeedsAnalysisActivity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="indicator" type="{http://www.asd-europe.org/s-series/s3000l}candidateItemAnalysisActivityIndicator" minOccurs="0"/>
 *         &lt;element name="rationale" type="{http://www.asd-europe.org/s-series/s3000l}candidateItemAnalysisActivityRationale" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.asd-europe.org/s-series/s3000l}candidateItemAnalysisActivityStatus" minOccurs="0"/>
 *         &lt;element name="update" type="{http://www.asd-europe.org/s-series/s3000l}candidateItemAnalysisActivityDate" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="ciaa[1-9][0-9]*"/>
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
@XmlType(name = "lsaCandidateTrainingNeedsAnalysisActivity", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "indicator",
    "rationale",
    "status",
    "update",
    "orgInfos",
    "docs",
    "rmks"
})
public class LsaCandidateTrainingNeedsAnalysisActivity {

    @XmlElementRef(name = "indicator", type = JAXBElement.class, required = false)
    protected JAXBElement<CandidateItemAnalysisActivityIndicator> indicator;
    @XmlElementRef(name = "rationale", type = JAXBElement.class, required = false)
    protected JAXBElement<CandidateItemAnalysisActivityRationale> rationale;
    @XmlElementRef(name = "status", type = JAXBElement.class, required = false)
    protected JAXBElement<CandidateItemAnalysisActivityStatus> status;
    @XmlElementRef(name = "update", type = JAXBElement.class, required = false)
    protected JAXBElement<CandidateItemAnalysisActivityDate> update;
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
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the indicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CandidateItemAnalysisActivityIndicator }{@code >}
     *     
     */
    public JAXBElement<CandidateItemAnalysisActivityIndicator> getIndicator() {
        return indicator;
    }

    /**
     * Sets the value of the indicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CandidateItemAnalysisActivityIndicator }{@code >}
     *     
     */
    public void setIndicator(JAXBElement<CandidateItemAnalysisActivityIndicator> value) {
        this.indicator = value;
    }

    /**
     * Gets the value of the rationale property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CandidateItemAnalysisActivityRationale }{@code >}
     *     
     */
    public JAXBElement<CandidateItemAnalysisActivityRationale> getRationale() {
        return rationale;
    }

    /**
     * Sets the value of the rationale property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CandidateItemAnalysisActivityRationale }{@code >}
     *     
     */
    public void setRationale(JAXBElement<CandidateItemAnalysisActivityRationale> value) {
        this.rationale = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CandidateItemAnalysisActivityStatus }{@code >}
     *     
     */
    public JAXBElement<CandidateItemAnalysisActivityStatus> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CandidateItemAnalysisActivityStatus }{@code >}
     *     
     */
    public void setStatus(JAXBElement<CandidateItemAnalysisActivityStatus> value) {
        this.status = value;
    }

    /**
     * Gets the value of the update property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CandidateItemAnalysisActivityDate }{@code >}
     *     
     */
    public JAXBElement<CandidateItemAnalysisActivityDate> getUpdate() {
        return update;
    }

    /**
     * Sets the value of the update property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CandidateItemAnalysisActivityDate }{@code >}
     *     
     */
    public void setUpdate(JAXBElement<CandidateItemAnalysisActivityDate> value) {
        this.update = value;
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
