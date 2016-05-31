package org.cassproject.ebac.repository;

import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSON;
import org.stjs.javascript.JSObjectAdapter;
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
		for (int i = 0;i < urls.$length();i++)
		{
			String url = urls.$get(i);
			if (url.startsWith(selectedServer) && JSObjectAdapter.$get(cache,url) == null)
			{
				cacheUrls.push(url.replace(selectedServer, ""));
			}
		}
		if (cacheUrls.$length() == 0) return;
		FormData fd = new FormData();
		fd.append("data", Global.JSON.stringify(cacheUrls));
		fd.append("signatureSheet", EcIdentityManager.signatureSheet(60000, selectedServer));
		EcRemote.postExpectingObject(selectedServer, "sky/repo/multiGet", fd, new Callback1<Object>()
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
		FormData fd = new FormData();
		fd.append("signatureSheet", EcIdentityManager.signatureSheet(60000, url));
		EcRemote.postExpectingObject(url, null, fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object p1)
			{
				EcRemoteLinkedData d = new EcRemoteLinkedData("", "");
				d.copyFrom(p1);				
				if (caching)
					JSObjectAdapter.$put(cache, url, d);
				success.$invoke(d);
			}
		}, failure);
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
		FormData fd = new FormData();
		fd.append("data", query);
		fd.append("signatureSheet", EcIdentityManager.signatureSheet(60000, selectedServer));
		EcRemote.postExpectingObject(selectedServer, "sky/repo/search", fd, new Callback1<Object>()
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
	public void searchWithParams(String query, Object params, final Callback1<EcRemoteLinkedData> eachSuccess,
			final Callback1<Array<EcRemoteLinkedData>> success, final Callback1<String> failure)
	{
		FormData fd = new FormData();
		fd.append("data", query);
		if (params != null)
			fd.append("searchParams", Global.JSON.stringify(params));
		fd.append("signatureSheet", EcIdentityManager.signatureSheet(60000, selectedServer));
		EcRemote.postExpectingObject(selectedServer, "sky/repo/search", fd, new Callback1<Object>()
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

	public void autoDetectRepository()
	{
		EcRemote.async = false;
		Array<String> protocols = new Array<String>();
		protocols.push("https:");
		if (Global.window.location.protocol == "http:")
			protocols.push("http:");
		Array<String> hostnames = new Array<String>();
		
		if (Global.window.location.host != null)
			hostnames.push(
					Global.window.location.host, 
					Global.window.location.host.replace(".", ".service."), 
					Global.window.location.host + ":8080",
					Global.window.location.host.replace(".", ".service.") + ":8080");
		
		if (Global.window.location.hostname != null)
			hostnames.push(
					Global.window.location.hostname, 
					Global.window.location.hostname.replace(".", ".service."), 
					Global.window.location.hostname	+ ":8080", 
					Global.window.location.hostname.replace(".", ".service.") + ":8080");
		
		hostnames.push("localhost", "localhost" + ":8080", "localhost" + ":9722");
		
		Array<String> servicePrefixes = new Array<String>("/"+Global.window.location.pathname.split("/")[1]+"/api/custom/","/", "/service/", "/api/custom/", "/levr/api/custom/");
		for (int i = 0; i < protocols.$length(); i++)
			for (int j = 0; j < hostnames.$length(); j++)
				for (int k = 0; k < servicePrefixes.$length(); k++)
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
			}
			catch (Exception ex)
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

	public static void save(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure){
		Global.console.warn("Watch out! "+data.id+" is being saved with the repository save function, no value checking will occur");

		if(data.privateEncrypted != null && data.privateEncrypted.booleanValue()){
			EcEncryptedValue encrypted = EcEncryptedValue.toEncryptedValue(data, false);
			_save(encrypted, success, failure);
		}else{
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
		EcIdentityManager.sign(data);
		if(!data.isA(EcEncryptedValue.myType))
			data.updateTimestamp();
		FormData fd = new FormData();
		fd.append("data", data.toJson());
		fd.append("signatureSheet", EcIdentityManager.signatureSheetFor(data.owner, 60000, data.id));
		EcRemote.postExpectingString(data.id, "", fd, success, failure);
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
		Global.console.warn("Watch out! "+data.id+" is being deleted with the repository delete function, no clean up delete operations will occur");
		
		DELETE(data, success, failure);
	}
	
	public static void DELETE(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure)
	{
		if (caching)
		{
			JSObjectAdapter.$properties(cache).$delete(data.id);
			JSObjectAdapter.$properties(cache).$delete(data.shortId());
		}
		EcRemote._delete(data.shortId(), EcIdentityManager.signatureSheet(60000, data.id), success, failure);
	}

	public static void sign(EcRemoteLinkedData data, EcPpk pen)
	{
		data.signature.push(EcRsaOaep.sign(pen, data.toSignableJson()));
	}

}
