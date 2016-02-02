package org.cassproject.schema.general;

import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.ec.random.EcRandom;

/**
 * Data wrapper to represent remotely hosted data. Includes necessary fields for
 * permission controls, signing, and identification of the object.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EcRemoteLinkedData extends EcLinkedData
{
	// An owner has write privileges according to a repository.
	// These owners are in PEM format.
	/**
	 * PEM encoded public keys of the owner of the object. A repository, upon
	 * receiving a write operation, will ensure either the data did not
	 * previously exist, or that an owner has provided a signature authorizing
	 * the replacement of the old data with the new data.
	 */
	public Array<String> owner;
	/**
	 * PEM encoded public keys of identities authorized to view the object. A
	 * repository will ignore write operations from these identities, but will
	 * allow them to read the object.
	 */
	public Array<String> reader;
	/**
	 * Signatures of the object. The signing method is as follows: Remove the
	 * signature field. Encode the object and its fields in ascii-sort order
	 * JSON-LD using a space-free, tab-free encoding. Sign the aforementioned
	 * string.
	 */
	public Array<String> signature;
	/**
	 * URL/URI used to retrieve and store the object, plus identify the object.
	 */
	public String id;

	public EcRemoteLinkedData(String schema, String type)
	{
		super(schema, type);
	}

	/**
	 * Will generate an identifier using the server URL provided (usually from
	 * an EcRepository).
	 * 
	 * @param server
	 *            Base URL of the server's repository functionality.
	 */
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

	/**
	 * Determines if the object has pk as an owner. Homogenizes the PEM strings
	 * for comparison.
	 * 
	 * @param pk
	 * @return True if owner is represented by the PK, false otherwise.
	 */
	public boolean hasOwner(EcPk pk)
	{
		String pkPem = pk.toPem();
		for (int i = 0; i < owner.$length(); i++)
			// Homogenizing the owner's PEM string.
			if (pkPem.equals(EcPk.fromPem(owner.$get(i)).toPem()))
				return true;
		return false;
	}

	/**
	 * Encodes the object in a form where it is ready to be signed.
	 * 
	 * @return ASCII-sort order encoded space-free and tab-free JSON-LD.
	 */
	public String toSignableJson()
	{
		
		EcLinkedData d = (EcLinkedData) JSGlobal.JSON.parse(toJson());
		JSObjectAdapter.$properties(d).$delete("@signature");
		JSObjectAdapter.$properties(d).$delete("@owner");
		JSObjectAdapter.$properties(d).$delete("@reader");
		
		EcLinkedData e = new EcLinkedData(d.schema, d.type);
		e.copyFrom(d);
		return e.toJson();
	}

	/**
	 * Sign this object with a private key.
	 * 
	 * @param ppk
	 */
	public void signWith(EcPpk ppk)
	{
		String signableJson = toSignableJson();
		String signed = EcRsaOaep.sign(ppk, signableJson);
		if(signature != null)
		{
			for (int i = 0; i < signature.$length(); i++)
				if (signature.$get(i).equals(signed))
					return;
		}
		else
		{
			signature = new Array<String>();
		}
		signature.push(signed);
	}

	/**
	 * Adds an owner to the object, if the owner does not exist.
	 * 
	 * @param newOwner
	 *            PK of the new owner.
	 */
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

	/**
	 * Determines if the object will survive and be retreivable from a server,
	 * should it be written.
	 * 
	 * @return True if the object is NOT VALID for storage, false otherwise.
	 */
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
