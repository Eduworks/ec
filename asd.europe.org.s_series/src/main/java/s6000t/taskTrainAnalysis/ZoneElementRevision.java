
package s6000t.taskTrainAnalysis;

import java.math.BigDecimal;
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
 * <p>Java class for zoneElementRevision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="zoneElementRevision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beRevId" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementRevisionIdentifier"/>
 *         &lt;element name="status" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementRevisionStatus" minOccurs="0"/>
 *         &lt;element name="msi" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceSignificantOrRelevant" minOccurs="0"/>
 *         &lt;element name="beRevDate" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementRevisionCreationDate" minOccurs="0"/>
 *         &lt;element name="beDescr" type="{http://www.asd-europe.org/s-series/s3000l}zoneElementDescription" minOccurs="0"/>
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
@XmlType(name = "zoneElementRevision", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
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
public class ZoneElementRevision {

    @XmlElement(required = true)
    protected BreakdownElementRevisionIdentifier beRevId;
    @XmlElementRef(name = "status", type = JAXBElement.class, required = false)
    protected JAXBElement<BreakdownElementRevisionStatus> status;
    @XmlElementRef(name = "msi", type = JAXBElement.class, required = false)
    protected JAXBElement<MaintenanceSignificantOrRelevant> msi;
    @XmlElementRef(name = "beRevDate", type = JAXBElement.class, required = false)
    protected JAXBElement<BreakdownElementRevisionCreationDate> beRevDate;
    @XmlElementRef(name = "beDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<ZoneElementDescription> beDescr;
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
    protected List<ZoneElementRevision.SrvLife> productServiceLife;
    @XmlElement(name = "smInt", nillable = true)
    protected List<ZoneElementRevision.SmInt> scheduledMaintenanceInterval;
    @XmlElement(name = "mfop", nillable = true)
    protected List<ZoneElementRevision.Mfop> maintenanceFreeOperatingPeriod;
    @XmlElement(name = "dt", nillable = true)
    protected List<ZoneElementRevision.Dt> downTime;
    @XmlElement(name = "mmhoh", nillable = true)
    protected List<ZoneElementRevision.Mmhoh> maintenanceManHoursPerOperatingHour;
    @XmlElement(name = "mtbur", nillable = true)
    protected List<ZoneElementRevision.Mtbur> meanTimeBetweenUnscheduledRemoval;
    @XmlElement(name = "mttr", nillable = true)
    protected List<ZoneElementRevision.Mttr> meanTimeToRepair;
    @XmlElement(name = "dmc", nillable = true)
    protected List<ZoneElementRevision.Dmc> directMaintenanceCost;
    @XmlElement(name = "spt", nillable = true)
    protected List<ZoneElementRevision.Spt> shopProcessingTime;
    @XmlElement(name = "foh", nillable = true)
    protected List<ZoneElementRevision.Foh> failuresPerOperatingHour;
    @XmlElement(name = "rplt", nillable = true)
    protected List<ZoneElementRevision.Rplt> replacementTime;
    @XmlElement(name = "lcc", nillable = true)
    protected List<ZoneElementRevision.Lcc> lifeCycleCost;
    @XmlElement(name = "mtbf", nillable = true)
    protected List<ZoneElementRevision.Mtbf> meanTimeBetweenFailure;
    @XmlElement(name = "fRate", nillable = true)
    protected List<ZoneElementRevision.FRate> failureRate;
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
    protected JAXBElement<ZoneElementRevision.DmgAnlys> dmgAnlys;
    @XmlElementRef(name = "failModes", type = JAXBElement.class, required = false)
    protected JAXBElement<ZoneElementRevision.FailModes> failModes;
    @XmlElementRef(name = "detectMnCaps", type = JAXBElement.class, required = false)
    protected JAXBElement<ZoneElementRevision.DetectMnCaps> detectMnCaps;
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
     *     {@link JAXBElement }{@code <}{@link ZoneElementDescription }{@code >}
     *     
     */
    public JAXBElement<ZoneElementDescription> getBeDescr() {
        return beDescr;
    }

    /**
     * Sets the value of the beDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ZoneElementDescription }{@code >}
     *     
     */
    public void setBeDescr(JAXBElement<ZoneElementDescription> value) {
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
     * {@link ZoneElementRevision.SrvLife }
     * 
     * 
     */
    public List<ZoneElementRevision.SrvLife> getProductServiceLife() {
        if (productServiceLife == null) {
            productServiceLife = new ArrayList<ZoneElementRevision.SrvLife>();
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
     * {@link ZoneElementRevision.SmInt }
     * 
     * 
     */
    public List<ZoneElementRevision.SmInt> getScheduledMaintenanceInterval() {
        if (scheduledMaintenanceInterval == null) {
            scheduledMaintenanceInterval = new ArrayList<ZoneElementRevision.SmInt>();
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
     * {@link ZoneElementRevision.Mfop }
     * 
     * 
     */
    public List<ZoneElementRevision.Mfop> getMaintenanceFreeOperatingPeriod() {
        if (maintenanceFreeOperatingPeriod == null) {
            maintenanceFreeOperatingPeriod = new ArrayList<ZoneElementRevision.Mfop>();
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
     * {@link ZoneElementRevision.Dt }
     * 
     * 
     */
    public List<ZoneElementRevision.Dt> getDownTime() {
        if (downTime == null) {
            downTime = new ArrayList<ZoneElementRevision.Dt>();
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
     * {@link ZoneElementRevision.Mmhoh }
     * 
     * 
     */
    public List<ZoneElementRevision.Mmhoh> getMaintenanceManHoursPerOperatingHour() {
        if (maintenanceManHoursPerOperatingHour == null) {
            maintenanceManHoursPerOperatingHour = new ArrayList<ZoneElementRevision.Mmhoh>();
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
     * {@link ZoneElementRevision.Mtbur }
     * 
     * 
     */
    public List<ZoneElementRevision.Mtbur> getMeanTimeBetweenUnscheduledRemoval() {
        if (meanTimeBetweenUnscheduledRemoval == null) {
            meanTimeBetweenUnscheduledRemoval = new ArrayList<ZoneElementRevision.Mtbur>();
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
     * {@link ZoneElementRevision.Mttr }
     * 
     * 
     */
    public List<ZoneElementRevision.Mttr> getMeanTimeToRepair() {
        if (meanTimeToRepair == null) {
            meanTimeToRepair = new ArrayList<ZoneElementRevision.Mttr>();
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
     * {@link ZoneElementRevision.Dmc }
     * 
     * 
     */
    public List<ZoneElementRevision.Dmc> getDirectMaintenanceCost() {
        if (directMaintenanceCost == null) {
            directMaintenanceCost = new ArrayList<ZoneElementRevision.Dmc>();
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
     * {@link ZoneElementRevision.Spt }
     * 
     * 
     */
    public List<ZoneElementRevision.Spt> getShopProcessingTime() {
        if (shopProcessingTime == null) {
            shopProcessingTime = new ArrayList<ZoneElementRevision.Spt>();
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
     * {@link ZoneElementRevision.Foh }
     * 
     * 
     */
    public List<ZoneElementRevision.Foh> getFailuresPerOperatingHour() {
        if (failuresPerOperatingHour == null) {
            failuresPerOperatingHour = new ArrayList<ZoneElementRevision.Foh>();
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
     * {@link ZoneElementRevision.Rplt }
     * 
     * 
     */
    public List<ZoneElementRevision.Rplt> getReplacementTime() {
        if (replacementTime == null) {
            replacementTime = new ArrayList<ZoneElementRevision.Rplt>();
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
     * {@link ZoneElementRevision.Lcc }
     * 
     * 
     */
    public List<ZoneElementRevision.Lcc> getLifeCycleCost() {
        if (lifeCycleCost == null) {
            lifeCycleCost = new ArrayList<ZoneElementRevision.Lcc>();
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
     * {@link ZoneElementRevision.Mtbf }
     * 
     * 
     */
    public List<ZoneElementRevision.Mtbf> getMeanTimeBetweenFailure() {
        if (meanTimeBetweenFailure == null) {
            meanTimeBetweenFailure = new ArrayList<ZoneElementRevision.Mtbf>();
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
     * {@link ZoneElementRevision.FRate }
     * 
     * 
     */
    public List<ZoneElementRevision.FRate> getFailureRate() {
        if (failureRate == null) {
            failureRate = new ArrayList<ZoneElementRevision.FRate>();
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
     *     {@link JAXBElement }{@code <}{@link ZoneElementRevision.DmgAnlys }{@code >}
     *     
     */
    public JAXBElement<ZoneElementRevision.DmgAnlys> getDmgAnlys() {
        return dmgAnlys;
    }

    /**
     * Sets the value of the dmgAnlys property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ZoneElementRevision.DmgAnlys }{@code >}
     *     
     */
    public void setDmgAnlys(JAXBElement<ZoneElementRevision.DmgAnlys> value) {
        this.dmgAnlys = value;
    }

    /**
     * Gets the value of the failModes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ZoneElementRevision.FailModes }{@code >}
     *     
     */
    public JAXBElement<ZoneElementRevision.FailModes> getFailModes() {
        return failModes;
    }

    /**
     * Sets the value of the failModes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ZoneElementRevision.FailModes }{@code >}
     *     
     */
    public void setFailModes(JAXBElement<ZoneElementRevision.FailModes> value) {
        this.failModes = value;
    }

    /**
     * Gets the value of the detectMnCaps property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ZoneElementRevision.DetectMnCaps }{@code >}
     *     
     */
    public JAXBElement<ZoneElementRevision.DetectMnCaps> getDetectMnCaps() {
        return detectMnCaps;
    }

    /**
     * Sets the value of the detectMnCaps property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ZoneElementRevision.DetectMnCaps }{@code >}
     *     
     */
    public void setDetectMnCaps(JAXBElement<ZoneElementRevision.DetectMnCaps> value) {
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="detectMnCap" type="{http://www.asd-europe.org/s-series/s3000l}detectionMeanCapability" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "detectMnCap"
    })
    public static class DetectMnCaps {

        @XmlElement(required = true, nillable = true)
        protected List<DetectionMeanCapability> detectMnCap;

        /**
         * Gets the value of the detectMnCap property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the detectMnCap property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDetectMnCap().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DetectionMeanCapability }
         * 
         * 
         */
        public List<DetectionMeanCapability> getDetectMnCap() {
            if (detectMnCap == null) {
                detectMnCap = new ArrayList<DetectionMeanCapability>();
            }
            return this.detectMnCap;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="cost" type="{http://www.asd-europe.org/s-series/s3000l}directMaintenanceCost" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cost",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class Dmc {

        @XmlElement(required = true)
        protected List<DirectMaintenanceCost> cost;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the cost property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the cost property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCost().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DirectMaintenanceCost }
         * 
         * 
         */
        public List<DirectMaintenanceCost> getCost() {
            if (cost == null) {
                cost = new ArrayList<DirectMaintenanceCost>();
            }
            return this.cost;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateTechnologyBehaviourRating"/>
     *         &lt;element name="dmg" type="{http://www.asd-europe.org/s-series/s3000l}damage" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "techBhvr",
        "dmg"
    })
    public static class DmgAnlys {

        @XmlElementRef(name = "techBhvr", type = JAXBElement.class, required = false)
        protected JAXBElement<LsaCandidateTechnologyBehaviourRatingWrapper> techBhvr;
        @XmlElement(nillable = true)
        protected List<Damage> dmg;

        /**
         * Gets the value of the techBhvr property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link LsaCandidateTechnologyBehaviourRatingWrapper }{@code >}
         *     
         */
        public JAXBElement<LsaCandidateTechnologyBehaviourRatingWrapper> getTechBhvr() {
            return techBhvr;
        }

        /**
         * Sets the value of the techBhvr property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link LsaCandidateTechnologyBehaviourRatingWrapper }{@code >}
         *     
         */
        public void setTechBhvr(JAXBElement<LsaCandidateTechnologyBehaviourRatingWrapper> value) {
            this.techBhvr = value;
        }

        /**
         * Gets the value of the dmg property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dmg property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDmg().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Damage }
         * 
         * 
         */
        public List<Damage> getDmg() {
            if (dmg == null) {
                dmg = new ArrayList<Damage>();
            }
            return this.dmg;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="time" type="{http://www.asd-europe.org/s-series/s3000l}downTime" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "time",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class Dt {

        @XmlElement(required = true)
        protected List<DownTime> time;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the time property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the time property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTime().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DownTime }
         * 
         * 
         */
        public List<DownTime> getTime() {
            if (time == null) {
                time = new ArrayList<DownTime>();
            }
            return this.time;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="rate" type="{http://www.asd-europe.org/s-series/s3000l}failureRate" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}correctionFactor"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "rate",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "corrFact",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class FRate {

        @XmlElement(required = true)
        protected List<FailureRate> rate;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElement(nillable = true)
        protected List<ZoneElementRevision.FRate.CorrFact> corrFact;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the rate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the rate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FailureRate }
         * 
         * 
         */
        public List<FailureRate> getRate() {
            if (rate == null) {
                rate = new ArrayList<FailureRate>();
            }
            return this.rate;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the corrFact property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the corrFact property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCorrFact().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ZoneElementRevision.FRate.CorrFact }
         * 
         * 
         */
        public List<ZoneElementRevision.FRate.CorrFact> getCorrFact() {
            if (corrFact == null) {
                corrFact = new ArrayList<ZoneElementRevision.FRate.CorrFact>();
            }
            return this.corrFact;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="factor" type="{http://www.asd-europe.org/s-series/s3000l}correctionFactor"/>
         *         &lt;element name="just" type="{http://www.asd-europe.org/s-series/s3000l}correctionFactorJustification" minOccurs="0"/>
         *         &lt;element name="defDate" type="{http://www.asd-europe.org/s-series/s3000l}correctionFactorDate" minOccurs="0"/>
         *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
         *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
         *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "factor",
            "just",
            "defDate",
            "docs",
            "rmks",
            "applic"
        })
        public static class CorrFact {

            @XmlElement(required = true)
            protected BigDecimal factor;
            @XmlElementRef(name = "just", type = JAXBElement.class, required = false)
            protected JAXBElement<CorrectionFactorJustification> just;
            @XmlElementRef(name = "defDate", type = JAXBElement.class, required = false)
            protected JAXBElement<CorrectionFactorDate> defDate;
            @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
            protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
            @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
            protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
            @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
            protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

            /**
             * Gets the value of the factor property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getFactor() {
                return factor;
            }

            /**
             * Sets the value of the factor property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setFactor(BigDecimal value) {
                this.factor = value;
            }

            /**
             * Gets the value of the just property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link CorrectionFactorJustification }{@code >}
             *     
             */
            public JAXBElement<CorrectionFactorJustification> getJust() {
                return just;
            }

            /**
             * Sets the value of the just property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link CorrectionFactorJustification }{@code >}
             *     
             */
            public void setJust(JAXBElement<CorrectionFactorJustification> value) {
                this.just = value;
            }

            /**
             * Gets the value of the defDate property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link CorrectionFactorDate }{@code >}
             *     
             */
            public JAXBElement<CorrectionFactorDate> getDefDate() {
                return defDate;
            }

            /**
             * Sets the value of the defDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link CorrectionFactorDate }{@code >}
             *     
             */
            public void setDefDate(JAXBElement<CorrectionFactorDate> value) {
                this.defDate = value;
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

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}failureModeNonAbstractClasses" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "failureModeNonAbstractClasses"
    })
    public static class FailModes {

        @XmlElements({
            @XmlElement(name = "techFm", type = TechnicalFailureMode.class, nillable = true),
            @XmlElement(name = "lsaFm", type = LsaFailureMode.class, nillable = true),
            @XmlElement(name = "lsaFmRtg", type = LsaFailureModeWithDistributionRating.class, nillable = true),
            @XmlElement(name = "lsaFmRo", type = LsaFailureModeWithDistributionRatio.class, nillable = true)
        })
        protected List<Object> failureModeNonAbstractClasses;

        /**
         * Gets the value of the failureModeNonAbstractClasses property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the failureModeNonAbstractClasses property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFailureModeNonAbstractClasses().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TechnicalFailureMode }
         * {@link LsaFailureMode }
         * {@link LsaFailureModeWithDistributionRating }
         * {@link LsaFailureModeWithDistributionRatio }
         * 
         * 
         */
        public List<Object> getFailureModeNonAbstractClasses() {
            if (failureModeNonAbstractClasses == null) {
                failureModeNonAbstractClasses = new ArrayList<Object>();
            }
            return this.failureModeNonAbstractClasses;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="nr" type="{http://www.asd-europe.org/s-series/s3000l}failuresPerOperatingHour" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nr",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class Foh {

        @XmlElement(required = true)
        protected List<FailuresPerOperatingHour> nr;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the nr property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nr property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNr().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FailuresPerOperatingHour }
         * 
         * 
         */
        public List<FailuresPerOperatingHour> getNr() {
            if (nr == null) {
                nr = new ArrayList<FailuresPerOperatingHour>();
            }
            return this.nr;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="cost" type="{http://www.asd-europe.org/s-series/s3000l}lifeCycleCost" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cost",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class Lcc {

        @XmlElement(required = true)
        protected List<LifeCycleCost> cost;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the cost property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the cost property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCost().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LifeCycleCost }
         * 
         * 
         */
        public List<LifeCycleCost> getCost() {
            if (cost == null) {
                cost = new ArrayList<LifeCycleCost>();
            }
            return this.cost;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="per" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceFreeOperatingPeriod" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "per",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class Mfop {

        @XmlElement(required = true)
        protected List<MaintenanceFreeOperatingPeriod> per;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the per property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the per property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPer().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MaintenanceFreeOperatingPeriod }
         * 
         * 
         */
        public List<MaintenanceFreeOperatingPeriod> getPer() {
            if (per == null) {
                per = new ArrayList<MaintenanceFreeOperatingPeriod>();
            }
            return this.per;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="mh" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceManHoursPerOperatingHour" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mh",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class Mmhoh {

        @XmlElement(required = true)
        protected List<MaintenanceManHoursPerOperatingHour> mh;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the mh property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mh property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMh().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MaintenanceManHoursPerOperatingHour }
         * 
         * 
         */
        public List<MaintenanceManHoursPerOperatingHour> getMh() {
            if (mh == null) {
                mh = new ArrayList<MaintenanceManHoursPerOperatingHour>();
            }
            return this.mh;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="mt" type="{http://www.asd-europe.org/s-series/s3000l}meanTimeBetweenFailure" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}correctionFactor"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mt",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "corrFact",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class Mtbf {

        @XmlElement(required = true)
        protected List<MeanTimeBetweenFailure> mt;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElement(nillable = true)
        protected List<ZoneElementRevision.FRate.CorrFact> corrFact;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the mt property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mt property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMt().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MeanTimeBetweenFailure }
         * 
         * 
         */
        public List<MeanTimeBetweenFailure> getMt() {
            if (mt == null) {
                mt = new ArrayList<MeanTimeBetweenFailure>();
            }
            return this.mt;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the corrFact property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the corrFact property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCorrFact().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ZoneElementRevision.FRate.CorrFact }
         * 
         * 
         */
        public List<ZoneElementRevision.FRate.CorrFact> getCorrFact() {
            if (corrFact == null) {
                corrFact = new ArrayList<ZoneElementRevision.FRate.CorrFact>();
            }
            return this.corrFact;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="mt" type="{http://www.asd-europe.org/s-series/s3000l}meanTimeBetweenUnscheduledRemoval" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mt",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class Mtbur {

        @XmlElement(required = true)
        protected List<MeanTimeBetweenUnscheduledRemoval> mt;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the mt property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mt property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMt().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MeanTimeBetweenUnscheduledRemoval }
         * 
         * 
         */
        public List<MeanTimeBetweenUnscheduledRemoval> getMt() {
            if (mt == null) {
                mt = new ArrayList<MeanTimeBetweenUnscheduledRemoval>();
            }
            return this.mt;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="mt" type="{http://www.asd-europe.org/s-series/s3000l}meanTimeToRepair" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mt",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class Mttr {

        @XmlElement(required = true)
        protected List<MeanTimeToRepair> mt;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the mt property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mt property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMt().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MeanTimeToRepair }
         * 
         * 
         */
        public List<MeanTimeToRepair> getMt() {
            if (mt == null) {
                mt = new ArrayList<MeanTimeToRepair>();
            }
            return this.mt;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="time" type="{http://www.asd-europe.org/s-series/s3000l}replacementTime" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "time",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class Rplt {

        @XmlElement(required = true)
        protected List<ReplacementTime> time;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the time property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the time property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTime().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ReplacementTime }
         * 
         * 
         */
        public List<ReplacementTime> getTime() {
            if (time == null) {
                time = new ArrayList<ReplacementTime>();
            }
            return this.time;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="int" type="{http://www.asd-europe.org/s-series/s3000l}scheduledMaintenanceInterval" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "_int",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class SmInt {

        @XmlElement(name = "int", required = true)
        protected List<ScheduledMaintenanceInterval> _int;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the int property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the int property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInt().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ScheduledMaintenanceInterval }
         * 
         * 
         */
        public List<ScheduledMaintenanceInterval> getInt() {
            if (_int == null) {
                _int = new ArrayList<ScheduledMaintenanceInterval>();
            }
            return this._int;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="time" type="{http://www.asd-europe.org/s-series/s3000l}shopProcessingTime" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "time",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class Spt {

        @XmlElement(required = true)
        protected List<ShopProcessingTime> time;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the time property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the time property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTime().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ShopProcessingTime }
         * 
         * 
         */
        public List<ShopProcessingTime> getTime() {
            if (time == null) {
                time = new ArrayList<ShopProcessingTime>();
            }
            return this.time;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="life" type="{http://www.asd-europe.org/s-series/s3000l}productServiceLife" maxOccurs="unbounded"/>
     *         &lt;element name="kpiMthd" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorMethod" minOccurs="0"/>
     *         &lt;element name="kpiStatus" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorStatus" minOccurs="0"/>
     *         &lt;element name="kpiPctl" type="{http://www.asd-europe.org/s-series/s3000l}keyPerformanceIndicatorPercentile" minOccurs="0"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
     *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "life",
        "kpiMthd",
        "kpiStatus",
        "kpiPctl",
        "orgInfos",
        "docs",
        "rmks",
        "applic"
    })
    public static class SrvLife {

        @XmlElement(required = true)
        protected List<ProductServiceLife> life;
        @XmlElementRef(name = "kpiMthd", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorMethod> kpiMthd;
        @XmlElementRef(name = "kpiStatus", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorStatus> kpiStatus;
        @XmlElementRef(name = "kpiPctl", type = JAXBElement.class, required = false)
        protected JAXBElement<KeyPerformanceIndicatorPercentile> kpiPctl;
        @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
        protected JAXBElement<DownTime.OrgInfos> orgInfos;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
        @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;

        /**
         * Gets the value of the life property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the life property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLife().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ProductServiceLife }
         * 
         * 
         */
        public List<ProductServiceLife> getLife() {
            if (life == null) {
                life = new ArrayList<ProductServiceLife>();
            }
            return this.life;
        }

        /**
         * Gets the value of the kpiMthd property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorMethod> getKpiMthd() {
            return kpiMthd;
        }

        /**
         * Sets the value of the kpiMthd property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorMethod }{@code >}
         *     
         */
        public void setKpiMthd(JAXBElement<KeyPerformanceIndicatorMethod> value) {
            this.kpiMthd = value;
        }

        /**
         * Gets the value of the kpiStatus property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorStatus> getKpiStatus() {
            return kpiStatus;
        }

        /**
         * Sets the value of the kpiStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorStatus }{@code >}
         *     
         */
        public void setKpiStatus(JAXBElement<KeyPerformanceIndicatorStatus> value) {
            this.kpiStatus = value;
        }

        /**
         * Gets the value of the kpiPctl property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public JAXBElement<KeyPerformanceIndicatorPercentile> getKpiPctl() {
            return kpiPctl;
        }

        /**
         * Sets the value of the kpiPctl property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link KeyPerformanceIndicatorPercentile }{@code >}
         *     
         */
        public void setKpiPctl(JAXBElement<KeyPerformanceIndicatorPercentile> value) {
            this.kpiPctl = value;
        }

        /**
         * Gets the value of the orgInfos property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public JAXBElement<DownTime.OrgInfos> getOrgInfos() {
            return orgInfos;
        }

        /**
         * Sets the value of the orgInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DownTime.OrgInfos }{@code >}
         *     
         */
        public void setOrgInfos(JAXBElement<DownTime.OrgInfos> value) {
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

    }

}
