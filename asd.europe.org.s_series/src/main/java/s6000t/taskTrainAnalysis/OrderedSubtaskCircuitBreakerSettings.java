
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
 * <p>Java class for orderedSubtaskCircuitBreakerSettings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderedSubtaskCircuitBreakerSettings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}subtaskCircuitBreakerSetting" minOccurs="0"/>
 *         &lt;element name="precCb" type="{http://www.asd-europe.org/s-series/s3000l}subtaskCircuitBreakerSettingsTimeline" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="subtcb[1-9][0-9]*"/>
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
@XmlType(name = "orderedSubtaskCircuitBreakerSettings", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "cb",
    "precCb",
    "applic"
})
public class OrderedSubtaskCircuitBreakerSettings {

    @XmlElement(nillable = true)
    protected List<s6000t.taskTrainAnalysis.RandomSubtaskCircuitBreakerSettings.Cb> cb;
    @XmlElementRef(name = "precCb", type = JAXBElement.class, required = false)
    protected JAXBElement<SubtaskCircuitBreakerSettingsTimeline> precCb;
    @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the cb property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cb property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCb().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link s6000t.taskTrainAnalysis.RandomSubtaskCircuitBreakerSettings.Cb }
     * 
     * 
     */
    public List<s6000t.taskTrainAnalysis.RandomSubtaskCircuitBreakerSettings.Cb> getCb() {
        if (cb == null) {
            cb = new ArrayList<s6000t.taskTrainAnalysis.RandomSubtaskCircuitBreakerSettings.Cb>();
        }
        return this.cb;
    }

    /**
     * Gets the value of the precCb property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubtaskCircuitBreakerSettingsTimeline }{@code >}
     *     
     */
    public JAXBElement<SubtaskCircuitBreakerSettingsTimeline> getPrecCb() {
        return precCb;
    }

    /**
     * Sets the value of the precCb property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubtaskCircuitBreakerSettingsTimeline }{@code >}
     *     
     */
    public void setPrecCb(JAXBElement<SubtaskCircuitBreakerSettingsTimeline> value) {
        this.precCb = value;
    }

    /**
     * Gets the value of the applic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ProductName.Applic }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> getApplic() {
        return applic;
    }

    /**
     * Sets the value of the applic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.ProductName.Applic }{@code >}
     *     
     */
    public void setApplic(JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> value) {
        this.applic = value;
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
