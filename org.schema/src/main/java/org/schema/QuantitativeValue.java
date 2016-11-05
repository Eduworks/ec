package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/QuantitativeValue
 *  A point value or interval for product characteristics and other purposes.
 * @author schema.org
 * @module schema.org
 * @class QuantitativeValue
 * @extends StructuredValue
 */
public class QuantitativeValue extends StructuredValue
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public QuantitativeValue()
	{
		context="http://schema.org/";
		type="QuantitativeValue";
	}

	/**
	 * Schema.org/additionalProperty
	 * A property-value pair representing an additional characteristics of the entitity, e.g. a product feature or another characteristic for which there is no matching property in schema.org.\n\nNote: Publishers should be aware that applications designed to use specific schema.org properties (e.g. http://schema.org/width, http://schema.org/color, http://schema.org/gtin13, ...) will typically expect such data to be provided using those properties, rather than using the generic property/value mechanism.

	 * @property additionalProperty
	 * @type PropertyValue
	 */
	public PropertyValue additionalProperty;

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