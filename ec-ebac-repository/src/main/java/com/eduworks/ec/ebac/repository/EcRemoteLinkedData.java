package com.eduworks.ec.ebac.repository;

import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.ec.ebac.identity.EcIdentityManager;
import com.eduworks.ec.ld.EcLinkedData;
import com.eduworks.ec.random.EcRandom;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;

public class EcRemoteLinkedData extends EcLinkedData
{
	// An owner has write privileges according to a repository.
	// These owners are in PEM format.
	public Array<String> owner = null;
	public Array<String> signature = null;
	public String id = null;

	protected EcRemoteLinkedData(String schema, String type)
	{
		super(schema, type);
	}
	
	public void generateId(EcRepository server)
	{
		id = server.selectedServer;
		if (!id.endsWith("/"))
			id += "/";
		id += EcRandom.generateUUID();
		id += "/";
		id += new Date().getTime();
	}

	public void save(final Callback1<String> success, final Callback1<String> failure) throws Exception
	{
		if (id == null)
			throw new Exception("Cannot save data that has no ID.");
		FormData fd = new FormData();
		fd.append("data", toJson());
		fd.append("signatureSheet", EcIdentityManager.signatureSheetFor(owner, 1000, id));
		EcRemote.postExpectingString(id, "", fd, success, failure);
	}
	
	public void update(final Callback1<EcRemoteLinkedData> success, final Callback1<String> failure)
	{
		EcRepository.get(id, success, failure);
	}

	public EcEncryptedValue encrypt()
	{
		return EcEncryptedValue.toEncryptedValue(this, false);
	}

	public void sign(EcPpk pen)
	{
		signature.push(EcRsaOaep.sign(pen, toSignableJson()));
	}

	public boolean hasOwner(EcPk pk)
	{
		String pkPem = pk.toPem();
		for (int i = 0; i < owner.$length(); i++)
			// Homogenizing the owner's PEM string.
			if (pkPem.equals(EcPk.fromPem(owner.$get(i)).toPem()))
				return true;
		return false;
	}

	public String toSignableJson()
	{
		EcLinkedData d = (EcLinkedData) JSGlobal.JSON.parse(toJson());
		JSObjectAdapter.$properties(d).$delete("@signature");
		return d.toJson();
	}
}
