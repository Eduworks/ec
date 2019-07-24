
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for partAsDesignedPartsListEntryReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="partAsDesignedPartsListEntryReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="partId" type="{http://www.asd-europe.org/s-series/s3000l}partIdentifier"/>
 *         &lt;element name="pListType" type="{http://www.asd-europe.org/s-series/s3000l}partsListType"/>
 *         &lt;element name="pListRevId" type="{http://www.asd-europe.org/s-series/s3000l}partsListRevisionIdentifier"/>
 *         &lt;element name="posId" type="{http://www.asd-europe.org/s-series/s3000l}partsListEntryIdentifier"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uidRef">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.asd-europe.org/s-series/s3000l}uidRef">
 *             &lt;pattern value="ple[1-9][0-9]*"/>
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
@XmlType(name = "partAsDesignedPartsListEntryReference", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "partId",
    "pListType",
    "pListRevId",
    "posId"
})
public class PartAsDesignedPartsListEntryReference {

    protected PartIdentifier partId;
    protected PartsListType pListType;
    protected PartsListRevisionIdentifier pListRevId;
    protected PartsListEntryIdentifier posId;
    @XmlAttribute(name = "uidRef")
    @XmlIDREF
    protected Object uidRef;

    /**
     * Gets the value of the partId property.
     * 
     * @return
     *     possible object is
     *     {@link PartIdentifier }
     *     
     */
    public PartIdentifier getPartId() {
        return partId;
    }

    /**
     * Sets the value of the partId property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartIdentifier }
     *     
     */
    public void setPartId(PartIdentifier value) {
        this.partId = value;
    }

    /**
     * Gets the value of the pListType property.
     * 
     * @return
     *     possible object is
     *     {@link PartsListType }
     *     
     */
    public PartsListType getPListType() {
        return pListType;
    }

    /**
     * Sets the value of the pListType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartsListType }
     *     
     */
    public void setPListType(PartsListType value) {
        this.pListType = value;
    }

    /**
     * Gets the value of the pListRevId property.
     * 
     * @return
     *     possible object is
     *     {@link PartsListRevisionIdentifier }
     *     
     */
    public PartsListRevisionIdentifier getPListRevId() {
        return pListRevId;
    }

    /**
     * Sets the value of the pListRevId property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartsListRevisionIdentifier }
     *     
     */
    public void setPListRevId(PartsListRevisionIdentifier value) {
        this.pListRevId = value;
    }

    /**
     * Gets the value of the posId property.
     * 
     * @return
     *     possible object is
     *     {@link PartsListEntryIdentifier }
     *     
     */
    public PartsListEntryIdentifier getPosId() {
        return posId;
    }

    /**
     * Sets the value of the posId property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartsListEntryIdentifier }
     *     
     */
    public void setPosId(PartsListEntryIdentifier value) {
        this.posId = value;
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
