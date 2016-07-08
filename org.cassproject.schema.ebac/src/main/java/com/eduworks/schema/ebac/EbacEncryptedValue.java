package com.eduworks.schema.ebac;

import org.cassproject.schema.general.Ebac;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * Encrypted JSON-LD object.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacEncryptedValue extends EcRemoteLinkedData
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/ebac/0.1/encryptedValue";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/ebac/0.2/encryptedValue";

	public static final String myType = TYPE_0_2;

	public EbacEncryptedValue()
	{
		super(Ebac.context, myType);
	}

	/**
	 * Optional Hint used to aid search, showing the type of the inner encrypted
	 * object.
	 */
	public String encryptedType;

	/**
	 * Base-64 encoded, AES encrypted form of the encrypted object (or data).
	 */
	public String payload;

	/**
	 * Optional Hint used to aid view, showing a name of the inner encrypted
	 * object.
	 */
	public String name;

	@Override
	public void copyFrom(Object that)
	{
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		for (String key : me)
			me.$delete(key);
		Map<String, Object> you = JSObjectAdapter.$properties(that);
		//We do not upgrade encrypted objects, as it invalidates the signatures.
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
