
package s6000t.taskTrainAnalysis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for messageContent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="messageContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="messageContentItems">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="tasks">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}taskNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="learningObjectives">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="learnObj" type="{http://www.asd-europe.org/s-series/s3000l}learningObjective" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="warningCautionNotes" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="wcn" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionNote" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="supportingContentItems">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="products" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="prod" type="{http://www.asd-europe.org/s-series/s3000l}product" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="breakdownElements" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}breakdownElementNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="parts" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}partAsDesignedNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="taskRequirements" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}taskRequirementNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="maintenanceLevels" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="mlv" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceLevel" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="maintenanceLocations" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="mLoc" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceLocation" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="operatingLocationTypes" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="opLocType" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocationType" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="operatingLocations" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="opLoc" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocation" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="substances" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="subs" type="{http://www.asd-europe.org/s-series/s3000l}substanceDefinition" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="specialEvents" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="sEvnt" type="{http://www.asd-europe.org/s-series/s3000l}specialEvent" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="productUsagePhases" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="usagePhaseDef" type="{http://www.asd-europe.org/s-series/s3000l}productUsagePhaseClass" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="resourceSpecifications" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}resourceSpecificationNonAbstractClasses" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="trades" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="trade" type="{http://www.asd-europe.org/s-series/s3000l}trade" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="skills" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="skill" type="{http://www.asd-europe.org/s-series/s3000l}skill" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="changeRequests" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="cr" type="{http://www.asd-europe.org/s-series/s3000l}changeRequest" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="circuitBreakers" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="cb" type="{http://www.asd-europe.org/s-series/s3000l}circuitBreaker" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="securityClasses" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="secClassDef" type="{http://www.asd-europe.org/s-series/s3000l}securityClassClass" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="documents" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentNonAbstractClasses" maxOccurs="unbounded"/>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="organizations" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="org" type="{http://www.asd-europe.org/s-series/s3000l}organization" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="applicabilityStatements" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityStatementNonAbstractClasses" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="applicabilityConditions" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="cond" type="{http://www.asd-europe.org/s-series/s3000l}conditionType" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="msgcnt[1-9][0-9]*"/>
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
@XmlType(name = "messageContent", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "messageContentItems",
    "supportingContentItems"
})
public class MessageContent {

    @XmlElement(required = true)
    protected MessageContent.MessageContentItems messageContentItems;
    @XmlElement(required = true)
    protected MessageContent.SupportingContentItems supportingContentItems;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the messageContentItems property.
     * 
     * @return
     *     possible object is
     *     {@link MessageContent.MessageContentItems }
     *     
     */
    public MessageContent.MessageContentItems getMessageContentItems() {
        return messageContentItems;
    }

    /**
     * Sets the value of the messageContentItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageContent.MessageContentItems }
     *     
     */
    public void setMessageContentItems(MessageContent.MessageContentItems value) {
        this.messageContentItems = value;
    }

    /**
     * Gets the value of the supportingContentItems property.
     * 
     * @return
     *     possible object is
     *     {@link MessageContent.SupportingContentItems }
     *     
     */
    public MessageContent.SupportingContentItems getSupportingContentItems() {
        return supportingContentItems;
    }

    /**
     * Sets the value of the supportingContentItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageContent.SupportingContentItems }
     *     
     */
    public void setSupportingContentItems(MessageContent.SupportingContentItems value) {
        this.supportingContentItems = value;
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
     *         &lt;element name="tasks">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}taskNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="learningObjectives">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="learnObj" type="{http://www.asd-europe.org/s-series/s3000l}learningObjective" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="warningCautionNotes" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="wcn" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionNote" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "tasks",
        "learningObjectives",
        "warningCautionNotes"
    })
    public static class MessageContentItems {

        @XmlElement(required = true)
        protected MessageContent.MessageContentItems.Tasks tasks;
        @XmlElement(required = true)
        protected MessageContent.MessageContentItems.LearningObjectives learningObjectives;
        protected MessageContent.MessageContentItems.WarningCautionNotes warningCautionNotes;

        /**
         * Gets the value of the tasks property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.MessageContentItems.Tasks }
         *     
         */
        public MessageContent.MessageContentItems.Tasks getTasks() {
            return tasks;
        }

        /**
         * Sets the value of the tasks property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.MessageContentItems.Tasks }
         *     
         */
        public void setTasks(MessageContent.MessageContentItems.Tasks value) {
            this.tasks = value;
        }

        /**
         * Gets the value of the learningObjectives property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.MessageContentItems.LearningObjectives }
         *     
         */
        public MessageContent.MessageContentItems.LearningObjectives getLearningObjectives() {
            return learningObjectives;
        }

        /**
         * Sets the value of the learningObjectives property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.MessageContentItems.LearningObjectives }
         *     
         */
        public void setLearningObjectives(MessageContent.MessageContentItems.LearningObjectives value) {
            this.learningObjectives = value;
        }

        /**
         * Gets the value of the warningCautionNotes property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.MessageContentItems.WarningCautionNotes }
         *     
         */
        public MessageContent.MessageContentItems.WarningCautionNotes getWarningCautionNotes() {
            return warningCautionNotes;
        }

        /**
         * Sets the value of the warningCautionNotes property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.MessageContentItems.WarningCautionNotes }
         *     
         */
        public void setWarningCautionNotes(MessageContent.MessageContentItems.WarningCautionNotes value) {
            this.warningCautionNotes = value;
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
         *         &lt;element name="learnObj" type="{http://www.asd-europe.org/s-series/s3000l}learningObjective" maxOccurs="unbounded" minOccurs="0"/>
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
            "learnObj"
        })
        public static class LearningObjectives {

            protected List<LearningObjective> learnObj;

            /**
             * Gets the value of the learnObj property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the learnObj property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLearnObj().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link LearningObjective }
             * 
             * 
             */
            public List<LearningObjective> getLearnObj() {
                if (learnObj == null) {
                    learnObj = new ArrayList<LearningObjective>();
                }
                return this.learnObj;
            }

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
         *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}taskNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
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
            "taskNonAbstractClasses"
        })
        public static class Tasks {

            @XmlElements({
                @XmlElement(name = "task", type = RectifyingTask.class, nillable = true),
                @XmlElement(name = "supTask", type = SupportingTask.class, nillable = true),
                @XmlElement(name = "opTask", type = OperationalTask.class, nillable = true)
            })
            protected List<Object> taskNonAbstractClasses;

            /**
             * Gets the value of the taskNonAbstractClasses property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the taskNonAbstractClasses property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTaskNonAbstractClasses().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link RectifyingTask }
             * {@link SupportingTask }
             * {@link OperationalTask }
             * 
             * 
             */
            public List<Object> getTaskNonAbstractClasses() {
                if (taskNonAbstractClasses == null) {
                    taskNonAbstractClasses = new ArrayList<Object>();
                }
                return this.taskNonAbstractClasses;
            }

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
         *         &lt;element name="wcn" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionNote" maxOccurs="unbounded" minOccurs="0"/>
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
            "wcn"
        })
        public static class WarningCautionNotes {

            protected List<WarningCautionNote> wcn;

            /**
             * Gets the value of the wcn property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the wcn property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getWcn().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link WarningCautionNote }
             * 
             * 
             */
            public List<WarningCautionNote> getWcn() {
                if (wcn == null) {
                    wcn = new ArrayList<WarningCautionNote>();
                }
                return this.wcn;
            }

        }

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
     *         &lt;element name="products" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="prod" type="{http://www.asd-europe.org/s-series/s3000l}product" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="breakdownElements" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}breakdownElementNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="parts" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}partAsDesignedNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="taskRequirements" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}taskRequirementNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="maintenanceLevels" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="mlv" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceLevel" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="maintenanceLocations" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="mLoc" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceLocation" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="operatingLocationTypes" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="opLocType" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocationType" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="operatingLocations" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="opLoc" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocation" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="substances" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="subs" type="{http://www.asd-europe.org/s-series/s3000l}substanceDefinition" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="specialEvents" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="sEvnt" type="{http://www.asd-europe.org/s-series/s3000l}specialEvent" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="productUsagePhases" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="usagePhaseDef" type="{http://www.asd-europe.org/s-series/s3000l}productUsagePhaseClass" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="resourceSpecifications" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}resourceSpecificationNonAbstractClasses" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="trades" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="trade" type="{http://www.asd-europe.org/s-series/s3000l}trade" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="skills" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="skill" type="{http://www.asd-europe.org/s-series/s3000l}skill" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="changeRequests" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="cr" type="{http://www.asd-europe.org/s-series/s3000l}changeRequest" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="circuitBreakers" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="cb" type="{http://www.asd-europe.org/s-series/s3000l}circuitBreaker" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="securityClasses" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="secClassDef" type="{http://www.asd-europe.org/s-series/s3000l}securityClassClass" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="documents" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentNonAbstractClasses" maxOccurs="unbounded"/>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="organizations" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="org" type="{http://www.asd-europe.org/s-series/s3000l}organization" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="applicabilityStatements" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityStatementNonAbstractClasses" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="applicabilityConditions" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="cond" type="{http://www.asd-europe.org/s-series/s3000l}conditionType" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "products",
        "breakdownElements",
        "parts",
        "taskRequirements",
        "maintenanceLevels",
        "maintenanceLocations",
        "operatingLocationTypes",
        "operatingLocations",
        "substances",
        "specialEvents",
        "productUsagePhases",
        "resourceSpecifications",
        "trades",
        "skills",
        "changeRequests",
        "circuitBreakers",
        "securityClasses",
        "documents",
        "organizations",
        "applicabilityStatements",
        "applicabilityConditions"
    })
    public static class SupportingContentItems {

        protected MessageContent.SupportingContentItems.Products products;
        protected MessageContent.SupportingContentItems.BreakdownElements breakdownElements;
        protected MessageContent.SupportingContentItems.Parts parts;
        protected MessageContent.SupportingContentItems.TaskRequirements taskRequirements;
        protected MessageContent.SupportingContentItems.MaintenanceLevels maintenanceLevels;
        protected MessageContent.SupportingContentItems.MaintenanceLocations maintenanceLocations;
        protected MessageContent.SupportingContentItems.OperatingLocationTypes operatingLocationTypes;
        protected MessageContent.SupportingContentItems.OperatingLocations operatingLocations;
        protected MessageContent.SupportingContentItems.Substances substances;
        protected MessageContent.SupportingContentItems.SpecialEvents specialEvents;
        protected MessageContent.SupportingContentItems.ProductUsagePhases productUsagePhases;
        protected MessageContent.SupportingContentItems.ResourceSpecifications resourceSpecifications;
        protected MessageContent.SupportingContentItems.Trades trades;
        protected MessageContent.SupportingContentItems.Skills skills;
        protected MessageContent.SupportingContentItems.ChangeRequests changeRequests;
        protected MessageContent.SupportingContentItems.CircuitBreakers circuitBreakers;
        protected MessageContent.SupportingContentItems.SecurityClasses securityClasses;
        protected MessageContent.SupportingContentItems.Documents documents;
        protected MessageContent.SupportingContentItems.Organizations organizations;
        protected MessageContent.SupportingContentItems.ApplicabilityStatements applicabilityStatements;
        protected MessageContent.SupportingContentItems.ApplicabilityConditions applicabilityConditions;

        /**
         * Gets the value of the products property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.Products }
         *     
         */
        public MessageContent.SupportingContentItems.Products getProducts() {
            return products;
        }

        /**
         * Sets the value of the products property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.Products }
         *     
         */
        public void setProducts(MessageContent.SupportingContentItems.Products value) {
            this.products = value;
        }

        /**
         * Gets the value of the breakdownElements property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.BreakdownElements }
         *     
         */
        public MessageContent.SupportingContentItems.BreakdownElements getBreakdownElements() {
            return breakdownElements;
        }

        /**
         * Sets the value of the breakdownElements property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.BreakdownElements }
         *     
         */
        public void setBreakdownElements(MessageContent.SupportingContentItems.BreakdownElements value) {
            this.breakdownElements = value;
        }

        /**
         * Gets the value of the parts property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.Parts }
         *     
         */
        public MessageContent.SupportingContentItems.Parts getParts() {
            return parts;
        }

        /**
         * Sets the value of the parts property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.Parts }
         *     
         */
        public void setParts(MessageContent.SupportingContentItems.Parts value) {
            this.parts = value;
        }

        /**
         * Gets the value of the taskRequirements property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.TaskRequirements }
         *     
         */
        public MessageContent.SupportingContentItems.TaskRequirements getTaskRequirements() {
            return taskRequirements;
        }

        /**
         * Sets the value of the taskRequirements property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.TaskRequirements }
         *     
         */
        public void setTaskRequirements(MessageContent.SupportingContentItems.TaskRequirements value) {
            this.taskRequirements = value;
        }

        /**
         * Gets the value of the maintenanceLevels property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.MaintenanceLevels }
         *     
         */
        public MessageContent.SupportingContentItems.MaintenanceLevels getMaintenanceLevels() {
            return maintenanceLevels;
        }

        /**
         * Sets the value of the maintenanceLevels property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.MaintenanceLevels }
         *     
         */
        public void setMaintenanceLevels(MessageContent.SupportingContentItems.MaintenanceLevels value) {
            this.maintenanceLevels = value;
        }

        /**
         * Gets the value of the maintenanceLocations property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.MaintenanceLocations }
         *     
         */
        public MessageContent.SupportingContentItems.MaintenanceLocations getMaintenanceLocations() {
            return maintenanceLocations;
        }

        /**
         * Sets the value of the maintenanceLocations property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.MaintenanceLocations }
         *     
         */
        public void setMaintenanceLocations(MessageContent.SupportingContentItems.MaintenanceLocations value) {
            this.maintenanceLocations = value;
        }

        /**
         * Gets the value of the operatingLocationTypes property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.OperatingLocationTypes }
         *     
         */
        public MessageContent.SupportingContentItems.OperatingLocationTypes getOperatingLocationTypes() {
            return operatingLocationTypes;
        }

        /**
         * Sets the value of the operatingLocationTypes property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.OperatingLocationTypes }
         *     
         */
        public void setOperatingLocationTypes(MessageContent.SupportingContentItems.OperatingLocationTypes value) {
            this.operatingLocationTypes = value;
        }

        /**
         * Gets the value of the operatingLocations property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.OperatingLocations }
         *     
         */
        public MessageContent.SupportingContentItems.OperatingLocations getOperatingLocations() {
            return operatingLocations;
        }

        /**
         * Sets the value of the operatingLocations property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.OperatingLocations }
         *     
         */
        public void setOperatingLocations(MessageContent.SupportingContentItems.OperatingLocations value) {
            this.operatingLocations = value;
        }

        /**
         * Gets the value of the substances property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.Substances }
         *     
         */
        public MessageContent.SupportingContentItems.Substances getSubstances() {
            return substances;
        }

        /**
         * Sets the value of the substances property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.Substances }
         *     
         */
        public void setSubstances(MessageContent.SupportingContentItems.Substances value) {
            this.substances = value;
        }

        /**
         * Gets the value of the specialEvents property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.SpecialEvents }
         *     
         */
        public MessageContent.SupportingContentItems.SpecialEvents getSpecialEvents() {
            return specialEvents;
        }

        /**
         * Sets the value of the specialEvents property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.SpecialEvents }
         *     
         */
        public void setSpecialEvents(MessageContent.SupportingContentItems.SpecialEvents value) {
            this.specialEvents = value;
        }

        /**
         * Gets the value of the productUsagePhases property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.ProductUsagePhases }
         *     
         */
        public MessageContent.SupportingContentItems.ProductUsagePhases getProductUsagePhases() {
            return productUsagePhases;
        }

        /**
         * Sets the value of the productUsagePhases property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.ProductUsagePhases }
         *     
         */
        public void setProductUsagePhases(MessageContent.SupportingContentItems.ProductUsagePhases value) {
            this.productUsagePhases = value;
        }

        /**
         * Gets the value of the resourceSpecifications property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.ResourceSpecifications }
         *     
         */
        public MessageContent.SupportingContentItems.ResourceSpecifications getResourceSpecifications() {
            return resourceSpecifications;
        }

        /**
         * Sets the value of the resourceSpecifications property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.ResourceSpecifications }
         *     
         */
        public void setResourceSpecifications(MessageContent.SupportingContentItems.ResourceSpecifications value) {
            this.resourceSpecifications = value;
        }

        /**
         * Gets the value of the trades property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.Trades }
         *     
         */
        public MessageContent.SupportingContentItems.Trades getTrades() {
            return trades;
        }

        /**
         * Sets the value of the trades property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.Trades }
         *     
         */
        public void setTrades(MessageContent.SupportingContentItems.Trades value) {
            this.trades = value;
        }

        /**
         * Gets the value of the skills property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.Skills }
         *     
         */
        public MessageContent.SupportingContentItems.Skills getSkills() {
            return skills;
        }

        /**
         * Sets the value of the skills property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.Skills }
         *     
         */
        public void setSkills(MessageContent.SupportingContentItems.Skills value) {
            this.skills = value;
        }

        /**
         * Gets the value of the changeRequests property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.ChangeRequests }
         *     
         */
        public MessageContent.SupportingContentItems.ChangeRequests getChangeRequests() {
            return changeRequests;
        }

        /**
         * Sets the value of the changeRequests property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.ChangeRequests }
         *     
         */
        public void setChangeRequests(MessageContent.SupportingContentItems.ChangeRequests value) {
            this.changeRequests = value;
        }

        /**
         * Gets the value of the circuitBreakers property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.CircuitBreakers }
         *     
         */
        public MessageContent.SupportingContentItems.CircuitBreakers getCircuitBreakers() {
            return circuitBreakers;
        }

        /**
         * Sets the value of the circuitBreakers property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.CircuitBreakers }
         *     
         */
        public void setCircuitBreakers(MessageContent.SupportingContentItems.CircuitBreakers value) {
            this.circuitBreakers = value;
        }

        /**
         * Gets the value of the securityClasses property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.SecurityClasses }
         *     
         */
        public MessageContent.SupportingContentItems.SecurityClasses getSecurityClasses() {
            return securityClasses;
        }

        /**
         * Sets the value of the securityClasses property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.SecurityClasses }
         *     
         */
        public void setSecurityClasses(MessageContent.SupportingContentItems.SecurityClasses value) {
            this.securityClasses = value;
        }

        /**
         * Gets the value of the documents property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.Documents }
         *     
         */
        public MessageContent.SupportingContentItems.Documents getDocuments() {
            return documents;
        }

        /**
         * Sets the value of the documents property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.Documents }
         *     
         */
        public void setDocuments(MessageContent.SupportingContentItems.Documents value) {
            this.documents = value;
        }

        /**
         * Gets the value of the organizations property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.Organizations }
         *     
         */
        public MessageContent.SupportingContentItems.Organizations getOrganizations() {
            return organizations;
        }

        /**
         * Sets the value of the organizations property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.Organizations }
         *     
         */
        public void setOrganizations(MessageContent.SupportingContentItems.Organizations value) {
            this.organizations = value;
        }

        /**
         * Gets the value of the applicabilityStatements property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.ApplicabilityStatements }
         *     
         */
        public MessageContent.SupportingContentItems.ApplicabilityStatements getApplicabilityStatements() {
            return applicabilityStatements;
        }

        /**
         * Sets the value of the applicabilityStatements property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.ApplicabilityStatements }
         *     
         */
        public void setApplicabilityStatements(MessageContent.SupportingContentItems.ApplicabilityStatements value) {
            this.applicabilityStatements = value;
        }

        /**
         * Gets the value of the applicabilityConditions property.
         * 
         * @return
         *     possible object is
         *     {@link MessageContent.SupportingContentItems.ApplicabilityConditions }
         *     
         */
        public MessageContent.SupportingContentItems.ApplicabilityConditions getApplicabilityConditions() {
            return applicabilityConditions;
        }

        /**
         * Sets the value of the applicabilityConditions property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageContent.SupportingContentItems.ApplicabilityConditions }
         *     
         */
        public void setApplicabilityConditions(MessageContent.SupportingContentItems.ApplicabilityConditions value) {
            this.applicabilityConditions = value;
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
         *         &lt;element name="cond" type="{http://www.asd-europe.org/s-series/s3000l}conditionType" maxOccurs="unbounded" minOccurs="0"/>
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
            "cond"
        })
        public static class ApplicabilityConditions {

            protected List<ConditionType> cond;

            /**
             * Gets the value of the cond property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the cond property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCond().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ConditionType }
             * 
             * 
             */
            public List<ConditionType> getCond() {
                if (cond == null) {
                    cond = new ArrayList<ConditionType>();
                }
                return this.cond;
            }

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
         *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityStatementNonAbstractClasses" maxOccurs="unbounded"/>
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
            "applicabilityStatementNonAbstractClasses"
        })
        public static class ApplicabilityStatements {

            @XmlElements({
                @XmlElement(name = "applicDef", type = ApplicabilityStatement.class, nillable = true),
                @XmlElement(name = "datedApplicDef", type = DatedApplicabilityStatement.class, nillable = true)
            })
            protected List<Object> applicabilityStatementNonAbstractClasses;

            /**
             * Gets the value of the applicabilityStatementNonAbstractClasses property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the applicabilityStatementNonAbstractClasses property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getApplicabilityStatementNonAbstractClasses().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ApplicabilityStatement }
             * {@link DatedApplicabilityStatement }
             * 
             * 
             */
            public List<Object> getApplicabilityStatementNonAbstractClasses() {
                if (applicabilityStatementNonAbstractClasses == null) {
                    applicabilityStatementNonAbstractClasses = new ArrayList<Object>();
                }
                return this.applicabilityStatementNonAbstractClasses;
            }

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
         *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}breakdownElementNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
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
            "breakdownElementNonAbstractClasses"
        })
        public static class BreakdownElements {

            @XmlElements({
                @XmlElement(name = "beAggr", type = AggregatedElement.class, nillable = true),
                @XmlElement(name = "beHw", type = HardwareElement.class, nillable = true),
                @XmlElement(name = "beSw", type = SoftwareElement.class, nillable = true),
                @XmlElement(name = "beZone", type = ZoneElement.class, nillable = true)
            })
            protected List<Object> breakdownElementNonAbstractClasses;

            /**
             * Gets the value of the breakdownElementNonAbstractClasses property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the breakdownElementNonAbstractClasses property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getBreakdownElementNonAbstractClasses().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AggregatedElement }
             * {@link HardwareElement }
             * {@link SoftwareElement }
             * {@link ZoneElement }
             * 
             * 
             */
            public List<Object> getBreakdownElementNonAbstractClasses() {
                if (breakdownElementNonAbstractClasses == null) {
                    breakdownElementNonAbstractClasses = new ArrayList<Object>();
                }
                return this.breakdownElementNonAbstractClasses;
            }

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
         *         &lt;element name="cr" type="{http://www.asd-europe.org/s-series/s3000l}changeRequest" maxOccurs="unbounded" minOccurs="0"/>
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
            "cr"
        })
        public static class ChangeRequests {

            protected List<ChangeRequest> cr;

            /**
             * Gets the value of the cr property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the cr property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCr().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ChangeRequest }
             * 
             * 
             */
            public List<ChangeRequest> getCr() {
                if (cr == null) {
                    cr = new ArrayList<ChangeRequest>();
                }
                return this.cr;
            }

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
         *         &lt;element name="cb" type="{http://www.asd-europe.org/s-series/s3000l}circuitBreaker" maxOccurs="unbounded" minOccurs="0"/>
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
            "cb"
        })
        public static class CircuitBreakers {

            protected List<CircuitBreaker> cb;

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
             * {@link CircuitBreaker }
             * 
             * 
             */
            public List<CircuitBreaker> getCb() {
                if (cb == null) {
                    cb = new ArrayList<CircuitBreaker>();
                }
                return this.cb;
            }

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
         *       &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}documentNonAbstractClasses" maxOccurs="unbounded"/>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "documentNonAbstractClasses"
        })
        public static class Documents {

            @XmlElements({
                @XmlElement(name = "extDoc", type = ExternalDocument.class, nillable = true),
                @XmlElement(name = "s1000dPM", type = S1000DPublicationModule.class, nillable = true),
                @XmlElement(name = "s1000dDM", type = S1000DDataModule.class, nillable = true)
            })
            protected List<Object> documentNonAbstractClasses;

            /**
             * Gets the value of the documentNonAbstractClasses property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the documentNonAbstractClasses property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDocumentNonAbstractClasses().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ExternalDocument }
             * {@link S1000DPublicationModule }
             * {@link S1000DDataModule }
             * 
             * 
             */
            public List<Object> getDocumentNonAbstractClasses() {
                if (documentNonAbstractClasses == null) {
                    documentNonAbstractClasses = new ArrayList<Object>();
                }
                return this.documentNonAbstractClasses;
            }

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
         *         &lt;element name="mlv" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceLevel" maxOccurs="unbounded"/>
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
            "mlv"
        })
        public static class MaintenanceLevels {

            @XmlElement(required = true)
            protected List<MaintenanceLevel> mlv;

            /**
             * Gets the value of the mlv property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the mlv property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getMlv().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link MaintenanceLevel }
             * 
             * 
             */
            public List<MaintenanceLevel> getMlv() {
                if (mlv == null) {
                    mlv = new ArrayList<MaintenanceLevel>();
                }
                return this.mlv;
            }

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
         *         &lt;element name="mLoc" type="{http://www.asd-europe.org/s-series/s3000l}maintenanceLocation" maxOccurs="unbounded"/>
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
            "mLoc"
        })
        public static class MaintenanceLocations {

            @XmlElement(required = true)
            protected List<MaintenanceLocation> mLoc;

            /**
             * Gets the value of the mLoc property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the mLoc property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getMLoc().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link MaintenanceLocation }
             * 
             * 
             */
            public List<MaintenanceLocation> getMLoc() {
                if (mLoc == null) {
                    mLoc = new ArrayList<MaintenanceLocation>();
                }
                return this.mLoc;
            }

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
         *         &lt;element name="opLocType" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocationType" maxOccurs="unbounded"/>
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
            "opLocType"
        })
        public static class OperatingLocationTypes {

            @XmlElement(required = true)
            protected List<OperatingLocationType> opLocType;

            /**
             * Gets the value of the opLocType property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the opLocType property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOpLocType().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link OperatingLocationType }
             * 
             * 
             */
            public List<OperatingLocationType> getOpLocType() {
                if (opLocType == null) {
                    opLocType = new ArrayList<OperatingLocationType>();
                }
                return this.opLocType;
            }

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
         *         &lt;element name="opLoc" type="{http://www.asd-europe.org/s-series/s3000l}operatingLocation" maxOccurs="unbounded"/>
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
            "opLoc"
        })
        public static class OperatingLocations {

            @XmlElement(required = true)
            protected List<OperatingLocation> opLoc;

            /**
             * Gets the value of the opLoc property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the opLoc property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOpLoc().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link OperatingLocation }
             * 
             * 
             */
            public List<OperatingLocation> getOpLoc() {
                if (opLoc == null) {
                    opLoc = new ArrayList<OperatingLocation>();
                }
                return this.opLoc;
            }

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
         *         &lt;element name="org" type="{http://www.asd-europe.org/s-series/s3000l}organization" maxOccurs="unbounded" minOccurs="0"/>
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
            "org"
        })
        public static class Organizations {

            protected List<Organization> org;

            /**
             * Gets the value of the org property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the org property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOrg().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Organization }
             * 
             * 
             */
            public List<Organization> getOrg() {
                if (org == null) {
                    org = new ArrayList<Organization>();
                }
                return this.org;
            }

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
         *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}partAsDesignedNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
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
            "partAsDesignedNonAbstractClasses"
        })
        public static class Parts {

            @XmlElements({
                @XmlElement(name = "hwPart", type = HardwarePartAsDesigned.class, nillable = true),
                @XmlElement(name = "hwConfPart", type = AllowedProductConfigurationHardwarePartAsDesigned.class, nillable = true),
                @XmlElement(name = "swPart", type = SoftwarePartAsDesigned.class, nillable = true)
            })
            protected List<Object> partAsDesignedNonAbstractClasses;

            /**
             * Gets the value of the partAsDesignedNonAbstractClasses property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the partAsDesignedNonAbstractClasses property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPartAsDesignedNonAbstractClasses().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link HardwarePartAsDesigned }
             * {@link AllowedProductConfigurationHardwarePartAsDesigned }
             * {@link SoftwarePartAsDesigned }
             * 
             * 
             */
            public List<Object> getPartAsDesignedNonAbstractClasses() {
                if (partAsDesignedNonAbstractClasses == null) {
                    partAsDesignedNonAbstractClasses = new ArrayList<Object>();
                }
                return this.partAsDesignedNonAbstractClasses;
            }

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
         *         &lt;element name="usagePhaseDef" type="{http://www.asd-europe.org/s-series/s3000l}productUsagePhaseClass" maxOccurs="unbounded"/>
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
            "usagePhaseDef"
        })
        public static class ProductUsagePhases {

            @XmlElement(required = true)
            protected List<ProductUsagePhaseClass> usagePhaseDef;

            /**
             * Gets the value of the usagePhaseDef property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the usagePhaseDef property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getUsagePhaseDef().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ProductUsagePhaseClass }
             * 
             * 
             */
            public List<ProductUsagePhaseClass> getUsagePhaseDef() {
                if (usagePhaseDef == null) {
                    usagePhaseDef = new ArrayList<ProductUsagePhaseClass>();
                }
                return this.usagePhaseDef;
            }

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
         *         &lt;element name="prod" type="{http://www.asd-europe.org/s-series/s3000l}product" maxOccurs="unbounded" minOccurs="0"/>
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
            "prod"
        })
        public static class Products {

            protected List<Product> prod;

            /**
             * Gets the value of the prod property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the prod property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getProd().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Product }
             * 
             * 
             */
            public List<Product> getProd() {
                if (prod == null) {
                    prod = new ArrayList<Product>();
                }
                return this.prod;
            }

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
         *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}resourceSpecificationNonAbstractClasses" maxOccurs="unbounded"/>
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
            "resourceSpecificationNonAbstractClasses"
        })
        public static class ResourceSpecifications {

            @XmlElements({
                @XmlElement(name = "mtrlResSpec", type = MaterialResourceSpecification.class, nillable = true),
                @XmlElement(name = "facResSpec", type = FacilityResourceSpecification.class, nillable = true)
            })
            protected List<Object> resourceSpecificationNonAbstractClasses;

            /**
             * Gets the value of the resourceSpecificationNonAbstractClasses property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the resourceSpecificationNonAbstractClasses property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getResourceSpecificationNonAbstractClasses().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link MaterialResourceSpecification }
             * {@link FacilityResourceSpecification }
             * 
             * 
             */
            public List<Object> getResourceSpecificationNonAbstractClasses() {
                if (resourceSpecificationNonAbstractClasses == null) {
                    resourceSpecificationNonAbstractClasses = new ArrayList<Object>();
                }
                return this.resourceSpecificationNonAbstractClasses;
            }

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
         *         &lt;element name="secClassDef" type="{http://www.asd-europe.org/s-series/s3000l}securityClassClass" maxOccurs="unbounded" minOccurs="0"/>
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
            "secClassDef"
        })
        public static class SecurityClasses {

            protected List<SecurityClassClass> secClassDef;

            /**
             * Gets the value of the secClassDef property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the secClassDef property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSecClassDef().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link SecurityClassClass }
             * 
             * 
             */
            public List<SecurityClassClass> getSecClassDef() {
                if (secClassDef == null) {
                    secClassDef = new ArrayList<SecurityClassClass>();
                }
                return this.secClassDef;
            }

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
         *         &lt;element name="skill" type="{http://www.asd-europe.org/s-series/s3000l}skill" maxOccurs="unbounded" minOccurs="0"/>
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
            "skill"
        })
        public static class Skills {

            protected List<Skill> skill;

            /**
             * Gets the value of the skill property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the skill property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSkill().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Skill }
             * 
             * 
             */
            public List<Skill> getSkill() {
                if (skill == null) {
                    skill = new ArrayList<Skill>();
                }
                return this.skill;
            }

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
         *         &lt;element name="sEvnt" type="{http://www.asd-europe.org/s-series/s3000l}specialEvent" maxOccurs="unbounded"/>
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
            "sEvnt"
        })
        public static class SpecialEvents {

            @XmlElement(required = true)
            protected List<SpecialEvent> sEvnt;

            /**
             * Gets the value of the sEvnt property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the sEvnt property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSEvnt().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link SpecialEvent }
             * 
             * 
             */
            public List<SpecialEvent> getSEvnt() {
                if (sEvnt == null) {
                    sEvnt = new ArrayList<SpecialEvent>();
                }
                return this.sEvnt;
            }

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
         *         &lt;element name="subs" type="{http://www.asd-europe.org/s-series/s3000l}substanceDefinition" maxOccurs="unbounded"/>
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
            "subs"
        })
        public static class Substances {

            @XmlElement(required = true)
            protected List<SubstanceDefinition> subs;

            /**
             * Gets the value of the subs property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the subs property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSubs().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link SubstanceDefinition }
             * 
             * 
             */
            public List<SubstanceDefinition> getSubs() {
                if (subs == null) {
                    subs = new ArrayList<SubstanceDefinition>();
                }
                return this.subs;
            }

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
         *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}taskRequirementNonAbstractClasses" maxOccurs="unbounded" minOccurs="0"/>
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
            "taskRequirementNonAbstractClasses"
        })
        public static class TaskRequirements {

            @XmlElements({
                @XmlElement(name = "taskReq", type = TaskRequirement.class, nillable = true),
                @XmlElement(name = "authTaskReq", type = AuthorityDrivenTaskRequirement.class, nillable = true)
            })
            protected List<Object> taskRequirementNonAbstractClasses;

            /**
             * Gets the value of the taskRequirementNonAbstractClasses property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the taskRequirementNonAbstractClasses property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTaskRequirementNonAbstractClasses().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TaskRequirement }
             * {@link AuthorityDrivenTaskRequirement }
             * 
             * 
             */
            public List<Object> getTaskRequirementNonAbstractClasses() {
                if (taskRequirementNonAbstractClasses == null) {
                    taskRequirementNonAbstractClasses = new ArrayList<Object>();
                }
                return this.taskRequirementNonAbstractClasses;
            }

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
         *         &lt;element name="trade" type="{http://www.asd-europe.org/s-series/s3000l}trade" maxOccurs="unbounded" minOccurs="0"/>
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
            "trade"
        })
        public static class Trades {

            protected List<Trade> trade;

            /**
             * Gets the value of the trade property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the trade property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTrade().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Trade }
             * 
             * 
             */
            public List<Trade> getTrade() {
                if (trade == null) {
                    trade = new ArrayList<Trade>();
                }
                return this.trade;
            }

        }

    }

}
