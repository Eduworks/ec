/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Mon Jul 29 11:33:22 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class SubstanceDefinitionReference extends EcRemoteLinkedData {

    protected SubstanceIdentifier subsId;
    protected Object uidRef;

    public SubstanceIdentifier getSubsId() {
        return subsId;
    }

    public void setSubsId(SubstanceIdentifier value) {
        this.subsId = value;
    }

    public Object getUidRef() {
        return uidRef;
    }

    public void setUidRef(Object value) {
        this.uidRef = value;
    }

	public SubstanceDefinitionReference() {
		super("http://www.asd-europe.org/s-series/s3000l", "SubstanceDefinitionReference");
	}

}