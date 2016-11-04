package com.eduworks.schema.ebac;

import org.cassproject.schema.general.Ebac;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * AES encrypted public key and display name. Contains Initialization Vectors,
 * but not secrets. Used to encrypt public identities for storage on remote
 * systems.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacContactGrant extends EcRemoteLinkedData
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/ebac/0.1/contactGrant";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/ebac/0.2/contactGrant";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/kbac/0.2/ContactGrant";

	public EbacContactGrant()
	{
		super(Ebac.context, TYPE_0_3);
	}

	public String iv;
	public String pk;
	public String displayName;
	public String source;
	public String responseToken;
	public String responseSignature;

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
