/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:00 CDT 2019
 *
 **/

package s6000t;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class CompetencyDefinitionRef extends EcRemoteLinkedData {

    protected CompetencyDefinitionIdentifier compId;
    protected Object uidRef;
    protected String uriRef;

    public CompetencyDefinitionIdentifier getCompId() {
        return compId;
    }

    public void setCompId(CompetencyDefinitionIdentifier value) {
        this.compId = value;
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

	public CompetencyDefinitionRef() {
		super("http://www.asd-europe.org/s-series/s3000l", "CompetencyDefinitionRef");
	}

}
