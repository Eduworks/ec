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
 * Implementation of a Level object with methods for interacting with CASS
 * services on a server.
 * 
 * @module org.cassproject
 * @class EcLevel
 * @constructor
 * @extends Level
 * 
 * @author fritz.ray@eduworks.com
 * @author devlin.junker@eduworks.com
 */
public class EcLevel extends Level
{
	/**
	 * Adds a relationship between this level and a target level to define
	 * how they correspond to one another
	 * 
	 * @memberOf EcLevel
	 * @method addRelationship
	 * @param {EcLevel} targetLevel
	 * 			Target level of the relationship
	 * @param {String} alignmentType
	 * 			Type of relationship
	 * @param {EcPpk} identity
	 * 			Private key that will own the new relationship
	 * @param {String} server
	 * 			URL Prefix of the new relationship ID (Server it will be saved on)
	 */
	public void addRelationship(EcLevel targetLevel, String alignmentType, final EcPpk identity, final String server)
	{
		final EcAlignment a = new EcAlignment();
		a.source = id;
		a.target = targetLevel.id;
		a.relationType = alignmentType;
		a.addOwner(identity.toPk());
		a.generateId(server);
		a.signWith(identity);
	}
	
	/**
	 * Method to set the name of this level
	 * 
	 * @memberOf EcLevel
	 * @method setName
	 * @param {String} name
	 * 			Name to set on the level
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Method to set the description of the level
	 * 
	 * @memberOf EcLevel
	 * @method setDescription
	 * @param {String} description
	 * 			Description to set on the level
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	/**
	 * Saves this levels details to the server
	 * 
	 * @memberOf EcLevel
	 * @method save
	 * @param {Callback1<String>} success
	 * 			Callback triggered on successfully saving the level to the server
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error occurs while saving the level to the server
	 */
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
		
		EcRepository._save(this, success, failure);
	}
	
	/**
	 * Deletes the level from it's repository
	 * 
	 * @memberOf EcLevel
	 * @method _delete
	 * @param {Callback1<String>} success
	 * 			Callback triggered when the level is successfully deleted from the server
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if an error occurs while deleting the level
	 */
	public void _delete(Callback1<String> success, Callback1<String> failure){
		EcRepository.DELETE(this, success, failure);
	}
	
	/**
	 * Retrieves a level from the server specified by its ID
	 * 
	 * @memberOf EcLevel
	 * @method get
	 * @static
	 * @param {String} id
	 * 			ID of the level to retrieve
	 * @param {Callback1<EcLevel>} success
	 * 			Callback triggered when successfully retrieving the level, 
	 * 			returns the level
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error occurs when retrieving the level
	 */
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
					
					EcEncryptedValue.encryptOnSave(p1.id, true);
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
	
	/**
	 * Searches for levels using a competency that the results must be related to
	 * 
	 * @memberOf EcLevel
	 * @method searchByCompetency
	 * @static
	 * @param {EcRepository} repo
	 * 			Repository to search for levels
	 * @param {String} competencyId
	 * 			competency ID that the levels are rleated to
	 * @param {Callback1<Array<EcLevel>>} success
	 * 			Callback triggered when searches successfully
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if an error occurs while searching
	 * @param {Object} paramObj
	 * 			Search parameters object to pass in
	 * 		@param size
	 * 		@param start
	 */
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
								EcEncryptedValue.encryptOnSave(level.id, true);
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
