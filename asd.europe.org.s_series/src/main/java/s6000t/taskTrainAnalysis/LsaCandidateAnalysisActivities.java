
package s6000t.taskTrainAnalysis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lsaCandidateAnalysisActivities complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lsaCandidateAnalysisActivities">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="comp" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateComparativeAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="hf" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateHumanFactorAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="rlbty" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateReliabilityAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="mntnblty" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateMaintainabilityAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="tstblty" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateTestabilityAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="fmea" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateFailureModeAndEffectAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="dmg" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateDamageAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="sEvnt" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateSpecialEventAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="lora" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateLevelOfRepairAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="mta" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateMaintenanceTaskAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="sdl" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateSoftwareDataLoadingAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="ssa" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateSoftwareSupportAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="opa" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateOperationalAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="simOp" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateSimulationOperationalScenariosAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="tna" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateTrainingNeedsAnalysisActivity" minOccurs="0"/>
 *         &lt;element name="other" type="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateOtherAnalysisActivity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lsaCandidateAnalysisActivities", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "comp",
    "hf",
    "rlbty",
    "mntnblty",
    "tstblty",
    "fmea",
    "dmg",
    "sEvnt",
    "lora",
    "mta",
    "sdl",
    "ssa",
    "opa",
    "simOp",
    "tna",
    "other"
})
public class LsaCandidateAnalysisActivities {

    @XmlElementRef(name = "comp", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateComparativeAnalysisActivity> comp;
    @XmlElementRef(name = "hf", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateHumanFactorAnalysisActivity> hf;
    @XmlElementRef(name = "rlbty", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateReliabilityAnalysisActivity> rlbty;
    @XmlElementRef(name = "mntnblty", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateMaintainabilityAnalysisActivity> mntnblty;
    @XmlElementRef(name = "tstblty", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateTestabilityAnalysisActivity> tstblty;
    @XmlElementRef(name = "fmea", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateFailureModeAndEffectAnalysisActivity> fmea;
    @XmlElementRef(name = "dmg", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateDamageAnalysisActivity> dmg;
    @XmlElementRef(name = "sEvnt", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateSpecialEventAnalysisActivity> sEvnt;
    @XmlElementRef(name = "lora", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateLevelOfRepairAnalysisActivity> lora;
    @XmlElementRef(name = "mta", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateMaintenanceTaskAnalysisActivity> mta;
    @XmlElementRef(name = "sdl", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateSoftwareDataLoadingAnalysisActivity> sdl;
    @XmlElementRef(name = "ssa", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateSoftwareSupportAnalysisActivity> ssa;
    @XmlElementRef(name = "opa", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateOperationalAnalysisActivity> opa;
    @XmlElementRef(name = "simOp", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateSimulationOperationalScenariosAnalysisActivity> simOp;
    @XmlElementRef(name = "tna", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateTrainingNeedsAnalysisActivity> tna;
    @XmlElementRef(name = "other", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateOtherAnalysisActivity> other;

    /**
     * Gets the value of the comp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateComparativeAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateComparativeAnalysisActivity> getComp() {
        return comp;
    }

    /**
     * Sets the value of the comp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateComparativeAnalysisActivity }{@code >}
     *     
     */
    public void setComp(JAXBElement<LsaCandidateComparativeAnalysisActivity> value) {
        this.comp = value;
    }

    /**
     * Gets the value of the hf property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateHumanFactorAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateHumanFactorAnalysisActivity> getHf() {
        return hf;
    }

    /**
     * Sets the value of the hf property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateHumanFactorAnalysisActivity }{@code >}
     *     
     */
    public void setHf(JAXBElement<LsaCandidateHumanFactorAnalysisActivity> value) {
        this.hf = value;
    }

    /**
     * Gets the value of the rlbty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateReliabilityAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateReliabilityAnalysisActivity> getRlbty() {
        return rlbty;
    }

    /**
     * Sets the value of the rlbty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateReliabilityAnalysisActivity }{@code >}
     *     
     */
    public void setRlbty(JAXBElement<LsaCandidateReliabilityAnalysisActivity> value) {
        this.rlbty = value;
    }

    /**
     * Gets the value of the mntnblty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateMaintainabilityAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateMaintainabilityAnalysisActivity> getMntnblty() {
        return mntnblty;
    }

    /**
     * Sets the value of the mntnblty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateMaintainabilityAnalysisActivity }{@code >}
     *     
     */
    public void setMntnblty(JAXBElement<LsaCandidateMaintainabilityAnalysisActivity> value) {
        this.mntnblty = value;
    }

    /**
     * Gets the value of the tstblty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateTestabilityAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateTestabilityAnalysisActivity> getTstblty() {
        return tstblty;
    }

    /**
     * Sets the value of the tstblty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateTestabilityAnalysisActivity }{@code >}
     *     
     */
    public void setTstblty(JAXBElement<LsaCandidateTestabilityAnalysisActivity> value) {
        this.tstblty = value;
    }

    /**
     * Gets the value of the fmea property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateFailureModeAndEffectAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateFailureModeAndEffectAnalysisActivity> getFmea() {
        return fmea;
    }

    /**
     * Sets the value of the fmea property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateFailureModeAndEffectAnalysisActivity }{@code >}
     *     
     */
    public void setFmea(JAXBElement<LsaCandidateFailureModeAndEffectAnalysisActivity> value) {
        this.fmea = value;
    }

    /**
     * Gets the value of the dmg property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateDamageAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateDamageAnalysisActivity> getDmg() {
        return dmg;
    }

    /**
     * Sets the value of the dmg property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateDamageAnalysisActivity }{@code >}
     *     
     */
    public void setDmg(JAXBElement<LsaCandidateDamageAnalysisActivity> value) {
        this.dmg = value;
    }

    /**
     * Gets the value of the sEvnt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateSpecialEventAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateSpecialEventAnalysisActivity> getSEvnt() {
        return sEvnt;
    }

    /**
     * Sets the value of the sEvnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateSpecialEventAnalysisActivity }{@code >}
     *     
     */
    public void setSEvnt(JAXBElement<LsaCandidateSpecialEventAnalysisActivity> value) {
        this.sEvnt = value;
    }

    /**
     * Gets the value of the lora property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateLevelOfRepairAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateLevelOfRepairAnalysisActivity> getLora() {
        return lora;
    }

    /**
     * Sets the value of the lora property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateLevelOfRepairAnalysisActivity }{@code >}
     *     
     */
    public void setLora(JAXBElement<LsaCandidateLevelOfRepairAnalysisActivity> value) {
        this.lora = value;
    }

    /**
     * Gets the value of the mta property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateMaintenanceTaskAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateMaintenanceTaskAnalysisActivity> getMta() {
        return mta;
    }

    /**
     * Sets the value of the mta property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateMaintenanceTaskAnalysisActivity }{@code >}
     *     
     */
    public void setMta(JAXBElement<LsaCandidateMaintenanceTaskAnalysisActivity> value) {
        this.mta = value;
    }

    /**
     * Gets the value of the sdl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateSoftwareDataLoadingAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateSoftwareDataLoadingAnalysisActivity> getSdl() {
        return sdl;
    }

    /**
     * Sets the value of the sdl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateSoftwareDataLoadingAnalysisActivity }{@code >}
     *     
     */
    public void setSdl(JAXBElement<LsaCandidateSoftwareDataLoadingAnalysisActivity> value) {
        this.sdl = value;
    }

    /**
     * Gets the value of the ssa property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateSoftwareSupportAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateSoftwareSupportAnalysisActivity> getSsa() {
        return ssa;
    }

    /**
     * Sets the value of the ssa property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateSoftwareSupportAnalysisActivity }{@code >}
     *     
     */
    public void setSsa(JAXBElement<LsaCandidateSoftwareSupportAnalysisActivity> value) {
        this.ssa = value;
    }

    /**
     * Gets the value of the opa property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateOperationalAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateOperationalAnalysisActivity> getOpa() {
        return opa;
    }

    /**
     * Sets the value of the opa property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateOperationalAnalysisActivity }{@code >}
     *     
     */
    public void setOpa(JAXBElement<LsaCandidateOperationalAnalysisActivity> value) {
        this.opa = value;
    }

    /**
     * Gets the value of the simOp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateSimulationOperationalScenariosAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateSimulationOperationalScenariosAnalysisActivity> getSimOp() {
        return simOp;
    }

    /**
     * Sets the value of the simOp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateSimulationOperationalScenariosAnalysisActivity }{@code >}
     *     
     */
    public void setSimOp(JAXBElement<LsaCandidateSimulationOperationalScenariosAnalysisActivity> value) {
        this.simOp = value;
    }

    /**
     * Gets the value of the tna property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateTrainingNeedsAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateTrainingNeedsAnalysisActivity> getTna() {
        return tna;
    }

    /**
     * Sets the value of the tna property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateTrainingNeedsAnalysisActivity }{@code >}
     *     
     */
    public void setTna(JAXBElement<LsaCandidateTrainingNeedsAnalysisActivity> value) {
        this.tna = value;
    }

    /**
     * Gets the value of the other property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateOtherAnalysisActivity }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateOtherAnalysisActivity> getOther() {
        return other;
    }

    /**
     * Sets the value of the other property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateOtherAnalysisActivity }{@code >}
     *     
     */
    public void setOther(JAXBElement<LsaCandidateOtherAnalysisActivity> value) {
        this.other = value;
    }

}
