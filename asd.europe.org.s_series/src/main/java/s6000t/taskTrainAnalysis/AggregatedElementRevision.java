
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
 * <p>Java class for aggregatedElementRevision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="aggregatedElementRevision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beRevId" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementRevisionIdentifier"/>
 *         &lt;element name="status" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementRevisionStatus" minOccurs="0"/>
 *         &lt;element name="msi" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceSignificantOrRelevant" minOccurs="0"/>
 *         &lt;element name="beRevDate" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementRevisionCreationDate" minOccurs="0"/>
 *         &lt;element name="beDescr" type="{http://www.asd-europe.org/s-series/s3000l}aggregatedElementDescription" minOccurs="0"/>
 *         &lt;element name="funcFail" type="{http://www.asd-europe.org/s-series/s3000l}functionalFailure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="beRel" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementRevisionRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}lsaCandidate"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}damageAnalysisItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}failureAnalysisItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}detectionMeanItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="ber[1-9][0-9]*"/>
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
@XmlType(name = "aggregatedElementRevision", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "beRevId",
    "status",
    "msi",
    "beRevDate",
    "beDescr",
    "funcFail",
    "beRel",
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
    "docs",
    "rmks",
    "dmgAnlys",
    "failModes",
    "detectMnCaps"
})
public class AggregatedElementRevision {

    @XmlElement(required = true)
    protected BreakdownElementRevisionIdentifier beRevId;
    @XmlElementRef(name = "status", type = JAXBElement.class, required = false)
    protected JAXBElement<BreakdownElementRevisionStatus> status;
    @XmlElementRef(name = "msi", type = JAXBElement.class, required = false)
    protected JAXBElement<MaintenanceSignificantOrRelevant> msi;
    @XmlElementRef(name = "beRevDate", type = JAXBElement.class, required = false)
    protected JAXBElement<BreakdownElementRevisionCreationDate> beRevDate;
    @XmlElementRef(name = "beDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<AggregatedElementDescription> beDescr;
    @XmlElement(nillable = true)
    protected List<FunctionalFailure> funcFail;
    @XmlElement(nillable = true)
    protected List<BreakdownElementRevisionRelationship> beRel;
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
     * Gets the value of the beRevId property.
     * 
     * @return
     *     possible object is
     *     {@link BreakdownElementRevisionIdentifier }
     *     
     */
    public BreakdownElementRevisionIdentifier getBeRevId() {
        return beRevId;
    }

    /**
     * Sets the value of the beRevId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BreakdownElementRevisionIdentifier }
     *     
     */
    public void setBeRevId(BreakdownElementRevisionIdentifier value) {
        this.beRevId = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BreakdownElementRevisionStatus }{@code >}
     *     
     */
    public JAXBElement<BreakdownElementRevisionStatus> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BreakdownElementRevisionStatus }{@code >}
     *     
     */
    public void setStatus(JAXBElement<BreakdownElementRevisionStatus> value) {
        this.status = value;
    }

    /**
     * Gets the value of the msi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MaintenanceSignificantOrRelevant }{@code >}
     *     
     */
    public JAXBElement<MaintenanceSignificantOrRelevant> getMsi() {
        return msi;
    }

    /**
     * Sets the value of the msi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MaintenanceSignificantOrRelevant }{@code >}
     *     
     */
    public void setMsi(JAXBElement<MaintenanceSignificantOrRelevant> value) {
        this.msi = value;
    }

    /**
     * Gets the value of the beRevDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BreakdownElementRevisionCreationDate }{@code >}
     *     
     */
    public JAXBElement<BreakdownElementRevisionCreationDate> getBeRevDate() {
        return beRevDate;
    }

    /**
     * Sets the value of the beRevDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BreakdownElementRevisionCreationDate }{@code >}
     *     
     */
    public void setBeRevDate(JAXBElement<BreakdownElementRevisionCreationDate> value) {
        this.beRevDate = value;
    }

    /**
     * Gets the value of the beDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AggregatedElementDescription }{@code >}
     *     
     */
    public JAXBElement<AggregatedElementDescription> getBeDescr() {
        return beDescr;
    }

    /**
     * Sets the value of the beDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AggregatedElementDescription }{@code >}
     *     
     */
    public void setBeDescr(JAXBElement<AggregatedElementDescription> value) {
        this.beDescr = value;
    }

    /**
     * Gets the value of the funcFail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the funcFail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFuncFail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FunctionalFailure }
     * 
     * 
     */
    public List<FunctionalFailure> getFuncFail() {
        if (funcFail == null) {
            funcFail = new ArrayList<FunctionalFailure>();
        }
        return this.funcFail;
    }

    /**
     * Gets the value of the beRel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the beRel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBeRel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BreakdownElementRevisionRelationship }
     * 
     * 
     */
    public List<BreakdownElementRevisionRelationship> getBeRel() {
        if (beRel == null) {
            beRel = new ArrayList<BreakdownElementRevisionRelationship>();
        }
        return this.beRel;
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
