/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:00 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Date;

public class ApplicabilityEndDate extends EcRemoteLinkedData {

    protected Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date value) {
        this.date = value;
    }

	public ApplicabilityEndDate() {
		super("http://www.asd-europe.org/s-series/s3000l", "ApplicabilityEndDate");
	}

}
