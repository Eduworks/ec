/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Sep 12 10:06:03 CDT 2019
 *
 **/

package s6000t;

import org.cassproject.schema.general.EcRemoteLinkedData;
import s3000l.OrganizationReference;

public class TaskKnowledgeSkillAttitudeGapIdentifier extends EcRemoteLinkedData {

    protected String clazz;
    protected OrganizationReference setBy;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String value) {
        this.clazz = value;
    }

    public OrganizationReference getSetBy() {
        return setBy;
    }

    public void setSetBy(OrganizationReference value) {
        this.setBy = value;
    }

	public TaskKnowledgeSkillAttitudeGapIdentifier() {
		super("http://www.asd-europe.org/s-series/s3000l", "TaskKnowledgeSkillAttitudeGapIdentifier");
	}

}
