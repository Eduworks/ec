/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:00 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class ApplicabilityEvaluationByApplicabilityStatementReference extends EcRemoteLinkedData {

    protected ApplicabilityStatementReference applicRef;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected String uid;
    protected CrudCodeValues crud;

    public ApplicabilityStatementReference getApplicRef() {
        return applicRef;
    }

    public void setApplicRef(ApplicabilityStatementReference value) {
        this.applicRef = value;
    }

    public s3000l.ConditionInstance.Rmks getRmks() {
        return rmks;
    }

    public void setRmks(s3000l.ConditionInstance.Rmks value) {
        this.rmks = value;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String value) {
        this.uid = value;
    }

    public CrudCodeValues getCrud() {
        if (crud == null) {
            return CrudCodeValues.I;
        } else {
            return crud;
        }
    }

    public void setCrud(CrudCodeValues value) {
        this.crud = value;
    }

	public ApplicabilityEvaluationByApplicabilityStatementReference() {
		super("http://www.asd-europe.org/s-series/s3000l", "ApplicabilityEvaluationByApplicabilityStatementReference");
	}

}
