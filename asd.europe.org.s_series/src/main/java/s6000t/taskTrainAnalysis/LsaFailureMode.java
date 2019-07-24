
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
 * <p>Java class for lsaFailureMode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lsaFailureMode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fmId" type="{http://www.asd-europe.org/s-series/s3000l}failureModeIdentifier"/>
 *         &lt;element name="fmDescr" type="{http://www.asd-europe.org/s-series/s3000l}failureModeDescription" minOccurs="0"/>
 *         &lt;element name="failRte" type="{http://www.asd-europe.org/s-series/s3000l}failureModeFailureRate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="detectRtg" type="{http://www.asd-europe.org/s-series/s3000l}failureModeDetectionAbilityRating" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="detectDescr" type="{http://www.asd-europe.org/s-series/s3000l}failureModeDetectionAbilityDescription" minOccurs="0"/>
 *         &lt;element name="lznRtg" type="{http://www.asd-europe.org/s-series/s3000l}failureModeLocalizationAbilityRating" minOccurs="0"/>
 *         &lt;element name="lznDescr" type="{http://www.asd-europe.org/s-series/s3000l}failureModeLocalizationAbilityDescription" minOccurs="0"/>
 *         &lt;element name="isolRte" type="{http://www.asd-europe.org/s-series/s3000l}failureModeIsolationRate" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}failureModeEffectNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="techFmRef" type="{http://www.asd-europe.org/s-series/s3000l}failureModeReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="failm[1-9][0-9]*"/>
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
@XmlType(name = "lsaFailureMode", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "fmId",
    "fmDescr",
    "failRte",
    "detectRtg",
    "detectDescr",
    "lznRtg",
    "lznDescr",
    "isolRte",
    "failureModeEffectNonAbstractClasses",
    "techFmRef",
    "orgInfos",
    "docs",
    "rmks",
    "applic"
})
public class LsaFailureMode {

    @XmlElement(required = true)
    protected FailureModeIdentifier fmId;
    @XmlElementRef(name = "fmDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<FailureModeDescription> fmDescr;
    @XmlElement(nillable = true)
    protected List<FailureModeFailureRate> failRte;
    @XmlElement(nillable = true)
    protected List<FailureModeDetectionAbilityRating> detectRtg;
    @XmlElementRef(name = "detectDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<FailureModeDetectionAbilityDescription> detectDescr;
    @XmlElementRef(name = "lznRtg", type = JAXBElement.class, required = false)
    protected JAXBElement<FailureModeLocalizationAbilityRating> lznRtg;
    @XmlElementRef(name = "lznDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<FailureModeLocalizationAbilityDescription> lznDescr;
    @XmlElementRef(name = "isolRte", type = JAXBElement.class, required = false)
    protected JAXBElement<FailureModeIsolationRate> isolRte;
    @XmlElements({
        @XmlElement(name = "lclEfct", type = LocalFailureModeEffect.class, nillable = true),
        @XmlElement(name = "hghrEfct", type = HigherFailureModeEffect.class, nillable = true)
    })
    protected List<Object> failureModeEffectNonAbstractClasses;
    @XmlElement(nillable = true)
    protected List<FailureModeReference> techFmRef;
    @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> orgInfos;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the fmId property.
     * 
     * @return
     *     possible object is
     *     {@link FailureModeIdentifier }
     *     
     */
    public FailureModeIdentifier getFmId() {
        return fmId;
    }

    /**
     * Sets the value of the fmId property.
     * 
     * @param value
     *     allowed object is
     *     {@link FailureModeIdentifier }
     *     
     */
    public void setFmId(FailureModeIdentifier value) {
        this.fmId = value;
    }

    /**
     * Gets the value of the fmDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FailureModeDescription }{@code >}
     *     
     */
    public JAXBElement<FailureModeDescription> getFmDescr() {
        return fmDescr;
    }

    /**
     * Sets the value of the fmDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FailureModeDescription }{@code >}
     *     
     */
    public void setFmDescr(JAXBElement<FailureModeDescription> value) {
        this.fmDescr = value;
    }

    /**
     * Gets the value of the failRte property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the failRte property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFailRte().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FailureModeFailureRate }
     * 
     * 
     */
    public List<FailureModeFailureRate> getFailRte() {
        if (failRte == null) {
            failRte = new ArrayList<FailureModeFailureRate>();
        }
        return this.failRte;
    }

    /**
     * Gets the value of the detectRtg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detectRtg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetectRtg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FailureModeDetectionAbilityRating }
     * 
     * 
     */
    public List<FailureModeDetectionAbilityRating> getDetectRtg() {
        if (detectRtg == null) {
            detectRtg = new ArrayList<FailureModeDetectionAbilityRating>();
        }
        return this.detectRtg;
    }

    /**
     * Gets the value of the detectDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FailureModeDetectionAbilityDescription }{@code >}
     *     
     */
    public JAXBElement<FailureModeDetectionAbilityDescription> getDetectDescr() {
        return detectDescr;
    }

    /**
     * Sets the value of the detectDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FailureModeDetectionAbilityDescription }{@code >}
     *     
     */
    public void setDetectDescr(JAXBElement<FailureModeDetectionAbilityDescription> value) {
        this.detectDescr = value;
    }

    /**
     * Gets the value of the lznRtg property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FailureModeLocalizationAbilityRating }{@code >}
     *     
     */
    public JAXBElement<FailureModeLocalizationAbilityRating> getLznRtg() {
        return lznRtg;
    }

    /**
     * Sets the value of the lznRtg property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FailureModeLocalizationAbilityRating }{@code >}
     *     
     */
    public void setLznRtg(JAXBElement<FailureModeLocalizationAbilityRating> value) {
        this.lznRtg = value;
    }

    /**
     * Gets the value of the lznDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FailureModeLocalizationAbilityDescription }{@code >}
     *     
     */
    public JAXBElement<FailureModeLocalizationAbilityDescription> getLznDescr() {
        return lznDescr;
    }

    /**
     * Sets the value of the lznDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FailureModeLocalizationAbilityDescription }{@code >}
     *     
     */
    public void setLznDescr(JAXBElement<FailureModeLocalizationAbilityDescription> value) {
        this.lznDescr = value;
    }

    /**
     * Gets the value of the isolRte property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FailureModeIsolationRate }{@code >}
     *     
     */
    public JAXBElement<FailureModeIsolationRate> getIsolRte() {
        return isolRte;
    }

    /**
     * Sets the value of the isolRte property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FailureModeIsolationRate }{@code >}
     *     
     */
    public void setIsolRte(JAXBElement<FailureModeIsolationRate> value) {
        this.isolRte = value;
    }

    /**
     * Gets the value of the failureModeEffectNonAbstractClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the failureModeEffectNonAbstractClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFailureModeEffectNonAbstractClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalFailureModeEffect }
     * {@link HigherFailureModeEffect }
     * 
     * 
     */
    public List<Object> getFailureModeEffectNonAbstractClasses() {
        if (failureModeEffectNonAbstractClasses == null) {
            failureModeEffectNonAbstractClasses = new ArrayList<Object>();
        }
        return this.failureModeEffectNonAbstractClasses;
    }

    /**
     * Gets the value of the techFmRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the techFmRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTechFmRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FailureModeReference }
     * 
     * 
     */
    public List<FailureModeReference> getTechFmRef() {
        if (techFmRef == null) {
            techFmRef = new ArrayList<FailureModeReference>();
        }
        return this.techFmRef;
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
