/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:55 CDT 2019
 *
 **/

package s6000t;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import s6000t.TaskKnowledgeSkillAttitudeRequirement;

public class TaskKnowledgeSkillAttitudeRequirementItem extends EcRemoteLinkedData {

    protected Array<TaskKnowledgeSkillAttitudeRequirement> ksaReq;

    public Array<TaskKnowledgeSkillAttitudeRequirement> getKsaReq() {
        if (ksaReq == null) {
            ksaReq = new Array<TaskKnowledgeSkillAttitudeRequirement>();
        }
        return this.ksaReq;
    }

	public TaskKnowledgeSkillAttitudeRequirementItem() {
		super("http://www.asd-europe.org/s-series/s6000t", "TaskKnowledgeSkillAttitudeRequirementItem");
	}

}