/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Mon Jul 29 11:33:20 CDT 2019
 *
 **/

package s6000t;

import org.cassproject.schema.general.EcRemoteLinkedData;
import s6000t.LearningObjectiveIdentifier;

public class LearningObjectiveRef extends EcRemoteLinkedData {

    protected LearningObjectiveIdentifier loId;
    protected Object uidRef;
    protected String uriRef;

    public LearningObjectiveIdentifier getLoId() {
        return loId;
    }

    public void setLoId(LearningObjectiveIdentifier value) {
        this.loId = value;
    }

    public Object getUidRef() {
        return uidRef;
    }

    public void setUidRef(Object value) {
        this.uidRef = value;
    }

    public String getUriRef() {
        return uriRef;
    }

    public void setUriRef(String value) {
        this.uriRef = value;
    }

	public LearningObjectiveRef() {
		super("http://www.asd-europe.org/s-series/s6000t", "LearningObjectiveRef");
	}

}