package org.cassproject.schema.general;

import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.random.EcRandom;

public class EcRemoteLinkedData extends EcLinkedData
{
	// An owner has write privileges according to a repository.
	// These owners are in PEM format.
	public Array<String> owner;
	public Array<String> signature;
	public String id;

	public EcRemoteLinkedData(String schema, String type)
	{
		super(schema, type);
	}

	public void generateId(String server)
	{
		id = server;
		if (!id.endsWith("/"))
			id += "/";
		id += "data/";
		id += type.replace("http://", "").replaceAll("/", ".");
		id += "/";
		id += EcRandom.generateUUID();
		id += "/";
		id += new Date().getTime();
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

	public void addOwner(EcPk newOwner)
	{
		String pem = newOwner.toPem();
		if (owner == null)
			owner = new Array<String>();
		for (int i = 0; i < owner.$length(); i++)
			if (owner.$get(i).equals(pem))
				return;
		owner.push(pem);
	}

	public boolean invalid()
	{
		if (id == null)
			return true;
		if (id.contains("http://") == false)
			return true;
		if (schema == null)
			return true;
		if (getFullType() == null)
			return true;
		if (getFullType().contains("http://") == false)
			return true;
		return false;
	}
}
