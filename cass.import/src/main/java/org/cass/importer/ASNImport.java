package org.cass.importer;

import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cassproject.ebac.identity.EcIdentity;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

import js.FileReader;

public class ASNImport extends Importer{
	
	static Object jsonFramework;
	static String frameworkUrl;
	
	static Map<String, Object> jsonCompetencies;
	
	public static void asnJsonPrime(Object obj, String key){
		Object value = JSObjectAdapter.$get(obj, key);
	    
		if (isObject(value)) {
	        if (JSObjectAdapter.$get(value, "http://www.w3.org/1999/02/22-rdf-syntax-ns#type") != null) {
	        	Object stringVal = JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(value,"http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), "0"), "value");
	            if (stringVal == "http://purl.org/ASN/schema/core/Statement") {
	            	jsonCompetencies.$put(key, value);
	                Array<Object> children = (Array<Object>) JSObjectAdapter.$get(value, "http://purl.org/gem/qualifiers/hasChild");
	                if (children != null)
	                    for (int j = 0; j < children.$length(); j++) {
	                        asnJsonPrime(obj, (String)JSObjectAdapter.$get(children.$get(j),"value"));
	                    }
	            }
	        }
	    }
	}
	
	public static void lookThroughSource(Object obj)
	{
		for (String key : JSObjectAdapter.$properties(obj)) {
	        Object value = JSObjectAdapter.$get(obj, key);
	        if (isObject(value)) {
	            if (JSObjectAdapter.$get(value, "http://www.w3.org/1999/02/22-rdf-syntax-ns#type") != null) {
	            	Object stringVal = JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(value,"http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), "0"), "value");
	            	if (stringVal == "http://purl.org/ASN/schema/core/StandardDocument") {
	                    jsonFramework = value;
	                    frameworkUrl = key;
	                    Array<Object> children = (Array<Object>)JSObjectAdapter.$get(value, "http://purl.org/gem/qualifiers/hasChild");
	                    if (children != null)
	                        for (int j = 0; j < children.$length(); j++) {
	                            asnJsonPrime(obj, (String)JSObjectAdapter.$get(children.$get(j),"value"));
	                        }
	                }
	            }
	        }
	    }
	}
	
	public static void analyzeFile(Object file, final Callback1<Object> success, final Callback1<Object> failure)
	{
		if(file == null)
		{
			failure.$invoke("No File to Analyze");
			return;
		}
		
		FileReader reader = new FileReader();
		
		reader.onload = new Callback1<Object>(){
			@Override
			public void $invoke(Object e) {
				String result = (String)JSObjectAdapter.$get(JSObjectAdapter.$get(e, "target"), "result");
				
				Object jsonObj = Global.JSON.parse(result);
				
				jsonCompetencies = JSCollections.$map();
				jsonFramework = null;
				frameworkUrl = "";
				
				lookThroughSource(jsonObj);
				
				if (jsonFramework == null) {
	                failure.$invoke("Could not find StandardDocument.");
	            } else {
	                success.$invoke(jsonCompetencies);
	            }
			}
		};
		
		reader.readAsText(file);
	}
	
	
	static EcFramework importedFramework;
	
	static Map<String, EcCompetency> competencies;
	
	public static void importCompetencies(String serverUrl, EcIdentity owner, boolean createFramework,
			final Callback2<Array<EcCompetency>, EcFramework> success, final Callback1<Object> failure)
	{
		competencies = JSCollections.$map();
		if(createFramework)
		{
			importedFramework = new EcFramework();
			importedFramework.competency = JSCollections.$array();
			importedFramework.relation = JSCollections.$array();
		}
		else
		{
			importedFramework = null;
		}
			
		createCompetencies(serverUrl, owner, failure);
		createRelationships(serverUrl, owner, jsonFramework, null, failure);
		
		
		
		
		
		if(createFramework){
			createFramework(serverUrl, owner, success, failure);
		}else{
			Array<EcCompetency> compList = JSCollections.$array();
			for(String key : competencies){
				compList.push(competencies.$get(key));
			}
			
			if(success != null)
				success.$invoke(compList, null);
		}
		
		
	}
	
	public static void createCompetencies(String serverUrl, EcIdentity owner, final Callback1<Object> failure)
	{
		for (String key : jsonCompetencies) {
	        EcCompetency comp = new EcCompetency();
			Object jsonComp = jsonCompetencies.$get(key);
	        
			if(JSObjectAdapter.$get(jsonComp, "http://purl.org/dc/elements/1.1/title") == null)
				comp.name = (String) JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(jsonComp, "http://purl.org/dc/terms/description"), "0"), "value");
			else
				comp.name = (String) JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(jsonComp, "http://purl.org/dc/elements/1.1/title"), "0"), "value");
			
			comp.sameAs = key;
			
			if(JSObjectAdapter.$get(jsonComp, "http://purl.org/dc/terms/description") != null)
				comp.description = (String) JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(jsonComp, "http://purl.org/dc/terms/description"), "0"), "value");
			
			comp.generateId(serverUrl);
			
			if(owner != null)
				comp.addOwner(owner.ppk.toPk());
			
			if(importedFramework != null)
				importedFramework.addCompetency(comp.shortId());
			
			competencies.$put(key, comp);
			
			comp.save(new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					
				}
			}, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					failure.$invoke("Failed to save competency");
				}
			});
	    }
	}
	
	public static void createRelationships(String serverUrl, EcIdentity owner, Object node, String nodeId, final Callback1<Object> failure)
	{
	    Array<Object> children = (Array<Object>)JSObjectAdapter.$get(node, "http://purl.org/gem/qualifiers/hasChild");
	    if (children != null)
	        for (int j = 0; j < children.$length(); j++) {
	            if (nodeId != null) {
	                EcAlignment relation = new EcAlignment();
	                
	                relation.target = competencies.$get(nodeId).shortId();
	            	relation.source = competencies.$get((String) JSObjectAdapter.$get(children.$get(j), "value")).shortId();
	            	
	            	relation.relationType = "narrows";
	            	relation.name = "";
	            	relation.description = "";
	            	relation.generateId(serverUrl);
	            	
	            	if(owner != null)
	            		relation.addOwner(owner.ppk.toPk());
	            	
	            	if(importedFramework != null)
	            		importedFramework.addRelation(relation.shortId());
	            	
	            	relation.save(new Callback1<String>() {
	            		@Override
	            		public void $invoke(String p1) {
	            			
	            		}
	            	}, new Callback1<String>() {
	            		@Override
	            		public void $invoke(String p1) {
	            			failure.$invoke("Failed to save Relationship");
	            		}
	            	});
	            }
	            
	            createRelationships(serverUrl, owner, 
	            		jsonCompetencies.$get( (String) JSObjectAdapter.$get(children.$get(j), "value") ),
	            		(String) JSObjectAdapter.$get(children.$get(j), "value"),
	            		failure
	            	);
	        }
	}
	
	
	public static void createFramework(String serverUrl, EcIdentity owner, final Callback2<Array<EcCompetency>, EcFramework> success, final Callback1<Object> failure)
	{
		importedFramework.name = (String) JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(jsonFramework, "http://purl.org/dc/elements/1.1/title"), "0"), "value");
		
        importedFramework.description = (String) JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(jsonFramework, "http://purl.org/dc/terms/description"), "0"), "value");
        
        importedFramework.generateId(serverUrl);
        importedFramework.sameAs = frameworkUrl;
        
        if (owner != null)
        	importedFramework.addOwner(owner.ppk.toPk());
        
        importedFramework.save(new Callback1<String>() {
    		@Override
    		public void $invoke(String p1) {
    			Array<EcCompetency> compList = JSCollections.$array();
    			for(String key : competencies){
    				compList.push(competencies.$get(key));
    			}
    			
    			if(success != null)
    				success.$invoke(compList, importedFramework);
    		}
    	}, new Callback1<String>() {
    		@Override
    		public void $invoke(String p1) {
    			failure.$invoke("Failed to save framework");
    		}
    	});
	}
}
