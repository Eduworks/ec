/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:01 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class MaintenanceCapabilityAtOperatingLocationType extends EcRemoteLinkedData {

    protected MaintenanceLevelReference mlvRef;
    protected String uid;
    protected CrudCodeValues crud;

    public MaintenanceLevelReference getMlvRef() {
        return mlvRef;
    }

    public void setMlvRef(MaintenanceLevelReference value) {
        this.mlvRef = value;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String value) {
        this.uid = value;
    }

    public CrudCodeValues getCrud() {
        if (crud == null) {
            return CrudCodeValues.I;
        } else {
            return crud;
        }
    }

    public void setCrud(CrudCodeValues value) {
        this.crud = value;
    }

	public MaintenanceCapabilityAtOperatingLocationType() {
		super("http://www.asd-europe.org/s-series/s3000l", "MaintenanceCapabilityAtOperatingLocationType");
	}

}
