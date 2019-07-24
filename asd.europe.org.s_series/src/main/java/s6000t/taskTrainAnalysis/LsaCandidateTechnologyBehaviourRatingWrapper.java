
package s6000t.taskTrainAnalysis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lsaCandidateTechnologyBehaviourRatingWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lsaCandidateTechnologyBehaviourRatingWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bhvrRtg" type="{http://www.asd-europe.org/s-series/s3000l}technologyBehaviourKnowledgeRating" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sensRtg" type="{http://www.asd-europe.org/s-series/s3000l}technologySensitivityRating" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentAssignmentItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lsaCandidateTechnologyBehaviourRatingWrapper", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "bhvrRtg",
    "sensRtg",
    "docs",
    "rmks"
})
public class LsaCandidateTechnologyBehaviourRatingWrapper {

    @XmlElement(nillable = true)
    protected List<TechnologyBehaviourKnowledgeRating> bhvrRtg;
    @XmlElement(nillable = true)
    protected List<TechnologySensitivityRating> sensRtg;
    @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;

    /**
     * Gets the value of the bhvrRtg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bhvrRtg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBhvrRtg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TechnologyBehaviourKnowledgeRating }
     * 
     * 
     */
    public List<TechnologyBehaviourKnowledgeRating> getBhvrRtg() {
        if (bhvrRtg == null) {
            bhvrRtg = new ArrayList<TechnologyBehaviourKnowledgeRating>();
        }
        return this.bhvrRtg;
    }

    /**
     * Gets the value of the sensRtg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sensRtg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSensRtg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TechnologySensitivityRating }
     * 
     * 
     */
    public List<TechnologySensitivityRating> getSensRtg() {
        if (sensRtg == null) {
            sensRtg = new ArrayList<TechnologySensitivityRating>();
        }
        return this.sensRtg;
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

}
