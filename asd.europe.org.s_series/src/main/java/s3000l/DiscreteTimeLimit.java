/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Mon Jul 29 11:33:19 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;

public class DiscreteTimeLimit extends EcRemoteLinkedData {

    protected Boolean harmoniz;
    protected TimeLimitDescription limitDescr;
    protected Array<DiscreteTimeLimit.Trig> trig;
    protected Array<DiscreteTimeLimit.Thld> thld;
    protected DownTime.OrgInfos orgInfos;
    protected ConditionInstance.Docs docs;
    protected ConditionInstance.Rmks rmks;
    protected ProductName.Applic applic;
    protected SamplingDefinition samplByDef;
    protected SamplingDefinitionByValue samplByValue;
    protected SamplingDefinitionByRatio samplByRo;
    protected String uid;
    protected CrudCodeValues crud;

    public Boolean getHarmoniz() {
        return harmoniz;
    }

    public void setHarmoniz(Boolean value) {
        this.harmoniz = value;
    }

    public TimeLimitDescription getLimitDescr() {
        return limitDescr;
    }

    public void setLimitDescr(TimeLimitDescription value) {
        this.limitDescr = value;
    }

    public Array<DiscreteTimeLimit.Trig> getTrig() {
        if (trig == null) {
            trig = new Array<DiscreteTimeLimit.Trig>();
        }
        return this.trig;
    }

    public Array<DiscreteTimeLimit.Thld> getThld() {
        if (thld == null) {
            thld = new Array<DiscreteTimeLimit.Thld>();
        }
        return this.thld;
    }

    public DownTime.OrgInfos getOrgInfos() {
        return orgInfos;
    }

    public void setOrgInfos(DownTime.OrgInfos value) {
        this.orgInfos = value;
    }

    public ConditionInstance.Docs getDocs() {
        return docs;
    }

    public void setDocs(ConditionInstance.Docs value) {
        this.docs = value;
    }

    public ConditionInstance.Rmks getRmks() {
        return rmks;
    }

    public void setRmks(ConditionInstance.Rmks value) {
        this.rmks = value;
    }

    public ProductName.Applic getApplic() {
        return applic;
    }

    public void setApplic(ProductName.Applic value) {
        this.applic = value;
    }

    public SamplingDefinition getSamplByDef() {
        return samplByDef;
    }

    public void setSamplByDef(SamplingDefinition value) {
        this.samplByDef = value;
    }

    public SamplingDefinitionByValue getSamplByValue() {
        return samplByValue;
    }

    public void setSamplByValue(SamplingDefinitionByValue value) {
        this.samplByValue = value;
    }

    public SamplingDefinitionByRatio getSamplByRo() {
        return samplByRo;
    }

    public void setSamplByRo(SamplingDefinitionByRatio value) {
        this.samplByRo = value;
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

    public static class Thld {

        protected ParameterThresholdDefinition paramThld;
        protected TaskThresholdDefinition taskThld;
        protected SpecialEventThresholdDefinition sEvntThld;
        protected FailureModeThresholdDefinition fmThld;

        public ParameterThresholdDefinition getParamThld() {
            return paramThld;
        }

        public void setParamThld(ParameterThresholdDefinition value) {
            this.paramThld = value;
        }

        public TaskThresholdDefinition getTaskThld() {
            return taskThld;
        }

        public void setTaskThld(TaskThresholdDefinition value) {
            this.taskThld = value;
        }

        public SpecialEventThresholdDefinition getSEvntThld() {
            return sEvntThld;
        }

        public void setSEvntThld(SpecialEventThresholdDefinition value) {
            this.sEvntThld = value;
        }

        public FailureModeThresholdDefinition getFmThld() {
            return fmThld;
        }

        public void setFmThld(FailureModeThresholdDefinition value) {
            this.fmThld = value;
        }

    }

    public static class Trig {

        protected ParameterThresholdDefinition paramThld;
        protected TaskThresholdDefinition taskThld;
        protected SpecialEventThresholdDefinition sEvntThld;
        protected FailureModeThresholdDefinition fmThld;

        public ParameterThresholdDefinition getParamThld() {
            return paramThld;
        }

        public void setParamThld(ParameterThresholdDefinition value) {
            this.paramThld = value;
        }

        public TaskThresholdDefinition getTaskThld() {
            return taskThld;
        }

        public void setTaskThld(TaskThresholdDefinition value) {
            this.taskThld = value;
        }

        public SpecialEventThresholdDefinition getSEvntThld() {
            return sEvntThld;
        }

        public void setSEvntThld(SpecialEventThresholdDefinition value) {
            this.sEvntThld = value;
        }

        public FailureModeThresholdDefinition getFmThld() {
            return fmThld;
        }

        public void setFmThld(FailureModeThresholdDefinition value) {
            this.fmThld = value;
        }

    }

	public DiscreteTimeLimit() {
		super("http://www.asd-europe.org/s-series/s3000l", "DiscreteTimeLimit");
	}

}