/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Mon Jul 29 11:33:20 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class HardwarePartFitmentRequirement extends EcRemoteLinkedData {

    protected HardwarePartFitmentRequirementCodeValues code;
    protected ProductName.Applic applic;
    protected ConditionInstance.Docs docs;
    protected ConditionInstance.Rmks rmks;

    public HardwarePartFitmentRequirementCodeValues getCode() {
        return code;
    }

    public void setCode(HardwarePartFitmentRequirementCodeValues value) {
        this.code = value;
    }

    public ProductName.Applic getApplic() {
        return applic;
    }

    public void setApplic(ProductName.Applic value) {
        this.applic = value;
    }

    public ConditionInstance.Docs getDocs() {
        return docs;
    }

    public void setDocs(ConditionInstance.Docs value) {
        this.docs = value;
    }

    public ConditionInstance.Rmks getRmks() {
        return rmks;
    }

    public void setRmks(ConditionInstance.Rmks value) {
        this.rmks = value;
    }

	public HardwarePartFitmentRequirement() {
		super("http://www.asd-europe.org/s-series/s3000l", "HardwarePartFitmentRequirement");
	}

}
