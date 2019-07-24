
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
 * <p>Java class for s1000dPublicationModule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="s1000dPublicationModule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pmc" type="{http://www.asd-europe.org/s-series/s3000l}publicationModuleCode"/>
 *         &lt;element name="pmTitle" type="{http://www.asd-europe.org/s-series/s3000l}publicationModuleTitle" minOccurs="0"/>
 *         &lt;element name="pmIss" type="{http://www.asd-europe.org/s-series/s3000l}s1000dPublicationModuleIssue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="doc[1-9][0-9]*"/>
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
@XmlType(name = "s1000dPublicationModule", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "pmc",
    "pmTitle",
    "pmIss",
    "orgInfos",
    "rmks"
})
public class S1000DPublicationModule {

    @XmlElement(required = true)
    protected PublicationModuleCode pmc;
    @XmlElementRef(name = "pmTitle", type = JAXBElement.class, required = false)
    protected JAXBElement<PublicationModuleTitle> pmTitle;
    @XmlElement(nillable = true)
    protected List<S1000DPublicationModuleIssue> pmIss;
    @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> orgInfos;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the pmc property.
     * 
     * @return
     *     possible object is
     *     {@link PublicationModuleCode }
     *     
     */
    public PublicationModuleCode getPmc() {
        return pmc;
    }

    /**
     * Sets the value of the pmc property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicationModuleCode }
     *     
     */
    public void setPmc(PublicationModuleCode value) {
        this.pmc = value;
    }

    /**
     * Gets the value of the pmTitle property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PublicationModuleTitle }{@code >}
     *     
     */
    public JAXBElement<PublicationModuleTitle> getPmTitle() {
        return pmTitle;
    }

    /**
     * Sets the value of the pmTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PublicationModuleTitle }{@code >}
     *     
     */
    public void setPmTitle(JAXBElement<PublicationModuleTitle> value) {
        this.pmTitle = value;
    }

    /**
     * Gets the value of the pmIss property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pmIss property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPmIss().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link S1000DPublicationModuleIssue }
     * 
     * 
     */
    public List<S1000DPublicationModuleIssue> getPmIss() {
        if (pmIss == null) {
            pmIss = new ArrayList<S1000DPublicationModuleIssue>();
        }
        return this.pmIss;
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
