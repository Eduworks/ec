/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:02 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class SamplingDefinitionByValue extends EcRemoteLinkedData {

    protected SamplingMethodDescription samplDescr;
    protected SamplingValue samplValue;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected String uid;
    protected CrudCodeValues crud;

    public SamplingMethodDescription getSamplDescr() {
        return samplDescr;
    }

    public void setSamplDescr(SamplingMethodDescription value) {
        this.samplDescr = value;
    }

    public SamplingValue getSamplValue() {
        return samplValue;
    }

    public void setSamplValue(SamplingValue value) {
        this.samplValue = value;
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

	public SamplingDefinitionByValue() {
		super("http://www.asd-europe.org/s-series/s3000l", "SamplingDefinitionByValue");
	}

}
