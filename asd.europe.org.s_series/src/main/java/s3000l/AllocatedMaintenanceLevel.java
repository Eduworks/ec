/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:00 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import s6000t.SubtaskTrainingLevelDecision;

public class AllocatedMaintenanceLevel extends EcRemoteLinkedData {

    protected OperatingLocationReference opLocRef;
    protected OperatingLocationTypeReference opTypeRef;
    protected MaintenanceLevelReference mlvRef;
    protected MaintenanceLocationReference mLocRef;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected SubtaskTrainingLevelDecision.Applic applic;
    protected String uid;
    protected CrudCodeValues crud;

    public OperatingLocationReference getOpLocRef() {
        return opLocRef;
    }

    public void setOpLocRef(OperatingLocationReference value) {
        this.opLocRef = value;
    }

    public OperatingLocationTypeReference getOpTypeRef() {
        return opTypeRef;
    }

    public void setOpTypeRef(OperatingLocationTypeReference value) {
        this.opTypeRef = value;
    }

    public MaintenanceLevelReference getMlvRef() {
        return mlvRef;
    }

    public void setMlvRef(MaintenanceLevelReference value) {
        this.mlvRef = value;
    }

    public MaintenanceLocationReference getMLocRef() {
        return mLocRef;
    }

    public void setMLocRef(MaintenanceLocationReference value) {
        this.mLocRef = value;
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

	public AllocatedMaintenanceLevel() {
		super("http://www.asd-europe.org/s-series/s3000l", "AllocatedMaintenanceLevel");
	}

}
