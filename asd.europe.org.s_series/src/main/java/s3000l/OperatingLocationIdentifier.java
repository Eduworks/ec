/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Mon Jul 29 11:33:21 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class OperatingLocationIdentifier extends EcRemoteLinkedData {

    protected OperatingLocationIdentifierClassValues clazz;
    protected OrganizationReference setBy;

    public OperatingLocationIdentifierClassValues getClazz() {
        return clazz;
    }

    public void setClazz(OperatingLocationIdentifierClassValues value) {
        this.clazz = value;
    }

    public OrganizationReference getSetBy() {
        return setBy;
    }

    public void setSetBy(OrganizationReference value) {
        this.setBy = value;
    }

	public OperatingLocationIdentifier() {
		super("http://www.asd-europe.org/s-series/s3000l", "OperatingLocationIdentifier");
	}

}