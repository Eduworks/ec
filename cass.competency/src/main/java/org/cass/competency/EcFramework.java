package org.cass.competency;

import org.cassproject.ebac.repository.EcEncryptedValue;
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

	private void removeRelationshipsThatInclude(final String id, final int i, final Callback1<String> success, final Callback1<String> failure)
	{
		final String shortId = trimVersionFromUrl(id);
		final EcFramework me = this;
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

	private void removeLevelsThatInclude(final String id, final int i, final Callback1<String> success, final Callback1<String> failure)
	{ 
		final String shortId = trimVersionFromUrl(id);
		final EcFramework me = this;
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

		if (privateEncrypted != null && privateEncrypted)
		{
			EcEncryptedValue encrypted = EcEncryptedValue.toEncryptedValue(this, false);
			EcRepository._save(encrypted, success, failure);
		} else
		{
			EcRepository._save(this, success, failure);
		}
		
	}
	
	public void _delete(Callback1<String> success, Callback1<String> failure)
	{
		EcRepository.DELETE(this, success, failure);
	}
	
	public static void get(String id, final Callback1<EcFramework> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcFramework framework = new EcFramework();
				
				if (p1.isA(EcEncryptedValue.myType))
				{
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();
					
					p1.privateEncrypted = true;
				}
				if (p1.isAny(framework.getTypes()))
				{
					framework.copyFrom(p1);
					
					if(success != null)
						success.$invoke(framework);
				}
				else
				{
					String msg = "Resultant object is not a framework.";
					if (failure != null)
						failure.$invoke(msg);
					else
						Global.console.error(msg);
				}
				
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
	
	public static void search(EcRepository repo, String query, final Callback1<Array<EcFramework>> success, Callback1<String> failure, Object paramObj){
		String queryAdd = "";
		queryAdd = new EcFramework().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;
		
		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>(){

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if(success != null)
				{
					Array<EcFramework> ret = JSCollections.$array();
					for(int i = 0; i < p1.$length(); i++){
						
						EcFramework framework = new EcFramework();
						if(p1.$get(i).isAny(framework.getTypes())){
							framework.copyFrom(p1.$get(i));
						}else if(p1.$get(i).isA(EcEncryptedValue.myType)){
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if(val.isAnEncrypted(EcFramework.myType)){
								EcRemoteLinkedData obj = val.decryptIntoObject();
								framework.copyFrom(obj);
								framework.privateEncrypted = true;
							}
						}
						
						ret.$set(i, framework);
					}
					
					success.$invoke(ret);
				}
			}
			
		}, failure);
	}
}
