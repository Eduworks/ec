/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:02 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class SecurityClassReference extends EcRemoteLinkedData {

    protected SecurityClass scc;
    protected Object uidRef;

    public SecurityClass getScc() {
        return scc;
    }

    public void setScc(SecurityClass value) {
        this.scc = value;
    }

    public Object getUidRef() {
        return uidRef;
    }

    public void setUidRef(Object value) {
        this.uidRef = value;
    }

	public SecurityClassReference() {
		super("http://www.asd-europe.org/s-series/s3000l", "SecurityClassReference");
	}

}
