
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
 * <p>Java class for softwareElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="softwareElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beId" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementIdentifier" maxOccurs="unbounded"/>
 *         &lt;element name="name" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="esc" type="{http://www.asd-europe.org/s-series/s3000l}breakdownElementEssentiality" minOccurs="0"/>
 *         &lt;element name="beType" type="{http://www.asd-europe.org/s-series/s3000l}softwareElementType" minOccurs="0"/>
 *         &lt;element name="beRev" type="{http://www.asd-europe.org/s-series/s3000l}softwareElementRevision" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}securityClassificationItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="be[1-9][0-9]*"/>
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
@XmlType(name = "softwareElement", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "beId",
    "name",
    "esc",
    "beType",
    "beRev",
    "secs",
    "orgInfos",
    "docs",
    "rmks"
})
public class SoftwareElement {

    @XmlElement(required = true)
    protected List<BreakdownElementIdentifier> beId;
    @XmlElement(nillable = true)
    protected List<BreakdownElementName> name;
    @XmlElementRef(name = "esc", type = JAXBElement.class, required = false)
    protected JAXBElement<BreakdownElementEssentiality> esc;
    @XmlElementRef(name = "beType", type = JAXBElement.class, required = false)
    protected JAXBElement<SoftwareElementType> beType;
    @XmlElement(nillable = true)
    protected List<SoftwareElementRevision> beRev;
    @XmlElementRef(name = "secs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.OperationalTask.Secs> secs;
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
     * Gets the value of the beId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the beId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBeId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BreakdownElementIdentifier }
     * 
     * 
     */
    public List<BreakdownElementIdentifier> getBeId() {
        if (beId == null) {
            beId = new ArrayList<BreakdownElementIdentifier>();
        }
        return this.beId;
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
     * {@link BreakdownElementName }
     * 
     * 
     */
    public List<BreakdownElementName> getName() {
        if (name == null) {
            name = new ArrayList<BreakdownElementName>();
        }
        return this.name;
    }

    /**
     * Gets the value of the esc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BreakdownElementEssentiality }{@code >}
     *     
     */
    public JAXBElement<BreakdownElementEssentiality> getEsc() {
        return esc;
    }

    /**
     * Sets the value of the esc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BreakdownElementEssentiality }{@code >}
     *     
     */
    public void setEsc(JAXBElement<BreakdownElementEssentiality> value) {
        this.esc = value;
    }

    /**
     * Gets the value of the beType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SoftwareElementType }{@code >}
     *     
     */
    public JAXBElement<SoftwareElementType> getBeType() {
        return beType;
    }

    /**
     * Sets the value of the beType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SoftwareElementType }{@code >}
     *     
     */
    public void setBeType(JAXBElement<SoftwareElementType> value) {
        this.beType = value;
    }

    /**
     * Gets the value of the beRev property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the beRev property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBeRev().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoftwareElementRevision }
     * 
     * 
     */
    public List<SoftwareElementRevision> getBeRev() {
        if (beRev == null) {
            beRev = new ArrayList<SoftwareElementRevision>();
        }
        return this.beRev;
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
