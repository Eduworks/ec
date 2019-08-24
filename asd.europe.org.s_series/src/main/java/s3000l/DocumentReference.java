/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:53 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class DocumentReference extends EcRemoteLinkedData {

    protected DocumentIdentifier docId;
    protected DataModuleCode dmc;
    protected PublicationModuleCode pmc;
    protected Object uidRef;

    public DocumentIdentifier getDocId() {
        return docId;
    }

    public void setDocId(DocumentIdentifier value) {
        this.docId = value;
    }

    public DataModuleCode getDmc() {
        return dmc;
    }

    public void setDmc(DataModuleCode value) {
        this.dmc = value;
    }

    public PublicationModuleCode getPmc() {
        return pmc;
    }

    public void setPmc(PublicationModuleCode value) {
        this.pmc = value;
    }

    public Object getUidRef() {
        return uidRef;
    }

    public void setUidRef(Object value) {
        this.uidRef = value;
    }

	public DocumentReference() {
		super("http://www.asd-europe.org/s-series/s3000l", "DocumentReference");
	}

}
