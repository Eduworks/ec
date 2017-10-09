package org.cassproject.schema.general;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.ec.random.EcRandom;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback1;

/**
 * Data wrapper to represent remotely hosted data. Includes necessary KBAC fields for
 * permission controls, signing, identifying and locating the object.
 *
 * @author fritz.ray@eduworks.com
 * @class EcRemoteLinkedData
 * @extends EcLinkedData
 * @module org.cassproject
 */
public class EcRemoteLinkedData extends EcLinkedData {
	// An owner has write privileges according to a repository.
	// These owners are in PEM format.
	/**
	 * PEM encoded public keys of the owner of the object. A repository, upon
	 * receiving a write operation, will ensure either the data did not
	 * previously exist, or that an owner has provided a signature authorizing
	 * the replacement of the old data with the new data.
	 *
	 * @property owner
	 * @type string[] (PEM)
	 */
	public Array<String> owner;

	/**
	 * Signatures of the object. The signing method is as follows: Remove the
	 * signature field. Encode the object and its fields in ascii-sort order
	 * JSON-LD using a space-free, tab-free encoding. Sign the aforementioned
	 * string.
	 *
	 * @property signature
	 * @type string[] (Base64)
	 */
	public Array<String> signature;

	/**
	 * URL/URI used to retrieve, store and identify the object.
	 *
	 * @property id
	 * @type string (URL)
	 */
	public String id;

	/**
	 * PEM encoded public keys of identities authorized to view the object. A
	 * repository will ignore write operations from these identities, but will
	 * allow them to read the object.
	 *
	 * @property reader
	 * @type string[] (PEM)
	 */
	public Array<String> reader;

	/**
	 * Constructor for remote linked data object.
	 *
	 * @param {string} context JSON-LD Context.
	 * @param {string} type JSON-LD Type.
	 * @constructor
	 */
	public EcRemoteLinkedData(String context, String type) {
		super(context, type);
	}

	/**
	 * Removes the version information from an identifier.
	 * Warning: Will remove identifier if the identifier is composed solely of digits!!!
	 *
	 * @param {string} id Slash delimited URL or path.
	 * @return ID without version.
	 * @method trimVersionFromUrl
	 * @static
	 */
	public static String trimVersionFromUrl(String id) {
		if (id == null)
			return null;
		// May not be a GUID, may be more canonical. Check to see if it is a
		// parsable long.

		if (!id.substring(id.lastIndexOf("/")).matches("\\/[0-9]+"))
			return id;
		String rawId = id.substring(0, id.lastIndexOf("/"));
		if (rawId.endsWith("/"))
			rawId = rawId.substring(0, rawId.length() - 1);
		return rawId;
	}

	/**
	 * Will generate an identifier using the server URL provided (usually from
	 * an EcRepository).
	 *
	 * @param {string} server Base URL of the server's repository functionality.
	 * @method generateId
	 */
	public void generateId(String server) {
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
	 * @param {string} server Base URL of the server's repository functionality.
	 * @param {string} uniqueIdentifier Canonical identifier. Must contain a letter or symbol.
	 * @method assignId
	 */
	public void assignId(String server, String uniqueIdentifier) {
		id = server;
		if (!id.endsWith("/"))
			id += "/";
		id += "data/"; //endpoint to CRUD data
		id += getFullType().replace("http://", "").replaceAll("/", "."); //type information (ease of use)
		id += "/";
		id += uniqueIdentifier; //local identifier
		id += "/";
		id += new Date().getTime(); //version
	}

	/**
	 * Will generate an identifier using the server URL provided (usually from
	 * an EcRepository) and unique identifier.
	 *
	 * @param {string} server Base URL of the server's repository functionality.
	 * @param {string} uniqueIdentifier Canonical identifier. Must contain a letter or symbol.
	 * @method assignId
	 */
	public void assignIdAndVersion(String server, String uniqueIdentifier, String version) {
		id = server;
		if (!id.endsWith("/"))
			id += "/";
		id += "data/"; //endpoint to CRUD data
		id += getFullType().replace("http://", "").replaceAll("/", "."); //type information (ease of use)
		id += "/";
		id += uniqueIdentifier; //local identifier
		id += "/";
		id += version; //version
	}

	/**
	 * Determines if the object has an owner identified by pk.
	 * Homogenizes the PEM strings for comparison.
	 * Homogenization is necessary for comparing PKCS#1 and PKCS#8 or PKs with Certificates, etc.
	 *
	 * @param {EcPk} pk Public Key of the owner.
	 * @return {boolean} True if owner is represented by the PK, false otherwise.
	 * @method hasOwner
	 */
	public boolean hasOwner(EcPk pk) {
		if (owner == null)
			return false;

		String pkPem = pk.toPem();
		for (int i = 0; i < owner.$length(); i++)
			if (pkPem == EcPk.fromPem(owner.$get(i)).toPem())
				return true;
		return false;
	}

	/**
	 * Determines if the PK matches an owner or if the object is public.
	 * Homogenizes the PEM strings for comparison.
	 * Homogenization is necessary for comparing PKCS#1 and PKCS#8 or PKs with Certificates, etc.
	 *
	 * @param {EcPk} pk Public Key of the owner.
	 * @return {boolean} True if owner is represented by the PK, false otherwise.
	 * @method canEdit
	 */
	public boolean canEdit(EcPk pk) {
		if (owner == null || owner.$length() == 0)
			return true;
		return hasOwner(pk);
	}

	/**
	 * Encodes the object in a form where it is ready to be signed.
	 * This method is under long term review, and may change from version to version.
	 *
	 * @return ASCII-sort order encoded space-free and tab-free JSON-LD.
	 * @method toSignableJson
	 */
	public String toSignableJson() {
		EcLinkedData d = (EcLinkedData) JSGlobal.JSON.parse(toJson());

		if (type.contains("http://schema.eduworks.com/") && type.contains("/0.1/")) {
			JSObjectAdapter.$properties(d).$delete("@signature");
			JSObjectAdapter.$properties(d).$delete("@owner");
			JSObjectAdapter.$properties(d).$delete("@reader");
			JSObjectAdapter.$properties(d).$delete("@id");
		} else {
			// Whom else has signed the object does not change the contents of
			// the object.
			JSObjectAdapter.$properties(d).$delete("@signature");
			// Where the object resides does not change the contents of the
			// object, and provides server administration capabilities.
			JSObjectAdapter.$properties(d).$delete("@id");

			// Who owns the object, or who can read the object *does* matter
			// though, as administrators should not be able to change the
			// ownership properties of the object in a clandestine fashion.
		}

		EcLinkedData e = new EcLinkedData(d.context, d.type);
		e.copyFrom(d);
		return e.toJson();
	}

	/**
	 * Sign this object using a private key.
	 * Does not check for ownership, objects signed with keys absent from @owner or @reader may be removed.
	 *
	 * @param {EcPpk} ppk Public private keypair.
	 * @method signWith
	 */
	public void signWith(EcPpk ppk) {
		String signableJson = toSignableJson();
		String signed = EcRsaOaep.sign(ppk, signableJson);
		if (signature != null) {
			for (int i = 0; i < signature.$length(); i++)
				if (signature.$get(i) == signed)
					return;
		} else {
			signature = new Array<String>();
		}
		signature.push(signed);
	}

	/**
	 * Verifies the object's signatures.
	 *
	 * @return {boolean} true if all of the signatures could be verified, false if they could not
	 * @method verify
	 */
	public boolean verify() {
		if (signature != null) {
			for (int i = 0; i < signature.$length(); ) {
				boolean works = false;
				String sig = signature.$get(i);
				if (owner != null) {
					for (int j = 0; j < owner.$length(); j++) {
						String own = owner.$get(j);
						EcPk pk = EcPk.fromPem(own);
						Boolean verify = false;
						try {
							verify = EcRsaOaep.verify(pk, toSignableJson(), sig);
						} catch (Exception ex) {
						}
						if (verify) {
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
	 * @param {EcPk} newOwner PK of the new owner.
	 * @method addOwner
	 */
	public void addOwner(EcPk newOwner) {
		String pem = newOwner.toPem();
		if (owner == null)
			owner = new Array<String>();
		for (int i = 0; i < owner.$length(); i++)
			if (owner.$get(i) == pem)
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
	 * @param {EcPk} oldOwner PK to remove.
	 * @method removeOwner
	 */
	public void removeOwner(EcPk oldOwner) {
		String pem = oldOwner.toPem();
		if (owner == null)
			owner = new Array<String>();
		for (int i = 0; i < owner.$length(); i++)
			if (owner.$get(i) == pem)
				owner.splice(i, 1);
		// Changing an owner invalidates the signatures in order to prevent
		// server admins from injecting owners or readers into the object.
		signature = null;
	}

	/**
	 * Adds a reader to the object, if the reader does not exist.
	 * Note that this method invalidates all signatures.
	 *
	 * @param {EcPk} newReader PK of the new reader.
	 * @method addReader
	 */
	public void addReader(EcPk newReader) {
		String pem = newReader.toPem();
		if (reader == null)
			reader = new Array<String>();
		for (int i = 0; i < reader.$length(); i++)
			if (reader.$get(i) == pem)
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
	 * @param {EcPk} oldReader PK of the old reader.
	 * @method removeReader
	 */
	public void removeReader(EcPk oldReader) {
		String pem = oldReader.toPem();
		if (reader == null)
			reader = new Array<String>();
		for (int i = 0; i < reader.$length(); i++)
			if (reader.$get(i) == pem)
				reader.splice(i, 1);
		// Changing an owner invalidates the signatures in order to prevent
		// server admins from injecting owners or readers into the object.
		signature = null;
	}

	/**
	 * Determines if the object is not retrievable from a repository should it be written.
	 *
	 * @return {boolean} True if the object is NOT VALID for storage, false otherwise.
	 * @method invalid
	 */
	public boolean invalid() {
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
	 *
	 * @method updateTimestamp
	 */
	public void updateTimestamp() {
		String rawId = id.substring(0, id.lastIndexOf("/"));
		if (rawId.endsWith("/") == false)
			rawId += "/";
		rawId += new Date().getTime();
		id = rawId;
	}

	/**
	 * Updates the ID timestamp of the object, for versioning purposes.
	 *
	 * @method updateTimestamp
	 */
	public Integer getTimestamp() {
		return Integer.parseInt(id.substring(id.lastIndexOf("/")));
	}

	/**
	 * Returns true if the provided ID represents this object.
	 * Use this, as version information can make direct comparison difficult.
	 *
	 * @param {string} id
	 * @return {boolean} True if the provided ID represents this object.
	 * @method isId
	 */
	public boolean isId(String id) {
		return trimVersionFromUrl(this.id) == trimVersionFromUrl(id);
	}

	/**
	 * Return the ID of this object without the version information.
	 * Used to reference the latest version of an object.
	 *
	 * @return {string} ID of the latest version of this object.
	 * @method shortId
	 */
	public String shortId() {
		return trimVersionFromUrl(id);
	}

	/**
	 * Return the GUID portion of the short ID.
	 *
	 * @return {string} Guid of the linked data object.
	 * @method getGuid
	 */
	public String getGuid() {
		String shortId = trimVersionFromUrl(id);
		Array<String> parts = (Array<String>) (Object) shortId.split("/");
		return parts.$get(parts.$length() - 1);
	}

	/**
	 * Return the URL Base portion of the short ID.
	 *
	 * @return {string} Server Base URL of the linked data object.
	 * @method getServerBaseUrl
	 */
	public String getServerBaseUrl() {
		String shortId = trimVersionFromUrl(id);
		Array<String> parts = (Array<String>) (Object) shortId.split("/");

		return parts.slice(0, parts.indexOf("data")).join("/");
	}

	/**
	 * Return a valid ElasticSearch search string that will retrieve all objects with this type.
	 *
	 * @return {string} ElasticSearch compatible search string.
	 * @method getSearchStringByType
	 */
	public String getSearchStringByType() {
		Array<String> types = getTypes();
		String result = "";
		for (int i = 0; i < types.$length(); i++) {
			if (i != 0)
				result += " OR ";
			result += "@type:\"" + types.$get(i) + "\"";

			int lastSlash = types.$get(i).lastIndexOf("/");
			result += " OR (@context:\"" + types.$get(i).substring(0, lastSlash + 1) + "\" AND @type:\"" + types.$get(i).substring(lastSlash + 1) + "\")";
		}
		for (int i = 0; i < types.$length(); i++) {
			if (result != "")
				result += " OR ";
			result += "@encryptedType:\"" + types.$get(i) + "\"";

			int lastSlash = types.$get(i).lastIndexOf("/");
			result += " OR (@context:\"" + Ebac.context + "\" AND @encryptedType:\"" + types.$get(i).substring(lastSlash + 1) + "\")";
		}
		return "(" + result + ")";
	}


	public void asRdfXml(Callback1<String> success, Callback1<String> failure, String signatureSheet) {
		final FormData fd = new FormData();

		final String id = this.id;

		if (signatureSheet != null || signatureSheet != JSGlobal.undefined)
			fd.append("signatureSheet", signatureSheet);

		Map<String, String> headers = JSCollections.$map();
		headers.$put("Accept", "application/rdf+xml");

		EcRemote.postWithHeadersExpectingString(id, "", fd, headers, success, failure);
	}

	public void asNQuads(Callback1<String> success, Callback1<String> failure, String signatureSheet) {
		final FormData fd = new FormData();

		final String id = this.id;

		if (signatureSheet != null || signatureSheet != JSGlobal.undefined)
			fd.append("signatureSheet", signatureSheet);

		Map<String, String> headers = JSCollections.$map();
		headers.$put("Accept", "text/n4");

		EcRemote.postWithHeadersExpectingString(id, "", fd, headers, success, failure);
	}

	public void asTurtle(Callback1<String> success, Callback1<String> failure, String signatureSheet) {
		final FormData fd = new FormData();

		final String id = this.id;

		if (signatureSheet != null || signatureSheet != JSGlobal.undefined)
			fd.append("signatureSheet", signatureSheet);

		Map<String, String> headers = JSCollections.$map();
		headers.$put("Accept", "text/turtle");

		EcRemote.postWithHeadersExpectingString(id, "", fd, headers, success, failure);
	}
}
