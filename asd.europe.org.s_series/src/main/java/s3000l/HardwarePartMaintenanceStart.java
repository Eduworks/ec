/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Mon Jul 29 11:33:20 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class HardwarePartMaintenanceStart extends EcRemoteLinkedData {

    protected HardwarePartMaintenanceStartCodeValues code;
    protected ProductName.Applic applic;
    protected ConditionInstance.Docs docs;
    protected ConditionInstance.Rmks rmks;

    public HardwarePartMaintenanceStartCodeValues getCode() {
        return code;
    }

    public void setCode(HardwarePartMaintenanceStartCodeValues value) {
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

	public HardwarePartMaintenanceStart() {
		super("http://www.asd-europe.org/s-series/s3000l", "HardwarePartMaintenanceStart");
	}

}
