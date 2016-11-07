package org.cass.importer;

import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

/**
 * Importer methods to copy or link to competencies that already
 * exist in another framework in a CASS instance.
 * 
 * @module org.cassproject
 * @class FrameworkImport
 * @static
 * @extends Importer
 * 
 * @author devlin.junker@eduworks.com
 */
public class FrameworkImport {

	public static int saved;
	
	public static EcFramework targetUsable;
	
	static Array<EcCompetency> competencies;
	
	
	/**
	 * Copies or links competencies that exist in one framework in a CASS instance, 
	 * to another different framework in the same CASS instance.
	 * 
	 * @memberOf FrameworkImport
	 * @method importCompetencies
	 * @static
	 * @param {EcFramework} source
	 * 			Framework to copy or link the competencies from
	 * @param {EcFramework} target
	 * 			Framework to add the copied or linked competencies to
	 * @param {boolean} copy
	 * 			Flag indicating whether or not to copy or link the competencies in the source framework
	 * @param {String} serverUrl
	 * 			URL Prefix for the created competencies if copied
	 * @param {EcIdentity} owner
	 * 			EcIdentity that will own the created competencies if copied
	 * @param {Callback1<Array<EcCompetency>>} success
	 * 			Callback triggered after succesfully copying or linking all of the competencies,
	 * 			returns an array of the new or linked competencies
	 * @param {Callback1<Object>} failure
	 * 			Callback triggered if an error occurred while creating the competencies
	 */
	public static void importCompetencies(final EcFramework source, EcFramework target, boolean copy, 
			final String serverUrl, final EcIdentity owner,
			final Callback1<Array<EcCompetency>> success, final Callback1<Object> failure)
	{
		
		if(source == null)
		{
			failure.$invoke("Source Framework not set");
			return;
		}
		
		if(target == null)
		{
			failure.$invoke("Target Framework not Set");
			return;
		}
		targetUsable = target;
		
		if(source.competency == null || source.competency.$length() == 0)
		{
			failure.$invoke("Source Has No Competencies");
			return;
		}
		
		competencies = JSCollections.$array();
		if(copy){
			saved = 0;
			
			for(int i = 0; i < source.competency.$length(); i++){
				String id = source.competency.$get(i);
				
				EcCompetency.get(id, new Callback1<EcCompetency>(){
					public void $invoke(EcCompetency comp){
						EcCompetency competency = new EcCompetency();
						competency.copyFrom(comp);
						
						competency.generateId(serverUrl);
						
						if (owner != null)
	                        competency.addOwner(owner.ppk.toPk());
						
						final String id = competency.id;
						competency.save(new Callback1<String>(){
							public void $invoke(String str){
								saved++;
								targetUsable.addCompetency(id);
								
								if(saved == competencies.$length()){
									targetUsable.save(new Callback1<String>() {
										@Override
										public void $invoke(String p1) {
											success.$invoke(competencies);
										}
									}, new Callback1<String>(){
										@Override
										public void $invoke(String p1) {
											failure.$invoke(p1);
										}
									});
								}
							}
						}, new Callback1<String>(){
							public void $invoke(String str){
								failure.$invoke("Trouble Saving Copied Competency");
							}
						});
						
						competencies.push(competency);
					}
				}, new Callback1<String>(){
					public void $invoke(String str){
						failure.$invoke(str);
					}
				});
				
			}
	
		}else{
			for(int i = 0; i < source.competency.$length(); i++)
			{
				if(target.competency == null || (target.competency.indexOf(source.competency.$get(i)) == -1 
						&& target.competency.indexOf(EcRemoteLinkedData.trimVersionFromUrl(source.competency.$get(i))) == -1))
				{
					EcCompetency.get(source.competency.$get(i), new Callback1<EcCompetency>(){
						@Override
						public void $invoke(EcCompetency comp){
							competencies.push(comp);
							
							targetUsable.addCompetency(comp.id);
							
							if(competencies.$length() == source.competency.$length()){
								JSObjectAdapter.$properties(targetUsable).$delete("competencyObjects");
								targetUsable.save(new Callback1<String>() {
									@Override
									public void $invoke(String p1) {
										success.$invoke(competencies);
									}
								}, new Callback1<String>(){
									@Override
									public void $invoke(String p1) {
										failure.$invoke(p1);
									}
								});
							}
						}
					}, new Callback1<String>(){
						@Override
						public void $invoke(String p1) {
							failure.$invoke(p1);
						}
					});
				}
			}
			
			
		}
	}
}
