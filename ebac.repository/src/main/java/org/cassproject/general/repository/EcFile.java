package org.cassproject.general.repository;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;


public class EcFile extends GeneralFile {
	
	
	public void save(final Callback1<String> success, Callback1<String> failure)
	{
		if(this.name == null || this.name == "")
		{
			String msg = "Competency Name can not be empty";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(this.invalid()){
			String msg = "Cannot save file. It is missing a vital component.";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(privateEncrypted != null && privateEncrypted){
			EcEncryptedValue encrypted = EcEncryptedValue.toEncryptedValue(this, false);
			EcRepository._save(encrypted, success, failure);
		}else{
			EcRepository._save(this, success, failure);
		}
	}
	
	public void _delete(final Callback1<String> success, final Callback1<String> failure){
		EcRepository.DELETE(this, success, failure);
	}
	
	
	public static EcFile create(String name, String base64Data, String mimeType){
		EcFile f = new EcFile();
		f.data = base64Data;
		f.name = name;
		f.mimeType = mimeType;
		
		return f;
	}
	
	public static void get(String id, final Callback1<EcFile> success, final Callback1<String> failure){
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcFile f = new EcFile();
				if (p1.isA(EcEncryptedValue.myType))
				{
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();
					
					p1.privateEncrypted = true;
				}
				if (p1 != null && p1.isA(GeneralFile.myType))
				{
					f.copyFrom(p1);
					
					if(success != null)
						success.$invoke(f);
				}else{
					if (failure != null)
						failure.$invoke("Resultant object is not a competency.");
					return;
				}
			}
		}, failure);
	}
	
	public static void search(EcRepository repo, String query, final Callback1<Array<EcFile>> success, Callback1<String> failure, Object paramObj){
		String queryAdd = "";

		queryAdd = new GeneralFile().getSearchStringByType();
		
		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>(){
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if(success != null)
				{
					Array<EcFile> ret = JSCollections.$array();
					for(int i = 0; i < p1.$length(); i++){
						EcFile file = new EcFile();
						if(p1.$get(i).isAny(file.getTypes())){
							file.copyFrom(p1.$get(i));
						}else if(p1.$get(i).isA(EcEncryptedValue.myType)){
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if(val.isAnEncrypted(EcFile.myType)){
								EcRemoteLinkedData obj = val.decryptIntoObject();
								file.copyFrom(obj);
								file.privateEncrypted = true;
							}
						}

						ret.$set(i, file);
					}
					
					success.$invoke(ret);
				}
			}
		}, failure);
	}
	
}
