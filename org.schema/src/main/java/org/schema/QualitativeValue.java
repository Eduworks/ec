package org.schema;

/**
 * Schema.org/QualitativeValue
 * A predefined value for a product characteristic, e.g. the power cord plug type 'US' or the garment sizes 'S', 'M', 'L', and 'XL'.
 * @author schema.org
 * @class QualitativeValue
 * @module org.schema
 * @extends Enumeration
 */
public class QualitativeValue extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public QualitativeValue()
	{
		context="http://schema.org/";
		type="QualitativeValue";
	}

	/**
	 * Schema.org/greaterOrEqual
	 * This ordering relation for qualitative values indicates that the subject is greater than or equal to the object.
	 * @property greaterOrEqual
	 * @type QualitativeValue
	 */
	public QualitativeValue greaterOrEqual;

	/**
	 * Schema.org/additionalProperty
	 * A property-value pair representing an additional characteristics of the entitity, e.g. a product feature or another characteristic for which there is no matching property in schema.org.\n\nNote: Publishers should be aware that applications designed to use specific schema.org properties (e.g. http://schema.org/width, http://schema.org/color, http://schema.org/gtin13, ...) will typically expect such data to be provided using those properties, rather than using the generic property/value mechanism.

	 * @property additionalProperty
	 * @type PropertyValue
	 */
	public PropertyValue additionalProperty;

	/**
	 * Schema.org/nonEqual
	 * This ordering relation for qualitative values indicates that the subject is not equal to the object.
	 * @property nonEqual
	 * @type QualitativeValue
	 */
	public QualitativeValue nonEqual;

	/**
	 * Schema.org/lesser
	 * This ordering relation for qualitative values indicates that the subject is lesser than the object.
	 * @property lesser
	 * @type QualitativeValue
	 */
	public QualitativeValue lesser;

	/**
	 * Schema.org/lesserOrEqual
	 * This ordering relation for qualitative values indicates that the subject is lesser than or equal to the object.
	 * @property lesserOrEqual
	 * @type QualitativeValue
	 */
	public QualitativeValue lesserOrEqual;

	/**
	 * Schema.org/equal
	 * This ordering relation for qualitative values indicates that the subject is equal to the object.
	 * @property equal
	 * @type QualitativeValue
	 */
	public QualitativeValue equal;

	/**
	 * Schema.org/greater
	 * This ordering relation for qualitative values indicates that the subject is greater than the object.
	 * @property greater
	 * @type QualitativeValue
	 */
	public QualitativeValue greater;

	/**
	 * Schema.org/valueReference
	 * A pointer to a secondary value that provides additional information on the original value, e.g. a reference temperature.
	 * @property valueReference
	 * @type schema,StructuredValue | schema,QualitativeValue | schema,Enumeration | schema,QuantitativeValue | schema,PropertyValue
	 */
	public Object valueReference;

}