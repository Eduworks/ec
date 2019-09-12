/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:03 CDT 2019
 *
 **/

package s6000t;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Date;
import s3000l.LanguageCodeValues;
import s3000l.OrganizationReference;
import s6000t.SubtaskTrainingLevelDecision;

public class TaskBehaviorCondition extends EcRemoteLinkedData {

    protected String descr;
    protected LanguageCodeValues lang;
    protected Date date;
    protected OrganizationReference providedBy;
    protected SubtaskTrainingLevelDecision.Applic applic;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String value) {
        this.descr = value;
    }

    public LanguageCodeValues getLang() {
        return lang;
    }

    public void setLang(LanguageCodeValues value) {
        this.lang = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date value) {
        this.date = value;
    }

    public OrganizationReference getProvidedBy() {
        return providedBy;
    }

    public void setProvidedBy(OrganizationReference value) {
        this.providedBy = value;
    }

    public SubtaskTrainingLevelDecision.Applic getApplic() {
        return applic;
    }

    public void setApplic(SubtaskTrainingLevelDecision.Applic value) {
        this.applic = value;
    }

	public TaskBehaviorCondition() {
		super("http://www.asd-europe.org/s-series/s3000l", "TaskBehaviorCondition");
	}

}
