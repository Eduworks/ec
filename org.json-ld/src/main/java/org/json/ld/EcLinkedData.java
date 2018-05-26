package org.json.ld;

import com.eduworks.ec.array.EcArray;
import com.eduworks.ec.array.EcObject;
import js.jsonld;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback3;

/**
 * Represents a JSON-LD linked data object and performs serialization.
 * Note: Serialization and deserialization remove parameters that begin with '@'.
 * Note: This Linked Data Object is not assumed to have an @id field.
 *
 * @author fritz.ray@eduworks.com
 * @module org.json.ld
 * @class EcLinkedData
 */
public class EcLinkedData {
	public static Array<String> atProperties = JSCollections.$array("id", "type", "schema", "context", "signature", "graph", "owner", "reader", "encryptedType");
	/**
	 * JSON-LD @type field.
	 *
	 * @property type
	 * @type string
	 */
	public String type;
	/**
	 * JSON-LD @context field.
	 *
	 * @property context
	 * @type string
	 */
	public String context;

	/**
	 * Create a linked data object.
	 *
	 * @param {string} context JSON-LD Context.
	 * @param {string} type JSON-LD Type.
	 * @constructor
	 */
	public EcLinkedData(String context, String type) {
		setContextAndType(context, type);
	}

	/**
	 * Determines which fields to serialize into @fields.
	 *
	 * @param {string} key Property name to check if it should be an @property.
	 * @return {boolean} True if property is in the set of atProperties.
	 * @internal
	 * @static
	 * @method isAtProperty
	 */
	public static boolean isAtProperty(String key) {
		for (int i = 0; i < atProperties.$length(); i++)
			if (atProperties.$get(i).equals(key))
				return true;
		return false;
	}

	/**
	 * Helper function to determine if a piece of data is probably a JSON
	 * object.
	 *
	 * @param {string} probableJson JSON to test.
	 * @return {boolean} True if it is probably JSON. False if not.
	 * @method isProbablyJson
	 * @static
	 */
	public static boolean isProbablyJson(String probableJson) {
		return probableJson.trim().startsWith("{") && probableJson.trim().endsWith("}");
	}

	/**
	 * Set the JSON-LD @context and @type.
	 *
	 * @param {string} context JSON-LD Context.
	 * @param {string} type JSON-LD Type.
	 * @method setContextAndType
	 */
	protected void setContextAndType(String context, String type) {
		this.context = context;
		this.type = type;
		if (type != null) {
			this.type = type.replace(context, "");
			if (this.type.startsWith("/"))
				this.type = this.type.substring(1);
		}
	}

	/**
	 * Serializes this object to JSON.
	 *
	 * @return {string} JSON formatted object (with JSON-LD fields).
	 * @method toJson
	 */
	public String toJson() {
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
	 * @return {Object} Serializable JSON object.
	 * @internal
	 * @method atIfy
	 */
	public Object atIfy() {
		return atIfyObject(this);
	}

	protected Object atIfyArray(Array o) {
		Array a = new Array();
		for (int i = 0; i < o.$length(); i++) {
			if (EcObject.isObject(o.$get(i))) {
				if (o.$get(i) instanceof EcLinkedData)
					a.$set(i, atIfyObject(o.$get(i)));
				else {
					a.$set(i, o.$get(i));
				}
			} else if (EcArray.isArray(o.$get(i)))
				a.$set(i, atIfyArray((Array) o.$get(i)));
			else
				a.$set(i, o.$get(i));
		}
		return a;
	}

	protected Object atIfyObject(Object o) {
		Array<String> keys = new Array<String>();
		Map<String, Object> me = JSObjectAdapter.$properties(o);
		for (String key : me) {
			if (isAtProperty(key))
				key = "@" + key;
			keys.push(key);
		}
		keys.sort(new SortFunction<String>() {
			@Override
			public int $invoke(String a, String b) {
				return a.compareTo(b);
			}
		});
		Map<String, Object> op = JSObjectAdapter.$properties(new Object());
		for (int i = 0; i < keys.$length(); i++) {
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
	 * Uses the object's fully qualified type name and compares it to the
	 * provided type.
	 *
	 * @param {string} type Fully qualified type name uri.
	 * @return {boolean} True if match, False if not.
	 * @method isA
	 */
	public boolean isA(String type) {
		String computedType = getFullType();
		return computedType.equals(type) || this.type.equals(type);
	}

	/**
	 * Uses the object's fully qualified type name and compares it to the
	 * provided type.
	 *
	 * @param {string[]} type Fully qualified type name uris.
	 * @return {boolean} True if match, False if not.
	 * @method isAny
	 */
	public boolean isAny(Array<String> type) {
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
	 * @return {string} Fully qualified type name.
	 * @method getFullType
	 */
	public String getFullType() {
		if (context == null)
			return this.type;
		if (this.type.indexOf("http") != -1)
			return this.type;

		String computedType = context;
		if (EcObject.isObject(context)) {
			Array<String> typeParts = (Array<String>) (Object) this.type.split(":");
			if (typeParts.$length() == 2) {
				computedType = (String) JSObjectAdapter.$get(context, typeParts.$get(0));
				if (!computedType.endsWith("/"))
					computedType += "/";
				computedType += typeParts.$get(1);
				return computedType;
			} else if (JSObjectAdapter.$get(context, "@vocab") != null)
				computedType = (String) JSObjectAdapter.$get(context, "@vocab");
		}
		if (!computedType.endsWith("/"))
			computedType += "/";
		computedType += this.type;
		return computedType;
	}

	/**
	 * Also could be called "upcast", for those in the know.
	 * <p>
	 * Ghetto method of copying properties from some other object. As freshly
	 * deserialized javascript objects do not inherently attach the functions of
	 * their type, it is this or factory hell.
	 *
	 * @param that The freshly deserialized object, or the object to upcast into this object.
	 * @method copyFrom
	 */
	public void copyFrom(Object that) {
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		for (String key : me) {
			if (JSGlobal.typeof(me.$get(key)) != "function")
				me.$delete(key);
		}
		Map<String, Object> you = JSObjectAdapter.$properties(that);
		for (String key : you) {
			if (JSGlobal.typeof(you.$get(key)) != "function")
				me.$put(key.replace("@", ""), you.$get(key));
		}

		String stripNamespace = null;
		String newContext = null;

		if (type != null && context != null && EcObject.isObject(context)) {
			Array<String> typeParts = (Array<String>) (Object) this.type.split(":");
			if (typeParts.$length() == 2) {
				newContext = (String) JSObjectAdapter.$get(context, typeParts.$get(0));
				stripNamespace = typeParts.$get(0);
				if (!newContext.endsWith("/"))
					newContext += "/";
			} else if (JSObjectAdapter.$get(context, "@vocab") != null)
				newContext = (String) JSObjectAdapter.$get(context, "@vocab");
		}

		if (stripNamespace != null)
			for (String key : me) {
				if (JSGlobal.typeof(me.$get(key)) != "function") {
					if (key.startsWith(stripNamespace + ":")) {
						if (EcArray.isArray(me.$get(key))) {
							JSObjectAdapter.$put(me, key.replace(stripNamespace + ":", ""), Global.JSON.parse(Global.JSON.stringify(me.$get(key)).replaceAll(stripNamespace + ":", "")));
						} else if (EcObject.isObject(me.$get(key))) {
							JSObjectAdapter.$put(me, key.replace(stripNamespace + ":", ""), Global.JSON.parse(Global.JSON.stringify(me.$get(key)).replaceAll(stripNamespace + ":", "")));
						} else
							JSObjectAdapter.$put(me, key.replace(stripNamespace + ":", ""), me.$get(key));
						me.$delete(key);
					}
				}
			}

		if (newContext != null)
			context = newContext;

		upgrade();
		if (!isAny(getTypes()))
			throw new RuntimeException("Incompatible type: " + getFullType());
	}

	/***
	 * Upgrades the object to the latest version, performing transforms and the like.
	 *
	 * @method upgrade
	 */
	protected void upgrade() {
	}

	/**
	 * Removes the @ symbol from properties in order to make them more
	 * accessible in Javascript.
	 *
	 * @return {EcLinkedData} This object, with @ properties converted to @-less properties.
	 * @method deAtify
	 * @internal
	 */
	public EcLinkedData deAtify() {
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		for (String key : me) {
			if (me.$get(key) == null) {
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
	 * @return {string[]} Array of URIs.
	 * @method getTypes
	 */
	public Array<String> getTypes() {
		Array<String> a = new Array<>();
		if (context != null && type != null) {
			if (!EcObject.isObject(context)) {
				String context = (!this.context.endsWith("/") ? this.context + "/" : this.context);
				a.push(context + type);
			}
		}
		return a;
	}

	public void compact(String remoteContextUrl, final Callback1<Object> success, final Callback1<String> failure) {
		final EcLinkedData me = this;
		jsonld.compact(toJson(), remoteContextUrl, new Object(), new Callback3<String, Object, Object>() {
			@Override
			public void $invoke(String err, Object compacted, Object context) {
				if (err != null) {
					failure.$invoke(err);
					return;
				}
				me.copyFrom(compacted);
				success.$invoke(this);
			}
		});
	}

}
