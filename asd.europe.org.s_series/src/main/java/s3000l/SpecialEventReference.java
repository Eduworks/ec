/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Mon Jul 29 11:33:22 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class SpecialEventReference extends EcRemoteLinkedData {

    protected SpecialEventTitle evntTitle;
    protected Object uidRef;

    public SpecialEventTitle getEvntTitle() {
        return evntTitle;
    }

    public void setEvntTitle(SpecialEventTitle value) {
        this.evntTitle = value;
    }

    public Object getUidRef() {
        return uidRef;
    }

    public void setUidRef(Object value) {
        this.uidRef = value;
    }

	public SpecialEventReference() {
		super("http://www.asd-europe.org/s-series/s3000l", "SpecialEventReference");
	}

}