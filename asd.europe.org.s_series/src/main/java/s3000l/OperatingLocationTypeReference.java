/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Mon Jul 29 11:33:21 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class OperatingLocationTypeReference extends EcRemoteLinkedData {

    protected OperatingLocationTypeIdentifier opTypeId;
    protected Object uidRef;

    public OperatingLocationTypeIdentifier getOpTypeId() {
        return opTypeId;
    }

    public void setOpTypeId(OperatingLocationTypeIdentifier value) {
        this.opTypeId = value;
    }

    public Object getUidRef() {
        return uidRef;
    }

    public void setUidRef(Object value) {
        this.uidRef = value;
    }

	public OperatingLocationTypeReference() {
		super("http://www.asd-europe.org/s-series/s3000l", "OperatingLocationTypeReference");
	}

}