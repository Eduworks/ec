/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:52 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Date;

public class CandidateItemAnalysisActivityRationale extends EcRemoteLinkedData {

    protected String descr;
    protected LanguageCodeValues lang;
    protected Date date;
    protected OrganizationReference providedBy;
    protected s3000l.ProductName.Applic applic;

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

    public s3000l.ProductName.Applic getApplic() {
        return applic;
    }

    public void setApplic(s3000l.ProductName.Applic value) {
        this.applic = value;
    }

	public CandidateItemAnalysisActivityRationale() {
		super("http://www.asd-europe.org/s-series/s3000l", "CandidateItemAnalysisActivityRationale");
	}

}
