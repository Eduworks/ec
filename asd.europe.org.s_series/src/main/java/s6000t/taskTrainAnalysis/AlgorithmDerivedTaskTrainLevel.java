
package s6000t.taskTrainAnalysis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for algorithmDerivedTaskTrainLevel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="algorithmDerivedTaskTrainLevel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aTaskDiff" type="{http://www.asd-europe.org/s-series/s3000l}algorithmTaskDifficultyCategory" minOccurs="0"/>
 *         &lt;element name="aTaskImp" type="{http://www.asd-europe.org/s-series/s3000l}algorithmTaskImportanceCategory" minOccurs="0"/>
 *         &lt;element name="aTaskFreq" type="{http://www.asd-europe.org/s-series/s3000l}algorithmTaskFrequencyCategory" minOccurs="0"/>
 *         &lt;element name="aTrainLev" type="{http://www.asd-europe.org/s-series/s3000l}algorithmTaskTrainLevel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "algorithmDerivedTaskTrainLevel", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "aTaskDiff",
    "aTaskImp",
    "aTaskFreq",
    "aTrainLev"
})
public class AlgorithmDerivedTaskTrainLevel {

    @XmlElementRef(name = "aTaskDiff", type = JAXBElement.class, required = false)
    protected JAXBElement<AlgorithmTaskDifficultyCategory> aTaskDiff;
    @XmlElementRef(name = "aTaskImp", type = JAXBElement.class, required = false)
    protected JAXBElement<AlgorithmTaskImportanceCategory> aTaskImp;
    @XmlElementRef(name = "aTaskFreq", type = JAXBElement.class, required = false)
    protected JAXBElement<AlgorithmTaskFrequencyCategory> aTaskFreq;
    @XmlElementRef(name = "aTrainLev", type = JAXBElement.class, required = false)
    protected JAXBElement<AlgorithmTaskTrainLevel> aTrainLev;

    /**
     * Gets the value of the aTaskDiff property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AlgorithmTaskDifficultyCategory }{@code >}
     *     
     */
    public JAXBElement<AlgorithmTaskDifficultyCategory> getATaskDiff() {
        return aTaskDiff;
    }

    /**
     * Sets the value of the aTaskDiff property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AlgorithmTaskDifficultyCategory }{@code >}
     *     
     */
    public void setATaskDiff(JAXBElement<AlgorithmTaskDifficultyCategory> value) {
        this.aTaskDiff = value;
    }

    /**
     * Gets the value of the aTaskImp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AlgorithmTaskImportanceCategory }{@code >}
     *     
     */
    public JAXBElement<AlgorithmTaskImportanceCategory> getATaskImp() {
        return aTaskImp;
    }

    /**
     * Sets the value of the aTaskImp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AlgorithmTaskImportanceCategory }{@code >}
     *     
     */
    public void setATaskImp(JAXBElement<AlgorithmTaskImportanceCategory> value) {
        this.aTaskImp = value;
    }

    /**
     * Gets the value of the aTaskFreq property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AlgorithmTaskFrequencyCategory }{@code >}
     *     
     */
    public JAXBElement<AlgorithmTaskFrequencyCategory> getATaskFreq() {
        return aTaskFreq;
    }

    /**
     * Sets the value of the aTaskFreq property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AlgorithmTaskFrequencyCategory }{@code >}
     *     
     */
    public void setATaskFreq(JAXBElement<AlgorithmTaskFrequencyCategory> value) {
        this.aTaskFreq = value;
    }

    /**
     * Gets the value of the aTrainLev property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AlgorithmTaskTrainLevel }{@code >}
     *     
     */
    public JAXBElement<AlgorithmTaskTrainLevel> getATrainLev() {
        return aTrainLev;
    }

    /**
     * Sets the value of the aTrainLev property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AlgorithmTaskTrainLevel }{@code >}
     *     
     */
    public void setATrainLev(JAXBElement<AlgorithmTaskTrainLevel> value) {
        this.aTrainLev = value;
    }

}
