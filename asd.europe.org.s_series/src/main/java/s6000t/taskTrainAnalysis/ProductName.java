
package s6000t.taskTrainAnalysis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for productName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descr" type="{http://www.asd-europe.org/s-series/s3000l}nonEmptyString"/>
 *         &lt;element name="lang" type="{http://www.asd-europe.org/spec/validValues}languageCodeValues" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="providedBy" type="{http://www.asd-europe.org/s-series/s3000l}organizationReference" minOccurs="0"/>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityAssignmentItem"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productName", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "descr",
    "lang",
    "date",
    "providedBy",
    "applic"
})
public class ProductName {

    @XmlElement(required = true, nillable = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String descr;
    @XmlElementRef(name = "lang", type = JAXBElement.class, required = false)
    protected JAXBElement<LanguageCodeValues> lang;
    @XmlElementRef(name = "date", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> date;
    @XmlElementRef(name = "providedBy", type = JAXBElement.class, required = false)
    protected JAXBElement<OrganizationReference> providedBy;
    @XmlElementRef(name = "applic", type = JAXBElement.class, required = false)
    protected JAXBElement<ProductName.Applic> applic;

    /**
     * Gets the value of the descr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescr() {
        return descr;
    }

    /**
     * Sets the value of the descr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescr(String value) {
        this.descr = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LanguageCodeValues }{@code >}
     *     
     */
    public JAXBElement<LanguageCodeValues> getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LanguageCodeValues }{@code >}
     *     
     */
    public void setLang(JAXBElement<LanguageCodeValues> value) {
        this.lang = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDate(JAXBElement<XMLGregorianCalendar> value) {
        this.date = value;
    }

    /**
     * Gets the value of the providedBy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrganizationReference }{@code >}
     *     
     */
    public JAXBElement<OrganizationReference> getProvidedBy() {
        return providedBy;
    }

    /**
     * Sets the value of the providedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrganizationReference }{@code >}
     *     
     */
    public void setProvidedBy(JAXBElement<OrganizationReference> value) {
        this.providedBy = value;
    }

    /**
     * Gets the value of the applic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductName.Applic }{@code >}
     *     
     */
    public JAXBElement<ProductName.Applic> getApplic() {
        return applic;
    }

    /**
     * Sets the value of the applic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductName.Applic }{@code >}
     *     
     */
    public void setApplic(JAXBElement<ProductName.Applic> value) {
        this.applic = value;
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
     *       &lt;choice>
     *         &lt;sequence>
     *           &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}applicabilityStatementNonAbstractClasses"/>
     *         &lt;/sequence>
     *         &lt;sequence>
     *           &lt;element name="applicRef" type="{http://www.asd-europe.org/s-series/s3000l}applicabilityStatementReference"/>
     *         &lt;/sequence>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "applicDef",
        "datedApplicDef",
        "applicRef"
    })
    public static class Applic {

        @XmlElementRef(name = "applicDef", type = JAXBElement.class, required = false)
        protected JAXBElement<ApplicabilityStatement> applicDef;
        @XmlElementRef(name = "datedApplicDef", type = JAXBElement.class, required = false)
        protected JAXBElement<DatedApplicabilityStatement> datedApplicDef;
        protected ApplicabilityStatementReference applicRef;

        /**
         * Gets the value of the applicDef property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link ApplicabilityStatement }{@code >}
         *     
         */
        public JAXBElement<ApplicabilityStatement> getApplicDef() {
            return applicDef;
        }

        /**
         * Sets the value of the applicDef property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link ApplicabilityStatement }{@code >}
         *     
         */
        public void setApplicDef(JAXBElement<ApplicabilityStatement> value) {
            this.applicDef = value;
        }

        /**
         * Gets the value of the datedApplicDef property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link DatedApplicabilityStatement }{@code >}
         *     
         */
        public JAXBElement<DatedApplicabilityStatement> getDatedApplicDef() {
            return datedApplicDef;
        }

        /**
         * Sets the value of the datedApplicDef property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link DatedApplicabilityStatement }{@code >}
         *     
         */
        public void setDatedApplicDef(JAXBElement<DatedApplicabilityStatement> value) {
            this.datedApplicDef = value;
        }

        /**
         * Gets the value of the applicRef property.
         * 
         * @return
         *     possible object is
         *     {@link ApplicabilityStatementReference }
         *     
         */
        public ApplicabilityStatementReference getApplicRef() {
            return applicRef;
        }

        /**
         * Sets the value of the applicRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link ApplicabilityStatementReference }
         *     
         */
        public void setApplicRef(ApplicabilityStatementReference value) {
            this.applicRef = value;
        }

    }

}
