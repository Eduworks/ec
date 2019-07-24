
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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for substanceDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="substanceDefinition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subsId" type="{http://www.asd-europe.org/s-series/s3000l}substanceIdentifier" maxOccurs="unbounded"/>
 *         &lt;element name="name" type="{http://www.asd-europe.org/s-series/s3000l}substanceName" minOccurs="0"/>
 *         &lt;element name="subsDescr" type="{http://www.asd-europe.org/s-series/s3000l}substanceDescription" minOccurs="0"/>
 *         &lt;element name="usageCat" type="{http://www.asd-europe.org/s-series/s3000l}substanceUsageCategory" minOccurs="0"/>
 *         &lt;element name="riskDescr" type="{http://www.asd-europe.org/s-series/s3000l}substanceRiskDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="riskFactor" type="{http://www.asd-europe.org/s-series/s3000l}substanceRiskFactor" minOccurs="0"/>
 *         &lt;element name="recDate" type="{http://www.asd-europe.org/s-series/s3000l}substanceCharacteristicsRecordingDate" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="subs[1-9][0-9]*"/>
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
@XmlType(name = "substanceDefinition", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "subsId",
    "name",
    "subsDescr",
    "usageCat",
    "riskDescr",
    "riskFactor",
    "recDate",
    "orgInfos",
    "docs",
    "rmks"
})
public class SubstanceDefinition {

    @XmlElement(required = true)
    protected List<SubstanceIdentifier> subsId;
    @XmlElementRef(name = "name", type = JAXBElement.class, required = false)
    protected JAXBElement<SubstanceName> name;
    @XmlElementRef(name = "subsDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<SubstanceDescription> subsDescr;
    @XmlElementRef(name = "usageCat", type = JAXBElement.class, required = false)
    protected JAXBElement<SubstanceUsageCategory> usageCat;
    @XmlElement(nillable = true)
    protected List<SubstanceRiskDescription> riskDescr;
    @XmlElementRef(name = "riskFactor", type = JAXBElement.class, required = false)
    protected JAXBElement<SubstanceRiskFactor> riskFactor;
    @XmlElementRef(name = "recDate", type = JAXBElement.class, required = false)
    protected JAXBElement<SubstanceCharacteristicsRecordingDate> recDate;
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
     * Gets the value of the subsId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subsId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubsId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubstanceIdentifier }
     * 
     * 
     */
    public List<SubstanceIdentifier> getSubsId() {
        if (subsId == null) {
            subsId = new ArrayList<SubstanceIdentifier>();
        }
        return this.subsId;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubstanceName }{@code >}
     *     
     */
    public JAXBElement<SubstanceName> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubstanceName }{@code >}
     *     
     */
    public void setName(JAXBElement<SubstanceName> value) {
        this.name = value;
    }

    /**
     * Gets the value of the subsDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubstanceDescription }{@code >}
     *     
     */
    public JAXBElement<SubstanceDescription> getSubsDescr() {
        return subsDescr;
    }

    /**
     * Sets the value of the subsDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubstanceDescription }{@code >}
     *     
     */
    public void setSubsDescr(JAXBElement<SubstanceDescription> value) {
        this.subsDescr = value;
    }

    /**
     * Gets the value of the usageCat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubstanceUsageCategory }{@code >}
     *     
     */
    public JAXBElement<SubstanceUsageCategory> getUsageCat() {
        return usageCat;
    }

    /**
     * Sets the value of the usageCat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubstanceUsageCategory }{@code >}
     *     
     */
    public void setUsageCat(JAXBElement<SubstanceUsageCategory> value) {
        this.usageCat = value;
    }

    /**
     * Gets the value of the riskDescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the riskDescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRiskDescr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubstanceRiskDescription }
     * 
     * 
     */
    public List<SubstanceRiskDescription> getRiskDescr() {
        if (riskDescr == null) {
            riskDescr = new ArrayList<SubstanceRiskDescription>();
        }
        return this.riskDescr;
    }

    /**
     * Gets the value of the riskFactor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubstanceRiskFactor }{@code >}
     *     
     */
    public JAXBElement<SubstanceRiskFactor> getRiskFactor() {
        return riskFactor;
    }

    /**
     * Sets the value of the riskFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubstanceRiskFactor }{@code >}
     *     
     */
    public void setRiskFactor(JAXBElement<SubstanceRiskFactor> value) {
        this.riskFactor = value;
    }

    /**
     * Gets the value of the recDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubstanceCharacteristicsRecordingDate }{@code >}
     *     
     */
    public JAXBElement<SubstanceCharacteristicsRecordingDate> getRecDate() {
        return recDate;
    }

    /**
     * Sets the value of the recDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubstanceCharacteristicsRecordingDate }{@code >}
     *     
     */
    public void setRecDate(JAXBElement<SubstanceCharacteristicsRecordingDate> value) {
        this.recDate = value;
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
