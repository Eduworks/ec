
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
 * <p>Java class for taskRequirementJustification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskRequirementJustification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}taskRequirementJustificationItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="trjust[1-9][0-9]*"/>
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
@XmlType(name = "taskRequirementJustification", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "sEvntRef",
    "fmRef",
    "dmgRef",
    "analysisRef",
    "funcFailRef",
    "docs",
    "rmks"
})
public class TaskRequirementJustification {

    protected SpecialEventReference sEvntRef;
    protected FailureModeReference fmRef;
    protected DamageReference dmgRef;
    protected CandidateItemAnalysisActivityReference analysisRef;
    protected FunctionalFailureReference funcFailRef;
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
     * Gets the value of the sEvntRef property.
     * 
     * @return
     *     possible object is
     *     {@link SpecialEventReference }
     *     
     */
    public SpecialEventReference getSEvntRef() {
        return sEvntRef;
    }

    /**
     * Sets the value of the sEvntRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialEventReference }
     *     
     */
    public void setSEvntRef(SpecialEventReference value) {
        this.sEvntRef = value;
    }

    /**
     * Gets the value of the fmRef property.
     * 
     * @return
     *     possible object is
     *     {@link FailureModeReference }
     *     
     */
    public FailureModeReference getFmRef() {
        return fmRef;
    }

    /**
     * Sets the value of the fmRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link FailureModeReference }
     *     
     */
    public void setFmRef(FailureModeReference value) {
        this.fmRef = value;
    }

    /**
     * Gets the value of the dmgRef property.
     * 
     * @return
     *     possible object is
     *     {@link DamageReference }
     *     
     */
    public DamageReference getDmgRef() {
        return dmgRef;
    }

    /**
     * Sets the value of the dmgRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link DamageReference }
     *     
     */
    public void setDmgRef(DamageReference value) {
        this.dmgRef = value;
    }

    /**
     * Gets the value of the analysisRef property.
     * 
     * @return
     *     possible object is
     *     {@link CandidateItemAnalysisActivityReference }
     *     
     */
    public CandidateItemAnalysisActivityReference getAnalysisRef() {
        return analysisRef;
    }

    /**
     * Sets the value of the analysisRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link CandidateItemAnalysisActivityReference }
     *     
     */
    public void setAnalysisRef(CandidateItemAnalysisActivityReference value) {
        this.analysisRef = value;
    }

    /**
     * Gets the value of the funcFailRef property.
     * 
     * @return
     *     possible object is
     *     {@link FunctionalFailureReference }
     *     
     */
    public FunctionalFailureReference getFuncFailRef() {
        return funcFailRef;
    }

    /**
     * Sets the value of the funcFailRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link FunctionalFailureReference }
     *     
     */
    public void setFuncFailRef(FunctionalFailureReference value) {
        this.funcFailRef = value;
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
