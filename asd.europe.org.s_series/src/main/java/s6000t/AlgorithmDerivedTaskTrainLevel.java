/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:00 CDT 2019
 *
 **/

package s6000t;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class AlgorithmDerivedTaskTrainLevel extends EcRemoteLinkedData {

    protected AlgorithmTaskDifficultyCategory taskDiff;
    protected AlgorithmTaskImportanceCategory taskImp;
    protected AlgorithmTaskFrequencyCategory taskFreq;
    protected AlgorithmTaskTrainingLevel taskTrainLvl;

    public AlgorithmTaskDifficultyCategory getTaskDiff() {
        return taskDiff;
    }

    public void setTaskDiff(AlgorithmTaskDifficultyCategory value) {
        this.taskDiff = value;
    }

    public AlgorithmTaskImportanceCategory getTaskImp() {
        return taskImp;
    }

    public void setTaskImp(AlgorithmTaskImportanceCategory value) {
        this.taskImp = value;
    }

    public AlgorithmTaskFrequencyCategory getTaskFreq() {
        return taskFreq;
    }

    public void setTaskFreq(AlgorithmTaskFrequencyCategory value) {
        this.taskFreq = value;
    }

    public AlgorithmTaskTrainingLevel getTaskTrainLvl() {
        return taskTrainLvl;
    }

    public void setTaskTrainLvl(AlgorithmTaskTrainingLevel value) {
        this.taskTrainLvl = value;
    }

	public AlgorithmDerivedTaskTrainLevel() {
		super("http://www.asd-europe.org/s-series/s3000l", "AlgorithmDerivedTaskTrainLevel");
	}

}
