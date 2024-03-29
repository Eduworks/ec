/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:02 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import s6000t.SubtaskTrainingLevelDecision;

public class SpecialEventThresholdDefinition extends EcRemoteLinkedData {

    protected long nrOfEvnts;
    protected SpecialEventReference sEvntRef;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected SubtaskTrainingLevelDecision.Applic applic;
    protected String uid;
    protected CrudCodeValues crud;

    public long getNrOfEvnts() {
        return nrOfEvnts;
    }

    public void setNrOfEvnts(long value) {
        this.nrOfEvnts = value;
    }

    public SpecialEventReference getSEvntRef() {
        return sEvntRef;
    }

    public void setSEvntRef(SpecialEventReference value) {
        this.sEvntRef = value;
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

	public SpecialEventThresholdDefinition() {
		super("http://www.asd-europe.org/s-series/s3000l", "SpecialEventThresholdDefinition");
	}

}
