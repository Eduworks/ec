
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for documentIssueReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="documentIssueReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice minOccurs="0">
 *         &lt;sequence>
 *           &lt;element name="docId" type="{http://www.asd-europe.org/s-series/s3000l}documentIdentifier"/>
 *           &lt;element name="docIssId" type="{http://www.asd-europe.org/s-series/s3000l}documentIssueIdentifier"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="dmc" type="{http://www.asd-europe.org/s-series/s3000l}dataModuleCode"/>
 *           &lt;element name="dmIssId" type="{http://www.asd-europe.org/s-series/s3000l}dataModuleIssueNumber"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="pmc" type="{http://www.asd-europe.org/s-series/s3000l}publicationModuleCode"/>
 *           &lt;element name="pmIssId" type="{http://www.asd-europe.org/s-series/s3000l}publicationModuleIssueNumber"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attribute name="uidRef">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.asd-europe.org/s-series/s3000l}uidRef">
 *             &lt;pattern value="dociss[1-9][0-9]*"/>
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
@XmlType(name = "documentIssueReference", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "docId",
    "docIssId",
    "dmc",
    "dmIssId",
    "pmc",
    "pmIssId"
})
public class DocumentIssueReference {

    protected DocumentIdentifier docId;
    protected DocumentIssueIdentifier docIssId;
    protected DataModuleCode dmc;
    protected DataModuleIssueNumber dmIssId;
    protected PublicationModuleCode pmc;
    protected PublicationModuleIssueNumber pmIssId;
    @XmlAttribute(name = "uidRef")
    @XmlIDREF
    protected Object uidRef;

    /**
     * Gets the value of the docId property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentIdentifier }
     *     
     */
    public DocumentIdentifier getDocId() {
        return docId;
    }

    /**
     * Sets the value of the docId property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentIdentifier }
     *     
     */
    public void setDocId(DocumentIdentifier value) {
        this.docId = value;
    }

    /**
     * Gets the value of the docIssId property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentIssueIdentifier }
     *     
     */
    public DocumentIssueIdentifier getDocIssId() {
        return docIssId;
    }

    /**
     * Sets the value of the docIssId property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentIssueIdentifier }
     *     
     */
    public void setDocIssId(DocumentIssueIdentifier value) {
        this.docIssId = value;
    }

    /**
     * Gets the value of the dmc property.
     * 
     * @return
     *     possible object is
     *     {@link DataModuleCode }
     *     
     */
    public DataModuleCode getDmc() {
        return dmc;
    }

    /**
     * Sets the value of the dmc property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataModuleCode }
     *     
     */
    public void setDmc(DataModuleCode value) {
        this.dmc = value;
    }

    /**
     * Gets the value of the dmIssId property.
     * 
     * @return
     *     possible object is
     *     {@link DataModuleIssueNumber }
     *     
     */
    public DataModuleIssueNumber getDmIssId() {
        return dmIssId;
    }

    /**
     * Sets the value of the dmIssId property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataModuleIssueNumber }
     *     
     */
    public void setDmIssId(DataModuleIssueNumber value) {
        this.dmIssId = value;
    }

    /**
     * Gets the value of the pmc property.
     * 
     * @return
     *     possible object is
     *     {@link PublicationModuleCode }
     *     
     */
    public PublicationModuleCode getPmc() {
        return pmc;
    }

    /**
     * Sets the value of the pmc property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicationModuleCode }
     *     
     */
    public void setPmc(PublicationModuleCode value) {
        this.pmc = value;
    }

    /**
     * Gets the value of the pmIssId property.
     * 
     * @return
     *     possible object is
     *     {@link PublicationModuleIssueNumber }
     *     
     */
    public PublicationModuleIssueNumber getPmIssId() {
        return pmIssId;
    }

    /**
     * Sets the value of the pmIssId property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicationModuleIssueNumber }
     *     
     */
    public void setPmIssId(PublicationModuleIssueNumber value) {
        this.pmIssId = value;
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
