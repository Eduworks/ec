package org.cassproject.ebac.repository;

import org.cassproject.ebac.identity.EcIdentityManager;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import com.eduworks.schema.ebac.EcRemoteLinkedData;

public class EcRepository
{
	public String selectedServer = null;

	public static void get(String uri, final Callback1<EcRemoteLinkedData> success, final Callback1<String> failure)
	{
		FormData fd = new FormData();
		fd.append("signatureSheet", EcIdentityManager.signatureSheet(1000, uri));
		EcRemote.postExpectingObject(uri, null, fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object p1)
			{
				success.$invoke((EcRemoteLinkedData) p1);
			}
		}, failure);
	}

	public void search(String query, final Callback1<EcRemoteLinkedData> eachSuccess, final Callback1<Array<EcRemoteLinkedData>> success,
			final Callback1<String> failure)
	{
		FormData fd = new FormData();
		fd.append("data", query);
		fd.append("signatureSheet", EcIdentityManager.signatureSheet(1000, selectedServer));
		EcRemote.postExpectingObject(selectedServer, null, fd, new Callback1<Object>()
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
	public void save(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure) throws Exception
	{
		if (data.id == null)
			throw new Exception("Cannot save data that has no ID.");
		FormData fd = new FormData();
		fd.append("data", data.toJson());
		fd.append("signatureSheet", EcIdentityManager.signatureSheetFor(data.owner, 1000, data.id));
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
