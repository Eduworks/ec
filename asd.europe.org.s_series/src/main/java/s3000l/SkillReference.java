/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:54 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class SkillReference extends EcRemoteLinkedData {

    protected TradeName skillCode;
    protected Object uidRef;
    protected String uriRef;

    public TradeName getSkillCode() {
        return skillCode;
    }

    public void setSkillCode(TradeName value) {
        this.skillCode = value;
    }

    public Object getUidRef() {
        return uidRef;
    }

    public void setUidRef(Object value) {
        this.uidRef = value;
    }

    public String getUriRef() {
        return uriRef;
    }

    public void setUriRef(String value) {
        this.uriRef = value;
    }

	public SkillReference() {
		super("http://www.asd-europe.org/s-series/s3000l", "SkillReference");
	}

}
