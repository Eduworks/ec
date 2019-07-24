
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
 * <p>Java class for taskPersonnelResourceCompetence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskPersonnelResourceCompetence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}additionalTrainingRequirement"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}competenceDefinitionItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="tprc[1-9][0-9]*"/>
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
@XmlType(name = "taskPersonnelResourceCompetence", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "addTrain",
    "tradeRef",
    "skillLevelRef",
    "skillRef",
    "applic"
})
public class TaskPersonnelResourceCompetence {

    @XmlElement(nillable = true)
    protected List<TaskPersonnelResourceCompetence.AddTrain> addTrain;
    protected TradeReference tradeRef;
    protected SkillLevelReference skillLevelRef;
    protected SkillReference skillRef;
    @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ProductName.Applic> applic;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the addTrain property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addTrain property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddTrain().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskPersonnelResourceCompetence.AddTrain }
     * 
     * 
     */
    public List<TaskPersonnelResourceCompetence.AddTrain> getAddTrain() {
        if (addTrain == null) {
            addTrain = new ArrayList<TaskPersonnelResourceCompetence.AddTrain>();
        }
        return this.addTrain;
    }

    /**
     * Gets the value of the tradeRef property.
     * 
     * @return
     *     possible object is
     *     {@link TradeReference }
     *     
     */
    public TradeReference getTradeRef() {
        return tradeRef;
    }

    /**
     * Sets the value of the tradeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeReference }
     *     
     */
    public void setTradeRef(TradeReference value) {
        this.tradeRef = value;
    }

    /**
     * Gets the value of the skillLevelRef property.
     * 
     * @return
     *     possible object is
     *     {@link SkillLevelReference }
     *     
     */
    public SkillLevelReference getSkillLevelRef() {
        return skillLevelRef;
    }

    /**
     * Sets the value of the skillLevelRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SkillLevelReference }
     *     
     */
    public void setSkillLevelRef(SkillLevelReference value) {
        this.skillLevelRef = value;
    }

    /**
     * Gets the value of the skillRef property.
     * 
     * @return
     *     possible object is
     *     {@link SkillReference }
     *     
     */
    public SkillReference getSkillRef() {
        return skillRef;
    }

    /**
     * Sets the value of the skillRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SkillReference }
     *     
     */
    public void setSkillRef(SkillReference value) {
        this.skillRef = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="trainDescr" type="{http://www.asd-europe.org/s-series/s3000l}additionalTrainingRequirementDescription" minOccurs="0"/>
     *         &lt;element name="trainMeth" type="{http://www.asd-europe.org/s-series/s3000l}trainingMethod" minOccurs="0"/>
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
    @XmlType(name = "", propOrder = {
        "trainDescr",
        "trainMeth",
        "docs",
        "rmks"
    })
    public static class AddTrain {

        @XmlElementRef(name = "trainDescr", type = JAXBElement.class, required = false)
        protected JAXBElement<AdditionalTrainingRequirementDescription> trainDescr;
        @XmlElementRef(name = "trainMeth", type = JAXBElement.class, required = false)
        protected JAXBElement<TrainingMethod> trainMeth;
        @XmlElementRef(name = "docs", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Docs> docs;
        @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
        protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;

        /**
         * Gets the value of the trainDescr property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link AdditionalTrainingRequirementDescription }{@code >}
         *     
         */
        public JAXBElement<AdditionalTrainingRequirementDescription> getTrainDescr() {
            return trainDescr;
        }

        /**
         * Sets the value of the trainDescr property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link AdditionalTrainingRequirementDescription }{@code >}
         *     
         */
        public void setTrainDescr(JAXBElement<AdditionalTrainingRequirementDescription> value) {
            this.trainDescr = value;
        }

        /**
         * Gets the value of the trainMeth property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link TrainingMethod }{@code >}
         *     
         */
        public JAXBElement<TrainingMethod> getTrainMeth() {
            return trainMeth;
        }

        /**
         * Sets the value of the trainMeth property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link TrainingMethod }{@code >}
         *     
         */
        public void setTrainMeth(JAXBElement<TrainingMethod> value) {
            this.trainMeth = value;
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

}
