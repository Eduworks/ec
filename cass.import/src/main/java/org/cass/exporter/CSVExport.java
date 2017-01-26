package org.cass.exporter;

import org.cass.competency.EcFramework;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSFunctionAdapter;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.dom.DOMEvent;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.jquery.GlobalJQuery;

import js.Papa;

/**
 * Export methods to handle exporting two CSV file , one of competencies
 * and one of relationships representing a framework
 * 
 * @module org.cassproject
 * @class CSVExport
 * @static
 * @extends Exporter
 * 
 * @author devlin.junker@eduworks.com
 * @author fritz.ray@eduworks.com
 */
public class CSVExport extends Exporter {
	
	static Array<Object> csvOutput;
	static Array<Object> csvRelationOutput;
	
	/**
	 * Method to export the CSV files of competencies and relationships for a framework
	 * 
	 * @memberOf CSVExport
	 * @method export
	 * @static
	 * @param {String} frameworkId
	 * 			Id of the framework to export
	 *  @param {Callback0} success
	 * 			Callback triggered after both files have been successfully exported
	 *  @param {Callback1<String>} failure
	 * 			Callback triggered if an error occurs during export
	 */
	public static void exportFramework(String frameworkId, Callback0 success, final Callback1<String> failure){
	    if (frameworkId == null) {
	    	failure.$invoke("Framework not selected.");
	        return;
	    }
	    
	    csvOutput = JSCollections.$array();
	    csvRelationOutput = JSCollections.$array();
	    
	    EcRepository.get(frameworkId, new Callback1<EcRemoteLinkedData>(){
	    	
	    	public void $invoke(EcRemoteLinkedData data) {
	    		if(data.isAny(new EcFramework().getTypes())){
	    			final EcFramework fw = new EcFramework();
	    			fw.copyFrom(data);
	    			if (fw.competency == null || fw.competency.$length() == 0)
			            failure.$invoke("No Competencies in Framework");
			        
			        for (int i = 0; i < fw.competency.$length(); i++) {
			            String competencyUrl = fw.competency.$get(i);
			            
			            EcRepository.get(competencyUrl, new Callback1<EcRemoteLinkedData>(){
			            	public void $invoke(EcRemoteLinkedData competency) {
		                        csvOutput.push(Global.JSON.parse(competency.toJson()));
		                        
		                        Map<String, Object> props = JSObjectAdapter.$properties(Global.JSON.parse(competency.toJson()));
		                        
		                        for(String prop : props){
		                        	if(props.$get(prop) != null && props.$get(prop) != ""){
			                        	for(int i = 0 ; i < csvOutput.$length(); i++){
			                        		Object row = csvOutput.$get(i);
			                        		if(!JSObjectAdapter.hasOwnProperty(row, prop)){
			                        			JSObjectAdapter.$put(row, prop, "");
			                        		}
			                        	}
		                        	}
		                        }
		                        
		                        if (csvOutput.$length() == fw.competency.$length()) {
		                            String csv = Papa.unparse(csvOutput);
		                            Element pom = Global.window.document.createElement("a");
		                            
		                            pom.setAttribute("href", "data:text/csv;charset=utf-8," + Global.encodeURIComponent(csv));
		                            pom.setAttribute("download", fw.name + " - Competencies.csv");
	
		                            if(JSObjectAdapter.$get(Global.window.document, "createEvent") != null){
		                            	DOMEvent event = JSFunctionAdapter.call(JSObjectAdapter.$get(Global.window.document, "createEvent"), Global.window.document, "MouseEvents");
		                                
		                            	JSFunctionAdapter.call(JSObjectAdapter.$get(event, "initEvent"), event, "click", true, true);
		                                
		                            	pom.dispatchEvent(event);
		                            }else{
		                            	JSFunctionAdapter.call(JSObjectAdapter.$get(pom, "click"), pom);
		                            }
		                            
		                            
		                        } else {
		                            // incremental if we want
			            		}
			            	}
	                    }, failure);
			        }
			        
			        for (int i = 0; i < fw.relation.$length(); i++) {
			            String relationUrl = fw.relation.$get(i);
			            
			            EcRepository.get(relationUrl, new Callback1<EcRemoteLinkedData>(){
			            	public void $invoke(EcRemoteLinkedData relation) {
			            		csvRelationOutput.push(Global.JSON.parse(relation.toJson()));
			            		
			            		Map<String, Object> props = JSObjectAdapter.$properties(Global.JSON.parse(relation.toJson()));
		                        
		                        for(String prop : props){
		                        	if(props.$get(prop) != null && props.$get(prop) != ""){
			                        	for(int i = 0 ; i < csvOutput.$length(); i++){
			                        		Object row = csvOutput.$get(i);
			                        		if(!JSObjectAdapter.hasOwnProperty(row, prop)){
			                        			JSObjectAdapter.$put(row, prop, "");
			                        		}
			                        	}
		                        	}
		                        }
			            		
		                        if (csvRelationOutput.$length() == fw.relation.$length()) {
		                            String csv = Papa.unparse(csvRelationOutput);
		                            Element pom = Global.window.document.createElement("a");
		                            
		                            pom.setAttribute("href", "data:text/csv;charset=utf-8," + Global.encodeURIComponent(csv));
		                            pom.setAttribute("download", fw.name + " - Relations.csv");
	
		                            if(JSObjectAdapter.$get(Global.window.document, "createEvent") != null){
		                            	DOMEvent event = JSFunctionAdapter.call(JSObjectAdapter.$get(Global.window.document, "createEvent"), Global.window.document, "MouseEvents");
		                                
		                            	JSFunctionAdapter.call(JSObjectAdapter.$get(event, "initEvent"), event, "click", true, true);
		                                
		                            	pom.dispatchEvent(event);
		                            }else{
		                            	JSFunctionAdapter.call(JSObjectAdapter.$get(pom, "click"), pom);
		                            }
		                            
		                        } else {
		                            // incremental if we want
			            		}
			            	}
	                    }, failure);
			        }
	    		}
	    		
		        
	    	}
	    }, failure);
	}
	
}
