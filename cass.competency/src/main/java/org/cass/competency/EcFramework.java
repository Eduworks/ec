package org.cass.competency;

import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Framework;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;

public class EcFramework extends Framework
{
	public void addCompetency(String id, final Callback1<String> success, final Callback1<String> failure)
	{
		id = trimVersionFromUrl(id);
		if (competency == null)
			competency = new Array<String>();
		for (int i = 0; i < competency.$length(); i++)
			if (competency.$get(i).equals(id))
				return;
		competency.push(id);
		EcRepository.save(this, success, failure);
	}

	public void removeCompetency(String id2, final Callback1<String> success, final Callback1<String> failure)
	{
		final String id = trimVersionFromUrl(id2);
		if (competency == null)
			competency = new Array<String>();
		for (int i = 0; i < competency.$length(); i++)
			if (competency.$get(i).equals(id))
				competency.splice(i, 1);
		if (relation != null)
		{
			removeRelationshipsThatInclude(id, 0, success, failure);
		}
		EcRepository.save(this, success, failure);
	}

	private void removeRelationshipsThatInclude(String id, int i, final Callback1<String> success, final Callback1<String> failure)
	{
		EcFramework me = this;
		if (i >= relation.$length())
			EcRepository.save(this, success, failure);
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
						relation.splice(i, 1);
						me.removeRelationshipsThatInclude(id, i, success, failure);
					}
					else
						me.removeRelationshipsThatInclude(id, i + 1, success, failure);
				}
			}, failure);
	}

	public void addRelation(String id, final Callback1<String> success, final Callback1<String> failure)
	{
		id = trimVersionFromUrl(id);
		if (relation == null)
			relation = new Array<String>();
		for (int i = 0; i < relation.$length(); i++)
			if (relation.$get(i).equals(id))
				return;
		relation.push(id);
		EcRepository.save(this, success, failure);
	}

	public void removeRelation(String id, final Callback1<String> success, final Callback1<String> failure)
	{
		id = trimVersionFromUrl(id);
		if (relation == null)
			relation = new Array<String>();
		for (int i = 0; i < relation.$length(); i++)
			if (relation.$get(i).equals(id))
				relation.splice(i, 1);
		EcRepository.save(this, success, failure);
	}
}
