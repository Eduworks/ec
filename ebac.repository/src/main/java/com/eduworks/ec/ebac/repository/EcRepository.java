package com.eduworks.ec.ebac.repository;

import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.ebac.identity.EcIdentityManager;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;

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

				for (int i = 0; i < results.$length(); i++)
					if (eachSuccess != null)
						eachSuccess.$invoke(results.$get(i));

				if (success != null)
					success.$invoke(results);
			}
		}, failure);
	}
}
