
package s6000t.taskTrainAnalysis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for productVariantIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productVariantIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.asd-europe.org/s-series/s3000l}nonEmptyString"/>
 *         &lt;element name="class" type="{http://www.asd-europe.org/spec/validValues}productVariantIdentifierClassValues" minOccurs="0"/>
 *         &lt;element name="setBy" type="{http://www.asd-europe.org/s-series/s3000l}organizationReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productVariantIdentifier", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "id",
    "clazz",
    "setBy"
})
public class ProductVariantIdentifier {

    @XmlElement(required = true, nillable = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElementRef(name = "class", type = JAXBElement.class, required = false)
    protected JAXBElement<ProductVariantIdentifierClassValues> clazz;
    @XmlElementRef(name = "setBy", type = JAXBElement.class, required = false)
    protected JAXBElement<OrganizationReference> setBy;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductVariantIdentifierClassValues }{@code >}
     *     
     */
    public JAXBElement<ProductVariantIdentifierClassValues> getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductVariantIdentifierClassValues }{@code >}
     *     
     */
    public void setClazz(JAXBElement<ProductVariantIdentifierClassValues> value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the setBy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrganizationReference }{@code >}
     *     
     */
    public JAXBElement<OrganizationReference> getSetBy() {
        return setBy;
    }

    /**
     * Sets the value of the setBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrganizationReference }{@code >}
     *     
     */
    public void setSetBy(JAXBElement<OrganizationReference> value) {
        this.setBy = value;
    }

}
