/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:00 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class BreakdownElementRevisionIdentifier extends EcRemoteLinkedData {

    protected BreakdownElementRevisionIdentifierClassValues clazz;
    protected OrganizationReference setBy;

    public BreakdownElementRevisionIdentifierClassValues getClazz() {
        return clazz;
    }

    public void setClazz(BreakdownElementRevisionIdentifierClassValues value) {
        this.clazz = value;
    }

    public OrganizationReference getSetBy() {
        return setBy;
    }

    public void setSetBy(OrganizationReference value) {
        this.setBy = value;
    }

	public BreakdownElementRevisionIdentifier() {
		super("http://www.asd-europe.org/s-series/s3000l", "BreakdownElementRevisionIdentifier");
	}

}
