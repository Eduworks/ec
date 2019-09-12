/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:02 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;

public class SpecialEvent extends EcRemoteLinkedData {

    protected SpecialEventTitle evntTitle;
    protected SpecialEventDescription evntDescr;
    protected SpecialEventGroup evntGrp;
    protected Array<Object> specialEventOccurrenceNonAbstractClasses;
    protected s3000l.ConditionInstance.Docs docs;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected String uid;
    protected CrudCodeValues crud;

    public SpecialEventTitle getEvntTitle() {
        return evntTitle;
    }

    public void setEvntTitle(SpecialEventTitle value) {
        this.evntTitle = value;
    }

    public SpecialEventDescription getEvntDescr() {
        return evntDescr;
    }

    public void setEvntDescr(SpecialEventDescription value) {
        this.evntDescr = value;
    }

    public SpecialEventGroup getEvntGrp() {
        return evntGrp;
    }

    public void setEvntGrp(SpecialEventGroup value) {
        this.evntGrp = value;
    }

    public Array<Object> getSpecialEventOccurrenceNonAbstractClasses() {
        if (specialEventOccurrenceNonAbstractClasses == null) {
            specialEventOccurrenceNonAbstractClasses = new Array<Object>();
        }
        return this.specialEventOccurrenceNonAbstractClasses;
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

	public SpecialEvent() {
		super("http://www.asd-europe.org/s-series/s3000l", "SpecialEvent");
	}

}
