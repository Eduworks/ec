package org.cassproject.ebac.repository;

import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;

public class EcRepository
{
	public String selectedServer = null;

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
	public static void get(String url, final Callback1<EcRemoteLinkedData> success, final Callback1<String> failure)
	{
		FormData fd = new FormData();
		fd.append("signatureSheet", EcIdentityManager.signatureSheet(10000, url));
		EcRemote.postExpectingObject(url, null, fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object p1)
			{
				EcRemoteLinkedData d = new EcRemoteLinkedData("", "");
				d.copyFrom(p1);
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
		fd.append("signatureSheet", EcIdentityManager.signatureSheet(10000, selectedServer));
		EcRemote.postExpectingObject(selectedServer, "sky/repo/search", fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object p1)
			{
				Array<EcRemoteLinkedData> results = (Array<EcRemoteLinkedData>) p1;

				if (eachSuccess != null)
					for (int i = 0; i < results.$length(); i++)
						eachSuccess.$invoke(results.$get(i));

				if (success != null)
					success.$invoke(results);
			}
		}, failure);
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
	public void save(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure)
	{
		if (data.id == null)
			throw new RuntimeException("Cannot save data that has no ID.");
		FormData fd = new FormData();
		fd.append("data", data.toJson());
		fd.append("signatureSheet", EcIdentityManager.signatureSheetFor(data.owner, 10000, data.id));
		EcRemote.postExpectingString(data.id, "", fd, success, failure);
	}

	public void update(EcRemoteLinkedData data, final Callback1<EcRemoteLinkedData> success, final Callback1<String> failure)
	{
		EcRepository.get(data.id, success, failure);
	}

	public void sign(EcRemoteLinkedData data, EcPpk pen)
	{
		data.signature.push(EcRsaOaep.sign(pen, data.toSignableJson()));
	}

}
