/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Mon Jul 29 11:33:18 CDT 2019
 *
 **/

package s6000t;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class AlgorithmDerivedTaskTrainLevel extends EcRemoteLinkedData {

    protected AlgorithmTaskDifficultyCategory aTaskDiff;
    protected AlgorithmTaskImportanceCategory aTaskImp;
    protected AlgorithmTaskFrequencyCategory aTaskFreq;
    protected AlgorithmTaskTrainLevel aTrainLev;

    public AlgorithmTaskDifficultyCategory getATaskDiff() {
        return aTaskDiff;
    }

    public void setATaskDiff(AlgorithmTaskDifficultyCategory value) {
        this.aTaskDiff = value;
    }

    public AlgorithmTaskImportanceCategory getATaskImp() {
        return aTaskImp;
    }

    public void setATaskImp(AlgorithmTaskImportanceCategory value) {
        this.aTaskImp = value;
    }

    public AlgorithmTaskFrequencyCategory getATaskFreq() {
        return aTaskFreq;
    }

    public void setATaskFreq(AlgorithmTaskFrequencyCategory value) {
        this.aTaskFreq = value;
    }

    public AlgorithmTaskTrainLevel getATrainLev() {
        return aTrainLev;
    }

    public void setATrainLev(AlgorithmTaskTrainLevel value) {
        this.aTrainLev = value;
    }

	public AlgorithmDerivedTaskTrainLevel() {
		super("http://www.asd-europe.org/s-series/s6000t", "AlgorithmDerivedTaskTrainLevel");
	}

}