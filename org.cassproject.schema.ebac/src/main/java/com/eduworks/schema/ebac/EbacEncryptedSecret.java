package com.eduworks.schema.ebac;

import org.cassproject.schema.general.Ebac;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

import forge.pkcs5;

/**
 * Component of EbacEncryptedValue that contains data needed to decrypt
 * encrypted payload. Is, in itself, encrypted.
 * 
 * Also contains data used to verify that encrypted-data substitution attacks
 * were not performed on the data.
 * 
 * Must be encryptable by RSA, therefore, serialized form is less than 256
 * bytes.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacEncryptedSecret extends EcLinkedData
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/ebac/0.1/encryptedSecret";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/ebac/0.2/encryptedSecret";

	public EbacEncryptedSecret()
	{
		super(Ebac.context, TYPE_0_2);
	}

	/**
	 * IV used to encrypt/decrypt payload.
	 */
	public String iv;

	/**
	 * Hashed and Base64 encoded ID of the parent (if any) object.
	 */
	public String id;

	/**
	 * Secret used to encrypt/decrypt payload.
	 */
	public String secret;

	/**
	 * Dot and Bracket notated index of the field in the parent-most object (if
	 * any).
	 */
	public String field;

	public String toEncryptableJson()
	{
		Map<String, Object> o = JSObjectAdapter.$properties(new Object());
		o.$put("v", iv);
		if (id != null)
			o.$put("d", id);
		o.$put("s", secret);
		if (field != null)
			o.$put("f", field);
		return JSGlobal.JSON.stringify(o);
	}

	public static EbacEncryptedSecret fromEncryptableJson(Object obj)
	{
		EbacEncryptedSecret secret = new EbacEncryptedSecret();
		Map<String, Object> o = JSObjectAdapter.$properties(obj);
		secret.iv = (String) o.$get("v");
		if (o.$get("d") != null)
			secret.id = (String) o.$get("d");
		secret.secret = (String) o.$get("s");
		if (o.$get("f") != null)
			secret.field = (String) o.$get("f");
		return secret;
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
