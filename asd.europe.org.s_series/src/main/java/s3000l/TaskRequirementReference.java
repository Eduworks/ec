/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:03 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class TaskRequirementReference extends EcRemoteLinkedData {

    protected TaskRequirementIdentifier trId;
    protected Object uidRef;

    public TaskRequirementIdentifier getTrId() {
        return trId;
    }

    public void setTrId(TaskRequirementIdentifier value) {
        this.trId = value;
    }

    public Object getUidRef() {
        return uidRef;
    }

    public void setUidRef(Object value) {
        this.uidRef = value;
    }

	public TaskRequirementReference() {
		super("http://www.asd-europe.org/s-series/s3000l", "TaskRequirementReference");
	}

}
