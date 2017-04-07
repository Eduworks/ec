package com.eduworks.schema.cfd.competency;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.schema.AlignmentObject;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

public class CfdAlignment extends AlignmentObject {

	public static final String myType = "http://schema.org/AlignmentObject";
	
	/**
	 * Gets the AlignmentObject educationalFramework field of this alignment
	 * 
	 * @param {String} frameworkId
	 * 			ID of framework this Alignment is related to
	 */
	public String getEducationalFramework(){
		return educationalFramework;
	}
	
	/**
	 * Sets the AlignmentObject educationalFramework field with the id of the framework this competency is part of
	 * 
	 * @param {String} frameworkId
	 * 			ID of framework this Alignment is related to
	 */
	public void setEducationalFramework(String frameworkId){
		educationalFramework = frameworkId;
	}
	
	/**
	 * Gets the AlignmentObject targetUrl field with the id of the competency it is aligned with
	 * 
	 * @return {String}
	 * 			ID of the competency aligned with
	 */
	public String getTargetUrl(){
		return targetUrl;
	}
	
	/**
	 * Sets the AlignmentObject targetUrl field with the id of the competency it is aligned with
	 * 
	 * @param {String} targetId
	 * 			ID of competency this Alignment is related to
	 */
	public void setTargetUrl(String targetId){
		targetUrl = targetId;
	}
	
	/**
	 * Sets the AlignmentObject alignmentType field
	 * 
	 * @param {String} type
	 * 			Alignment type for alignment. Recommended values include: 'assesses', 'teaches', 'requires', 'textComplexity', 'readingLevel', 'educationalSubject', and 'educationalLevel'.
	 */
	public void setAlignmentType(String type){
		alignmentType = type;
	}
	
	/**
	 * Saves this alignment details on the server corresponding to its ID 
	 * 
	 * @memberOf CfdAlignment
	 * @method save
	 * @param {Callback1<String>} success
	 * 			Callback triggered on successfully saving the alignment
	 * @param {Callback1<String>} [failure]
	 * 			Callback triggered if error while saving alignment
	 */
	public void save(Callback1<String> success, Callback1<String> failure){
		if(targetUrl == null || targetUrl == ""){
			String msg = "Target Competency cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(alignmentType == null || alignmentType == ""){
			String msg = "Relation Type cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		EcRepository._save(this, success, failure);
	}
	
	
	/**
	 * Deletes the alignment from the server corresponding to its ID
	 * 
	 * @memberOf CfdAlignment
	 * @method _delete
	 * @param {Callback1<String>} success
	 * 			Callback triggered on successfully deleting the alignment
	 * @param {Callback1<String>} [failure]
	 * 			Callback triggered if error while deleting alignment
	 */
	public void _delete(Callback1<String> success, Callback1<String> failure){
		EcRepository.DELETE(this, success, failure);
	}
	
	/**
	 * Retrieves the alignment specified with the ID from the server
	 * 
	 * @memberOf EcAlignment
	 * @method get
	 * @static
	 * @param {String} id
	 * 			ID of the alignment to retrieve
	 * @param {Callback1<EcAlignment>} success
	 * 			Callback triggered on successfully retrieving the alignment,
	 * 			returns the alignment
	 * @param {Callback1<String>} [failure]
	 * 			Callback triggered if error while retrieving alignment
	 */
	public static void get(String id, final Callback1<CfdAlignment> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
                if (p1 instanceof CfdAlignment)
                    if (success != null)
                    {
                        success.$invoke((CfdAlignment) p1);
                        return;
                    }
                
                CfdAlignment alignment = new CfdAlignment();
				
				if (p1.isA(EcEncryptedValue.myType))
				{
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();
				}
				if (p1.isAny(alignment.getTypes()))
				{
					alignment.copyFrom(p1);
					
                    if (EcRepository.caching)
                    {
                        JSObjectAdapter.$put(EcRepository.cache,alignment.shortId(),alignment);
                        JSObjectAdapter.$put(EcRepository.cache,alignment.id,alignment);
                    }
					if(success != null)
						success.$invoke(alignment);
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
	
	/**
	 * Retrieves an alignment from it's server synchronously, the call 
	 * blocks until it is successful or an error occurs
	 * 
	 * @memberOf EcAlignment
	 * @method getBlocking
	 * @static
	 * @param {String} id
	 * 			ID of the alignment to retrieve
	 * @return EcAlignment
	 * 			The alignment retrieved
	 */
	public static CfdAlignment getBlocking(String id)
	{
		EcRemoteLinkedData p1 = EcRepository.getBlocking(id);
                if (p1 instanceof CfdAlignment)
                    return (CfdAlignment) p1;

        CfdAlignment alignment = new CfdAlignment();

		if (p1.isA(EcEncryptedValue.myType))
		{
			EcEncryptedValue encrypted = new EcEncryptedValue();
			encrypted.copyFrom(p1);
			p1 = encrypted.decryptIntoObject();

			EcEncryptedValue.encryptOnSave(p1.id, true);
		}
		if (p1.isAny(alignment.getTypes()))
		{
			alignment.copyFrom(p1);
                    if (EcRepository.caching)
                    {
                        JSObjectAdapter.$put(EcRepository.cache,alignment.shortId(),alignment);
                        JSObjectAdapter.$put(EcRepository.cache,alignment.id,alignment);
                    }
			return alignment;
		} 
                else
		{
			String msg = "Retrieved object was not a relation";
			Global.console.error(msg);
			return null;
		}
	}
        
	/**
	 * Searches the repository using the query and optional parameters provided
	 * 
	 * @memberOf EcAlignment
	 * @method search
	 * @static
	 * @param {EcRepository} repo
	 * 			Repository to search using the query provided
	 * @param {String} query
	 * 			The query to send to the search
	 * @param {Callback1<Array<EcAlignment>>} success
	 * 			Callback triggered on successful search return
	 * @param {Callback1<String>} [failure]
	 * 			Callback triggered if error searching
	 * @param {Object} [paramObj]
	 * 			Parameters to include in the search
	 * 		@param start
	 * 		@param size
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<CfdAlignment>> success, Callback1<String> failure, Object paramObj){
		String queryAdd = new CfdAlignment().getSearchStringByType();
		
		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;
		
		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>(){

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if(success != null)
				{
					Array<CfdAlignment> ret = JSCollections.$array();
					for(int i = 0; i < p1.$length(); i++){
						CfdAlignment alignment = new CfdAlignment();
						if(p1.$get(i).isAny(alignment.getTypes())){
							alignment.copyFrom(p1.$get(i));
						}else if(p1.$get(i).isA(EcEncryptedValue.myType)){
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if(val.isAnEncrypted(CfdAlignment.myType)){
								EcRemoteLinkedData obj = val.decryptIntoObject();
								alignment.copyFrom(obj);
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
