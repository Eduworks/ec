package org.json.ld;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSON;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.SortFunction;

public class EcLinkedData
{
	public String type;
	public String schema;

	public EcLinkedData(String schema, String type)
	{
		this.schema = schema;
		this.type = type;
	}

	public static Array<String> atProperties = JSCollections.$array("id", "type", "schema", "context", "signature", "owner", "encryptedType");

	public static boolean isAtProperty(String s)
	{
		for (int i = 0; i < atProperties.$length(); i++)
			if (atProperties.$get(i).equals(s))
				return true;
		return false;
	}

	public String toJson()
	{
		//This method serializes the fields in alphabetical order. 
		//This is to prevent signature based errors.
		Array<String> keys = new Array<String>();
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		for (String key : me)
		{
			keys.push(key);
		}
		keys.sort(new SortFunction<String>()
		{
			@Override
			public int $invoke(String a, String b)
			{
				return b.compareTo(a);
			}
		});
		Object o = new Object();
		Map<String, Object> op = JSObjectAdapter.$properties(o);
		for (int i = 0; i < keys.$length(); i++)
		{
			String key = keys.$get(i);
			if (isAtProperty(key))
				key = "@" + key;
			Object value = me.$get(key);
			if (value != null)
				op.$put(key, value);
		}
		return JSGlobal.JSON.stringify(o);
	}

	public static boolean isProbablyJson(String decryptedSecret)
	{
		return decryptedSecret.trim().startsWith("{") && decryptedSecret.trim().endsWith("}");
	}

}
