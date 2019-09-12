/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:01 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import s6000t.SubtaskTrainingLevelDecision;

public class HigherFailureModeEffect extends EcRemoteLinkedData {

    protected FailureModeEffectDescription efctDescr;
    protected FailureModeEffectLevel efctLevel;
    protected BreakdownElementRevisionReference beRef;
    protected s3000l.ConditionInstance.Docs docs;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected SubtaskTrainingLevelDecision.Applic applic;
    protected String uid;
    protected CrudCodeValues crud;

    public FailureModeEffectDescription getEfctDescr() {
        return efctDescr;
    }

    public void setEfctDescr(FailureModeEffectDescription value) {
        this.efctDescr = value;
    }

    public FailureModeEffectLevel getEfctLevel() {
        return efctLevel;
    }

    public void setEfctLevel(FailureModeEffectLevel value) {
        this.efctLevel = value;
    }

    public BreakdownElementRevisionReference getBeRef() {
        return beRef;
    }

    public void setBeRef(BreakdownElementRevisionReference value) {
        this.beRef = value;
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

	public HigherFailureModeEffect() {
		super("http://www.asd-europe.org/s-series/s3000l", "HigherFailureModeEffect");
	}

}
