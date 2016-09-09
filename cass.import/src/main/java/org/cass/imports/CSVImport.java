package org.cass.imports;

import org.cass.competency.EcCompetency;
import org.cassproject.ebac.identity.EcIdentity;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

import papa.Papa;
import papa.PapaParseParams;

public class CSVImport {
	
	public static void analyzeFile(Object file, final Callback1<Object> success, final Callback1<Object> failure)
	{
		Papa.parse(file, new PapaParseParams(){ {
			complete = new Callback1<Object>(){
				@Override
				public void $invoke(Object results) {
					Object tabularData = JSObjectAdapter.$get(results, "data");
					success.$invoke(tabularData);
				}
			};
			error = failure;
		} });
	}
	
	static Array<EcCompetency> competencies;
	static int saved;
    
	public static void importCompetencies(Object file, final String serverUrl, final EcIdentity owner,
			final int nameIndex, final int descriptionIndex, final int scopeIndex, 
			final Callback1<Array<EcCompetency>> success, final Callback1<Object> failure)
	{
		
		if(nameIndex < 0){
			failure.$invoke("Name Index not Set");
			return;
		}
		
		Papa.parse(file, new PapaParseParams(){ {
			complete = new Callback1<Object>(){
				@Override
				public void $invoke(Object results) {
					Array<Array<String>> tabularData = (Array<Array<String>>)JSObjectAdapter.$get(results, "data");
					
					competencies = JSCollections.$array();
					
					for(int i = 1; i < tabularData.$length(); i++){
						EcCompetency competency = new EcCompetency();
	                    if (tabularData.$get(i).$get(nameIndex) == null || tabularData.$get(i).$get(nameIndex) == ""){
	                    	//ViewManager.getView("#importCompetenciesMessageContainer").displayAlert("Name column contained blank value or could not be found in the CSV", "findName");
	                    	failure.$invoke("Name column contained blank value or could not be found in the CSV");
	                    	return;
	                    }
	                    //ViewManager.getView("#importCompetenciesMessageContainer").clearAlert("findName");
	                    competency.name = tabularData.$get(i).$get(nameIndex);
	                    
	                    if (descriptionIndex >= 0)
	                    	competency.description = tabularData.$get(i).$get(descriptionIndex);
	                    if (scopeIndex >= 0)
	                        competency.scope = tabularData.$get(i).$get(scopeIndex);
	                    
	                    competency.generateId(serverUrl);
	                    
	                    if (owner != null)
	                        competency.addOwner(owner.ppk.toPk());
	                    
	                    competencies.push(competency);
					}
					
					saved = 0;
	                for(int i = 0; i < competencies.$length(); i++)
	                {
	                	EcCompetency comp = competencies.$get(i);
	                	comp.save(new Callback1<String>(){
	                		public void $invoke(String results){
	                			saved++;
	                			
	                			if(saved == competencies.$length())
									success.$invoke(competencies);
	                		}
	                		
	                	}, new Callback1<String>(){
	                		public void $invoke(String results){
	                			failure.$invoke("Failed to save competency");
	                			
	                			for(int j = 0 ; j < competencies.$length(); j++){
	                				competencies.$get(j)._delete(null, null, null);
	                			}
	                		}
	                	});
	                }
				}
			};
			error = failure;
		} });
	}
}
