/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:00 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;

public class BreakdownElementUsageInBreakdown extends EcRemoteLinkedData {

    protected BreakdownElementRevisionReference beRef;
    protected Array<BreakdownElementStructure> beChild;
    protected BreakdownElementInZoneRelationship inZone;
    protected s3000l.HardwareElementPartRealization.UsableOnList usableOnList;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected String uid;
    protected CrudCodeValues crud;

    public BreakdownElementRevisionReference getBeRef() {
        return beRef;
    }

    public void setBeRef(BreakdownElementRevisionReference value) {
        this.beRef = value;
    }

    public Array<BreakdownElementStructure> getBeChild() {
        if (beChild == null) {
            beChild = new Array<BreakdownElementStructure>();
        }
        return this.beChild;
    }

    public BreakdownElementInZoneRelationship getInZone() {
        return inZone;
    }

    public void setInZone(BreakdownElementInZoneRelationship value) {
        this.inZone = value;
    }

    public s3000l.HardwareElementPartRealization.UsableOnList getUsableOnList() {
        return usableOnList;
    }

    public void setUsableOnList(s3000l.HardwareElementPartRealization.UsableOnList value) {
        this.usableOnList = value;
    }

    public s3000l.ConditionInstance.Rmks getRmks() {
        return rmks;
    }

    public void setRmks(s3000l.ConditionInstance.Rmks value) {
        this.rmks = value;
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

	public BreakdownElementUsageInBreakdown() {
		super("http://www.asd-europe.org/s-series/s3000l", "BreakdownElementUsageInBreakdown");
	}

}
