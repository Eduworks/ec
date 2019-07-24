
package s6000t.taskTrainAnalysis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for applicableSerialNumberRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="applicableSerialNumberRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lowBound" type="{http://www.asd-europe.org/s-series/s3000l}nonEmptyString"/>
 *         &lt;element name="uppBound" type="{http://www.asd-europe.org/s-series/s3000l}nonEmptyString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "applicableSerialNumberRange", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "lowBound",
    "uppBound"
})
public class ApplicableSerialNumberRange {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String lowBound;
    @XmlElementRef(name = "uppBound", type = JAXBElement.class, required = false)
    protected JAXBElement<String> uppBound;

    /**
     * Gets the value of the lowBound property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLowBound() {
        return lowBound;
    }

    /**
     * Sets the value of the lowBound property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLowBound(String value) {
        this.lowBound = value;
    }

    /**
     * Gets the value of the uppBound property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUppBound() {
        return uppBound;
    }

    /**
     * Sets the value of the uppBound property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUppBound(JAXBElement<String> value) {
        this.uppBound = value;
    }

}
