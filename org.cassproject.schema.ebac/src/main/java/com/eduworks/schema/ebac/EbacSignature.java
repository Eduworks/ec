package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;

/**
 * Signature used to authorize movement of data on behalf of a private-key
 * holding owner.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacSignature extends EcLinkedData
{
	public EbacSignature()
	{
		super(Ebac.context, "http://schema.eduworks.com/ebac/0.2/timeLimitedSignature");
	}

	/**
	 * The public key of the authorizing party.
	 */
	public String owner;

	/**
	 * The time in number of milliseconds since midnight of January 1, 1970
	 * 00:00:00 UTC that this signature is authorized to move data.
	 */
	public double expiry;

	/**
	 * The signature of this object, having signed the object, having been
	 * encoded in JSON with no space or tabs in ASCII sort order, having no
	 * value for the signature at the time of signing.
	 */
	public String signature;

	/**
	 * The server authorized to move data. If this is empty, the signature may
	 * be used by a server to ask for data from other servers.
	 */
	public String server;

}
