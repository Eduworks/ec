
package s6000t.taskTrainAnalysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskRequirementAuthority complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskRequirementAuthority">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orgRef" type="{http://www.asd-europe.org/s-series/s3000l}organizationReference"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taskRequirementAuthority", namespace = "http://www.asd-europe.org/s-series/s3000l", propOrder = {
    "orgRef"
})
public class TaskRequirementAuthority {

    @XmlElement(required = true)
    protected OrganizationReference orgRef;

    /**
     * Gets the value of the orgRef property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationReference }
     *     
     */
    public OrganizationReference getOrgRef() {
        return orgRef;
    }

    /**
     * Sets the value of the orgRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationReference }
     *     
     */
    public void setOrgRef(OrganizationReference value) {
        this.orgRef = value;
    }

}
