/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:02 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import s6000t.SubtaskTrainingLevelDecision;

public class PlannedTaskTarget extends EcRemoteLinkedData {

    protected Array<s3000l.SupportingTaskTarget.TaskFreq> taskFreq;
    protected TaskRef taskRef;
    protected Array<AllocatedMaintenanceLevel> maintLevel;
    protected s3000l.DownTime.OrgInfos orgInfos;
    protected s3000l.ConditionInstance.Docs docs;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected SubtaskTrainingLevelDecision.Applic applic;
    protected PlannedTaskTarget.TimeLimits timeLimits;
    protected String uid;
    protected CrudCodeValues crud;

    public Array<s3000l.SupportingTaskTarget.TaskFreq> getTaskFreq() {
        if (taskFreq == null) {
            taskFreq = new Array<s3000l.SupportingTaskTarget.TaskFreq>();
        }
        return this.taskFreq;
    }

    public TaskRef getTaskRef() {
        return taskRef;
    }

    public void setTaskRef(TaskRef value) {
        this.taskRef = value;
    }

    public Array<AllocatedMaintenanceLevel> getMaintLevel() {
        if (maintLevel == null) {
            maintLevel = new Array<AllocatedMaintenanceLevel>();
        }
        return this.maintLevel;
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

    public SubtaskTrainingLevelDecision.Applic getApplic() {
        return applic;
    }

    public void setApplic(SubtaskTrainingLevelDecision.Applic value) {
        this.applic = value;
    }

    public PlannedTaskTarget.TimeLimits getTimeLimits() {
        return timeLimits;
    }

    public void setTimeLimits(PlannedTaskTarget.TimeLimits value) {
        this.timeLimits = value;
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

    public static class TimeLimits {

        protected Array<Object> timeLimitNonAbstractClasses;

        public Array<Object> getTimeLimitNonAbstractClasses() {
            if (timeLimitNonAbstractClasses == null) {
                timeLimitNonAbstractClasses = new Array<Object>();
            }
            return this.timeLimitNonAbstractClasses;
        }

    }

	public PlannedTaskTarget() {
		super("http://www.asd-europe.org/s-series/s3000l", "PlannedTaskTarget");
	}

}
