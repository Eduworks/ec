/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:01 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class DataModuleIssueNumber extends EcRemoteLinkedData {

    protected DataModuleIssueNumberClassValues clazz;
    protected OrganizationReference setBy;

    public DataModuleIssueNumberClassValues getClazz() {
        return clazz;
    }

    public void setClazz(DataModuleIssueNumberClassValues value) {
        this.clazz = value;
    }

    public OrganizationReference getSetBy() {
        return setBy;
    }

    public void setSetBy(OrganizationReference value) {
        this.setBy = value;
    }

	public DataModuleIssueNumber() {
		super("http://www.asd-europe.org/s-series/s3000l", "DataModuleIssueNumber");
	}

}
