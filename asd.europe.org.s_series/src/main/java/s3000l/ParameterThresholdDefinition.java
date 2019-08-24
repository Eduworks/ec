/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:54 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class ParameterThresholdDefinition extends EcRemoteLinkedData {

    protected ThresholdValue thldValue;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected s3000l.ProductName.Applic applic;
    protected String uid;
    protected CrudCodeValues crud;

    public ThresholdValue getThldValue() {
        return thldValue;
    }

    public void setThldValue(ThresholdValue value) {
        this.thldValue = value;
    }

    public s3000l.ConditionInstance.Rmks getRmks() {
        return rmks;
    }

    public void setRmks(s3000l.ConditionInstance.Rmks value) {
        this.rmks = value;
    }

    public s3000l.ProductName.Applic getApplic() {
        return applic;
    }

    public void setApplic(s3000l.ProductName.Applic value) {
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

	public ParameterThresholdDefinition() {
		super("http://www.asd-europe.org/s-series/s3000l", "ParameterThresholdDefinition");
	}

}
