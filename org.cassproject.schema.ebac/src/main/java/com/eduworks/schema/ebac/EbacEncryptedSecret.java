package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

import forge.pkcs5;

public class EbacEncryptedSecret extends EcLinkedData
{

	public EbacEncryptedSecret()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/encryptedSecret");
	}

	public String iv;
	public String id;
	public String secret;
	public String field;

	public String toEncryptableJson()
	{
		Map<String, Object> o = JSObjectAdapter.$properties(new Object());
		o.$put("v", iv);
		if (id != null)
			o.$put("d", pkcs5.pbkdf2(id, "", 1, 8));
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

}
