
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
 * <p>Java class for maintenanceLocation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="maintenanceLocation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mLocId" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceLocationIdentifier"/>
 *         &lt;element name="name" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceLocationName" minOccurs="0"/>
 *         &lt;element name="mLocDescr" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceLocationDescription" minOccurs="0"/>
 *         &lt;element name="maintCap" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceLevelReference" minOccurs="0"/>
 *         &lt;element name="opers" type="{http://www.asd-europe.org/s-series/s3000l}operatorMaintenanceLocation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="mloc[1-9][0-9]*"/>
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
@XmlType(name = "maintenanceLocation", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "mLocId",
    "name",
    "mLocDescr",
    "maintCap",
    "opers",
    "docs",
    "rmks"
})
public class MaintenanceLocation {

    @XmlElement(required = true)
    protected MaintenanceLocationIdentifier mLocId;
    @XmlElementRef(name = "name", type = JAXBElement.class, required = false)
    protected JAXBElement<MaintenanceLocationName> name;
    @XmlElementRef(name = "mLocDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<MaintenanceLocationDescription> mLocDescr;
    @XmlElementRef(name = "maintCap", type = JAXBElement.class, required = false)
    protected JAXBElement<MaintenanceLevelReference> maintCap;
    @XmlElement(nillable = true)
    protected List<OperatorMaintenanceLocation> opers;
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
     * Gets the value of the mLocId property.
     * 
     * @return
     *     possible object is
     *     {@link MaintenanceLocationIdentifier }
     *     
     */
    public MaintenanceLocationIdentifier getMLocId() {
        return mLocId;
    }

    /**
     * Sets the value of the mLocId property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaintenanceLocationIdentifier }
     *     
     */
    public void setMLocId(MaintenanceLocationIdentifier value) {
        this.mLocId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MaintenanceLocationName }{@code >}
     *     
     */
    public JAXBElement<MaintenanceLocationName> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MaintenanceLocationName }{@code >}
     *     
     */
    public void setName(JAXBElement<MaintenanceLocationName> value) {
        this.name = value;
    }

    /**
     * Gets the value of the mLocDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MaintenanceLocationDescription }{@code >}
     *     
     */
    public JAXBElement<MaintenanceLocationDescription> getMLocDescr() {
        return mLocDescr;
    }

    /**
     * Sets the value of the mLocDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MaintenanceLocationDescription }{@code >}
     *     
     */
    public void setMLocDescr(JAXBElement<MaintenanceLocationDescription> value) {
        this.mLocDescr = value;
    }

    /**
     * Gets the value of the maintCap property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MaintenanceLevelReference }{@code >}
     *     
     */
    public JAXBElement<MaintenanceLevelReference> getMaintCap() {
        return maintCap;
    }

    /**
     * Sets the value of the maintCap property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MaintenanceLevelReference }{@code >}
     *     
     */
    public void setMaintCap(JAXBElement<MaintenanceLevelReference> value) {
        this.maintCap = value;
    }

    /**
     * Gets the value of the opers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperatorMaintenanceLocation }
     * 
     * 
     */
    public List<OperatorMaintenanceLocation> getOpers() {
        if (opers == null) {
            opers = new ArrayList<OperatorMaintenanceLocation>();
        }
        return this.opers;
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
