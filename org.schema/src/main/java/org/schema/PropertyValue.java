package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PropertyValue
 * A property-value pair, e.g. representing a feature of a product or place. Use the 'name' property for the name of the property. If there is an additional human-readable version of the value, put that into the 'description' property.\n\n Always use specific schema.org properties when a) they exist and b) you can populate them. Using PropertyValue as a substitute will typically not trigger the same effect as using the original, specific property.
    
 * @author schema.org
 * @module schema.org
 * @class PropertyValue
 * @extends StructuredValue
 */
public class PropertyValue extends StructuredValue
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PropertyValue()
	{
		context="http://schema.org/";
		type="PropertyValue";
	}

	/**
	 * Schema.org/unitCode
	 * The unit of measurement given using the UN/CEFACT Common Code (3 characters) or a URL. Other codes than the UN/CEFACT Common Code may be used with a prefix followed by a colon.
	 * @property unitCode
	 * @type schema,Text | schema,URL	 */
	public Object unitCode;

	/**
	 * Schema.org/minValue
	 * The lower value of some characteristic or property.
	 * @property minValue
	 * @type Number
	 */
	public Double minValue;

	/**
	 * Schema.org/unitText
	 * A string or text indicating the unit of measurement. Useful if you cannot provide a standard unit code for
<a href='unitCode'>unitCode</a>.
	 * @property unitText
	 * @type Text
	 */
	public String unitText;

	/**
	 * Schema.org/valueReference
	 * A pointer to a secondary value that provides additional information on the original value, e.g. a reference temperature.
	 * @property valueReference
	 * @type schema,QuantitativeValue | schema,Enumeration | schema,PropertyValue | schema,StructuredValue | schema,QualitativeValue	 */
	public Object valueReference;

	/**
	 * Schema.org/propertyID
	 * A commonly used identifier for the characteristic represented by the property, e.g. a manufacturer or a standard code for a property. propertyID can be
(1) a prefixed string, mainly meant to be used with standards for product properties; (2) a site-specific, non-prefixed string (e.g. the primary key of the property or the vendor-specific id of the property), or (3)
a URL indicating the type of the property, either pointing to an external vocabulary, or a Web resource that describes the property (e.g. a glossary entry).
Standards bodies should promote a standard prefix for the identifiers of properties from their standards.
	 * @property propertyID
	 * @type schema,Text | schema,URL	 */
	public Object propertyID;

	/**
	 * Schema.org/value
	 * The value of the quantitative value or property value node.\n\n* For [[QuantitativeValue]] and [[MonetaryAmount]], the recommended type for values is 'Number'.\n* For [[PropertyValue]], it can be 'Text;', 'Number', 'Boolean', or 'StructuredValue'.
	 * @property value
	 * @type schema,Text | schema,StructuredValue | schema,Boolean | schema,Number	 */
	public Object value;

	/**
	 * Schema.org/maxValue
	 * The upper value of some characteristic or property.
	 * @property maxValue
	 * @type Number
	 */
	public Double maxValue;

}