/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:01 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class MaintenanceLocationReference extends EcRemoteLinkedData {

    protected MaintenanceLocationIdentifier mLocId;
    protected Object uidRef;

    public MaintenanceLocationIdentifier getMLocId() {
        return mLocId;
    }

    public void setMLocId(MaintenanceLocationIdentifier value) {
        this.mLocId = value;
    }

    public Object getUidRef() {
        return uidRef;
    }

    public void setUidRef(Object value) {
        this.uidRef = value;
    }

	public MaintenanceLocationReference() {
		super("http://www.asd-europe.org/s-series/s3000l", "MaintenanceLocationReference");
	}

}
