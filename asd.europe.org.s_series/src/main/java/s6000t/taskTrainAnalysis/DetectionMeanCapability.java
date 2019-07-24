
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
 * <p>Java class for detectionMeanCapability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="detectionMeanCapability">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="detectMnDescr" type="{http://www.asd-europe.org/s-series/s3000l}detectionMeanDescription" minOccurs="0"/>
 *         &lt;element name="detectMnType" type="{http://www.asd-europe.org/s-series/s3000l}detectionMeanType" minOccurs="0"/>
 *         &lt;element name="alarm" type="{http://www.asd-europe.org/s-series/s3000l}detectionMeanAlarm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="dmeancap[1-9][0-9]*"/>
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
@XmlType(name = "detectionMeanCapability", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "detectMnDescr",
    "detectMnType",
    "alarm",
    "rmks"
})
public class DetectionMeanCapability {

    @XmlElementRef(name = "detectMnDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<DetectionMeanDescription> detectMnDescr;
    @XmlElementRef(name = "detectMnType", type = JAXBElement.class, required = false)
    protected JAXBElement<DetectionMeanType> detectMnType;
    @XmlElement(nillable = true)
    protected List<DetectionMeanAlarm> alarm;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the detectMnDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DetectionMeanDescription }{@code >}
     *     
     */
    public JAXBElement<DetectionMeanDescription> getDetectMnDescr() {
        return detectMnDescr;
    }

    /**
     * Sets the value of the detectMnDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DetectionMeanDescription }{@code >}
     *     
     */
    public void setDetectMnDescr(JAXBElement<DetectionMeanDescription> value) {
        this.detectMnDescr = value;
    }

    /**
     * Gets the value of the detectMnType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DetectionMeanType }{@code >}
     *     
     */
    public JAXBElement<DetectionMeanType> getDetectMnType() {
        return detectMnType;
    }

    /**
     * Sets the value of the detectMnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DetectionMeanType }{@code >}
     *     
     */
    public void setDetectMnType(JAXBElement<DetectionMeanType> value) {
        this.detectMnType = value;
    }

    /**
     * Gets the value of the alarm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alarm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlarm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetectionMeanAlarm }
     * 
     * 
     */
    public List<DetectionMeanAlarm> getAlarm() {
        if (alarm == null) {
            alarm = new ArrayList<DetectionMeanAlarm>();
        }
        return this.alarm;
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
