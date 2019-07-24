
package s6000t.taskTrainAnalysis;

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
 * <p>Java class for changeRequestTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="changeRequestTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}lsaCandidateInterfaceRealizedByRef"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="crtgt[1-9][0-9]*"/>
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
@XmlType(name = "changeRequestTarget", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "beRef",
    "partRef"
})
public class ChangeRequestTarget {

    @XmlElementRef(name = "beRef", type = JAXBElement.class, required = false)
    protected JAXBElement<BreakdownElementReference> beRef;
    @XmlElementRef(name = "partRef", type = JAXBElement.class, required = false)
    protected JAXBElement<PartAsDesignedReference> partRef;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the beRef property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BreakdownElementReference }{@code >}
     *     
     */
    public JAXBElement<BreakdownElementReference> getBeRef() {
        return beRef;
    }

    /**
     * Sets the value of the beRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BreakdownElementReference }{@code >}
     *     
     */
    public void setBeRef(JAXBElement<BreakdownElementReference> value) {
        this.beRef = value;
    }

    /**
     * Gets the value of the partRef property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PartAsDesignedReference }{@code >}
     *     
     */
    public JAXBElement<PartAsDesignedReference> getPartRef() {
        return partRef;
    }

    /**
     * Sets the value of the partRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PartAsDesignedReference }{@code >}
     *     
     */
    public void setPartRef(JAXBElement<PartAsDesignedReference> value) {
        this.partRef = value;
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
