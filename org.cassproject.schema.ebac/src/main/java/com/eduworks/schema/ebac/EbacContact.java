package com.eduworks.schema.ebac;

import org.cassproject.schema.general.Ebac;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * AES encrypted public key and display name. Contains Initialization Vectors,
 * but not secrets. Used to encrypt public identities for storage on remote
 * systems.
 * 
 * @author fritz.ray@eduworks.com
 * @class EbacContact
 * @module org.cassproject
 */
public class EbacContact extends EcLinkedData
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/ebac/0.2/contact";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/ebac/0.2/contact";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/kbac/0.2/Contact";

	public EbacContact()
	{
		super(Ebac.context, TYPE_0_3);
	}

	/**
	 * AES Initialization Vector used to decode PPK. Base64 encoded.
	 * @property iv
	 * @type string
	 */
	public String iv;
	/**
	 * AES encrypted Private Key in PEM format.
	 * @property pk
	 * @type string
	 */
	public String pk;
	/**
	 * AES Initialization Vector used to decode displayName. Base64 encoded.
	 * @property displayNameIv
	 * @type string
	 */
	public String displayNameIv;
	/**
	 * AES encrypted display name for identity.
	 * @property displayName
	 * @type string
	 */
	public String displayName;

	/**
	 * AES Initialization Vector of the home server of the contact. Base64 encoded.
	 * @property sourceIv
	 * @type string
	 */
	public String sourceIv;

	/**
	 * URL to the home server of the contact.
	 * @property source
	 * @type string
	 */
	public String source;

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
