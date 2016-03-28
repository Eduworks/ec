package org.json.ld;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.SortFunction;

public class EcLinkedData
{
	/**
	 * Represents the @type field in JSON-LD.
	 */
	public String type;
	/**
	 * Represents the @schema field in JSON-LD.
	 */
	public String schema;

	public EcLinkedData(String schema, String type)
	{
		this.schema = schema;
		this.type = type;
	}

	public static Array<String> atProperties = JSCollections.$array("id", "type", "schema", "context", "signature", "owner", "reader","encryptedType");

	/**
	 * Determines which fields to serialize into @fields.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isAtProperty(String s)
	{
		for (int i = 0; i < atProperties.$length(); i++)
			if (atProperties.$get(i).equals(s))
				return true;
		return false;
	}

	public String toJson()
	{
		// This method serializes the fields in alphabetical order.
		// This is to prevent signature based errors.
		Object o = atIfy();
		return JSGlobal.JSON.stringify(o);
	}

	/**
	 * Forces Javascript to encode the object in alphabetical order in order to
	 * make signature based actions more viable. Also places @(at) symbols in
	 * front of appropriate fields.
	 * 
	 * @return Serializable JSON object.
	 */
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
			Object value = me.$get(key.replace("@", ""));
			if (value != null)
				if (value instanceof EcLinkedData)
					value = ((EcLinkedData) value).atIfy();
			if (value != null)
				op.$put(key, value);
			else
				value = me.$get(key);

			if (value != null)
				op.$put(key, value);
		}
		return op;
	}

	/**
	 * Helper function to determine if a piece of data is probably a JSON
	 * object.
	 * 
	 * @param probableJson
	 * @return True if is probably JSON. False if not.
	 */
	public static boolean isProbablyJson(String probableJson)
	{
		return probableJson.trim().startsWith("{") && probableJson.trim().endsWith("}");
	}

	/**
	 * Uses the object's fully qualified type name and compares it to the
	 * provided type.
	 * 
	 * @param type
	 *            Fully qualified type name uri.
	 * @return True if match, False if not.
	 */
	public boolean isA(String type)
	{
		String computedType = getFullType();
		return computedType.equals(type) || this.type.equals(type);
	}

	/**
	 * Gets the fully qualified type name, as JSON-LD allows the "namespace" of
	 * the type to be defined in @schema.
	 * 
	 * @return Fully qualified type name.
	 */
	public String getFullType()
	{
		String computedType = schema;
		// Someone confused Context with Schema. Don't do this!
		if (this.type.contains("http") == false && computedType.contains("http") == false)
			computedType = JSObjectAdapter.$properties(this).$get("context").toString();
		if (!computedType.endsWith("/"))
			computedType += "/";
		computedType += this.type;
		return computedType;
	}

	/**
	 * Also could be called "upcast", for those in the know.
	 * 
	 * Ghetto method of copying properties from some other object. As freshly
	 * deserialized javascript objects do not inherently attach the functions of
	 * their type, it is this or factory hell.
	 * 
	 * @param that
	 *            The freshly deserialized object, or the object to upcast into
	 *            this object.
	 */
	public void copyFrom(Object that)
	{
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		Map<String, Object> you = JSObjectAdapter.$properties(that);
		for (String key : you)
		{
			if (me.$get(key) == null)
				me.$put(key.replace("@", ""), you.$get(key));
		}
	}

	/**
	 * Removes the @ symbol from properties in order to make them more
	 * accessible in Javascript.
	 * 
	 * @return This object, with @ properties converted to @-less properties.
	 */
	public EcLinkedData deAtify()
	{
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		for (String key : me)
		{
			if (me.$get(key) == null)
			{
				Object value = me.$get(key);
				if (value != null)
					if (value instanceof EcLinkedData)
						value = ((EcLinkedData) value).deAtify();
				me.$put(key.replace("@", ""), value);
			}
		}
		return this;
	}

}
