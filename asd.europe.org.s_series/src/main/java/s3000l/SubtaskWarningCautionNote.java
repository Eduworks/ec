/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:03 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import s6000t.SubtaskTrainingLevelDecision;

public class SubtaskWarningCautionNote extends EcRemoteLinkedData {

    protected WarningCautionNoteRef wcnRef;
    protected WarningCautionNote wcnDef;
    protected SubtaskTrainingLevelDecision.Applic applic;
    protected String uid;
    protected CrudCodeValues crud;

    public WarningCautionNoteRef getWcnRef() {
        return wcnRef;
    }

    public void setWcnRef(WarningCautionNoteRef value) {
        this.wcnRef = value;
    }

    public WarningCautionNote getWcnDef() {
        return wcnDef;
    }

    public void setWcnDef(WarningCautionNote value) {
        this.wcnDef = value;
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

	public SubtaskWarningCautionNote() {
		super("http://www.asd-europe.org/s-series/s3000l", "SubtaskWarningCautionNote");
	}

}
