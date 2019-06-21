package com.eduworks.schema.ebac;

import org.cassproject.schema.general.Ebac;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;

/**
 * Signature used to authorize movement of data on behalf of a private-key
 * holding owner.
 *
 * @author fritz.ray@eduworks.com
 * @class EbacSignature
 * @module org.cassproject
 */
public class EbacSignature extends EcLinkedData {
	private static final String TYPE_0_1 = "http://schema.eduworks.com/ebac/0.1/timeLimitedSignature";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/ebac/0.2/timeLimitedSignature";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/kbac/0.2/TimeLimitedSignature";
	private static final String TYPE_0_4 = "https://schema.cassproject.org/kbac/0.4/TimeLimitedSignature";
	/**
	 * The public key of the authorizing party in PEM format.
	 *
	 * @property owner
	 * @type string
	 */
	public String owner;
	/**
	 * The time in number of milliseconds since midnight of January 1, 1970
	 * 00:00:00 UTC that this signature is authorized to move data.
	 *
	 * @property expiry
	 * @type long
	 */
	public Double expiry;
	/**
	 * The signature of this object, having signed the object, having been
	 * encoded in JSON with no space or tabs in ASCII sort order, having no
	 * value for the signature at the time of signing.
	 *
	 * @property signature
	 * @type string
	 */
	public String signature;
	/**
	 * The server authorized to move data. If this is empty, the signature may
	 * be used by a server to ask for data from other servers.
	 *
	 * @property server
	 * @type string
	 */
	public String server;

	public EbacSignature() {
		super(Ebac.context, TYPE_0_4);
	}

	@Override
	protected void upgrade() {
		super.upgrade();
		//DO NOT CHANGE ANYTHING WHEN AN UPGRADE OCCURS, this invalidates the signature.
	}

	@Override
	public Array<String> getTypes() {
		Array<String> a = new Array<String>();
		a.push(TYPE_0_4);
		a.push(TYPE_0_3);
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}

}
