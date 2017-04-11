package org.json.ld;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.SortFunction;

import com.eduworks.ec.array.EcArray;
import com.eduworks.ec.array.EcObject;

/**
 * Represents a JSON-LD linked data object and performs serialization.
 * Note: Serialization and deserialization remove parameters that begin with '@'.
 * Note: This Linked Data Object is not assumed to have an @id field.
 * @author fritz.ray@eduworks.com
 * @module org.json.ld
 * @class EcLinkedData
 */
public class EcLinkedData
{
	/**
	 * JSON-LD @type field.
	 * @property type
	 * @type string
	 */
	public String type;
	/**
	 * JSON-LD @context field.
	 * @property context
	 * @type string
	 */
	public String context;

	/**
	 * Create a linked data object.
	 * @constructor
	 * @param {string} context JSON-LD Context.
	 * @param {string} type JSON-LD Type.
	 */
	public EcLinkedData(String context, String type)
	{
		setContextAndType(context, type);
	}

	/**
	 * Set the JSON-LD @context and @type.
	 * @method setContextAndType
	 * @param {string} context JSON-LD Context.
	 * @param {string} type JSON-LD Type.
	 */
	protected void setContextAndType(String context, String type)
	{
		this.context = context;
		this.type = type;
		if (type != null)
		{
			this.type = type.replace(context, "");
			if (this.type.startsWith("/"))
				this.type = this.type.substring(1);
		}
	}

	public static Array<String> atProperties = JSCollections.$array("id", "type", "schema", "context", "signature", "owner", "reader", "encryptedType");

	/**
	 * Determines which fields to serialize into @fields.
	 * 
	 * @internal
	 * @static
	 * @method isAtProperty
	 * @param {string} key Property name to check if it should be an @property.
	 * @return {boolean} True if property is in the set of atProperties.
	 */
	public static boolean isAtProperty(String key)
	{
		for (int i = 0; i < atProperties.$length(); i++)
			if (atProperties.$get(i).equals(key))
				return true;
		return false;
	}

	/**
	 * Serializes this object to JSON.
	 * 
	 * @method toJson
	 * @return {string} JSON formatted object (with JSON-LD fields).
	 */
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
	 * @internal
	 * @method atIfy
	 * @return {Object} Serializable JSON object.
	 */
	public Object atIfy()
	{
		return atIfyObject(this);
	}

	protected Object atIfyArray(Array o)
	{
		Array a = new Array();
		for (int i = 0; i < o.$length(); i++)
		{
			if (EcObject.isObject(o.$get(i)))
			{
				if (o.$get(i) instanceof EcLinkedData)
					a.$set(i, atIfyObject(o.$get(i)));
				else {
					a.$set(i, o.$get(i));
				}
			}
			else if (EcArray.isArray(o.$get(i)))
				a.$set(i, atIfyArray((Array) o.$get(i)));
			else
				a.$set(i, o.$get(i));
		}
		return a;
	}

	protected Object atIfyObject(Object o)
	{
		Array<String> keys = new Array<String>();
		Map<String, Object> me = JSObjectAdapter.$properties(o);
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
				else if (EcArray.isArray(value))
					value = atIfyArray((Array) value);
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
	 * @method isProbablyJson
	 * @static 
	 * @param {string} probableJson JSON to test.
	 * @return {boolean} True if it is probably JSON. False if not.
	 */
	public static boolean isProbablyJson(String probableJson)
	{
		return probableJson.trim().startsWith("{") && probableJson.trim().endsWith("}");
	}

	/**
	 * Uses the object's fully qualified type name and compares it to the
	 * provided type.
	 * 
	 * @method isA
	 * @param {string} type Fully qualified type name uri.
	 * @return {boolean} True if match, False if not.
	 */
	public boolean isA(String type)
	{
		String computedType = getFullType();
		return computedType.equals(type) || this.type.equals(type);
	}

	/**
	 * Uses the object's fully qualified type name and compares it to the
	 * provided type.
	 * 
	 * @method isAny
	 * @param {string[]} type Fully qualified type name uris.
	 * @return {boolean} True if match, False if not.
	 */
	public boolean isAny(Array<String> type)
	{
		String computedType = getFullType();
		if (type.$length() == 0)
			return true;
		for (int i = 0; i < type.$length(); i++)
			if (type.$get(i).equals(computedType) || type.$get(i).equals(this.type))
				return true;
		return false;
	}

	/**
	 * Gets the fully qualified type name, as JSON-LD allows the "namespace" of
	 * the type to be defined in @context.
	 * 
	 * @method getFullType
	 * @return {string} Fully qualified type name.
	 */
	public String getFullType()
	{
		if (context == null)
			return this.type;
		if (this.type.contains("http"))
			return this.type;

		String computedType = context;
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
	 * @method copyFrom
	 * @param that The freshly deserialized object, or the object to upcast into this object.
	 */
	public void copyFrom(Object that)
	{
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		for (String key : me)
		{
			if (JSGlobal.typeof(me.$get(key)) != "function")
				me.$delete(key);
		}
		Map<String, Object> you = JSObjectAdapter.$properties(that);
		for (String key : you)
		{
			if (JSGlobal.typeof(you.$get(key)) != "function")
				me.$put(key.replace("@", ""), you.$get(key));
		}
		upgrade();
		if (!isAny(getTypes()))
			throw new RuntimeException("Incompatible type: " + getFullType());
	}

	/***
	 * Upgrades the object to the latest version, performing transforms and the like.
	 * 
	 * @method upgrade
	 */
	protected void upgrade()
	{
	}

	/**
	 * Removes the @ symbol from properties in order to make them more
	 * accessible in Javascript.
	 * 
	 * @method deAtify
	 * @internal
	 * @return {EcLinkedData} This object, with @ properties converted to @-less properties.
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

	/**
	 * Gets all versions of JSON-LD type strings for this type of object.
	 * 
	 * @method getTypes
	 * @return {string[]} Array of URIs.
	 */
	public Array<String> getTypes()
	{
		Array<String> a = new Array<>();
		if (context != null && type != null)
		{
			String context = (!this.context.endsWith("/") ? this.context+"/" : this.context);
			a.push(context + type);
		}
		return a;
	}

}
