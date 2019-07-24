
package s6000t.taskTrainAnalysis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for subtaskWarningCautionNote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subtaskWarningCautionNote">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="wcnRef" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionNoteRef"/>
 *           &lt;element name="wcnDef" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionNote"/>
 *         &lt;/choice>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}levelOfLearningIterationNonAbstractClasses"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="subwcn[1-9][0-9]*"/>
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
@XmlType(name = "subtaskWarningCautionNote", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "wcnRef",
    "wcnDef",
    "affecLoL",
    "cognLoL",
    "psychLoL"
})
public class SubtaskWarningCautionNote {

    protected WarningCautionNoteRef wcnRef;
    protected WarningCautionNote wcnDef;
    @XmlElementRef(name = "affecLoL", type = JAXBElement.class, required = false)
    protected JAXBElement<AffectiveLevelOfLearningIteration> affecLoL;
    @XmlElementRef(name = "cognLoL", type = JAXBElement.class, required = false)
    protected JAXBElement<CognitiveLevelOfLearningIteration> cognLoL;
    @XmlElementRef(name = "psychLoL", type = JAXBElement.class, required = false)
    protected JAXBElement<PsychomotorLevelOfLearningIteration> psychLoL;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the wcnRef property.
     * 
     * @return
     *     possible object is
     *     {@link WarningCautionNoteRef }
     *     
     */
    public WarningCautionNoteRef getWcnRef() {
        return wcnRef;
    }

    /**
     * Sets the value of the wcnRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link WarningCautionNoteRef }
     *     
     */
    public void setWcnRef(WarningCautionNoteRef value) {
        this.wcnRef = value;
    }

    /**
     * Gets the value of the wcnDef property.
     * 
     * @return
     *     possible object is
     *     {@link WarningCautionNote }
     *     
     */
    public WarningCautionNote getWcnDef() {
        return wcnDef;
    }

    /**
     * Sets the value of the wcnDef property.
     * 
     * @param value
     *     allowed object is
     *     {@link WarningCautionNote }
     *     
     */
    public void setWcnDef(WarningCautionNote value) {
        this.wcnDef = value;
    }

    /**
     * Gets the value of the affecLoL property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AffectiveLevelOfLearningIteration }{@code >}
     *     
     */
    public JAXBElement<AffectiveLevelOfLearningIteration> getAffecLoL() {
        return affecLoL;
    }

    /**
     * Sets the value of the affecLoL property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AffectiveLevelOfLearningIteration }{@code >}
     *     
     */
    public void setAffecLoL(JAXBElement<AffectiveLevelOfLearningIteration> value) {
        this.affecLoL = value;
    }

    /**
     * Gets the value of the cognLoL property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CognitiveLevelOfLearningIteration }{@code >}
     *     
     */
    public JAXBElement<CognitiveLevelOfLearningIteration> getCognLoL() {
        return cognLoL;
    }

    /**
     * Sets the value of the cognLoL property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CognitiveLevelOfLearningIteration }{@code >}
     *     
     */
    public void setCognLoL(JAXBElement<CognitiveLevelOfLearningIteration> value) {
        this.cognLoL = value;
    }

    /**
     * Gets the value of the psychLoL property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PsychomotorLevelOfLearningIteration }{@code >}
     *     
     */
    public JAXBElement<PsychomotorLevelOfLearningIteration> getPsychLoL() {
        return psychLoL;
    }

    /**
     * Sets the value of the psychLoL property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PsychomotorLevelOfLearningIteration }{@code >}
     *     
     */
    public void setPsychLoL(JAXBElement<PsychomotorLevelOfLearningIteration> value) {
        this.psychLoL = value;
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
