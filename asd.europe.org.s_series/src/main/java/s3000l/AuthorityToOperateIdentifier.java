/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:00 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class AuthorityToOperateIdentifier extends EcRemoteLinkedData {

    protected AuthorityToOperateIdentifierClassValues clazz;
    protected OrganizationReference setBy;

    public AuthorityToOperateIdentifierClassValues getClazz() {
        return clazz;
    }

    public void setClazz(AuthorityToOperateIdentifierClassValues value) {
        this.clazz = value;
    }

    public OrganizationReference getSetBy() {
        return setBy;
    }

    public void setSetBy(OrganizationReference value) {
        this.setBy = value;
    }

	public AuthorityToOperateIdentifier() {
		super("http://www.asd-europe.org/s-series/s3000l", "AuthorityToOperateIdentifier");
	}

}
