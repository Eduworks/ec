/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:53 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class DocumentAssignmentRole extends EcRemoteLinkedData {

    protected DocumentAssignmentRoleCodeValues code;
    protected s3000l.ProductName.Applic applic;
    protected s3000l.ConditionInstance.Docs docs;
    protected s3000l.ConditionInstance.Rmks rmks;

    public DocumentAssignmentRoleCodeValues getCode() {
        return code;
    }

    public void setCode(DocumentAssignmentRoleCodeValues value) {
        this.code = value;
    }

    public s3000l.ProductName.Applic getApplic() {
        return applic;
    }

    public void setApplic(s3000l.ProductName.Applic value) {
        this.applic = value;
    }

    public s3000l.ConditionInstance.Docs getDocs() {
        return docs;
    }

    public void setDocs(s3000l.ConditionInstance.Docs value) {
        this.docs = value;
    }

    public s3000l.ConditionInstance.Rmks getRmks() {
        return rmks;
    }

    public void setRmks(s3000l.ConditionInstance.Rmks value) {
        this.rmks = value;
    }

	public DocumentAssignmentRole() {
		super("http://www.asd-europe.org/s-series/s3000l", "DocumentAssignmentRole");
	}

}
