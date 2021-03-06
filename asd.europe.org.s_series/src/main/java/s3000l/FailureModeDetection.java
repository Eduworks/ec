/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:01 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class FailureModeDetection extends EcRemoteLinkedData {

    protected FailureModeDetectionRate detectRte;
    protected FailureModeReference fmRef;
    protected String uid;
    protected CrudCodeValues crud;

    public FailureModeDetectionRate getDetectRte() {
        return detectRte;
    }

    public void setDetectRte(FailureModeDetectionRate value) {
        this.detectRte = value;
    }

    public FailureModeReference getFmRef() {
        return fmRef;
    }

    public void setFmRef(FailureModeReference value) {
        this.fmRef = value;
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

	public FailureModeDetection() {
		super("http://www.asd-europe.org/s-series/s3000l", "FailureModeDetection");
	}

}
