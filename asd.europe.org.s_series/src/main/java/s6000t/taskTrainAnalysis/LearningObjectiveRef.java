
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for learningObjectiveRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="learningObjectiveRef">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="loId" type="{http://www.asd-europe.org/s-series/s3000l}learningObjectiveIdentifier"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uidRef">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.asd-europe.org/s-series/s3000l}uidRef">
 *             &lt;pattern value="loobj[1-9][0-9]*"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="uriRef" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "learningObjectiveRef", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "loId"
})
public class LearningObjectiveRef {

    protected LearningObjectiveIdentifier loId;
    @XmlAttribute(name = "uidRef")
    @XmlIDREF
    protected Object uidRef;
    @XmlAttribute(name = "uriRef")
    @XmlSchemaType(name = "anyURI")
    protected String uriRef;

    /**
     * Gets the value of the loId property.
     * 
     * @return
     *     possible object is
     *     {@link LearningObjectiveIdentifier }
     *     
     */
    public LearningObjectiveIdentifier getLoId() {
        return loId;
    }

    /**
     * Sets the value of the loId property.
     * 
     * @param value
     *     allowed object is
     *     {@link LearningObjectiveIdentifier }
     *     
     */
    public void setLoId(LearningObjectiveIdentifier value) {
        this.loId = value;
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

    /**
     * Gets the value of the uriRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUriRef() {
        return uriRef;
    }

    /**
     * Sets the value of the uriRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUriRef(String value) {
        this.uriRef = value;
    }

}
