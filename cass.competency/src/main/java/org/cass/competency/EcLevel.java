package org.cass.competency;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.Cass;
import org.cassproject.schema.cass.competency.Level;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPpk;

/**
 * @author fritz.ray@eduworks.com
 */
public class EcLevel extends Level
{
	public void addRelationship(EcLevel level, EcLevel targetLevel, String alignmentType, final EcPpk identity, final String server	)
	{
		final EcAlignment a = new EcAlignment();
		a.source = id;
		a.target = targetLevel.id;
		a.relationType = alignmentType;
		a.addOwner(identity.toPk());
		a.generateId(server);
		a.signWith(identity);
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void save(Callback1<String> success, Callback1<String> failure){
		if(name == null || name == ""){
			String msg = "Level name cannot be empty";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(competency == null || competency == ""){
			String msg = "Level's Competency cannot be empty";
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
	
	public void _delete(Callback1<String> success, Callback1<String> failure, EcRepository repo){
		EcRepository.DELETE(this, success, failure);
	}
	
	public static void get(String id, final Callback1<EcLevel> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcLevel level = new EcLevel();
				
				if (p1.isA(EcEncryptedValue.myType))
				{
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();
					
					p1.privateEncrypted = true;
				}
				if (p1.isAny(level.getTypes()))
				{
					level.copyFrom(p1);
					
					if(success != null)
						success.$invoke(level);
				}
				else
				{
					String msg = "Resultant object is not a level.";
					if (failure != null)
						failure.$invoke(msg);
					else
						Global.console.error(msg);
				}
			}
		}, failure);
	}
	
	public static void searchByCompetency(EcRepository repo, final String competencyId, final Callback1<Array<EcLevel>> success, Callback1<String> failure, Object paramObj){
		if(competencyId == null || competencyId == "")
		{
			failure.$invoke("No Competency Specified");
			return;
		}
		
		String query = "("+new EcLevel().getSearchStringByType();
		
		query += " AND ( competency:\"" + competencyId + "\" OR competency:\""+EcRemoteLinkedData.trimVersionFromUrl(competencyId)+"\"))";
		
		query += " OR @encryptedType:\""+EcLevel.myType+"\" OR @encryptedType:\""+EcLevel.myType.replace(Cass.context+"/", "")+"\"";
		
		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>(){

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if(success != null)
				{
					Array<EcLevel> levels = JSCollections.$array();
					
					for(int i = 0; i < p1.$length(); i++){
						EcLevel level = new EcLevel();
						
						if(p1.$get(i).isAny(level.getTypes())){
							level.copyFrom(p1.$get(i));
						}else if(p1.$get(i).isA(EcEncryptedValue.myType)){
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if(val.isAnEncrypted(EcLevel.myType)){
								EcRemoteLinkedData obj = val.decryptIntoObject();
								if(JSObjectAdapter.$get(obj, "competency") != competencyId){
									continue;
								}
								level.copyFrom(obj);
								level.privateEncrypted = true;
							}
						}
						level.copyFrom(p1.$get(i));
						levels.$set(i, level);
					}
					
					if(success != null)
						success.$invoke(levels);
				}
			}
			
		}, failure);
	}
}
