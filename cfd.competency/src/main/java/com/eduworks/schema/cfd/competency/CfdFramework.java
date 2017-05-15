package com.eduworks.schema.cfd.competency;

import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;

public class CfdFramework extends EcFramework {
	
	private static Map<String, Integer> toRemove;
	private static Map<String, Integer> removed;
	
	/**
	 * Deletes this framework from the server specified by it's ID
	 *
	 * @memberOf CfdFramework
	 * @method _delete
	 * @param {Callback1<String>} success
	 * 			Callback triggered if successfully deleted framework
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error occurs when deleting the framework
	 */
	public void _delete(final Callback1<String> success, final Callback1<String> failure)
	{
		if(toRemove == null)
			toRemove = JSCollections.$map();
		int remove = 0;
		remove += (this.competency == null ? 0 : this.competency.$length());
		remove += (this.relation == null ? 0 : this.relation.$length());
		toRemove.$put(this.shortId(), remove);
		
		if(removed == null)
			removed = JSCollections.$map();
		removed.$put(this.shortId(), 0);
		 
		final CfdFramework that = this;
		 
		final Callback0 onAllRemove = new Callback0(){
			 public void $invoke(){
				 EcRepository.DELETE(that, success, failure);
			 }
    	 };
		 
    	 if (remove == 0)
    		 onAllRemove.$invoke();
    	 
    	 if(this.competency != null && this.competency.$length() > 0){
    		 for (int x=0; x<this.competency.$length(); x++) {
    	 			CfdCompetency.get(this.competency.$get(x), new Callback1<EcCompetency>(){
    	 				public void $invoke(final EcCompetency comp){
    	 					comp._delete(new Callback1<String>(){
    	 		 				public void $invoke(String p1){
    		 			    	    removed.$put(that.shortId(), removed.$get(that.shortId())+1);
    	 		 					if(removed.$get(that.shortId()) == toRemove.$get(that.shortId()))
    		 		        			onAllRemove.$invoke();
    	 		 				}
    	 	    			}, new Callback1<String>(){
    	 	    				public void $invoke(String err){
    		 	    				String error = "Error deleting competency ("+comp.id+"): "+err;
    		 			    	    
    		 	    				failure.$invoke(error);
    		 	    				
    		 	    				removed.$put(that.shortId(), removed.$get(that.shortId())+1);
    	 		 					if(removed.$get(that.shortId()) == toRemove.$get(that.shortId()))
    		 		        			onAllRemove.$invoke();
    	 	    				}
    	 	    			}, null);
    	 					
    	 				}
    	 			},	new Callback1<String>(){
    	 				public void $invoke(String err){
    						String error = "Error retrieving competency to delete: "+err;
    		        		
    						failure.$invoke(error);
    		        		
    						removed.$put(that.shortId(), removed.$get(that.shortId())+1);
 		 					if(removed.$get(that.shortId()) == toRemove.$get(that.shortId()))
	 		        			onAllRemove.$invoke();
    	 				}
    				});
    			 }
    	 }
		 
    	 if(this.relation != null && this.relation.$length() > 0){
			 for (int x=0; x<this.relation.$length(); x++) {
		    	EcAlignment.get(this.relation.$get(x), new Callback1<EcAlignment>(){
	 				public void $invoke(final EcAlignment rel){
						rel._delete(new Callback1<String>(){
			 				public void $invoke(String p1){	    				    	   
			 					removed.$put(that.shortId(), removed.$get(that.shortId())+1);
	 		 					if(removed.$get(that.shortId()) == toRemove.$get(that.shortId()))
		 		        			onAllRemove.$invoke();
			 				}
		        		}, new Callback1<String>(){
		     				public void $invoke(String err){
			        			String error = "Error deleting relation ("+rel.id+"): "+err;
				        		
			        			failure.$invoke(error);
				        		
				        		removed.$put(that.shortId(), removed.$get(that.shortId())+1);
	 		 					if(removed.$get(that.shortId()) == toRemove.$get(that.shortId()))
		 		        			onAllRemove.$invoke();
		     				}
		        		});
	 				}
				}, new Callback1<String>(){
	 				public void $invoke(String err){
						String error = "Error retrieving relationship to delete: "+err;
		        		
						failure.$invoke(error);
						removed.$put(that.shortId(), removed.$get(that.shortId())+1);
		 					if(removed.$get(that.shortId()) == toRemove.$get(that.shortId()))
			        			onAllRemove.$invoke();
	 				}
				});
			 }
    	 }
    	 
    	 if(removed.$get(that.shortId()) == toRemove.$get(that.shortId()))
  			onAllRemove.$invoke();
	}


	/**
	 * Retrieves a framework from the server, specified by the ID
	 *
	 * @memberOf CfdFramework
	 * @method get
	 * @static
	 * @param {String} id
	 * 			ID of the framework to retrieve
	 * @param {Callback1<EcFramework>} success
	 * 			Callback triggered after successfully retrieving the framework,
	 * 			returns the retrieved framework
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if an error occurs while retrieving the framework
	 */
	public static void cfdGet(String id, final Callback1<CfdFramework> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				CfdFramework framework = new CfdFramework();

				if (p1.isA(EcEncryptedValue.myType))
				{
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();

					EcEncryptedValue.encryptOnSave(p1.id, true);
				}
				if (p1.isAny(framework.getTypes()))
				{
					framework.copyFrom(p1);

					if (success != null)
						success.$invoke(framework);
				} else
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

	/**
	 * Retrieves a framework from the server in a blocking fashion, specified by the ID
	 *
	 * @memberOf CfdFramework
	 * @method getBlocking
	 * @static
	 * @param {String} id
	 * 			ID of the framework to retrieve
	 * @param {Callback1<EcFramework>} success
	 * 			Callback triggered after successfully retrieving the framework,
	 * 			returns the retrieved framework
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if an error occurs while retrieving the framework
	 */
	public static CfdFramework cfdGetBlocking(String id) {
		EcRemoteLinkedData p1 = EcRepository.getBlocking(id);
		if (p1 == null) return null;
		CfdFramework framework = new CfdFramework();

		if (p1.isA(EcEncryptedValue.myType)) {
			EcEncryptedValue encrypted = new EcEncryptedValue();
			encrypted.copyFrom(p1);
			p1 = encrypted.decryptIntoObject();

			EcEncryptedValue.encryptOnSave(p1.id, true);
		}
		if (p1.isAny(framework.getTypes())) {
			framework.copyFrom(p1);
			return framework;
		} else {
			return null;
		}
	}



	/**
	 * Searches the repository given for frameworks using the query passed in
	 *
	 * @memberOf CfdFramework
	 * @method search
	 * @static
	 * @param {EcRepository} repo
	 * 			Repository to search for frameworks
	 * @param {String} query
	 * 			Query string used to search for a framework
	 * @param {Callback1<Array<EcFramework>} success
	 * 			Callback triggered when the search successfully returns,
	 * 			returns search results
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if an error occurs while searching
	 * @param {Object} paramObj
	 * 			Parameter object for search
	 * 		@param size
	 * 		@param start
	 */
	public static void cfdSearch(EcRepository repo, String query, final Callback1<Array<CfdFramework>> success, Callback1<String> failure, Object paramObj)
	{
		String queryAdd = "";
		queryAdd = new EcFramework().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>()
		{

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1)
			{
				if (success != null)
				{
					Array<CfdFramework> ret = JSCollections.$array();
					for (int i = 0; i < p1.$length(); i++)
					{

						CfdFramework framework = new CfdFramework();
						if (p1.$get(i).isAny(framework.getTypes()))
						{
							framework.copyFrom(p1.$get(i));
						} else if (p1.$get(i).isA(EcEncryptedValue.myType))
						{
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if (val.isAnEncrypted(EcFramework.myType))
							{
								EcRemoteLinkedData obj = val.decryptIntoObject();
								framework.copyFrom(obj);
								EcEncryptedValue.encryptOnSave(framework.id, true);
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
