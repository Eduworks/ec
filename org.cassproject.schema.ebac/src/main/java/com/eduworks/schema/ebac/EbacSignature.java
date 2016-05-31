package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * Signature used to authorize movement of data on behalf of a private-key
 * holding owner.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacSignature extends EcLinkedData
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/ebac/0.1/timeLimitedSignature";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/ebac/0.2/timeLimitedSignature";

	public EbacSignature()
	{
		super(Ebac.context, TYPE_0_2);
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

	@Override
	protected void upgrade()
	{
		super.upgrade();
		if (type.equals(TYPE_0_1))
		{
			Map<String, Object> me = JSObjectAdapter.$properties(this);
			// Error in older versions of LD objects: We used @schema instead of
			// @context. Whoops.
			if (me.$get("@context") == null && me.$get("@schema") != null)
				me.$put("@context", me.$get("@schema"));
			setContextAndType(Ebac.context_0_2,TYPE_0_2);
		}
	}

	@Override
	public Array<String> getTypes()
	{
		Array<String> a = new Array<String>();
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}

}
