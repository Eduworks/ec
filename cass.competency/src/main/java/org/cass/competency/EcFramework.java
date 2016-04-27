package org.cass.competency;

import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Framework;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
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

	static Map<String, Boolean> relDone = JSCollections.$map();
	static Map<String, Boolean> levelDone = JSCollections.$map();
			
	public void removeCompetency(final String id, final Callback1<String> success, final Callback1<String> failure)
	{
		final String shortId = trimVersionFromUrl(id);
		if (competency == null)
			competency = new Array<String>();
		for (int i = 0; i < competency.$length(); i++)
			if (competency.$get(i).equals(shortId) || competency.$get(i).equals(id))
				competency.splice(i, 1);
		if (relation == null && level == null)
			if(success != null)
				success.$invoke("");
		
		relDone.$put(id, false);
		levelDone.$put(id, false);

		if (relation != null)
		{
			removeRelationshipsThatInclude(id, 0, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					if(levelDone.$get(id)){
						if(success != null)
							success.$invoke(p1);
					}else{
						relDone.$put(id, true);
					}
				}
			}, failure);
		}else{
			relDone.$put(id, true);
		}
		if (level != null)
		{
			removeLevelsThatInclude(id, 0, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					if(relDone.$get(id)){
						if(success != null)
							success.$invoke(p1);
					}else{
						levelDone.$put(id, true);
					}
				}
			}, failure);
		}
		else{
			levelDone.$put(id, true);
		}
	}

	private void removeRelationshipsThatInclude(String id, int i, final Callback1<String> success, final Callback1<String> failure)
	{
		final String shortId = trimVersionFromUrl(id);
		EcFramework me = this;
		if (i >= relation.$length() && success != null)
			success.$invoke("");
		else
			EcRepository.get(relation.$get(i), new Callback1<EcRemoteLinkedData>()
			{
				@Override
				public void $invoke(EcRemoteLinkedData p1)
				{
					EcAlignment a = new EcAlignment();
					a.copyFrom(p1);
					if (a.source == shortId || a.target == shortId || a.source == id || a.target == id)
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
		final String shortId = trimVersionFromUrl(id);
		EcFramework me = this;
		if (i >= level.$length() && success != null)
			success.$invoke("");
		else
			EcRepository.get(level.$get(i), new Callback1<EcRemoteLinkedData>()
			{
				@Override
				public void $invoke(EcRemoteLinkedData p1)
				{
					EcLevel a = new EcLevel();
					a.copyFrom(p1);
					if (a.competency == shortId || a.competency == id)
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
	public void save(Callback1<String> success, Callback1<String> failure)
	{
		if(this.name == null || this.name == "")
		{
			String msg = "Framework Name Cannot be Empty";
			
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		
		EcRepository._save(this, success, failure);
	}
	
	public void _delete(Callback1<String> success, Callback1<String> failure)
	{
		EcRepository.DELETE(this, success, failure);
	}
=======
	
	public static void get(String id, final Callback1<EcFramework> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				if (success == null)
					return;
				if (!p1.isA(EcFramework.myType))
				{
					if (failure != null)
						failure.$invoke("Resultant object is not a framework.");
					return;
				}
				EcFramework c = new EcFramework();
				c.copyFrom(p1);
				success.$invoke(c);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				if (failure != null)
					failure.$invoke(p1);
			}
		});
	}
}
