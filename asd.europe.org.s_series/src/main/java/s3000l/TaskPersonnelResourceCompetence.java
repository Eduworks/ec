/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:03 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import s6000t.JobPositionRef;
import s6000t.SubtaskTrainingLevelDecision;

public class TaskPersonnelResourceCompetence extends EcRemoteLinkedData {

    protected Array<TaskPersonnelResourceCompetence.AddTrain> addTrain;
    protected TradeReference tradeRef;
    protected SkillLevelReference skillLevelRef;
    protected SkillReference skillRef;
    protected JobPositionRef jobPosRef;
    protected SubtaskTrainingLevelDecision.Applic applic;
    protected String uid;
    protected CrudCodeValues crud;

    public Array<TaskPersonnelResourceCompetence.AddTrain> getAddTrain() {
        if (addTrain == null) {
            addTrain = new Array<TaskPersonnelResourceCompetence.AddTrain>();
        }
        return this.addTrain;
    }

    public TradeReference getTradeRef() {
        return tradeRef;
    }

    public void setTradeRef(TradeReference value) {
        this.tradeRef = value;
    }

    public SkillLevelReference getSkillLevelRef() {
        return skillLevelRef;
    }

    public void setSkillLevelRef(SkillLevelReference value) {
        this.skillLevelRef = value;
    }

    public SkillReference getSkillRef() {
        return skillRef;
    }

    public void setSkillRef(SkillReference value) {
        this.skillRef = value;
    }

    public JobPositionRef getJobPosRef() {
        return jobPosRef;
    }

    public void setJobPosRef(JobPositionRef value) {
        this.jobPosRef = value;
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

    public static class AddTrain {

        protected AdditionalTrainingRequirementDescription trainDescr;
        protected TrainingMethod trainMeth;
        protected s3000l.ConditionInstance.Docs docs;
        protected s3000l.ConditionInstance.Rmks rmks;

        public AdditionalTrainingRequirementDescription getTrainDescr() {
            return trainDescr;
        }

        public void setTrainDescr(AdditionalTrainingRequirementDescription value) {
            this.trainDescr = value;
        }

        public TrainingMethod getTrainMeth() {
            return trainMeth;
        }

        public void setTrainMeth(TrainingMethod value) {
            this.trainMeth = value;
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

    }

	public TaskPersonnelResourceCompetence() {
		super("http://www.asd-europe.org/s-series/s3000l", "TaskPersonnelResourceCompetence");
	}

}
