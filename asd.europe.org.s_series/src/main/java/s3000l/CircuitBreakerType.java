/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:00 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import s6000t.SubtaskTrainingLevelDecision;

public class CircuitBreakerType extends EcRemoteLinkedData {

    protected CircuitBreakerTypeCodeValues code;
    protected SubtaskTrainingLevelDecision.Applic applic;
    protected s3000l.ConditionInstance.Docs docs;
    protected s3000l.ConditionInstance.Rmks rmks;

    public CircuitBreakerTypeCodeValues getCode() {
        return code;
    }

    public void setCode(CircuitBreakerTypeCodeValues value) {
        this.code = value;
    }

    public SubtaskTrainingLevelDecision.Applic getApplic() {
        return applic;
    }

    public void setApplic(SubtaskTrainingLevelDecision.Applic value) {
        this.applic = value;
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

	public CircuitBreakerType() {
		super("http://www.asd-europe.org/s-series/s3000l", "CircuitBreakerType");
	}

}
