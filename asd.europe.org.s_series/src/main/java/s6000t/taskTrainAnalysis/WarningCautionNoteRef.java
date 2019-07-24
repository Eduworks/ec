
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for warningCautionNoteRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="warningCautionNoteRef">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="wcnId" type="{http://www.asd-europe.org/s-series/s3000l}warningCautionNoteIdentifier"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uidRef">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.asd-europe.org/s-series/s3000l}uidRef">
 *             &lt;pattern value="wcn[1-9][0-9]*"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "warningCautionNoteRef", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "wcnId"
})
public class WarningCautionNoteRef {

    protected WarningCautionNoteIdentifier wcnId;
    @XmlAttribute(name = "uidRef")
    @XmlIDREF
    protected Object uidRef;

    /**
     * Gets the value of the wcnId property.
     * 
     * @return
     *     possible object is
     *     {@link WarningCautionNoteIdentifier }
     *     
     */
    public WarningCautionNoteIdentifier getWcnId() {
        return wcnId;
    }

    /**
     * Sets the value of the wcnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link WarningCautionNoteIdentifier }
     *     
     */
    public void setWcnId(WarningCautionNoteIdentifier value) {
        this.wcnId = value;
    }

    /**
     * Gets the value of the uidRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getUidRef() {
        return uidRef;
    }

    /**
     * Sets the value of the uidRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setUidRef(Object value) {
        this.uidRef = value;
    }

}
