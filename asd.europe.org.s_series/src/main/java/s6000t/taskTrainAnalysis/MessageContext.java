
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for messageContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="messageContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.asd-europe.org/s-series/s3000l}messageContextItemSelect"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="msgcxt[1-9][0-9]*"/>
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
@XmlType(name = "messageContext", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "prodRef",
    "prodVarRef",
    "projRef",
    "contrRef"
})
public class MessageContext {

    protected ProductReference prodRef;
    protected ProductVariantReference prodVarRef;
    protected ProjectReference projRef;
    protected ContractReference contrRef;
    @XmlAttribute(name = "uid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String uid;
    @XmlAttribute(name = "crud")
    protected CrudCodeValues crud;

    /**
     * Gets the value of the prodRef property.
     * 
     * @return
     *     possible object is
     *     {@link ProductReference }
     *     
     */
    public ProductReference getProdRef() {
        return prodRef;
    }

    /**
     * Sets the value of the prodRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductReference }
     *     
     */
    public void setProdRef(ProductReference value) {
        this.prodRef = value;
    }

    /**
     * Gets the value of the prodVarRef property.
     * 
     * @return
     *     possible object is
     *     {@link ProductVariantReference }
     *     
     */
    public ProductVariantReference getProdVarRef() {
        return prodVarRef;
    }

    /**
     * Sets the value of the prodVarRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductVariantReference }
     *     
     */
    public void setProdVarRef(ProductVariantReference value) {
        this.prodVarRef = value;
    }

    /**
     * Gets the value of the projRef property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectReference }
     *     
     */
    public ProjectReference getProjRef() {
        return projRef;
    }

    /**
     * Sets the value of the projRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectReference }
     *     
     */
    public void setProjRef(ProjectReference value) {
        this.projRef = value;
    }

    /**
     * Gets the value of the contrRef property.
     * 
     * @return
     *     possible object is
     *     {@link ContractReference }
     *     
     */
    public ContractReference getContrRef() {
        return contrRef;
    }

    /**
     * Sets the value of the contrRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractReference }
     *     
     */
    public void setContrRef(ContractReference value) {
        this.contrRef = value;
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
