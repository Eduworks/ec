
package s6000t.taskTrainAnalysis;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for detectionMeanAlarmFalseAlarmRate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="detectionMeanAlarmFalseAlarmRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="vdtm" type="{http://www.asd-europe.org/spec/validValues}valueDeterminationCodeValues" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="unit" type="{http://www.asd-europe.org/spec/validValues}relativeUnit"/>
 *             &lt;choice>
 *               &lt;sequence>
 *                 &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *               &lt;/sequence>
 *               &lt;sequence>
 *                 &lt;element name="nomVal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;element name="lowOff" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;element name="uppOff" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *               &lt;/sequence>
 *               &lt;sequence>
 *                 &lt;element name="lowVal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;element name="uppVal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *               &lt;/sequence>
 *             &lt;/choice>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="txt" type="{http://www.asd-europe.org/s-series/s3000l}nonEmptyString"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;sequence>
 *           &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
 *           &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *           &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}organizationAssignmentItem"/>
 *           &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detectionMeanAlarmFalseAlarmRate", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "date",
    "vdtm",
    "unit",
    "value",
    "nomVal",
    "lowOff",
    "uppOff",
    "lowVal",
    "uppVal",
    "txt",
    "applic",
    "docs",
    "orgInfos",
    "rmks"
})
public class DetectionMeanAlarmFalseAlarmRate {

    @XmlElementRef(name = "date", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> date;
    @XmlElementRef(name = "vdtm", type = JAXBElement.class, required = false)
    protected JAXBElement<ValueDeterminationCodeValues> vdtm;
    @XmlElement(defaultValue = "PCT")
    protected RelativeUnit unit;
    @XmlElementRef(name = "value", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> value;
    protected BigDecimal nomVal;
    protected BigDecimal lowOff;
    protected BigDecimal uppOff;
    protected BigDecimal lowVal;
    protected BigDecimal uppVal;
    @XmlElementRef(name = "txt", type = JAXBElement.class, required = false)
    protected JAXBElement<String> txt;
    @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
    @XmlElementRef(name = "orgInfos", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.DownTime.OrgInfos> orgInfos;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDate(JAXBElement<XMLGregorianCalendar> value) {
        this.date = value;
    }

    /**
     * Gets the value of the vdtm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValueDeterminationCodeValues }{@code >}
     *     
     */
    public JAXBElement<ValueDeterminationCodeValues> getVdtm() {
        return vdtm;
    }

    /**
     * Sets the value of the vdtm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValueDeterminationCodeValues }{@code >}
     *     
     */
    public void setVdtm(JAXBElement<ValueDeterminationCodeValues> value) {
        this.vdtm = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link RelativeUnit }
     *     
     */
    public RelativeUnit getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelativeUnit }
     *     
     */
    public void setUnit(RelativeUnit value) {
        this.unit = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setValue(JAXBElement<BigDecimal> value) {
        this.value = value;
    }

    /**
     * Gets the value of the nomVal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNomVal() {
        return nomVal;
    }

    /**
     * Sets the value of the nomVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNomVal(BigDecimal value) {
        this.nomVal = value;
    }

    /**
     * Gets the value of the lowOff property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLowOff() {
        return lowOff;
    }

    /**
     * Sets the value of the lowOff property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLowOff(BigDecimal value) {
        this.lowOff = value;
    }

    /**
     * Gets the value of the uppOff property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUppOff() {
        return uppOff;
    }

    /**
     * Sets the value of the uppOff property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUppOff(BigDecimal value) {
        this.uppOff = value;
    }

    /**
     * Gets the value of the lowVal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLowVal() {
        return lowVal;
    }

    /**
     * Sets the value of the lowVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLowVal(BigDecimal value) {
        this.lowVal = value;
    }

    /**
     * Gets the value of the uppVal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUppVal() {
        return uppVal;
    }

    /**
     * Sets the value of the uppVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUppVal(BigDecimal value) {
        this.uppVal = value;
    }

    /**
     * Gets the value of the txt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTxt() {
        return txt;
    }

    /**
     * Sets the value of the txt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTxt(JAXBElement<String> value) {
        this.txt = value;
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

}
