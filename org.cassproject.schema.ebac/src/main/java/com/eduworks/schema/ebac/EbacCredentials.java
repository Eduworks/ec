package com.eduworks.schema.ebac;

import org.cassproject.schema.general.Ebac;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * Credential list along with one time pad and session-based token for use in
 * commit actions.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacCredentials extends EcLinkedData
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/ebac/0.1/credentials";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/ebac/0.2/credentials";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/kbac/0.2/Credentials";

	public EbacCredentials()
	{
		super(Ebac.context, TYPE_0_3);
	}

	/**
	 * One time pad (aka perfect cipher)
	 */
	public String pad;
	/**
	 * Token provided by server to use in commit actions.
	 */
	public String token;
	/**
	 * Credential array.
	 */
	public Array<EbacCredential> credentials;
	/**
	 * Contact array.
	 */
	public Array<EbacContact> contacts;

	@Override
	protected void upgrade()
	{
		super.upgrade();
		if (TYPE_0_1.equals(type))
		{
			Map<String, Object> me = JSObjectAdapter.$properties(this);
			// Error in older versions of LD objects: We used @schema instead of
			// @context. Whoops.
			if (me.$get("@context") == null && me.$get("@schema") != null)
				me.$put("@context", me.$get("@schema"));
			setContextAndType(Ebac.context_0_2, TYPE_0_2);
		}
		if (TYPE_0_2.equals(getFullType()))
		{
			setContextAndType(Ebac.context_0_3, TYPE_0_3);
		}
	}

	@Override
	public Array<String> getTypes()
	{
		Array<String> a = new Array<String>();
		a.push(TYPE_0_3);
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}
}
