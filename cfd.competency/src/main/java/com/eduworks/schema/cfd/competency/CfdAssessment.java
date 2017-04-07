package com.eduworks.schema.cfd.competency;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.schema.AlignmentObject;
import org.schema.CreativeWork;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

/**
 * Competency is Under construction.
 * 
 * Working model of competency with CFD Assessment extension.
 * 
 * @author debbie.brown@eduworks.com
 * @author devlin.junker@eduworks.com
 * @class CfdAssessment
 * @module com.eduworks
 * @extends org.schema.CreativeWork
 */
public class CfdAssessment extends CreativeWork{

	public static final String myType = "http://schema.org/CreativeWork";
	
	public static final String edUse = "Assessment";
	
	public CfdAssessment(){
		super();
		educationalUse=edUse;
	}
	
	/**
	 * Returns the name of the assessment
	 * 
	 * @return {String} 
	 * 			name of assessment
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Sets the Name of the assessment
	 * 
	 * @param {String} name
	 * 			name of the assessment
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Gets the educational alignment of the reference
	 * 
	 * @return {CfdAlignment}
	 * 			Educational Alignment for reference
	 */
	public AlignmentObject getEducationalAlignment(){
		return educationalAlignment;
	}
	
	/**
	 * Sets the educational alignment of the reference
	 * 
	 * @param {CfdAlignment} alignment
	 * 			Educational alignment for reference
	 */
	public void setEducationalAlignment(CfdAlignment alignment){
		educationalAlignment = alignment;
	}
	
	/**
	 *  Returns the Educational Use of the reference (Should be Assessment)
	 * 
	 * @return {CfdAlignment}
	 * 			Educational Alignment for reference
	 */
	public String getEducationalUse(){
		return edUse;
	}
	
	/**
	 * Saves this alignment details on the server corresponding to its ID 
	 * 
	 * @memberOf EcAlignment
	 * @method save
	 * @param {Callback1<String>} success
	 * 			Callback triggered on successfully saving the alignment
	 * @param {Callback1<String>} [failure]
	 * 			Callback triggered if error while saving alignment
	 */
	public void save(Callback1<String> success, Callback1<String> failure){
		if(name == null || name == ""){
			String msg = "Name cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(educationalAlignment == null){
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
	 * @memberOf CfdAssessment
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
	 * @memberOf CfdAssessment
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
	public static void get(String id, final Callback1<CfdAssessment> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
                if (p1 instanceof CfdAssessment)
                    if (success != null)
                    {
                        success.$invoke((CfdAssessment) p1);
                        return;
                    }
                
                CfdAssessment assessment = new CfdAssessment();
				
				if (p1.isA(EcEncryptedValue.myType))
				{
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();
				}
				if (p1.isAny(assessment.getTypes()))
				{
					assessment.copyFrom(p1);
					
                    if (EcRepository.caching)
                    {
                        JSObjectAdapter.$put(EcRepository.cache,assessment.shortId(),assessment);
                        JSObjectAdapter.$put(EcRepository.cache,assessment.id,assessment);
                    }
					if(success != null)
						success.$invoke(assessment);
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
	 * @memberOf CfdAssessment
	 * @method getBlocking
	 * @static
	 * @param {String} id
	 * 			ID of the alignment to retrieve
	 * @return EcAlignment
	 * 			The alignment retrieved
	 */
	public static CfdAssessment getBlocking(String id)
	{
		EcRemoteLinkedData p1 = EcRepository.getBlocking(id);
                if (p1 instanceof CfdAssessment)
                    return (CfdAssessment) p1;

        CfdAssessment assessment = new CfdAssessment();

		if (p1.isA(EcEncryptedValue.myType))
		{
			EcEncryptedValue encrypted = new EcEncryptedValue();
			encrypted.copyFrom(p1);
			p1 = encrypted.decryptIntoObject();

			EcEncryptedValue.encryptOnSave(p1.id, true);
		}
		if (p1.isAny(assessment.getTypes()))
		{
			assessment.copyFrom(p1);
                    if (EcRepository.caching)
                    {
                        JSObjectAdapter.$put(EcRepository.cache,assessment.shortId(),assessment);
                        JSObjectAdapter.$put(EcRepository.cache,assessment.id,assessment);
                    }
			return assessment;
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
	 * @memberOf CfdAssessment
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
	public static void search(EcRepository repo, String query, final Callback1<Array<CfdAssessment>> success, Callback1<String> failure, Object paramObj){
		String queryAdd = new CfdAssessment().getSearchStringByType();
		
		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND educationalUse:\""+edUse+"\" AND " + queryAdd;
		
		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>(){

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if(success != null)
				{
					Array<CfdAssessment> ret = JSCollections.$array();
					for(int i = 0; i < p1.$length(); i++){
						CfdAssessment assessment = new CfdAssessment();
						if(p1.$get(i).isAny(assessment.getTypes())){
							assessment.copyFrom(p1.$get(i));
						}else if(p1.$get(i).isA(EcEncryptedValue.myType)){
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if(val.isAnEncrypted(CfdAssessment.myType)){
								EcRemoteLinkedData obj = val.decryptIntoObject();
								assessment.copyFrom(obj);
							}
						}
						
						ret.$set(i, assessment);
					}
					
					success.$invoke(ret);
				}
			}
			
		}, failure);
	}
	
	/**
	 * Searches the repository for assessments with the framework and optional parameters provided
	 * 
	 * @memberOf CfdReference
	 * @method search
	 * @static
	 * @param {EcRepository} repo
	 * 			Repository to search using the query provided
	 * @param {String} Framework
	 * 			The Framework to search for References with EducationalAlignments too
	 * @param {Callback1<Array<EcAlignment>>} success
	 * 			Callback triggered on successful search return
	 * @param {Callback1<String>} [failure]
	 * 			Callback triggered if error searching
	 * @param {Object} [paramObj]
	 * 			Parameters to include in the search
	 * 		@param start
	 * 		@param size
	 */
	public static void searchWithFramework(EcRepository repo, String framework, final Callback1<Array<CfdAssessment>> success, Callback1<String> failure, Object paramObj){
		String query = new CfdAssessment().getSearchStringByType();
		query = "(" + query + ") AND educationalUse:\""+edUse+"\" AND educationalAlignment.educationalFramework:\""+framework+"\"";
		
		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>(){

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if(success != null)
				{
					Array<CfdAssessment> ret = JSCollections.$array();
					for(int i = 0; i < p1.$length(); i++){
						CfdAssessment assessment = new CfdAssessment();
						if(p1.$get(i).isAny(assessment.getTypes())){
							assessment.copyFrom(p1.$get(i));
						}else if(p1.$get(i).isA(EcEncryptedValue.myType)){
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if(val.isAnEncrypted(CfdAssessment.myType)){
								EcRemoteLinkedData obj = val.decryptIntoObject();
								assessment.copyFrom(obj);
							}
						}
						
						ret.$set(i, assessment);
					}
					
					success.$invoke(ret);
				}
			}
			
		}, failure);
	}
}
