
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productVariantReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productVariantReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="prodId" type="{http://www.asd-europe.org/s-series/s3000l}productIdentifier"/>
 *         &lt;element name="prodVarId" type="{http://www.asd-europe.org/s-series/s3000l}productVariantIdentifier"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uidRef">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.asd-europe.org/s-series/s3000l}uidRef">
 *             &lt;pattern value="prodv[1-9][0-9]*"/>
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
@XmlType(name = "productVariantReference", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "prodId",
    "prodVarId"
})
public class ProductVariantReference {

    protected ProductIdentifier prodId;
    protected ProductVariantIdentifier prodVarId;
    @XmlAttribute(name = "uidRef")
    @XmlIDREF
    protected Object uidRef;

    /**
     * Gets the value of the prodId property.
     * 
     * @return
     *     possible object is
     *     {@link ProductIdentifier }
     *     
     */
    public ProductIdentifier getProdId() {
        return prodId;
    }

    /**
     * Sets the value of the prodId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductIdentifier }
     *     
     */
    public void setProdId(ProductIdentifier value) {
        this.prodId = value;
    }

    /**
     * Gets the value of the prodVarId property.
     * 
     * @return
     *     possible object is
     *     {@link ProductVariantIdentifier }
     *     
     */
    public ProductVariantIdentifier getProdVarId() {
        return prodVarId;
    }

    /**
     * Sets the value of the prodVarId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductVariantIdentifier }
     *     
     */
    public void setProdVarId(ProductVariantIdentifier value) {
        this.prodVarId = value;
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
