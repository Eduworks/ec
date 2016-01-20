package org.json.ld;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
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
		Object o = atIfy();
		return JSGlobal.JSON.stringify(o);
	}

	public Object atIfy()
	{
		Array<String> keys = new Array<String>();
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		for (String key : me)
		{
			if (isAtProperty(key))
				key = "@" + key;
			keys.push(key);
		}
		keys.sort(new SortFunction<String>()
		{
			@Override
			public int $invoke(String a, String b)
			{
				return a.compareTo(b);
			}
		});
		Map<String, Object> op = JSObjectAdapter.$properties(new Object());
		for (int i = 0; i < keys.$length(); i++)
		{
			String key = keys.$get(i);
			Object value = me.$get(key.replace("@",""));
			if (value != null)
				op.$put(key, value);
		}
		return op;
	}

	public static boolean isProbablyJson(String decryptedSecret)
	{
		return decryptedSecret.trim().startsWith("{") && decryptedSecret.trim().endsWith("}");
	}

	public boolean isA(String type)
	{
		String computedType = getFullType();
		return computedType.equals(type) || this.type.equals(type);
	}

	public String getFullType()
	{
		String computedType = schema;
		//Someone confused Context with Schema. Don't do this!
		if (this.type.contains("http") == false && computedType.contains("http") == false)
			computedType = JSObjectAdapter.$properties(this).$get("context").toString();
		if (!computedType.endsWith("/"))
			computedType += "/";
		computedType += this.type;
		return computedType;
	}

	public void copyFrom(Object that)
	{
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		Map<String, Object> you = JSObjectAdapter.$properties(that);
		for (String key : you)
		{
			if (me.$get(key) == null)
				me.$put(key.replace("@",""),you.$get(key));
		}
	}


}
