/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:54 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;

public class Project extends EcRemoteLinkedData {

    protected Array<ProjectIdentifier> projId;
    protected ProjectName name;
    protected s3000l.DownTime.OrgInfos orgInfos;
    protected s3000l.ConditionInstance.Docs docs;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected String uid;
    protected CrudCodeValues crud;

    public Array<ProjectIdentifier> getProjId() {
        if (projId == null) {
            projId = new Array<ProjectIdentifier>();
        }
        return this.projId;
    }

    public ProjectName getName() {
        return name;
    }

    public void setName(ProjectName value) {
        this.name = value;
    }

    public s3000l.DownTime.OrgInfos getOrgInfos() {
        return orgInfos;
    }

    public void setOrgInfos(s3000l.DownTime.OrgInfos value) {
        this.orgInfos = value;
    }

    public s3000l.ConditionInstance.Docs getDocs() {
        return docs;
    }

    public void setDocs(s3000l.ConditionInstance.Docs value) {
        this.docs = value;
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

	public Project() {
		super("http://www.asd-europe.org/s-series/s3000l", "Project");
	}

}
