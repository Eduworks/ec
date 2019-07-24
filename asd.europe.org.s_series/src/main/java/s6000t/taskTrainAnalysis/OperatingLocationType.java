
package s6000t.taskTrainAnalysis;

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
 * <p>Java class for operatingLocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operatingLocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="opTypeId" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocationTypeIdentifier"/>
 *         &lt;element name="name" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocationTypeName" minOccurs="0"/>
 *         &lt;element name="opTypeDescr" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocationTypeDescription" minOccurs="0"/>
 *         &lt;element name="nrOfLoc" type="{http://www.asd-europe.org/s-series/s3000l}numberOfOperatingLocations" minOccurs="0"/>
 *         &lt;element name="maintCap" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceCapabilityAtOperatingLocationType" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}operator"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="oplt[1-9][0-9]*"/>
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
@XmlType(name = "operatingLocationType", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "opTypeId",
    "name",
    "opTypeDescr",
    "nrOfLoc",
    "maintCap",
    "orgRef",
    "docs",
    "rmks"
})
public class OperatingLocationType {

    @XmlElement(required = true)
    protected OperatingLocationTypeIdentifier opTypeId;
    @XmlElementRef(name = "name", type = JAXBElement.class, required = false)
    protected JAXBElement<OperatingLocationTypeName> name;
    @XmlElementRef(name = "opTypeDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<OperatingLocationTypeDescription> opTypeDescr;
    @XmlElementRef(name = "nrOfLoc", type = JAXBElement.class, required = false)
    protected JAXBElement<NumberOfOperatingLocations> nrOfLoc;
    @XmlElementRef(name = "maintCap", type = JAXBElement.class, required = false)
    protected JAXBElement<MaintenanceCapabilityAtOperatingLocationType> maintCap;
    protected OrganizationReference orgRef;
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
     * Gets the value of the opTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link OperatingLocationTypeIdentifier }
     *     
     */
    public OperatingLocationTypeIdentifier getOpTypeId() {
        return opTypeId;
    }

    /**
     * Sets the value of the opTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingLocationTypeIdentifier }
     *     
     */
    public void setOpTypeId(OperatingLocationTypeIdentifier value) {
        this.opTypeId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OperatingLocationTypeName }{@code >}
     *     
     */
    public JAXBElement<OperatingLocationTypeName> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OperatingLocationTypeName }{@code >}
     *     
     */
    public void setName(JAXBElement<OperatingLocationTypeName> value) {
        this.name = value;
    }

    /**
     * Gets the value of the opTypeDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OperatingLocationTypeDescription }{@code >}
     *     
     */
    public JAXBElement<OperatingLocationTypeDescription> getOpTypeDescr() {
        return opTypeDescr;
    }

    /**
     * Sets the value of the opTypeDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OperatingLocationTypeDescription }{@code >}
     *     
     */
    public void setOpTypeDescr(JAXBElement<OperatingLocationTypeDescription> value) {
        this.opTypeDescr = value;
    }

    /**
     * Gets the value of the nrOfLoc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NumberOfOperatingLocations }{@code >}
     *     
     */
    public JAXBElement<NumberOfOperatingLocations> getNrOfLoc() {
        return nrOfLoc;
    }

    /**
     * Sets the value of the nrOfLoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NumberOfOperatingLocations }{@code >}
     *     
     */
    public void setNrOfLoc(JAXBElement<NumberOfOperatingLocations> value) {
        this.nrOfLoc = value;
    }

    /**
     * Gets the value of the maintCap property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MaintenanceCapabilityAtOperatingLocationType }{@code >}
     *     
     */
    public JAXBElement<MaintenanceCapabilityAtOperatingLocationType> getMaintCap() {
        return maintCap;
    }

    /**
     * Sets the value of the maintCap property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MaintenanceCapabilityAtOperatingLocationType }{@code >}
     *     
     */
    public void setMaintCap(JAXBElement<MaintenanceCapabilityAtOperatingLocationType> value) {
        this.maintCap = value;
    }

    /**
     * Gets the value of the orgRef property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationReference }
     *     
     */
    public OrganizationReference getOrgRef() {
        return orgRef;
    }

    /**
     * Sets the value of the orgRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationReference }
     *     
     */
    public void setOrgRef(OrganizationReference value) {
        this.orgRef = value;
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
