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
	 * Determines if the object has pk as an owner. Homogenizes the PEM strings
	 * for comparison.
	 * 
	 * @param pk
	 * @return True if owner is represented by the PK, false otherwise.
	 */
	public boolean canEdit(EcPk pk)
	{
		if (owner == null || owner.$length() == 0)
			return true;
		return hasOwner(pk);
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
		JSObjectAdapter.$properties(d).$delete("@id");
		
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
	 * Verify's the object's signatures
	 * 
	 * @return true if all of the signatures could be verified, false if they could not
	 */
	public boolean verify()
	{
		if(signature != null)
		{
			for (int i = 0; i < signature.$length();)
			{
				boolean works = false;
				String sig = signature.$get(i);
				if (owner != null)
				{
					for (int j = 0; j < owner.$length(); j++)
					{
						String own = owner.$get(j);
						EcPk pk = EcPk.fromPem(own);
						if (EcRsaOaep.verify(pk, toSignableJson(), sig))
						{
							works = true;
							break;
						}
					}
				}
				if (!works)
					return false;
				else
					i++;
			}
			
			return true;
		}
		
		return false;
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
	 * Removes an owner from the object, if the owner does exist.
	 * 
	 * @param owner
	 *            PK of the new owner.
	 */
	public void removeOwner(EcPk oldOwner)
	{
		String pem = oldOwner.toPem();
		if (owner == null)
			owner = new Array<String>();
		for (int i = 0; i < owner.$length(); i++)
			if (owner.$get(i).equals(pem))
				owner.splice(i,1);
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

	public void updateTimestamp()
	{
		String rawId = id.substring(0,id.lastIndexOf("/"));
		if (rawId.endsWith("/") == false)
			rawId += "/";
		rawId += new Date().getTime();
		id = rawId;
	}

	public boolean isId(String id)
	{
		return trimVersionFromUrl(this.id).equals(trimVersionFromUrl(id));
	}
	
	public static String trimVersionFromUrl(String id)
	{
		if (id == null) return null;
		if (id.substring(id.lastIndexOf("/")).contains("-"))
			return id;
		String rawId = id.substring(0,id.lastIndexOf("/"));
		if (rawId.endsWith("/"))
			rawId = rawId.substring(0,rawId.length()-1);
		return rawId;
	}
	
	public String shortId()
	{
		return trimVersionFromUrl(id);
	}
}
