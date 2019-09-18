/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:03 CDT 2019
 *
 **/

package s6000t;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import s3000l.CrudCodeValues;

public class SubtaskTrainStepDefinition extends EcRemoteLinkedData {

    protected SubtaskTrainStepIdentifier stepId;
    protected Array<SubtaskTrainStepName> stepName;
    protected Array<SubtaskTrainStepDescription> stepDescr;
    protected Array<SubtaskStepPerformanceStandard> perfStd;
    protected s3000l.DownTime.OrgInfos orgInfos;
    protected s3000l.ConditionInstance.Docs docs;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected KnowledgeSkillAttitudeRequirementItem ksaReqs;
    protected String uid;
    protected String uri;
    protected CrudCodeValues crud;

    public SubtaskTrainStepIdentifier getStepId() {
        return stepId;
    }

    public void setStepId(SubtaskTrainStepIdentifier value) {
        this.stepId = value;
    }

    public Array<SubtaskTrainStepName> getStepName() {
        if (stepName == null) {
            stepName = new Array<SubtaskTrainStepName>();
        }
        return this.stepName;
    }

    public Array<SubtaskTrainStepDescription> getStepDescr() {
        if (stepDescr == null) {
            stepDescr = new Array<SubtaskTrainStepDescription>();
        }
        return this.stepDescr;
    }

    public Array<SubtaskStepPerformanceStandard> getPerfStd() {
        if (perfStd == null) {
            perfStd = new Array<SubtaskStepPerformanceStandard>();
        }
        return this.perfStd;
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

    public KnowledgeSkillAttitudeRequirementItem getKsaReqs() {
        return ksaReqs;
    }

    public void setKsaReqs(KnowledgeSkillAttitudeRequirementItem value) {
        this.ksaReqs = value;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String value) {
        this.uid = value;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String value) {
        this.uri = value;
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

	public SubtaskTrainStepDefinition() {
		super("http://www.asd-europe.org/s-series/s3000l", "SubtaskTrainStepDefinition");
	}

}
