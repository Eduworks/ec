/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:03 CDT 2019
 *
 **/

package s6000t;

import org.cassproject.schema.general.EcRemoteLinkedData;
import s3000l.WarningCautionNoteRef;

public class TaskCognitiveLevelOfLearningRef extends EcRemoteLinkedData {

    protected TaskTrainDecisionByEvaluationRef trainTaskRef;
    protected SubtaskTrainDecisionDefinitionRef trainSubtaskRef;
    protected SubtaskTrainStepDefinitionRef trainStepRef;
    protected WarningCautionNoteRef wcnRef;
    protected TaskCognitiveLevelOfLearningIterationIdentifier cognIterId;
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

    public TaskCognitiveLevelOfLearningIterationIdentifier getCognIterId() {
        return cognIterId;
    }

    public void setCognIterId(TaskCognitiveLevelOfLearningIterationIdentifier value) {
        this.cognIterId = value;
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

	public TaskCognitiveLevelOfLearningRef() {
		super("http://www.asd-europe.org/s-series/s3000l", "TaskCognitiveLevelOfLearningRef");
	}

}