package com.eduworks.schema.ebac;

import org.cassproject.schema.general.Ebac;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * Encrypted JSON-LD object or string.
 * 
 * @author fritz.ray@eduworks.com
 * @class EbacEncryptedValue
 * @module org.cassproject
 */
public class EbacEncryptedValue extends EcRemoteLinkedData
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/ebac/0.1/encryptedValue";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/ebac/0.2/encryptedValue";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/kbac/0.2/EncryptedValue";

	public static final String myType = TYPE_0_3;

	public EbacEncryptedValue()
	{
		super(Ebac.context, myType);
	}

	/**
	 * Optional Hint used to aid in search.
	 * Displays the type of the encrypted object.
	 * @property encryptedType
	 * @type string
	 */
	public String encryptedType;

	/**
	 * Base-64 encoded, AES encrypted form of the encrypted object (or string).
	 * @property payload
	 * @type string
	 */
	public String payload;

	/**
	 * Optional Hint used to aid in search and display.
	 * Name of the inner encrypted object.
	 * @property name
	 * @type string
	 */
	public String name;

	/**
	 * Array of EbacEncryptedSecret objects encoded in Base-64, encrypted using
	 * RSA public keys of owners, readers, or other parties to allow them
	 * access to the payload.
	 * @property secret
	 * @type string[]
	 */
	public Array<String> secret;

	@Override
	public void copyFrom(Object that)
	{
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		for (String key : me)
			me.$delete(key);
		Map<String, Object> you = JSObjectAdapter.$properties(that);
		// We do not upgrade encrypted objects, as it invalidates the
		// signatures.
		for (String key : you)
		{
			if (me.$get(key) == null)
				me.$put(key.replace("@", ""), you.$get(key));
		}
		if (!isAny(getTypes()))
			throw new RuntimeException("Incompatible type: " + getFullType());
	}

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
