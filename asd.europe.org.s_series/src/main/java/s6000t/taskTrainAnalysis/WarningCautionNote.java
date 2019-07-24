
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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for warningCautionNote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="warningCautionNote">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wcnId" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionNoteIdentifier" minOccurs="0"/>
 *         &lt;element name="wcnDescr" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionNoteDescription" minOccurs="0"/>
 *         &lt;element name="wcnType" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionNoteType" minOccurs="0"/>
 *         &lt;element name="trainDecision" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionTrainDecision" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="wcn[1-9][0-9]*"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="uri" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="crud" type="{http://www.asd-europe.org/s-series/s3000l}crudCodeValues" default="I" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "warningCautionNote", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "wcnId",
    "wcnDescr",
    "wcnType",
    "trainDecision",
    "docs",
    "rmks"
})
public class WarningCautionNote {

    @XmlElementRef(name = "wcnId", type = JAXBElement.class, required = false)
    protected JAXBElement<WarningCautionNoteIdentifier> wcnId;
    @XmlElementRef(name = "wcnDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<WarningCautionNoteDescription> wcnDescr;
    @XmlElementRef(name = "wcnType", type = JAXBElement.class, required = false)
    protected JAXBElement<WarningCautionNoteType> wcnType;
    @XmlElement(nillable = true)
    protected List<WarningCautionTrainDecision> trainDecision;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected String uri;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the wcnId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WarningCautionNoteIdentifier }{@code >}
     *     
     */
    public JAXBElement<WarningCautionNoteIdentifier> getWcnId() {
        return wcnId;
    }

    /**
     * Sets the value of the wcnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WarningCautionNoteIdentifier }{@code >}
     *     
     */
    public void setWcnId(JAXBElement<WarningCautionNoteIdentifier> value) {
        this.wcnId = value;
    }

    /**
     * Gets the value of the wcnDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WarningCautionNoteDescription }{@code >}
     *     
     */
    public JAXBElement<WarningCautionNoteDescription> getWcnDescr() {
        return wcnDescr;
    }

    /**
     * Sets the value of the wcnDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WarningCautionNoteDescription }{@code >}
     *     
     */
    public void setWcnDescr(JAXBElement<WarningCautionNoteDescription> value) {
        this.wcnDescr = value;
    }

    /**
     * Gets the value of the wcnType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WarningCautionNoteType }{@code >}
     *     
     */
    public JAXBElement<WarningCautionNoteType> getWcnType() {
        return wcnType;
    }

    /**
     * Sets the value of the wcnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WarningCautionNoteType }{@code >}
     *     
     */
    public void setWcnType(JAXBElement<WarningCautionNoteType> value) {
        this.wcnType = value;
    }

    /**
     * Gets the value of the trainDecision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trainDecision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrainDecision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WarningCautionTrainDecision }
     * 
     * 
     */
    public List<WarningCautionTrainDecision> getTrainDecision() {
        if (trainDecision == null) {
            trainDecision = new ArrayList<WarningCautionTrainDecision>();
        }
        return this.trainDecision;
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
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUri(String value) {
        this.uri = value;
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
