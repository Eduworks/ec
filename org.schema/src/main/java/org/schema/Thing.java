package org.schema;

import com.eduworks.ec.array.EcArray;
import com.eduworks.ec.array.EcObject;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;

/**
 * Schema.org/Thing
 * The most generic type of item.
 *
 * @author schema.org
 * @class Thing
 * @module org.schema
 */
public class Thing extends EcRemoteLinkedData {
	/**
	 * Schema.org/name
	 * The name of the item.
	 *
	 * @property name
	 * @type Text
	 */
	public String name;
	/**
	 * Schema.org/identifier
	 * The identifier property represents any kind of identifier for any kind of [[Thing]], such as ISBNs, GTIN codes, UUIDs etc. Schema.org provides dedicated properties for representing many of these, either as textual strings or as URL (URI) links. See [background notes](/docs/datamodel.html#identifierBg) for more details.
	 *
	 * @property identifier
	 * @type schema, URL | schema,Text | schema,PropertyValue
	 */
	public Object identifier;
	/**
	 * Schema.org/url
	 * URL of the item.
	 *
	 * @property url
	 * @type URL
	 */
	public String url;
	/**
	 * Schema.org/image
	 * An image of the item. This can be a [[URL]] or a fully described [[ImageObject]].
	 *
	 * @property image
	 * @type schema, URL | schema,ImageObject
	 */
	public Object image;
	/**
	 * Schema.org/description
	 * A description of the item.
	 *
	 * @property description
	 * @type Text
	 */
	public String description;
	/**
	 * Schema.org/disambiguatingDescription
	 * A sub property of description. A short description of the item used to disambiguate from other, similar items. Information from other properties (in particular, name) may be necessary for the description to be useful for disambiguation.
	 *
	 * @property disambiguatingDescription
	 * @type Text
	 */
	public String disambiguatingDescription;
	/**
	 * Schema.org/alternateName
	 * An alias for the item.
	 *
	 * @property alternateName
	 * @type Text
	 */
	public String alternateName;
	/**
	 * Schema.org/sameAs
	 * URL of a reference Web page that unambiguously indicates the item's identity. E.g. the URL of the item's Wikipedia page, Wikidata entry, or official website.
	 *
	 * @property sameAs
	 * @type URL
	 */
	public String sameAs;
	/**
	 * Schema.org/additionalType
	 * An additional type for the item, typically used for adding more specific types from external vocabularies in microdata syntax. This is a relationship between something and a class that the thing is in. In RDFa syntax, it is better to use the native RDFa syntax - the 'typeof' attribute - for multiple types. Schema.org tools may have only weaker understanding of extra types, in particular those defined externally.
	 *
	 * @property additionalType
	 * @type URL
	 */
	public String additionalType;
	/**
	 * Schema.org/potentialAction
	 * Indicates a potential Action, which describes an idealized action in which this thing would play an 'object' role.
	 *
	 * @property potentialAction
	 * @type Action
	 */
	public Action potentialAction;
	/**
	 * Schema.org/mainEntityOfPage
	 * Indicates a page (or other CreativeWork) for which this thing is the main entity being described. See [background notes](/docs/datamodel.html#mainEntityBackground) for details.
	 *
	 * @property mainEntityOfPage
	 * @type schema, URL | schema,CreativeWork
	 */
	public Object mainEntityOfPage;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Thing() {
		super("http://schema.org/", "Thing");
	}

	/**
	 * Returns the name of the thing
	 *
	 * @return {String} name of Thing
	 * @memberOf Thing
	 * @method getName
	 */
	public String getName() {
		Object n = this.name;
		return getDisplayStringFrom(n);
	}

	/**
	 * Method to set Thing name
	 *
	 * @param {String} name
	 *                 Name to set for this Thing
	 * @memberOf Thing
	 * @method setName
	 */
	public void setName(String name) {
		if (this.name != null && EcObject.isObject(this.name) && JSObjectAdapter.hasOwnProperty(this.name, "@value")) {
			Object obj = JSObjectAdapter.$get(this, "name");
			JSObjectAdapter.$put(obj, "@value", name);
			JSObjectAdapter.$put(this, "name", obj);
		} else {
			this.name = name;
		}

	}

	/**
	 * Returns the description of the thing
	 *
	 * @return {String} description of Thing
	 * @memberOf Thing
	 * @method getDescription
	 */
	public String getDescription() {
		Object n = this.description;
		return getDisplayStringFrom(n);
	}

	public static String getDisplayStringFrom(Object n) {
		if (n != null && EcArray.isArray(n)) {
			if (((Array) n).$length() > 0)
				n = ((Array) n).$get(0);
		}
		if (n != null && EcObject.isObject(n) && JSObjectAdapter.hasOwnProperty(n, "@value")) {
			return (String) JSObjectAdapter.$get(n, "@value");
		}
		return (String) n;
	}

	/**
	 * Method to set Thing description
	 *
	 * @param {String} description
	 *                 Description to set for its Thing
	 * @memberOf Thing
	 * @method setDescription
	 */
	public void setDescription(String description) {
		if (this.description != null && EcObject.isObject(this.description) && JSObjectAdapter.hasOwnProperty(this.description, "@value")) {
			Object obj = JSObjectAdapter.$get(this, "description");
			JSObjectAdapter.$put(obj, "@value", description);
			JSObjectAdapter.$put(this, "description", obj);
		} else {
			this.description = description;
		}
	}

}