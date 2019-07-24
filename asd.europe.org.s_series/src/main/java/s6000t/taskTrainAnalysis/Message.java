
package s6000t.taskTrainAnalysis;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for message complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="message">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="msgId" type="{http://www.asd-europe.org/s-series/s3000l}messageIdentifier" minOccurs="0"/>
 *         &lt;element name="msgDate" type="{http://www.asd-europe.org/s-series/s3000l}messageCreationDate" minOccurs="0"/>
 *         &lt;element name="msgLang" type="{http://www.asd-europe.org/s-series/s3000l}messageLanguage" minOccurs="0"/>
 *         &lt;element name="msgStatus" type="{http://www.asd-europe.org/s-series/s3000l}messageContentStatus" minOccurs="0"/>
 *         &lt;element name="msgSend" type="{http://www.asd-europe.org/s-series/s3000l}messageSender" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="msgReceive" type="{http://www.asd-europe.org/s-series/s3000l}messageReceiver" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="msgContext" type="{http://www.asd-europe.org/s-series/s3000l}messageContext" minOccurs="0"/>
 *         &lt;element name="msgContent" type="{http://www.asd-europe.org/s-series/s3000l}messageContent" minOccurs="0"/>
 *         &lt;element name="relatedMsg" type="{http://www.asd-europe.org/s-series/s3000l}messageRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}securityClassificationItem"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}remarkAssignmentItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="msg[1-9][0-9]*"/>
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
@XmlType(name = "message", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "msgId",
    "msgDate",
    "msgLang",
    "msgStatus",
    "msgSend",
    "msgReceive",
    "msgContext",
    "msgContent",
    "relatedMsg",
    "secs",
    "rmks"
})
public class Message {

    @XmlElementRef(name = "msgId", type = JAXBElement.class, required = false)
    protected JAXBElement<MessageIdentifier> msgId;
    @XmlElementRef(name = "msgDate", type = JAXBElement.class, required = false)
    protected JAXBElement<MessageCreationDate> msgDate;
    @XmlElementRef(name = "msgLang", type = JAXBElement.class, required = false)
    protected JAXBElement<LanguageCodeValues> msgLang;
    @XmlElementRef(name = "msgStatus", type = JAXBElement.class, required = false)
    protected JAXBElement<MessageContentStatus> msgStatus;
    protected List<MessageSender> msgSend;
    protected List<MessageReceiver> msgReceive;
    @XmlElementRef(name = "msgContext", type = JAXBElement.class, required = false)
    protected JAXBElement<MessageContext> msgContext;
    @XmlElementRef(name = "msgContent", type = JAXBElement.class, required = false)
    protected JAXBElement<MessageContent> msgContent;
    protected List<MessageRelationship> relatedMsg;
    @XmlElementRef(name = "secs", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.OperationalTask.Secs> secs;
    @XmlElementRef(name = "rmks", type = JAXBElement.class, required = false)
    protected JAXBElement<s6000t.taskTrainAnalysis.ConditionInstance.Rmks> rmks;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the msgId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MessageIdentifier }{@code >}
     *     
     */
    public JAXBElement<MessageIdentifier> getMsgId() {
        return msgId;
    }

    /**
     * Sets the value of the msgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MessageIdentifier }{@code >}
     *     
     */
    public void setMsgId(JAXBElement<MessageIdentifier> value) {
        this.msgId = value;
    }

    /**
     * Gets the value of the msgDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MessageCreationDate }{@code >}
     *     
     */
    public JAXBElement<MessageCreationDate> getMsgDate() {
        return msgDate;
    }

    /**
     * Sets the value of the msgDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MessageCreationDate }{@code >}
     *     
     */
    public void setMsgDate(JAXBElement<MessageCreationDate> value) {
        this.msgDate = value;
    }

    /**
     * Gets the value of the msgLang property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LanguageCodeValues }{@code >}
     *     
     */
    public JAXBElement<LanguageCodeValues> getMsgLang() {
        return msgLang;
    }

    /**
     * Sets the value of the msgLang property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LanguageCodeValues }{@code >}
     *     
     */
    public void setMsgLang(JAXBElement<LanguageCodeValues> value) {
        this.msgLang = value;
    }

    /**
     * Gets the value of the msgStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MessageContentStatus }{@code >}
     *     
     */
    public JAXBElement<MessageContentStatus> getMsgStatus() {
        return msgStatus;
    }

    /**
     * Sets the value of the msgStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MessageContentStatus }{@code >}
     *     
     */
    public void setMsgStatus(JAXBElement<MessageContentStatus> value) {
        this.msgStatus = value;
    }

    /**
     * Gets the value of the msgSend property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the msgSend property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMsgSend().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageSender }
     * 
     * 
     */
    public List<MessageSender> getMsgSend() {
        if (msgSend == null) {
            msgSend = new ArrayList<MessageSender>();
        }
        return this.msgSend;
    }

    /**
     * Gets the value of the msgReceive property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the msgReceive property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMsgReceive().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageReceiver }
     * 
     * 
     */
    public List<MessageReceiver> getMsgReceive() {
        if (msgReceive == null) {
            msgReceive = new ArrayList<MessageReceiver>();
        }
        return this.msgReceive;
    }

    /**
     * Gets the value of the msgContext property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MessageContext }{@code >}
     *     
     */
    public JAXBElement<MessageContext> getMsgContext() {
        return msgContext;
    }

    /**
     * Sets the value of the msgContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MessageContext }{@code >}
     *     
     */
    public void setMsgContext(JAXBElement<MessageContext> value) {
        this.msgContext = value;
    }

    /**
     * Gets the value of the msgContent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MessageContent }{@code >}
     *     
     */
    public JAXBElement<MessageContent> getMsgContent() {
        return msgContent;
    }

    /**
     * Sets the value of the msgContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MessageContent }{@code >}
     *     
     */
    public void setMsgContent(JAXBElement<MessageContent> value) {
        this.msgContent = value;
    }

    /**
     * Gets the value of the relatedMsg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedMsg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedMsg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageRelationship }
     * 
     * 
     */
    public List<MessageRelationship> getRelatedMsg() {
        if (relatedMsg == null) {
            relatedMsg = new ArrayList<MessageRelationship>();
        }
        return this.relatedMsg;
    }

    /**
     * Gets the value of the secs property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.OperationalTask.Secs }{@code >}
     *     
     */
    public JAXBElement<s6000t.taskTrainAnalysis.OperationalTask.Secs> getSecs() {
        return secs;
    }

    /**
     * Sets the value of the secs property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link s6000t.taskTrainAnalysis.OperationalTask.Secs }{@code >}
     *     
     */
    public void setSecs(JAXBElement<s6000t.taskTrainAnalysis.OperationalTask.Secs> value) {
        this.secs = value;
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
