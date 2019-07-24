
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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for hardwarePartAsDesigned complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hardwarePartAsDesigned">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="partId" type="{http://www.asd-europe.org/s-series/s3000l}partIdentifier" maxOccurs="unbounded"/>
 *         &lt;element name="name" type="{http://www.asd-europe.org/s-series/s3000l}partName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}hardwarePartAsDesignedDesignData"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}hardwarePartAsDesignedSupportData"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}partAsDesignedControlledItemData"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}partAsDesignedDesignData"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}partAsDesignedSupportData"/>
 *         &lt;element name="partsList" type="{http://www.asd-europe.org/s-series/s3000l}partAsDesignedPartsList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="altPart" type="{http://www.asd-europe.org/s-series/s3000l}alternatePartAsDesignedRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="contSubs" type="{http://www.asd-europe.org/s-series/s3000l}containedSubstance" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}securityClassificationItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}lsaCandidate"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}damageAnalysisItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}failureAnalysisItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}detectionMeanItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="part[1-9][0-9]*"/>
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
@XmlType(name = "hardwarePartAsDesigned", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "partId",
    "name",
    "haz",
    "opAul",
    "ftc",
    "emi",
    "ess",
    "ems",
    "mse",
    "rse",
    "logCat",
    "rep",
    "sra",
    "rpy",
    "maintStart",
    "inUseDispDescr",
    "plndDispDescr",
    "envmtInUseClass",
    "envmtDispClass",
    "consRte",
    "dec",
    "phstReq",
    "maturity",
    "obsRisk",
    "partsList",
    "altPart",
    "contSubs",
    "secs",
    "lsaCand",
    "candRtnl",
    "maintCpt",
    "maintSln",
    "productServiceLife",
    "scheduledMaintenanceInterval",
    "maintenanceFreeOperatingPeriod",
    "downTime",
    "maintenanceManHoursPerOperatingHour",
    "meanTimeBetweenUnscheduledRemoval",
    "meanTimeToRepair",
    "directMaintenanceCost",
    "shopProcessingTime",
    "failuresPerOperatingHour",
    "replacementTime",
    "lifeCycleCost",
    "meanTimeBetweenFailure",
    "failureRate",
    "anlysActvty",
    "taskReq",
    "taskTargetNonAbstractClasses",
    "orgInfos",
    "docs",
    "rmks",
    "dmgAnlys",
    "failModes",
    "detectMnCaps"
})
public class HardwarePartAsDesigned {

    @XmlElement(required = true)
    protected List<PartIdentifier> partId;
    @XmlElement(nillable = true)
    protected List<PartName> name;
    @XmlElementRef(name = "haz", type = JAXBElement.class, required = false)
    protected JAXBElement<HardwarePartHazardousClass> haz;
    @XmlElement(nillable = true)
    protected List<HardwarePartOperationalAuthorizedLife> opAul;
    @XmlElementRef(name = "ftc", type = JAXBElement.class, required = false)
    protected JAXBElement<HardwarePartFitmentRequirement> ftc;
    @XmlElementRef(name = "emi", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> emi;
    @XmlElementRef(name = "ess", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> ess;
    @XmlElementRef(name = "ems", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> ems;
    @XmlElementRef(name = "mse", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> mse;
    @XmlElementRef(name = "rse", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> rse;
    @XmlElementRef(name = "logCat", type = JAXBElement.class, required = false)
    protected JAXBElement<HardwarePartLogisticsCategory> logCat;
    @XmlElementRef(name = "rep", type = JAXBElement.class, required = false)
    protected JAXBElement<HardwarePartRepairability> rep;
    @XmlElement(nillable = true)
    protected List<HardwarePartScrapRate> sra;
    @XmlElement(nillable = true)
    protected List<HardwarePartRepairabilityStrategy> rpy;
    @XmlElementRef(name = "maintStart", type = JAXBElement.class, required = false)
    protected JAXBElement<HardwarePartMaintenanceStart> maintStart;
    @XmlElement(nillable = true)
    protected List<HardwarePartWasteProductsInUseDisposalDescription> inUseDispDescr;
    @XmlElement(nillable = true)
    protected List<HardwarePartWasteProductsPlannedDisposalDescription> plndDispDescr;
    @XmlElement(nillable = true)
    protected List<HardwarePartEnvironmentalAspectInUseClass> envmtInUseClass;
    @XmlElement(nillable = true)
    protected List<HardwarePartEnvironmentalAspectPlannedDisposalClass> envmtDispClass;
    @XmlElement(nillable = true)
    protected List<HardwarePartConsumptionRate> consRte;
    @XmlElementRef(name = "dec", type = JAXBElement.class, required = false)
    protected JAXBElement<PartDemilitarizationClass> dec;
    @XmlElementRef(name = "phstReq", type = JAXBElement.class, required = false)
    protected JAXBElement<PartSpecialHandlingRequirement> phstReq;
    @XmlElement(nillable = true)
    protected List<PartMaturityClass> maturity;
    @XmlElement(nillable = true)
    protected List<PartObsolescenceRiskAssessment> obsRisk;
    @XmlElement(nillable = true)
    protected List<PartAsDesignedPartsList> partsList;
    @XmlElement(nillable = true)
    protected List<AlternatePartAsDesignedRelationship> altPart;
    @XmlElement(nillable = true)
    protected List<ContainedSubstance> contSubs;
    @XmlElementRef(name = "secs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.OperationalTask.Secs> secs;
    @XmlElementRef(name = "lsaCand", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateIndicator> lsaCand;
    @XmlElementRef(name = "candRtnl", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateRationale> candRtnl;
    @XmlElement(nillable = true)
    protected List<LsaCandidateMaintenanceConcept> maintCpt;
    @XmlElement(nillable = true)
    protected List<LsaCandidateMaintenanceSolution> maintSln;
    @XmlElement(name = "srvLife", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.SrvLife> productServiceLife;
    @XmlElement(name = "smInt", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.SmInt> scheduledMaintenanceInterval;
    @XmlElement(name = "mfop", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.Mfop> maintenanceFreeOperatingPeriod;
    @XmlElement(name = "dt", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.Dt> downTime;
    @XmlElement(name = "mmhoh", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.Mmhoh> maintenanceManHoursPerOperatingHour;
    @XmlElement(name = "mtbur", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.Mtbur> meanTimeBetweenUnscheduledRemoval;
    @XmlElement(name = "mttr", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.Mttr> meanTimeToRepair;
    @XmlElement(name = "dmc", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.Dmc> directMaintenanceCost;
    @XmlElement(name = "spt", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.Spt> shopProcessingTime;
    @XmlElement(name = "foh", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.Foh> failuresPerOperatingHour;
    @XmlElement(name = "rplt", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.Rplt> replacementTime;
    @XmlElement(name = "lcc", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.Lcc> lifeCycleCost;
    @XmlElement(name = "mtbf", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.Mtbf> meanTimeBetweenFailure;
    @XmlElement(name = "fRate", nillable = true)
    protected List<s6000t.taskTrainAnalysis.ZoneElementRevision.FRate> failureRate;
    @XmlElementRef(name = "anlysActvty", type = JAXBElement.class, required = false)
    protected JAXBElement<LsaCandidateAnalysisActivities> anlysActvty;
    @XmlElement(nillable = true)
    protected List<TaskRequirementTarget> taskReq;
    @XmlElements({
        @XmlElement(name = "plndTask", type = PlannedTaskTarget.class, nillable = true),
        @XmlElement(name = "supTask", type = SupportingTaskTarget.class, nillable = true)
    })
    protected List<Object> taskTargetNonAbstractClasses;
    @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> orgInfos;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlElementRef(name = "dmgAnlys", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ZoneElementRevision.DmgAnlys> dmgAnlys;
    @XmlElementRef(name = "failModes", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ZoneElementRevision.FailModes> failModes;
    @XmlElementRef(name = "detectMnCaps", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ZoneElementRevision.DetectMnCaps> detectMnCaps;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the partId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartIdentifier }
     * 
     * 
     */
    public List<PartIdentifier> getPartId() {
        if (partId == null) {
            partId = new ArrayList<PartIdentifier>();
        }
        return this.partId;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartName }
     * 
     * 
     */
    public List<PartName> getName() {
        if (name == null) {
            name = new ArrayList<PartName>();
        }
        return this.name;
    }

    /**
     * Gets the value of the haz property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link HardwarePartHazardousClass }{@code >}
     *     
     */
    public JAXBElement<HardwarePartHazardousClass> getHaz() {
        return haz;
    }

    /**
     * Sets the value of the haz property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link HardwarePartHazardousClass }{@code >}
     *     
     */
    public void setHaz(JAXBElement<HardwarePartHazardousClass> value) {
        this.haz = value;
    }

    /**
     * Gets the value of the opAul property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opAul property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpAul().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HardwarePartOperationalAuthorizedLife }
     * 
     * 
     */
    public List<HardwarePartOperationalAuthorizedLife> getOpAul() {
        if (opAul == null) {
            opAul = new ArrayList<HardwarePartOperationalAuthorizedLife>();
        }
        return this.opAul;
    }

    /**
     * Gets the value of the ftc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link HardwarePartFitmentRequirement }{@code >}
     *     
     */
    public JAXBElement<HardwarePartFitmentRequirement> getFtc() {
        return ftc;
    }

    /**
     * Sets the value of the ftc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link HardwarePartFitmentRequirement }{@code >}
     *     
     */
    public void setFtc(JAXBElement<HardwarePartFitmentRequirement> value) {
        this.ftc = value;
    }

    /**
     * Gets the value of the emi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getEmi() {
        return emi;
    }

    /**
     * Sets the value of the emi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setEmi(JAXBElement<Boolean> value) {
        this.emi = value;
    }

    /**
     * Gets the value of the ess property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getEss() {
        return ess;
    }

    /**
     * Sets the value of the ess property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setEss(JAXBElement<Boolean> value) {
        this.ess = value;
    }

    /**
     * Gets the value of the ems property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getEms() {
        return ems;
    }

    /**
     * Sets the value of the ems property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setEms(JAXBElement<Boolean> value) {
        this.ems = value;
    }

    /**
     * Gets the value of the mse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getMse() {
        return mse;
    }

    /**
     * Sets the value of the mse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setMse(JAXBElement<Boolean> value) {
        this.mse = value;
    }

    /**
     * Gets the value of the rse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getRse() {
        return rse;
    }

    /**
     * Sets the value of the rse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setRse(JAXBElement<Boolean> value) {
        this.rse = value;
    }

    /**
     * Gets the value of the logCat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link HardwarePartLogisticsCategory }{@code >}
     *     
     */
    public JAXBElement<HardwarePartLogisticsCategory> getLogCat() {
        return logCat;
    }

    /**
     * Sets the value of the logCat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link HardwarePartLogisticsCategory }{@code >}
     *     
     */
    public void setLogCat(JAXBElement<HardwarePartLogisticsCategory> value) {
        this.logCat = value;
    }

    /**
     * Gets the value of the rep property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link HardwarePartRepairability }{@code >}
     *     
     */
    public JAXBElement<HardwarePartRepairability> getRep() {
        return rep;
    }

    /**
     * Sets the value of the rep property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link HardwarePartRepairability }{@code >}
     *     
     */
    public void setRep(JAXBElement<HardwarePartRepairability> value) {
        this.rep = value;
    }

    /**
     * Gets the value of the sra property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sra property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSra().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HardwarePartScrapRate }
     * 
     * 
     */
    public List<HardwarePartScrapRate> getSra() {
        if (sra == null) {
            sra = new ArrayList<HardwarePartScrapRate>();
        }
        return this.sra;
    }

    /**
     * Gets the value of the rpy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rpy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRpy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HardwarePartRepairabilityStrategy }
     * 
     * 
     */
    public List<HardwarePartRepairabilityStrategy> getRpy() {
        if (rpy == null) {
            rpy = new ArrayList<HardwarePartRepairabilityStrategy>();
        }
        return this.rpy;
    }

    /**
     * Gets the value of the maintStart property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link HardwarePartMaintenanceStart }{@code >}
     *     
     */
    public JAXBElement<HardwarePartMaintenanceStart> getMaintStart() {
        return maintStart;
    }

    /**
     * Sets the value of the maintStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link HardwarePartMaintenanceStart }{@code >}
     *     
     */
    public void setMaintStart(JAXBElement<HardwarePartMaintenanceStart> value) {
        this.maintStart = value;
    }

    /**
     * Gets the value of the inUseDispDescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inUseDispDescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInUseDispDescr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HardwarePartWasteProductsInUseDisposalDescription }
     * 
     * 
     */
    public List<HardwarePartWasteProductsInUseDisposalDescription> getInUseDispDescr() {
        if (inUseDispDescr == null) {
            inUseDispDescr = new ArrayList<HardwarePartWasteProductsInUseDisposalDescription>();
        }
        return this.inUseDispDescr;
    }

    /**
     * Gets the value of the plndDispDescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plndDispDescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlndDispDescr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HardwarePartWasteProductsPlannedDisposalDescription }
     * 
     * 
     */
    public List<HardwarePartWasteProductsPlannedDisposalDescription> getPlndDispDescr() {
        if (plndDispDescr == null) {
            plndDispDescr = new ArrayList<HardwarePartWasteProductsPlannedDisposalDescription>();
        }
        return this.plndDispDescr;
    }

    /**
     * Gets the value of the envmtInUseClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the envmtInUseClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnvmtInUseClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HardwarePartEnvironmentalAspectInUseClass }
     * 
     * 
     */
    public List<HardwarePartEnvironmentalAspectInUseClass> getEnvmtInUseClass() {
        if (envmtInUseClass == null) {
            envmtInUseClass = new ArrayList<HardwarePartEnvironmentalAspectInUseClass>();
        }
        return this.envmtInUseClass;
    }

    /**
     * Gets the value of the envmtDispClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the envmtDispClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnvmtDispClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HardwarePartEnvironmentalAspectPlannedDisposalClass }
     * 
     * 
     */
    public List<HardwarePartEnvironmentalAspectPlannedDisposalClass> getEnvmtDispClass() {
        if (envmtDispClass == null) {
            envmtDispClass = new ArrayList<HardwarePartEnvironmentalAspectPlannedDisposalClass>();
        }
        return this.envmtDispClass;
    }

    /**
     * Gets the value of the consRte property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consRte property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsRte().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HardwarePartConsumptionRate }
     * 
     * 
     */
    public List<HardwarePartConsumptionRate> getConsRte() {
        if (consRte == null) {
            consRte = new ArrayList<HardwarePartConsumptionRate>();
        }
        return this.consRte;
    }

    /**
     * Gets the value of the dec property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PartDemilitarizationClass }{@code >}
     *     
     */
    public JAXBElement<PartDemilitarizationClass> getDec() {
        return dec;
    }

    /**
     * Sets the value of the dec property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PartDemilitarizationClass }{@code >}
     *     
     */
    public void setDec(JAXBElement<PartDemilitarizationClass> value) {
        this.dec = value;
    }

    /**
     * Gets the value of the phstReq property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PartSpecialHandlingRequirement }{@code >}
     *     
     */
    public JAXBElement<PartSpecialHandlingRequirement> getPhstReq() {
        return phstReq;
    }

    /**
     * Sets the value of the phstReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PartSpecialHandlingRequirement }{@code >}
     *     
     */
    public void setPhstReq(JAXBElement<PartSpecialHandlingRequirement> value) {
        this.phstReq = value;
    }

    /**
     * Gets the value of the maturity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the maturity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMaturity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartMaturityClass }
     * 
     * 
     */
    public List<PartMaturityClass> getMaturity() {
        if (maturity == null) {
            maturity = new ArrayList<PartMaturityClass>();
        }
        return this.maturity;
    }

    /**
     * Gets the value of the obsRisk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the obsRisk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObsRisk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartObsolescenceRiskAssessment }
     * 
     * 
     */
    public List<PartObsolescenceRiskAssessment> getObsRisk() {
        if (obsRisk == null) {
            obsRisk = new ArrayList<PartObsolescenceRiskAssessment>();
        }
        return this.obsRisk;
    }

    /**
     * Gets the value of the partsList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partsList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartsList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartAsDesignedPartsList }
     * 
     * 
     */
    public List<PartAsDesignedPartsList> getPartsList() {
        if (partsList == null) {
            partsList = new ArrayList<PartAsDesignedPartsList>();
        }
        return this.partsList;
    }

    /**
     * Gets the value of the altPart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the altPart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAltPart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AlternatePartAsDesignedRelationship }
     * 
     * 
     */
    public List<AlternatePartAsDesignedRelationship> getAltPart() {
        if (altPart == null) {
            altPart = new ArrayList<AlternatePartAsDesignedRelationship>();
        }
        return this.altPart;
    }

    /**
     * Gets the value of the contSubs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contSubs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContSubs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContainedSubstance }
     * 
     * 
     */
    public List<ContainedSubstance> getContSubs() {
        if (contSubs == null) {
            contSubs = new ArrayList<ContainedSubstance>();
        }
        return this.contSubs;
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
     * Gets the value of the lsaCand property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateIndicator }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateIndicator> getLsaCand() {
        return lsaCand;
    }

    /**
     * Sets the value of the lsaCand property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateIndicator }{@code >}
     *     
     */
    public void setLsaCand(JAXBElement<LsaCandidateIndicator> value) {
        this.lsaCand = value;
    }

    /**
     * Gets the value of the candRtnl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateRationale }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateRationale> getCandRtnl() {
        return candRtnl;
    }

    /**
     * Sets the value of the candRtnl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateRationale }{@code >}
     *     
     */
    public void setCandRtnl(JAXBElement<LsaCandidateRationale> value) {
        this.candRtnl = value;
    }

    /**
     * Gets the value of the maintCpt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the maintCpt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMaintCpt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LsaCandidateMaintenanceConcept }
     * 
     * 
     */
    public List<LsaCandidateMaintenanceConcept> getMaintCpt() {
        if (maintCpt == null) {
            maintCpt = new ArrayList<LsaCandidateMaintenanceConcept>();
        }
        return this.maintCpt;
    }

    /**
     * Gets the value of the maintSln property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the maintSln property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMaintSln().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LsaCandidateMaintenanceSolution }
     * 
     * 
     */
    public List<LsaCandidateMaintenanceSolution> getMaintSln() {
        if (maintSln == null) {
            maintSln = new ArrayList<LsaCandidateMaintenanceSolution>();
        }
        return this.maintSln;
    }

    /**
     * Gets the value of the productServiceLife property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productServiceLife property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductServiceLife().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.SrvLife }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.SrvLife> getProductServiceLife() {
        if (productServiceLife == null) {
            productServiceLife = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.SrvLife>();
        }
        return this.productServiceLife;
    }

    /**
     * Gets the value of the scheduledMaintenanceInterval property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scheduledMaintenanceInterval property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScheduledMaintenanceInterval().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.SmInt }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.SmInt> getScheduledMaintenanceInterval() {
        if (scheduledMaintenanceInterval == null) {
            scheduledMaintenanceInterval = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.SmInt>();
        }
        return this.scheduledMaintenanceInterval;
    }

    /**
     * Gets the value of the maintenanceFreeOperatingPeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the maintenanceFreeOperatingPeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMaintenanceFreeOperatingPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.Mfop }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.Mfop> getMaintenanceFreeOperatingPeriod() {
        if (maintenanceFreeOperatingPeriod == null) {
            maintenanceFreeOperatingPeriod = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.Mfop>();
        }
        return this.maintenanceFreeOperatingPeriod;
    }

    /**
     * Gets the value of the downTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the downTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDownTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.Dt }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.Dt> getDownTime() {
        if (downTime == null) {
            downTime = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.Dt>();
        }
        return this.downTime;
    }

    /**
     * Gets the value of the maintenanceManHoursPerOperatingHour property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the maintenanceManHoursPerOperatingHour property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMaintenanceManHoursPerOperatingHour().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.Mmhoh }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.Mmhoh> getMaintenanceManHoursPerOperatingHour() {
        if (maintenanceManHoursPerOperatingHour == null) {
            maintenanceManHoursPerOperatingHour = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.Mmhoh>();
        }
        return this.maintenanceManHoursPerOperatingHour;
    }

    /**
     * Gets the value of the meanTimeBetweenUnscheduledRemoval property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meanTimeBetweenUnscheduledRemoval property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeanTimeBetweenUnscheduledRemoval().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.Mtbur }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.Mtbur> getMeanTimeBetweenUnscheduledRemoval() {
        if (meanTimeBetweenUnscheduledRemoval == null) {
            meanTimeBetweenUnscheduledRemoval = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.Mtbur>();
        }
        return this.meanTimeBetweenUnscheduledRemoval;
    }

    /**
     * Gets the value of the meanTimeToRepair property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meanTimeToRepair property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeanTimeToRepair().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.Mttr }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.Mttr> getMeanTimeToRepair() {
        if (meanTimeToRepair == null) {
            meanTimeToRepair = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.Mttr>();
        }
        return this.meanTimeToRepair;
    }

    /**
     * Gets the value of the directMaintenanceCost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directMaintenanceCost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectMaintenanceCost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.Dmc }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.Dmc> getDirectMaintenanceCost() {
        if (directMaintenanceCost == null) {
            directMaintenanceCost = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.Dmc>();
        }
        return this.directMaintenanceCost;
    }

    /**
     * Gets the value of the shopProcessingTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shopProcessingTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShopProcessingTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.Spt }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.Spt> getShopProcessingTime() {
        if (shopProcessingTime == null) {
            shopProcessingTime = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.Spt>();
        }
        return this.shopProcessingTime;
    }

    /**
     * Gets the value of the failuresPerOperatingHour property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the failuresPerOperatingHour property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFailuresPerOperatingHour().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.Foh }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.Foh> getFailuresPerOperatingHour() {
        if (failuresPerOperatingHour == null) {
            failuresPerOperatingHour = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.Foh>();
        }
        return this.failuresPerOperatingHour;
    }

    /**
     * Gets the value of the replacementTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the replacementTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReplacementTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.Rplt }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.Rplt> getReplacementTime() {
        if (replacementTime == null) {
            replacementTime = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.Rplt>();
        }
        return this.replacementTime;
    }

    /**
     * Gets the value of the lifeCycleCost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lifeCycleCost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLifeCycleCost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.Lcc }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.Lcc> getLifeCycleCost() {
        if (lifeCycleCost == null) {
            lifeCycleCost = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.Lcc>();
        }
        return this.lifeCycleCost;
    }

    /**
     * Gets the value of the meanTimeBetweenFailure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meanTimeBetweenFailure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeanTimeBetweenFailure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.Mtbf }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.Mtbf> getMeanTimeBetweenFailure() {
        if (meanTimeBetweenFailure == null) {
            meanTimeBetweenFailure = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.Mtbf>();
        }
        return this.meanTimeBetweenFailure;
    }

    /**
     * Gets the value of the failureRate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the failureRate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFailureRate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.ZoneElementRevision.FRate }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.ZoneElementRevision.FRate> getFailureRate() {
        if (failureRate == null) {
            failureRate = new ArrayList<s6000t.taskTrainAnalysis.ZoneElementRevision.FRate>();
        }
        return this.failureRate;
    }

    /**
     * Gets the value of the anlysActvty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateAnalysisActivities }{@code >}
     *     
     */
    public JAXBElement<LsaCandidateAnalysisActivities> getAnlysActvty() {
        return anlysActvty;
    }

    /**
     * Sets the value of the anlysActvty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LsaCandidateAnalysisActivities }{@code >}
     *     
     */
    public void setAnlysActvty(JAXBElement<LsaCandidateAnalysisActivities> value) {
        this.anlysActvty = value;
    }

    /**
     * Gets the value of the taskReq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskReq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskReq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskRequirementTarget }
     * 
     * 
     */
    public List<TaskRequirementTarget> getTaskReq() {
        if (taskReq == null) {
            taskReq = new ArrayList<TaskRequirementTarget>();
        }
        return this.taskReq;
    }

    /**
     * Gets the value of the taskTargetNonAbstractClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskTargetNonAbstractClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskTargetNonAbstractClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlannedTaskTarget }
     * {@link SupportingTaskTarget }
     * 
     * 
     */
    public List<Object> getTaskTargetNonAbstractClasses() {
        if (taskTargetNonAbstractClasses == null) {
            taskTargetNonAbstractClasses = new ArrayList<Object>();
        }
        return this.taskTargetNonAbstractClasses;
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
     * Gets the value of the dmgAnlys property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ZoneElementRevision.DmgAnlys }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.ZoneElementRevision.DmgAnlys> getDmgAnlys() {
        return dmgAnlys;
    }

    /**
     * Sets the value of the dmgAnlys property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ZoneElementRevision.DmgAnlys }{@code >}
     *     
     */
    public void setDmgAnlys(JAXBElement<s6000t.taskTrainAnalysis.ZoneElementRevision.DmgAnlys> value) {
        this.dmgAnlys = value;
    }

    /**
     * Gets the value of the failModes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ZoneElementRevision.FailModes }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.ZoneElementRevision.FailModes> getFailModes() {
        return failModes;
    }

    /**
     * Sets the value of the failModes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ZoneElementRevision.FailModes }{@code >}
     *     
     */
    public void setFailModes(JAXBElement<s6000t.taskTrainAnalysis.ZoneElementRevision.FailModes> value) {
        this.failModes = value;
    }

    /**
     * Gets the value of the detectMnCaps property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ZoneElementRevision.DetectMnCaps }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.ZoneElementRevision.DetectMnCaps> getDetectMnCaps() {
        return detectMnCaps;
    }

    /**
     * Sets the value of the detectMnCaps property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ZoneElementRevision.DetectMnCaps }{@code >}
     *     
     */
    public void setDetectMnCaps(JAXBElement<s6000t.taskTrainAnalysis.ZoneElementRevision.DetectMnCaps> value) {
        this.detectMnCaps = value;
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
