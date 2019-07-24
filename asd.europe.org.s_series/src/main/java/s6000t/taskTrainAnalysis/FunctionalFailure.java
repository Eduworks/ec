
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
 * <p>Java class for functionalFailure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="functionalFailure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="funcFailDescr" type="{http://www.asd-europe.org/s-series/s3000l}functionalFailureDescription" minOccurs="0"/>
 *         &lt;element name="efctCritic" type="{http://www.asd-europe.org/s-series/s3000l}functionalFailureEffectCriticality" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="funcf[1-9][0-9]*"/>
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
@XmlType(name = "functionalFailure", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "funcFailDescr",
    "efctCritic"
})
public class FunctionalFailure {

    @XmlElementRef(name = "funcFailDescr", type = JAXBElement.class, required = false)
    protected JAXBElement<FunctionalFailureDescription> funcFailDescr;
    @XmlElementRef(name = "efctCritic", type = JAXBElement.class, required = false)
    protected JAXBElement<FunctionalFailureEffectCriticality> efctCritic;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the funcFailDescr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FunctionalFailureDescription }{@code >}
     *     
     */
    public JAXBElement<FunctionalFailureDescription> getFuncFailDescr() {
        return funcFailDescr;
    }

    /**
     * Sets the value of the funcFailDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FunctionalFailureDescription }{@code >}
     *     
     */
    public void setFuncFailDescr(JAXBElement<FunctionalFailureDescription> value) {
        this.funcFailDescr = value;
    }

    /**
     * Gets the value of the efctCritic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FunctionalFailureEffectCriticality }{@code >}
     *     
     */
    public JAXBElement<FunctionalFailureEffectCriticality> getEfctCritic() {
        return efctCritic;
    }

    /**
     * Sets the value of the efctCritic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FunctionalFailureEffectCriticality }{@code >}
     *     
     */
    public void setEfctCritic(JAXBElement<FunctionalFailureEffectCriticality> value) {
        this.efctCritic = value;
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
