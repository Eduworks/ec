package org.cassproject.ebac.repository;

import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSON;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.Window;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;

public class EcRepository
{
	public String selectedServer = null;
	public static boolean caching = false;
	public static Object cache = new Object();

	public void precache(Array<String> urls)
	{
		Array<String> cacheUrls = new Array<String>();
		for (int i = 0; i < urls.$length(); i++)
		{
			String url = urls.$get(i);
			if (url.startsWith(selectedServer) && JSObjectAdapter.$get(cache, url) == null)
			{
				cacheUrls.push(url.replace(selectedServer, ""));
			}
		}
		if (cacheUrls.$length() == 0)
			return;
		final FormData fd = new FormData();
		fd.append("data", Global.JSON.stringify(cacheUrls));
		final EcRepository me = this;
		EcIdentityManager.signatureSheetAsync(60000, selectedServer, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				fd.append("signatureSheet", p1);
				EcRemote.postExpectingObject(me.selectedServer, "sky/repo/multiGet", fd, new Callback1<Object>()
				{
					@Override
					public void $invoke(Object p1)
					{
						Array<EcRemoteLinkedData> results = (Array<EcRemoteLinkedData>) p1;
						for (int i = 0; i < results.$length(); i++)
						{
							EcRemoteLinkedData d = new EcRemoteLinkedData(null, null);
							d.copyFrom(results.$get(i));
							results.$set(i, d);
							if (caching)
								JSObjectAdapter.$put(cache, d.shortId(), d);
						}
					}
				}, null);
			}
		});
	}

	/**
	 * Gets a JSON-LD object from the place designated by the URI.
	 * 
	 * Uses a signature sheet gathered from {@link EcIdentityManager}.
	 * 
	 * @param url
	 *            URL of the remote object.
	 * @param success
	 *            Event to call upon successful retrieval.
	 * @param failure
	 *            Event to call upon spectacular failure.
	 */
	public static void get(final String url, final Callback1<EcRemoteLinkedData> success, final Callback1<String> failure)
	{
		if (caching)
			if (JSObjectAdapter.$get(cache, url) != null)
			{
				success.$invoke((EcRemoteLinkedData) JSObjectAdapter.$get(cache, url));
				return;
			}
		final FormData fd = new FormData();
		EcIdentityManager.signatureSheetAsync(60000, url, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				fd.append("signatureSheet", p1);
				EcRemote.postExpectingObject(url, null, fd, new Callback1<Object>()
				{
					@Override
					public void $invoke(Object p1)
					{
						EcRemoteLinkedData d = new EcRemoteLinkedData("", "");
						d.copyFrom(p1);
						if (d.getFullType() == null) {
							if (failure != null)
								failure.$invoke(Global.JSON.stringify(p1));
			                return;
			            }
						if (caching)
							JSObjectAdapter.$put(cache, url, d);
						success.$invoke(d);
					}
				}, failure);
			}
		});
	}

	/**
	 * Search a repository for JSON-LD compatible data.
	 * 
	 * Uses a signature sheet gathered from {@link EcIdentityManager}.
	 * 
	 * @param query
	 *            ElasticSearch compatible query string, similar to Google query
	 *            strings.
	 * @param eachSuccess
	 *            Success event for each found object.
	 * @param success
	 *            Success event, called after eachSuccess.
	 * @param failure
	 *            Failure event.
	 */
	public void search(String query, final Callback1<EcRemoteLinkedData> eachSuccess, final Callback1<Array<EcRemoteLinkedData>> success,
			final Callback1<String> failure)
	{
		searchWithParams(query, null, eachSuccess, success, failure);
	}

	/**
	 * Search a repository for JSON-LD compatible data.
	 * 
	 * Uses a signature sheet gathered from {@link EcIdentityManager}.
	 * 
	 * @param query
	 *            ElasticSearch compatible query string, similar to Google query
	 *            strings.
	 * @param paramObj
	 *            Additional parameters that can be used to tailor the search.
	 * @param eachSuccess
	 *            Success event for each found object.
	 * @param success
	 *            Success event, called after eachSuccess.
	 * @param failure
	 *            Failure event.
	 */
	public void searchWithParams(String query, Object paramObj, 
			final Callback1<EcRemoteLinkedData> eachSuccess,
			final Callback1<Array<EcRemoteLinkedData>> success, 
			final Callback1<String> failure)
	{
		if(paramObj == null)
			paramObj = new Object();
		
		Object params = new Object();
		Map<String, Object> paramProps = JSObjectAdapter.$properties(params);
		if(JSObjectAdapter.$get(paramObj, "start") != null)
			paramProps.$put("start", JSObjectAdapter.$get(paramObj, "start"));
		if(JSObjectAdapter.$get(paramObj, "size") != null)
			paramProps.$put("size", JSObjectAdapter.$get(paramObj, "size"));
		if(JSObjectAdapter.$get(paramObj, "types") != null)
			paramProps.$put("types", JSObjectAdapter.$get(paramObj, "types"));
			
		if(JSObjectAdapter.$get(paramObj, "ownership") != null)
		{
			String ownership = (String) JSObjectAdapter.$get(paramObj, "ownership");
			if(!query.startsWith("(") || !query.endsWith(")")){
				query = "("+query+")";
			}
			
			if(ownership.equals("public")){
				query +=" AND (_missing_:@owner)";
			}else if(ownership.equals("owned")){
				query +=" AND (_exists_:@owner)";
			}else if(ownership.equals("me")){
				query +=" AND (";
				for(int i = 0; i < EcIdentityManager.ids.$length(); i++){
					if(i != 0){
						query+=" OR ";
					}
					EcIdentity id = EcIdentityManager.ids.$get(i);
					
					query+="@owner:\""+id.ppk.toPk().toPem()+"\"";
				}
				
				query += ")";
			}
		}
		
		if(JSObjectAdapter.$get(paramObj, "fields") != null)
			paramProps.$put("fields", JSObjectAdapter.$get(paramObj, "fields"));
		
		
		
		final FormData fd = new FormData();
		fd.append("data", query);
		if (params != null)
			fd.append("searchParams", Global.JSON.stringify(params));
		final EcRepository me = this;
		EcIdentityManager.signatureSheetAsync(60000, selectedServer,new Callback1<String>()
		{
			@Override
			public void $invoke(String signatureSheet)
			{
				fd.append("signatureSheet", signatureSheet);
				EcRemote.postExpectingObject(me.selectedServer, "sky/repo/search", fd, new Callback1<Object>()
				{
					@Override
					public void $invoke(Object p1)
					{
						Array<EcRemoteLinkedData> results = (Array<EcRemoteLinkedData>) p1;

						for (int i = 0; i < results.$length(); i++)
						{
							EcRemoteLinkedData d = new EcRemoteLinkedData(null, null);
							d.copyFrom(results.$get(i));
							results.$set(i, d);
							if (caching)
								JSObjectAdapter.$put(cache, d.shortId(), d);
							if (eachSuccess != null)
								eachSuccess.$invoke(results.$get(i));
						}

						if (success != null)
							success.$invoke(results);
					}
				}, failure);
			}
		});
	}

	public void autoDetectRepository()
	{
		EcRemote.async = false;
		Array<String> protocols = new Array<String>();
		protocols.push("https:");
		if (Global.window != null)
			if (Global.window.location != null)
				if (Global.window.location.protocol == "http:")
					protocols.push("http:");
		Array<String> hostnames = new Array<String>();

		if (Global.window.location.host != null)
			hostnames.push(Global.window.location.host, Global.window.location.host.replace(".", ".service."), Global.window.location.host + ":8080",
					Global.window.location.host.replace(".", ".service.") + ":8080");

		if (Global.window.location.hostname != null)
			hostnames.push(Global.window.location.hostname, Global.window.location.hostname.replace(".", ".service."),
					Global.window.location.hostname + ":8080", Global.window.location.hostname.replace(".", ".service.") + ":8080");

		hostnames.push("localhost", "localhost" + ":8080", "localhost" + ":9722");

		Array<String> servicePrefixes = new Array<String>("/" + Global.window.location.pathname.split("/")[1] + "/api/custom/", "/", "/service/",
				"/api/custom/");
		for (int j = 0; j < hostnames.$length(); j++)
			for (int k = 0; k < servicePrefixes.$length(); k++)
				for (int i = 0; i < protocols.$length(); i++)
					if (autoDetectRepositoryActual(protocols.$get(i) + "//" + hostnames.$get(j) + servicePrefixes.$get(k)))
					{
						EcRemote.async = true;
						return;
					}
		EcRemote.async = true;
	}

	public boolean autoDetectFound = false;

	public boolean autoDetectRepositoryActual(final String guess)
	{
		final EcRepository me = this;
		Callback1<Object> successCheck = new Callback1<Object>()
		{
			@Override
			public void $invoke(Object p1)
			{
				if (p1 != null)
					if (JSObjectAdapter.$get(p1, "ping").equals("pong"))
					{
						me.selectedServer = guess;
						me.autoDetectFound = true;
					}
			}
		};
		Callback1<String> failureCheck = new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				if (p1 != null)
					if (!p1.equals(""))
						if (p1.contains("pong"))
						{
							me.selectedServer = guess;
							me.autoDetectFound = true;
						}
			}
		};
		if (guess != null && guess.equals("") == false)
			try
			{
				EcRemote.getExpectingObject(guess, "ping", successCheck, failureCheck);
			} catch (Exception ex)
			{

			}
		return autoDetectFound;
	}

	/**
	 * Lists all types visible to the current user in the repository
	 * 
	 * Uses a signature sheet gathered from {@link EcIdentityManager}.
	 * 
	 * @param success
	 *            Success event
	 * @param failure
	 *            Failure event.
	 */
	public void listTypes(final Callback1<Array<Object>> success, final Callback1<String> failure)
	{
		FormData fd = new FormData();
		fd.append("signatureSheet", EcIdentityManager.signatureSheet(60000, selectedServer));
		EcRemote.postExpectingObject(selectedServer, "sky/repo/types", fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object p1)
			{
				Array<Object> results = (Array<Object>) p1;

				if (success != null)
					success.$invoke(results);
			}
		}, failure);
	}

	public static String escapeSearch(String query)
	{
		String s = null;
		s = JSCollections.$castArray(query.split("\\")).join("\\\\");
		s = JSCollections.$castArray(s.split("-")).join("\\-");
		s = JSCollections.$castArray(s.split("=")).join("\\=");
		s = JSCollections.$castArray(s.split("&&")).join("\\&&");
		s = JSCollections.$castArray(s.split("||")).join("\\||");
		s = JSCollections.$castArray(s.split("<")).join("\\<");
		s = JSCollections.$castArray(s.split(">")).join("\\>");
		s = JSCollections.$castArray(s.split("|")).join("\\|");
		s = JSCollections.$castArray(s.split("(")).join("\\(");
		s = JSCollections.$castArray(s.split(")")).join("\\)");
		s = JSCollections.$castArray(s.split("{")).join("\\{");
		s = JSCollections.$castArray(s.split("}")).join("\\}");
		s = JSCollections.$castArray(s.split("[")).join("\\[");
		s = JSCollections.$castArray(s.split("]")).join("\\]");
		s = JSCollections.$castArray(s.split("^")).join("\\^");
		s = JSCollections.$castArray(s.split("\"")).join("\\\"");
		s = JSCollections.$castArray(s.split("~")).join("\\~");
		s = JSCollections.$castArray(s.split("*")).join("\\*");
		s = JSCollections.$castArray(s.split("?")).join("\\?");
		s = JSCollections.$castArray(s.split(":")).join("\\:");
		s = JSCollections.$castArray(s.split("/")).join("\\/");
		s = JSCollections.$castArray(s.split("+")).join("\\+");
		return s;
	}

	public static void save(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure)
	{
		Global.console.warn("Watch out! " + data.id + " is being saved with the repository save function, no value checking will occur");

		if(data.invalid())
		{
			String msg = "Cannot save data. It is missing a vital component.";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if (data.privateEncrypted != null && data.privateEncrypted)
		{
			EcEncryptedValue encrypted = EcEncryptedValue.toEncryptedValue(data, false);
			_save(encrypted, success, failure);
		} else
		{
			_save(data, success, failure);
		}
	}
	
	/**
	 * Attempts to save a piece of data.
	 * 
	 * Uses a signature sheet informed by the owner field of the data.
	 * 
	 * @param data
	 *            Data to save to the location designated by its id.
	 * @param success
	 * @param failure
	 */
	public static void _save(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure)
	{
		EcIdentityManager.sign(data);
		_saveWithoutSigning(data, success, failure);
	}

	/**
	 * Attempts to save a piece of data without signing it.
	 * 
	 * Uses a signature sheet informed by the owner field of the data.
	 * 
	 * @param data
	 *            Data to save to the location designated by its id.
	 * @param success
	 * @param failure
	 */
	private static void _saveWithoutSigning(final EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure) 
	{
	
		if (caching)
		{
			JSObjectAdapter.$properties(cache).$delete(data.id);
			JSObjectAdapter.$properties(cache).$delete(data.shortId());
		}
		if (data.invalid())
		{
			failure.$invoke("Data is malformed.");
			return;
		}
		
		data.updateTimestamp();
		
		final FormData fd = new FormData();
		fd.append("data", data.toJson());
		EcIdentityManager.signatureSheetForAsync(data.owner, 60000, data.id, new Callback1<String>()
		{
			@Override
			public void $invoke(String arg0)
			{
				fd.append("signatureSheet", arg0);
				EcRemote.postExpectingString(data.id, "", fd, success, failure);
			}
		});
	}

	/**
	 * Attempts to delete a piece of data.
	 * 
	 * Uses a signature sheet informed by the owner field of the data.
	 * 
	 * @param data
	 *            Data to save to the location designated by its id.
	 * @param success
	 * @param failure
	 */
	public static void _delete(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure)
	{
		Global.console.warn("Watch out! " + data.id + " is being deleted with the repository delete function, no clean up delete operations will occur");

		DELETE(data, success, failure);
	}

	public static void DELETE(final EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure)
	{
		if (caching)
		{
			JSObjectAdapter.$properties(cache).$delete(data.id);
			JSObjectAdapter.$properties(cache).$delete(data.shortId());
		}
		EcIdentityManager.signatureSheetAsync(60000, data.id, new Callback1<String>()
		{
			@Override
			public void $invoke(String signatureSheet)
			{
				EcRemote._delete(data.shortId(), signatureSheet, success, failure);
			}
		});
	}
}
