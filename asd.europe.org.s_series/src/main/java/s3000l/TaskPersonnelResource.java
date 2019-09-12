/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:03 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import s6000t.SubtaskTrainingLevelDecision;

public class TaskPersonnelResource extends EcRemoteLinkedData {

    protected Boolean fixed;
    protected Array<TaskResourceDuration> duration;
    protected TaskPersonnelResourceRole persRole;
    protected Array<TaskNumberOfPersonnelResource> number;
    protected Array<TaskPersonnelResourceLaborTime> laborTime;
    protected Array<TaskResourceRelationship> relRes;
    protected Array<TaskPersonnelResourceCompetence> compt;
    protected s3000l.ConditionInstance.Docs docs;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected SubtaskTrainingLevelDecision.Applic applic;
    protected String uid;
    protected CrudCodeValues crud;

    public Boolean getFixed() {
        return fixed;
    }

    public void setFixed(Boolean value) {
        this.fixed = value;
    }

    public Array<TaskResourceDuration> getDuration() {
        if (duration == null) {
            duration = new Array<TaskResourceDuration>();
        }
        return this.duration;
    }

    public TaskPersonnelResourceRole getPersRole() {
        return persRole;
    }

    public void setPersRole(TaskPersonnelResourceRole value) {
        this.persRole = value;
    }

    public Array<TaskNumberOfPersonnelResource> getNumber() {
        if (number == null) {
            number = new Array<TaskNumberOfPersonnelResource>();
        }
        return this.number;
    }

    public Array<TaskPersonnelResourceLaborTime> getLaborTime() {
        if (laborTime == null) {
            laborTime = new Array<TaskPersonnelResourceLaborTime>();
        }
        return this.laborTime;
    }

    public Array<TaskResourceRelationship> getRelRes() {
        if (relRes == null) {
            relRes = new Array<TaskResourceRelationship>();
        }
        return this.relRes;
    }

    public Array<TaskPersonnelResourceCompetence> getCompt() {
        if (compt == null) {
            compt = new Array<TaskPersonnelResourceCompetence>();
        }
        return this.compt;
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

	public TaskPersonnelResource() {
		super("http://www.asd-europe.org/s-series/s3000l", "TaskPersonnelResource");
	}

}
