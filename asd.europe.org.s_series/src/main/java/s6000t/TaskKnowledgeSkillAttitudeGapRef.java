/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:03 CDT 2019
 *
 **/

package s6000t;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class TaskKnowledgeSkillAttitudeGapRef extends EcRemoteLinkedData {

    protected TaskAffectiveLevelOfLearningRef taskAffLoLRef;
    protected TaskCognitiveLevelOfLearningRef taskCognLoLRef;
    protected TaskPsychomotorLevelOfLearningRef taskPsychLoLRef;
    protected TaskKnowledgeSkillAttitudeGapIdentifier taskKSAGapId;
    protected Object uidRef;
    protected String uriRef;

    public TaskAffectiveLevelOfLearningRef getTaskAffLoLRef() {
        return taskAffLoLRef;
    }

    public void setTaskAffLoLRef(TaskAffectiveLevelOfLearningRef value) {
        this.taskAffLoLRef = value;
    }

    public TaskCognitiveLevelOfLearningRef getTaskCognLoLRef() {
        return taskCognLoLRef;
    }

    public void setTaskCognLoLRef(TaskCognitiveLevelOfLearningRef value) {
        this.taskCognLoLRef = value;
    }

    public TaskPsychomotorLevelOfLearningRef getTaskPsychLoLRef() {
        return taskPsychLoLRef;
    }

    public void setTaskPsychLoLRef(TaskPsychomotorLevelOfLearningRef value) {
        this.taskPsychLoLRef = value;
    }

    public TaskKnowledgeSkillAttitudeGapIdentifier getTaskKSAGapId() {
        return taskKSAGapId;
    }

    public void setTaskKSAGapId(TaskKnowledgeSkillAttitudeGapIdentifier value) {
        this.taskKSAGapId = value;
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

	public TaskKnowledgeSkillAttitudeGapRef() {
		super("http://www.asd-europe.org/s-series/s3000l", "TaskKnowledgeSkillAttitudeGapRef");
	}

}
