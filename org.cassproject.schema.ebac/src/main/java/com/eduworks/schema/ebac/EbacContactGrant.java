package com.eduworks.schema.ebac;

import org.cassproject.schema.general.Ebac;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * AES encrypted public key and display name message. 
 * Used to grant access to a contact. 
 * Contains Initialization Vectors, but not secrets. 
 * Used to encrypt public identities for storage on remote systems.
 * 
 * @author fritz.ray@eduworks.com
 * @class EbacContactGrant
 * @module org.cassproject
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

	/**
	 * Public key being granted to the owner of this message.
	 * @property pk
	 * @type string(pem)
	 */
	public String pk;
	/**
	 * Display name of the contact.
	 * @property displayName
	 * @type string
	 */
	public String displayName;
	/**
	 * Source server of the contact.
	 * @property source
	 * @type string
	 */
	public String source;
	/**
	 * Response token used to validate that this grant is in response to a contact request you sent.
	 * @property responseToken
	 * @type string
	 */
	public String responseToken;
	/**
	 * Signature (Base64 encoded) of the response token to verify against your own public key 
	 * to ensure that this grant is in response to a contact request you sent.
	 * @property responseSignature
	 * @type string
	 */
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
