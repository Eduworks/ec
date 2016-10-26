package org.cass.importer;

import org.cass.competency.EcCompetency;
import org.cassproject.ebac.identity.EcIdentity;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.w3c.dom.events.Event;

import com.eduworks.ec.array.toString;

import js.FileReader;
import js.X2JS;

public class MedbiqImport extends Importer {

	static Array<EcCompetency> medbiqXmlCompetencies;
     
	private final static int INCREMENTAL_STEP = 5;
	
    
    public static void medbiqXmlLookForCompetencyObject(Object obj)
    {
 	    if (isObject(obj) || isArray(obj))
 	    	for (String key : JSObjectAdapter.$properties(obj)) {
 	            if (key == "CompetencyObject")
 	                medbiqXmlParseCompetencyObject(JSObjectAdapter.$get(obj, key));
 	            else
 	                medbiqXmlLookForCompetencyObject(JSObjectAdapter.$get(obj, key));
 	        }
    }
    
    public static void medbiqXmlParseCompetencyObject(Object obj)
    {
    	if (isArray(obj)) {
	        for (String key : JSObjectAdapter.$properties(obj)) {
	            medbiqXmlParseCompetencyObject(JSObjectAdapter.$get(obj, key));
	        }
	    } else {
	        EcCompetency newCompetency = new EcCompetency();
	        
	        if (JSObjectAdapter.$get(obj, "lom") != null && JSObjectAdapter.$get(JSObjectAdapter.$get(obj, "lom"), "general") != null) {

	        	newCompetency.name = JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(obj, "lom"), "general"), "title"), "string").toString();
	            
	        	if (JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(obj, "lom"), "general"), "description") != null)
	                newCompetency.description = JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(obj, "lom"), "general"), "description"), "string").toString();
	            
	        	if (JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(obj, "lom"), "general"), "identifier") != null)
	                newCompetency.url = JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(obj, "lom"), "general"), "identifier"), "entry").toString();	        		
	            
	        	if (newCompetency.description == null)
	                newCompetency.description = "";
	            
	        	medbiqXmlCompetencies.push(newCompetency);
	        }
	    }
    }
    
	public static void analyzeFile(Object file, final Callback1<Array<EcCompetency>> success, final Callback1<String> failure)
	{
		if(file == null)
		{
			failure.$invoke("No file to analyze");
			return;
		}
		
		if(JSObjectAdapter.$get(file, "name") == null){
			failure.$invoke("Invalid file");
			return;
		}else if(!((String)JSObjectAdapter.$get(file, "name")).endsWith(".xml")){
			failure.$invoke("Invalid file type");
			return;
		}
		
		FileReader reader = new FileReader();
		
		reader.onload = new Callback1<Object>() {
			@Override
			public void $invoke(Object e) {
				String result = (String)JSObjectAdapter.$get(JSObjectAdapter.$get(e, "target"), "result");
				
				Object jsonObject = new X2JS().xml_str2json(result);
				
				medbiqXmlCompetencies = JSCollections.$array();
				
				medbiqXmlLookForCompetencyObject(jsonObject);
				
				success.$invoke(medbiqXmlCompetencies);
			}
		};
		
		reader.onerror = new Callback1<Object>() {
			@Override
			public void $invoke(Object p1) {
				failure.$invoke("Error Reading File");
			}
		};
		
		reader.readAsText(file);
	}
	
	static Object progressObject;
	static int saved;
	public static void importCompetencies(final String serverUrl, final EcIdentity owner,
			final Callback1<Array<EcCompetency>> success, final Callback1<Object> failure, final Callback1<Object> incremental)
	{
		progressObject = null;
		saved = 0;
		for (int i = 0; i < medbiqXmlCompetencies.$length(); i++) {
			EcCompetency comp = medbiqXmlCompetencies.$get(i);
			
			comp.generateId(serverUrl);
			 
			if(owner != null)
				comp.addOwner(owner.ppk.toPk());
			
			comp.save(new Callback1<String>(){
				@Override
				public void $invoke(String p1) {
					saved++;
					
					if(saved % INCREMENTAL_STEP == 0){
						if(progressObject == null)
							progressObject = new Object();
						
						JSObjectAdapter.$put(progressObject, "competencies", saved);
							
						incremental.$invoke(progressObject);
					}
					
					if(saved == medbiqXmlCompetencies.$length()){
						if(progressObject == null)
							progressObject = new Object();
						
						JSObjectAdapter.$put(progressObject, "competencies", saved);
						incremental.$invoke(progressObject);
						
						success.$invoke(medbiqXmlCompetencies);
					}
				} 
			}, new Callback1<String>(){
				@Override
				public void $invoke(String p1) {
					failure.$invoke("Failed to Save Competency");
				} 
			});
		 }
	}
}
