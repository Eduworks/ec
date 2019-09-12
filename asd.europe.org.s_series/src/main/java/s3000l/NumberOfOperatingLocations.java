/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:02 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Date;
import s6000t.SubtaskTrainingLevelDecision;

public class NumberOfOperatingLocations extends EcRemoteLinkedData {

    protected Date date;
    protected ValueDeterminationCodeValues vdtm;
    protected CountUnit unit;
    protected double value;
    protected double nomVal;
    protected double lowOff;
    protected double uppOff;
    protected double lowVal;
    protected double uppVal;
    protected String txt;
    protected SubtaskTrainingLevelDecision.Applic applic;
    protected s3000l.ConditionInstance.Docs docs;
    protected s3000l.DownTime.OrgInfos orgInfos;
    protected s3000l.ConditionInstance.Rmks rmks;

    public Date getDate() {
        return date;
    }

    public void setDate(Date value) {
        this.date = value;
    }

    public ValueDeterminationCodeValues getVdtm() {
        return vdtm;
    }

    public void setVdtm(ValueDeterminationCodeValues value) {
        this.vdtm = value;
    }

    public CountUnit getUnit() {
        return unit;
    }

    public void setUnit(CountUnit value) {
        this.unit = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getNomVal() {
        return nomVal;
    }

    public void setNomVal(double value) {
        this.nomVal = value;
    }

    public double getLowOff() {
        return lowOff;
    }

    public void setLowOff(double value) {
        this.lowOff = value;
    }

    public double getUppOff() {
        return uppOff;
    }

    public void setUppOff(double value) {
        this.uppOff = value;
    }

    public double getLowVal() {
        return lowVal;
    }

    public void setLowVal(double value) {
        this.lowVal = value;
    }

    public double getUppVal() {
        return uppVal;
    }

    public void setUppVal(double value) {
        this.uppVal = value;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String value) {
        this.txt = value;
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

    public s3000l.DownTime.OrgInfos getOrgInfos() {
        return orgInfos;
    }

    public void setOrgInfos(s3000l.DownTime.OrgInfos value) {
        this.orgInfos = value;
    }

    public s3000l.ConditionInstance.Rmks getRmks() {
        return rmks;
    }

    public void setRmks(s3000l.ConditionInstance.Rmks value) {
        this.rmks = value;
    }

	public NumberOfOperatingLocations() {
		super("http://www.asd-europe.org/s-series/s3000l", "NumberOfOperatingLocations");
	}

}
