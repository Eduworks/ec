/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:55 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class TaskJustification extends EcRemoteLinkedData {

    protected TaskRequirementReference taskReqRef;
    protected String uid;
    protected CrudCodeValues crud;

    public TaskRequirementReference getTaskReqRef() {
        return taskReqRef;
    }

    public void setTaskReqRef(TaskRequirementReference value) {
        this.taskReqRef = value;
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

	public TaskJustification() {
		super("http://www.asd-europe.org/s-series/s3000l", "TaskJustification");
	}

}
