/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:00 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class ApplicabilityStatementIdentifier extends EcRemoteLinkedData {

    protected OrganizationReference setBy;

    public OrganizationReference getSetBy() {
        return setBy;
    }

    public void setSetBy(OrganizationReference value) {
        this.setBy = value;
    }

	public ApplicabilityStatementIdentifier() {
		super("http://www.asd-europe.org/s-series/s3000l", "ApplicabilityStatementIdentifier");
	}

}
