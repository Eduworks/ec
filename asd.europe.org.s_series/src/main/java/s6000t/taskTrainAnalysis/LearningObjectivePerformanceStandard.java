
package s6000t.taskTrainAnalysis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for learningObjectivePerformanceStandard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="learningObjectivePerformanceStandard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="behvrCond" type="{http://www.asd-europe.org/s-series/s3000l}behaviorCondition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="behvrActn" type="{http://www.asd-europe.org/s-series/s3000l}behaviorAction" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="behvrStd" type="{http://www.asd-europe.org/s-series/s3000l}behaviorStandard" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "learningObjectivePerformanceStandard", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "behvrCond",
    "behvrActn",
    "behvrStd"
})
public class LearningObjectivePerformanceStandard {

    @XmlElement(nillable = true)
    protected List<BehaviorCondition> behvrCond;
    @XmlElement(nillable = true)
    protected List<BehaviorAction> behvrActn;
    @XmlElement(nillable = true)
    protected List<BehaviorStandard> behvrStd;

    /**
     * Gets the value of the behvrCond property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the behvrCond property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBehvrCond().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BehaviorCondition }
     * 
     * 
     */
    public List<BehaviorCondition> getBehvrCond() {
        if (behvrCond == null) {
            behvrCond = new ArrayList<BehaviorCondition>();
        }
        return this.behvrCond;
    }

    /**
     * Gets the value of the behvrActn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the behvrActn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBehvrActn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BehaviorAction }
     * 
     * 
     */
    public List<BehaviorAction> getBehvrActn() {
        if (behvrActn == null) {
            behvrActn = new ArrayList<BehaviorAction>();
        }
        return this.behvrActn;
    }

    /**
     * Gets the value of the behvrStd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the behvrStd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBehvrStd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BehaviorStandard }
     * 
     * 
     */
    public List<BehaviorStandard> getBehvrStd() {
        if (behvrStd == null) {
            behvrStd = new ArrayList<BehaviorStandard>();
        }
        return this.behvrStd;
    }

}
