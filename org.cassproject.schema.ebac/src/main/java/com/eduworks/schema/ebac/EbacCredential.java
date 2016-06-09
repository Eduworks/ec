package com.eduworks.schema.ebac;

import org.cassproject.schema.general.Ebac;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * AES encrypted private key and display name. Contains Initialization Vectors,
 * but not secrets. Used to encrypt private identities for storage on remote
 * systems.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacCredential extends EcLinkedData
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/ebac/0.1/credential";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/ebac/0.2/credential";

	public EbacCredential()
	{
		super(Ebac.context, TYPE_0_2);
	}

	/**
	 * AES Initialization Vector used to decode PPK.
	 */
	public String iv;
	/**
	 * AES encrypted Private Key in PEM form.
	 */
	public String ppk;
	/**
	 * AES Initialization Vector used to decode displayName.
	 */
	public String displayNameIv;
	/**
	 * AES encrypted display name for identity.
	 */
	public String displayName;

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
