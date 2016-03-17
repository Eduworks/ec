package org.cass.competency;

import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Framework;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;

public class EcFramework extends Framework
{
	public void addCompetency(String id)
	{
		id = trimVersionFromUrl(id);
		if (competency == null)
			competency = new Array<String>();
		for (int i = 0; i < competency.$length(); i++)
			if (competency.$get(i).equals(id))
				return;
		competency.push(id);
	}

	public void removeCompetency(String id2, final Callback1<String> success, final Callback1<String> failure)
	{
		final String id = trimVersionFromUrl(id2);
		if (competency == null)
			competency = new Array<String>();
		for (int i = 0; i < competency.$length(); i++)
			if (competency.$get(i).equals(id))
				competency.splice(i, 1);
		if (relation == null && level == null)
			success.$invoke("");
		if (relation != null)
		{
			removeRelationshipsThatInclude(id, 0, success, failure);
		}
		if (level != null)
		{
			removeLevelsThatInclude(id, 0, success, failure);
		}
	}

	private void removeRelationshipsThatInclude(String id, int i, final Callback1<String> success, final Callback1<String> failure)
	{
		EcFramework me = this;
		if (i >= relation.$length())
			success.$invoke("");
		else
			EcRepository.get(relation.$get(i), new Callback1<EcRemoteLinkedData>()
			{
				@Override
				public void $invoke(EcRemoteLinkedData p1)
				{
					EcAlignment a = new EcAlignment();
					a.copyFrom(p1);
					if (a.source == id || a.target == id)
					{
						me.relation.splice(i, 1);
						me.removeRelationshipsThatInclude(id, i, success, failure);
					}
					else
						me.removeRelationshipsThatInclude(id, i + 1, success, failure);
				}
			}, failure);
	}

	private void removeLevelsThatInclude(String id, int i, final Callback1<String> success, final Callback1<String> failure)
	{
		EcFramework me = this;
		if (i >= level.$length())
			success.$invoke("");
		else
			EcRepository.get(level.$get(i), new Callback1<EcRemoteLinkedData>()
			{
				@Override
				public void $invoke(EcRemoteLinkedData p1)
				{
					EcLevel a = new EcLevel();
					a.copyFrom(p1);
					if (a.competency == id)
					{
						me.level.splice(i, 1);
						me.removeLevelsThatInclude(id, i, success, failure);
					}
					else
						me.removeLevelsThatInclude(id, i + 1, success, failure);
				}
			}, failure);
	}

	public void addRelation(String id)
	{
		id = trimVersionFromUrl(id);
		if (relation == null)
			relation = new Array<String>();
		for (int i = 0; i < relation.$length(); i++)
			if (relation.$get(i).equals(id))
				return;
		relation.push(id);
	}

	public void removeRelation(String id)
	{
		id = trimVersionFromUrl(id);
		if (relation == null)
			relation = new Array<String>();
		for (int i = 0; i < relation.$length(); i++)
			if (relation.$get(i).equals(id))
				relation.splice(i, 1);
	}
	
	public void addLevel(String id)
	{
		id = trimVersionFromUrl(id);
		if (level == null)
			level = new Array<String>();
		for (int i = 0; i < level.$length(); i++)
			if (level.$get(i).equals(id))
				return;
		level.push(id);
	}

	public void removeLevel(String id)
	{
		id = trimVersionFromUrl(id);
		if (level == null)
			level = new Array<String>();
		for (int i = 0; i < level.$length(); i++)
			if (level.$get(i).equals(id))
				level.splice(i, 1);
	}
}
