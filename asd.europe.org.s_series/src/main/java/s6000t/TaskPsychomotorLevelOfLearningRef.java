/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:03 CDT 2019
 *
 **/

package s6000t;

import org.cassproject.schema.general.EcRemoteLinkedData;
import s3000l.WarningCautionNoteRef;

public class TaskPsychomotorLevelOfLearningRef extends EcRemoteLinkedData {

    protected TaskTrainDecisionByEvaluationRef trainTaskRef;
    protected SubtaskTrainDecisionDefinitionRef trainSubtaskRef;
    protected SubtaskTrainStepDefinitionRef trainStepRef;
    protected WarningCautionNoteRef wcnRef;
    protected TaskPsychomotorLevelOfLearningIterationIdentifier psychoIterId;
    protected Object uidRef;
    protected String uriRef;

    public TaskTrainDecisionByEvaluationRef getTrainTaskRef() {
        return trainTaskRef;
    }

    public void setTrainTaskRef(TaskTrainDecisionByEvaluationRef value) {
        this.trainTaskRef = value;
    }

    public SubtaskTrainDecisionDefinitionRef getTrainSubtaskRef() {
        return trainSubtaskRef;
    }

    public void setTrainSubtaskRef(SubtaskTrainDecisionDefinitionRef value) {
        this.trainSubtaskRef = value;
    }

    public SubtaskTrainStepDefinitionRef getTrainStepRef() {
        return trainStepRef;
    }

    public void setTrainStepRef(SubtaskTrainStepDefinitionRef value) {
        this.trainStepRef = value;
    }

    public WarningCautionNoteRef getWcnRef() {
        return wcnRef;
    }

    public void setWcnRef(WarningCautionNoteRef value) {
        this.wcnRef = value;
    }

    public TaskPsychomotorLevelOfLearningIterationIdentifier getPsychoIterId() {
        return psychoIterId;
    }

    public void setPsychoIterId(TaskPsychomotorLevelOfLearningIterationIdentifier value) {
        this.psychoIterId = value;
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

	public TaskPsychomotorLevelOfLearningRef() {
		super("http://www.asd-europe.org/s-series/s3000l", "TaskPsychomotorLevelOfLearningRef");
	}

}
