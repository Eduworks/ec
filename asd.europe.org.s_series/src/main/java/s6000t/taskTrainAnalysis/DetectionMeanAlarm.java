
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
 * <p>Java class for detectionMeanAlarm complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="detectionMeanAlarm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmDescr" type="{http://www.asd-europe.org/s-series/s3000l}detectionMeanAlarmDescription"/>
 *         &lt;element name="falseAlarmRte" type="{http://www.asd-europe.org/s-series/s3000l}detectionMeanAlarmFalseAlarmRate" minOccurs="0"/>
 *         &lt;element name="alarmPres" type="{http://www.asd-europe.org/s-series/s3000l}detectionMeanAlarmPresentation" minOccurs="0"/>
 *         &lt;element name="fmDetect" type="{http://www.asd-europe.org/s-series/s3000l}failureModeDetection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="dmeanala[1-9][0-9]*"/>
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
@XmlType(name = "detectionMeanAlarm", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "alarmDescr",
    "falseAlarmRte",
    "alarmPres",
    "fmDetect",
    "docs",
    "rmks"
})
public class DetectionMeanAlarm {

    @XmlElement(required = true, nillable = true)
    protected DetectionMeanAlarmDescription alarmDescr;
    @XmlElementRef(name = "falseAlarmRte", type = JAXBElement.class, required = false)
    protected JAXBElement<DetectionMeanAlarmFalseAlarmRate> falseAlarmRte;
    @XmlElementRef(name = "alarmPres", type = JAXBElement.class, required = false)
    protected JAXBElement<DetectionMeanAlarmPresentation> alarmPres;
    @XmlElement(nillable = true)
    protected List<FailureModeDetection> fmDetect;
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
     * Gets the value of the alarmDescr property.
     * 
     * @return
     *     possible object is
     *     {@link DetectionMeanAlarmDescription }
     *     
     */
    public DetectionMeanAlarmDescription getAlarmDescr() {
        return alarmDescr;
    }

    /**
     * Sets the value of the alarmDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetectionMeanAlarmDescription }
     *     
     */
    public void setAlarmDescr(DetectionMeanAlarmDescription value) {
        this.alarmDescr = value;
    }

    /**
     * Gets the value of the falseAlarmRte property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DetectionMeanAlarmFalseAlarmRate }{@code >}
     *     
     */
    public JAXBElement<DetectionMeanAlarmFalseAlarmRate> getFalseAlarmRte() {
        return falseAlarmRte;
    }

    /**
     * Sets the value of the falseAlarmRte property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DetectionMeanAlarmFalseAlarmRate }{@code >}
     *     
     */
    public void setFalseAlarmRte(JAXBElement<DetectionMeanAlarmFalseAlarmRate> value) {
        this.falseAlarmRte = value;
    }

    /**
     * Gets the value of the alarmPres property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DetectionMeanAlarmPresentation }{@code >}
     *     
     */
    public JAXBElement<DetectionMeanAlarmPresentation> getAlarmPres() {
        return alarmPres;
    }

    /**
     * Sets the value of the alarmPres property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DetectionMeanAlarmPresentation }{@code >}
     *     
     */
    public void setAlarmPres(JAXBElement<DetectionMeanAlarmPresentation> value) {
        this.alarmPres = value;
    }

    /**
     * Gets the value of the fmDetect property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fmDetect property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFmDetect().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FailureModeDetection }
     * 
     * 
     */
    public List<FailureModeDetection> getFmDetect() {
        if (fmDetect == null) {
            fmDetect = new ArrayList<FailureModeDetection>();
        }
        return this.fmDetect;
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
