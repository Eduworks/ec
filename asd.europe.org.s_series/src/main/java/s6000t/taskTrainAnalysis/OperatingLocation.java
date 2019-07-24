
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
 * <p>Java class for operatingLocation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operatingLocation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="opLocId" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocationIdentifier"/>
 *         &lt;element name="name" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocationName" minOccurs="0"/>
 *         &lt;element name="opLocDescr" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocationDescription" minOccurs="0"/>
 *         &lt;element name="opCap" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocationTypeReference" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}operator"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="oploc[1-9][0-9]*"/>
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
@XmlType(name = "operatingLocation", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "opLocId",
    "name",
    "opLocDescr",
    "opCap",
    "orgRef",
    "docs",
    "rmks"
})
public class OperatingLocation {

    @XmlElement(required = true)
    protected OperatingLocationIdentifier opLocId;
    @XmlElementRef(name = "name", type = JAXBElement.class, required = false)
    protected JAXBElement<OperatingLocationName> name;
    @XmlElementRef(name = "opLocDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<OperatingLocationDescription> opLocDescr;
    @XmlElementRef(name = "opCap", type = JAXBElement.class, required = false)
    protected JAXBElement<OperatingLocationTypeReference> opCap;
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
     * Gets the value of the opLocId property.
     * 
     * @return
     *     possible object is
     *     {@link OperatingLocationIdentifier }
     *     
     */
    public OperatingLocationIdentifier getOpLocId() {
        return opLocId;
    }

    /**
     * Sets the value of the opLocId property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingLocationIdentifier }
     *     
     */
    public void setOpLocId(OperatingLocationIdentifier value) {
        this.opLocId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OperatingLocationName }{@code >}
     *     
     */
    public JAXBElement<OperatingLocationName> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OperatingLocationName }{@code >}
     *     
     */
    public void setName(JAXBElement<OperatingLocationName> value) {
        this.name = value;
    }

    /**
     * Gets the value of the opLocDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OperatingLocationDescription }{@code >}
     *     
     */
    public JAXBElement<OperatingLocationDescription> getOpLocDescr() {
        return opLocDescr;
    }

    /**
     * Sets the value of the opLocDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OperatingLocationDescription }{@code >}
     *     
     */
    public void setOpLocDescr(JAXBElement<OperatingLocationDescription> value) {
        this.opLocDescr = value;
    }

    /**
     * Gets the value of the opCap property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OperatingLocationTypeReference }{@code >}
     *     
     */
    public JAXBElement<OperatingLocationTypeReference> getOpCap() {
        return opCap;
    }

    /**
     * Sets the value of the opCap property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OperatingLocationTypeReference }{@code >}
     *     
     */
    public void setOpCap(JAXBElement<OperatingLocationTypeReference> value) {
        this.opCap = value;
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
