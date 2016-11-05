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
 * Data wrapper to represent remotely hosted data. Includes necessary KBAC fields for
 * permission controls, signing, identifying and locating the object.
 * 
 * @class EcRemoteLinkedData
 * @extends EcLinkedData
 * @module org.cassproject
 * @author fritz.ray@eduworks.com
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
	 * @property owner
	 * @type string[] (PEM)
	 */
	public Array<String> owner;

	/**
	 * Signatures of the object. The signing method is as follows: Remove the
	 * signature field. Encode the object and its fields in ascii-sort order
	 * JSON-LD using a space-free, tab-free encoding. Sign the aforementioned
	 * string.
	 * @property signature
	 * @type string[] (Base64)
	 */
	public Array<String> signature;

	/**
	 * URL/URI used to retrieve, store and identify the object.
	 * @property id
	 * @type string (URL)
	 */
	public String id;

	@Deprecated
	// Needs more discussion, but marking it here to spur said discussion.
	public Boolean privateEncrypted;

	/**
	 * PEM encoded public keys of identities authorized to view the object. A
	 * repository will ignore write operations from these identities, but will
	 * allow them to read the object.
	 * @property reader
	 * @type string[] (PEM)
	 */
	public Array<String> reader;

	/**
	 * Constructor for remote linked data object.
	 * @constructor
	 * @param {string} context JSON-LD Context.
	 * @param {string} type JSON-LD Type.
	 */
	public EcRemoteLinkedData(String context, String type)
	{
		super(context, type);
	}

	/**
	 * Will generate an identifier using the server URL provided (usually from
	 * an EcRepository).
	 * 
	 * @method generateId
	 * @param {string} server Base URL of the server's repository functionality.
	 */
	public void generateId(String server)
	{
		id = server;
		if (!id.endsWith("/"))
			id += "/";
		id += "data/";
		id += getFullType().replace("http://", "").replaceAll("/", ".");
		id += "/";
		id += EcRandom.generateUUID();
		id += "/";
		id += new Date().getTime();
	}

	/**
	 * Will generate an identifier using the server URL provided (usually from
	 * an EcRepository) and unique identifier.
	 * 
	 * @method assignId
	 * @param {string} server Base URL of the server's repository functionality.
	 * @param {string} uniqueIdentifier Canonical identifier. Must contain a letter or symbol.
	 */
	public void assignId(String server, String uniqueIdentifier)
	{
		id = server;
		if (!id.endsWith("/"))
			id += "/";
		id += "data/";
		id += getFullType().replace("http://", "").replaceAll("/", ".");
		id += "/";
		id += uniqueIdentifier;
		id += "/";
		id += new Date().getTime();
	}

	/**
	 * Determines if the object has an owner identified by pk. 
	 * Homogenizes the PEM strings for comparison. 
	 * Homogenization is necessary for comparing PKCS#1 and PKCS#8 or PKs with Certificates, etc.
	 * 
	 * @method hasOwner
	 * @param {EcPk} pk Public Key of the owner.
	 * @return {boolean} True if owner is represented by the PK, false otherwise.
	 */
	public boolean hasOwner(EcPk pk)
	{
		if (owner == null)
			return false;

		String pkPem = pk.toPem();
		for (int i = 0; i < owner.$length(); i++)
			if (pkPem.equals(EcPk.fromPem(owner.$get(i)).toPem()))
				return true;
		return false;
	}

	/**
	 * Determines if the PK matches an owner or if the object is public. 
	 * Homogenizes the PEM strings for comparison. 
	 * Homogenization is necessary for comparing PKCS#1 and PKCS#8 or PKs with Certificates, etc.
	 * 
	 * @method canEdit
	 * @param {EcPk} pk Public Key of the owner.
	 * @return {boolean} True if owner is represented by the PK, false otherwise.
	 */
	public boolean canEdit(EcPk pk)
	{
		if (owner == null || owner.$length() == 0)
			return true;
		return hasOwner(pk);
	}

	/**
	 * Encodes the object in a form where it is ready to be signed. 
	 * This method is under long term review, and may change from version to version.
	 * 
	 * @method toSignableJson
	 * @return ASCII-sort order encoded space-free and tab-free JSON-LD.
	 */
	public String toSignableJson()
	{
		EcLinkedData d = (EcLinkedData) JSGlobal.JSON.parse(toJson());

		if (type.contains("http://schema.eduworks.com/") && type.contains("/0.1/"))
		{
			JSObjectAdapter.$properties(d).$delete("@signature");
			JSObjectAdapter.$properties(d).$delete("@owner");
			JSObjectAdapter.$properties(d).$delete("@reader");
			JSObjectAdapter.$properties(d).$delete("@id");
			JSObjectAdapter.$properties(d).$delete("privateEncrypted");
		} else
		{
			// Whom else has signed the object does not change the contents of
			// the object.
			JSObjectAdapter.$properties(d).$delete("@signature");
			// Where the object resides does not change the contents of the
			// object, and provides server administration capabilities.
			JSObjectAdapter.$properties(d).$delete("@id");
			// Who owns the object, or who can read the object *does* matter
			// though, as administrators should not be able to change the
			// ownership properties of the object in a clandestine fashion.
			JSObjectAdapter.$properties(d).$delete("privateEncrypted");
		}

		EcLinkedData e = new EcLinkedData(d.context, d.type);
		e.copyFrom(d);
		return e.toJson();
	}

	/**
	 * Sign this object using a private key. 
	 * Does not check for ownership, objects signed with keys absent from @owner or @reader may be removed.
	 * 
	 * @method signWith
	 * @param {EcPpk} ppk Public private keypair.
	 */
	public void signWith(EcPpk ppk)
	{
		String signableJson = toSignableJson();
		String signed = EcRsaOaep.sign(ppk, signableJson);
		if (signature != null)
		{
			for (int i = 0; i < signature.$length(); i++)
				if (signature.$get(i).equals(signed))
					return;
		} else
		{
			signature = new Array<String>();
		}
		signature.push(signed);
	}

	/**
	 * Verifies the object's signatures.
	 * 
	 * @method verify
	 * @return {boolean} true if all of the signatures could be verified, false if they could not
	 */
	public boolean verify()
	{
		if (signature != null)
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
						Boolean verify = false;
						try
						{
							verify = EcRsaOaep.verify(pk, toSignableJson(), sig);
						} catch (Exception ex)
						{
						}
						if (verify)
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

			if (signature.$length() == 0)
				return false;

			return true;
		}

		return false;
	}

	/**
	 * Adds an owner to the object, if the owner does not exist.
	 * Note that this method invalidates all signatures.
	 * 
	 * @method addOwner
	 * @param {EcPk} newOwner PK of the new owner.
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
		// Changing an owner invalidates the signatures in order to prevent
		// server admins from injecting owners or readers into the object.
		signature = null;
	}

	/**
	 * Removes an owner from the object, if the owner does exist.
	 * Note that this method invalidates all signatures.
	 * 
	 * @method removeOwner
	 * @param {EcPk} oldOwner PK to remove.
	 */
	public void removeOwner(EcPk oldOwner)
	{
		String pem = oldOwner.toPem();
		if (owner == null)
			owner = new Array<String>();
		for (int i = 0; i < owner.$length(); i++)
			if (owner.$get(i).equals(pem))
				owner.splice(i, 1);
		// Changing an owner invalidates the signatures in order to prevent
		// server admins from injecting owners or readers into the object.
		signature = null;
	}

	/**
	 * Adds a reader to the object, if the reader does not exist.
	 * Note that this method invalidates all signatures.
	 * 
	 * @method addReader
	 * @param {EcPk} newReader PK of the new reader.
	 */
	public void addReader(EcPk newReader)
	{
		String pem = newReader.toPem();
		if (reader == null)
			reader = new Array<String>();
		for (int i = 0; i < reader.$length(); i++)
			if (reader.$get(i).equals(pem))
				return;
		reader.push(pem);
		// Changing an owner invalidates the signatures in order to prevent
		// server admins from injecting owners or readers into the object.
		signature = null;
	}

	/**
	 * Removes a reader from the object, if the reader does exist.
	 * Note that this method invalidates all signatures.
	 * 
	 * @method removeReader
	 * @param {EcPk} oldReader PK of the old reader.
	 */
	public void removeReader(EcPk oldReader)
	{
		String pem = oldReader.toPem();
		if (reader == null)
			reader = new Array<String>();
		for (int i = 0; i < reader.$length(); i++)
			if (reader.$get(i).equals(pem))
				reader.splice(i, 1);
		// Changing an owner invalidates the signatures in order to prevent
		// server admins from injecting owners or readers into the object.
		signature = null;
	}

	/**
	 * Determines if the object is not retrievable from a repository should it be written.
	 * 
	 * @method invalid
	 * @return {boolean} True if the object is NOT VALID for storage, false otherwise.
	 */
	public boolean invalid()
	{
		if (id == null)
			return true;
		// Allow relative pathed data.
		// if (id.contains("http://") == false && id.contains("https://") ==
		// false)
		// return true;
		if (context == null)
			return true;
		if (getFullType() == null)
			return true;
		if (getFullType().contains("http://") == false && getFullType().contains("https://") == false)
			return true;
		return false;
	}

	/**
	 * Updates the ID timestamp of the object, for versioning purposes.
	 * @method updateTimestamp
	 */
	public void updateTimestamp()
	{
		String rawId = id.substring(0, id.lastIndexOf("/"));
		if (rawId.endsWith("/") == false)
			rawId += "/";
		rawId += new Date().getTime();
		id = rawId;
	}

	/**
	 * Returns true if the provided ID represents this object. 
	 * Use this, as version information can make direct comparison difficult.
	 * @method isId
	 * @param {string} id
	 * @return {boolean} True if the provided ID represents this object.
	 */
	public boolean isId(String id)
	{
		return trimVersionFromUrl(this.id).equals(trimVersionFromUrl(id));
	}

	/**
	 * Removes the version information from an identifier.
	 * Warning: Will remove identifier if the identifier is composed solely of digits!!!
	 * @method trimVersionFromUrl
	 * @static
	 * @param {string} id Slash delimited URL or path.
	 * @return ID without version.
	 */
	public static String trimVersionFromUrl(String id)
	{
		if (id == null)
			return null;
		// May not be a GUID, may be more canonical. Check to see if it is a
		// parsable long.

		if (!id.substring(id.lastIndexOf("/")).matches("^\\/[0-9]+$"))
			return id;
		String rawId = id.substring(0, id.lastIndexOf("/"));
		if (rawId.endsWith("/"))
			rawId = rawId.substring(0, rawId.length() - 1);
		return rawId;
	}

	/**
	 * Return the ID of this object without the version information. 
	 * Used to reference the latest version of an object.
	 * 
	 * @method shortId
	 * @return {string} ID of the latest version of this object.
	 */
	public String shortId()
	{
		return trimVersionFromUrl(id);
	}

	/**
	 * Return a valid ElasticSearch search string that will retrieve all objects with this type.
	 * @method getSearchStringByType
	 * @return {string} ElasticSearch compatible search string.
	 */
	public String getSearchStringByType()
	{
		Array<String> types = getTypes();
		String result = "";
		for (int i = 0; i < types.$length(); i++)
		{
			if (i != 0)
				result += " OR ";
			result += "@type:\"" + types.$get(i) + "\"";

			int lastSlash = types.$get(i).lastIndexOf("/");
			result += " OR (@context:\"" + types.$get(i).substring(0, lastSlash) + "\" AND @type:\"" + types.$get(i).substring(lastSlash + 1) + "\")";
		}
		for (int i = 0; i < types.$length(); i++)
		{
			if (result.equals("") == false)
				result += " OR ";
			result += "@encryptedType:\"" + types.$get(i) + "\"";

			int lastSlash = types.$get(i).lastIndexOf("/");
			result += " OR (@context:\"" + Ebac.context + "\" AND @encryptedType:\"" + types.$get(i).substring(lastSlash + 1) + "\")";
		}
		return "(" + result + ")";
	}

}
