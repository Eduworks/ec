/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:53 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class LsaCandidateDamageAnalysisActivity extends EcRemoteLinkedData {

    protected CandidateItemAnalysisActivityIndicator indicator;
    protected CandidateItemAnalysisActivityRationale rationale;
    protected CandidateItemAnalysisActivityStatus status;
    protected CandidateItemAnalysisActivityDate update;
    protected s3000l.DownTime.OrgInfos orgInfos;
    protected s3000l.ConditionInstance.Docs docs;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected String uid;
    protected CrudCodeValues crud;

    public CandidateItemAnalysisActivityIndicator getIndicator() {
        return indicator;
    }

    public void setIndicator(CandidateItemAnalysisActivityIndicator value) {
        this.indicator = value;
    }

    public CandidateItemAnalysisActivityRationale getRationale() {
        return rationale;
    }

    public void setRationale(CandidateItemAnalysisActivityRationale value) {
        this.rationale = value;
    }

    public CandidateItemAnalysisActivityStatus getStatus() {
        return status;
    }

    public void setStatus(CandidateItemAnalysisActivityStatus value) {
        this.status = value;
    }

    public CandidateItemAnalysisActivityDate getUpdate() {
        return update;
    }

    public void setUpdate(CandidateItemAnalysisActivityDate value) {
        this.update = value;
    }

    public s3000l.DownTime.OrgInfos getOrgInfos() {
        return orgInfos;
    }

    public void setOrgInfos(s3000l.DownTime.OrgInfos value) {
        this.orgInfos = value;
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

	public LsaCandidateDamageAnalysisActivity() {
		super("http://www.asd-europe.org/s-series/s3000l", "LsaCandidateDamageAnalysisActivity");
	}

}
