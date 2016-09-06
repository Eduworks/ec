package org.cass.competency;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.Cass;
import org.cassproject.schema.cass.competency.Relation;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.functions.Callback1;

/**
 * TODO: Test case where an absent relation is in the framework.
 * @author fritz.ray@eduworks.com
 *
 */
public class EcAlignment extends Relation
{

	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void save(Callback1<String> success, Callback1<String> failure){
		if(source == null || source == ""){
			String msg = "Source Competency cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(target == null || target == ""){
			String msg = "Target Competency cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(relationType == null || relationType == ""){
			String msg = "Relation Type cannot be missing";
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
	
	public void _delete(Callback1<String> success, Callback1<String> failure){
		EcRepository.DELETE(this, success, failure);
	}
	
	public static void get(String id, final Callback1<EcAlignment> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcAlignment relation = new EcAlignment();
				
				if (p1.isA(EcEncryptedValue.myType))
				{
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();
					
					p1.privateEncrypted = true;
				}
				if (p1.isAny(relation.getTypes()))
				{
					relation.copyFrom(p1);
					
					if(success != null)
						success.$invoke(relation);
				}
				else
				{
					String msg = "Resultant object is not a relation.";
					if (failure != null)
						failure.$invoke(msg);
					else
						Global.console.error(msg);
				}
				
			}
		}, failure);
	}
	
	public static void search(EcRepository repo, String query, final Callback1<Array<EcAlignment>> success, Callback1<String> failure, Object paramObj){
		String queryAdd = new EcAlignment().getSearchStringByType();
		
		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;
		
		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>(){

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if(success != null)
				{
					Array<EcAlignment> ret = JSCollections.$array();
					for(int i = 0; i < p1.$length(); i++){
						EcAlignment alignment = new EcAlignment();
						if(p1.$get(i).isAny(alignment.getTypes())){
							alignment.copyFrom(p1.$get(i));
						}else if(p1.$get(i).isA(EcEncryptedValue.myType)){
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if(val.isAnEncrypted(EcAlignment.myType)){
								EcRemoteLinkedData obj = val.decryptIntoObject();
								alignment.copyFrom(obj);
								alignment.privateEncrypted = true;
							}
						}
						
						ret.$set(i, alignment);
					}
					
					success.$invoke(ret);
				}
			}
			
		}, failure);
	}
	
	public static void searchBySource(EcRepository repo, final String sourceId, final Callback1<Array<EcAlignment>> success, Callback1<String> failure, Object paramObj){
		String query = "";
		query = "("+new EcAlignment().getSearchStringByType();
		final String noVersion = EcRemoteLinkedData.trimVersionFromUrl(sourceId);
		if (noVersion == sourceId)
		{
			query += " AND (source:\""+sourceId+"\"))";
		}
		else
		{
			query += " AND (source:\"" +sourceId+"\" OR source:\""+noVersion+"\"))";
		}
		
		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>(){

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if(success != null)
				{
					Array<EcAlignment> ret = JSCollections.$array();
					for(int i = 0; i < p1.$length(); i++){
						EcAlignment alignment = new EcAlignment();
						if(p1.$get(i).isAny(alignment.getTypes())){
							alignment.copyFrom(p1.$get(i));
						}else if(p1.$get(i).isA(EcEncryptedValue.myType)){
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if(val.isAnEncrypted(EcAlignment.myType)){
								EcRemoteLinkedData obj = val.decryptIntoObject();
								if(JSObjectAdapter.$get(obj, "source") != sourceId && JSObjectAdapter.$get(obj, "source") != noVersion){
									continue;
								}
								alignment.copyFrom(obj);
								alignment.privateEncrypted = true;
							}
						}
						ret.$set(i, alignment);
					}
					
					success.$invoke(ret);
				}
			}
			
		}, failure);
	}
	
	public static void searchByCompetency(EcRepository repo, final String competencyId, final Callback1<Array<EcAlignment>> success, Callback1<String> failure, Object paramObj)
	{
		String query = "";
		query = "("+new EcAlignment().getSearchStringByType();
		final String noVersion = EcRemoteLinkedData.trimVersionFromUrl(competencyId);
		if (noVersion == competencyId)
		{
			query += " AND (source:\""+competencyId+"\" OR target:\""+competencyId+"\"))";
		}
		else
		{
			query += " AND (source:\"" +competencyId+"\" OR source:\""+noVersion+"\" OR target:\"" +competencyId+"\" OR target:\""+noVersion+"\"))";
		}
		
		query += " OR @encryptedType:\""+EcAlignment.myType+"\" OR @encryptedType:\""+EcAlignment.myType.replace(Cass.context+"/", "")+"\")";

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>(){

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if(success != null)
				{
					Array<EcAlignment> ret = JSCollections.$array();
					for(int i = 0; i < p1.$length(); i++){
						EcAlignment alignment = new EcAlignment();
						if(p1.$get(i).isAny(alignment.getTypes())){
							alignment.copyFrom(p1.$get(i));
						}else if(p1.$get(i).isA(EcEncryptedValue.myType)){
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if(val.isAnEncrypted(EcAlignment.myType)){
								EcRemoteLinkedData obj = val.decryptIntoObject();
								if(JSObjectAdapter.$get(obj, "source") != competencyId && JSObjectAdapter.$get(obj, "source") != noVersion && 
										JSObjectAdapter.$get(obj, "target") != competencyId && JSObjectAdapter.$get(obj, "target") != noVersion){
									continue;
								}
								alignment.copyFrom(obj);
								alignment.privateEncrypted = true;
							}
						}
						ret.$set(i, alignment);
					}
					
					success.$invoke(ret);
				}
			}
			
		}, failure);
	}

}
