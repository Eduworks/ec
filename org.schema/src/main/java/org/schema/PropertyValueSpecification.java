package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PropertyValueSpecification
 * A Property value specification.
 * @author schema.org
 * @class PropertyValueSpecification
 * @module org.schema
 * @extends Intangible
 */
public class PropertyValueSpecification extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PropertyValueSpecification()
	{
		context="http://schema.org/";
		type="PropertyValueSpecification";
	}

	/**
	 * Schema.org/valueMinLength
	 * Specifies the minimum allowed range for number of characters in a literal value.
	 * @property valueMinLength
	 * @type Number
	 */
	public Double valueMinLength;

	/**
	 * Schema.org/valuePattern
	 * Specifies a regular expression for testing literal values according to the HTML spec.
	 * @property valuePattern
	 * @type Text
	 */
	public String valuePattern;

	/**
	 * Schema.org/readonlyValue
	 * Whether or not a property is mutable.  Default is false. Specifying this for a property that also has a value makes it act similar to a "hidden" input in an HTML form.
	 * @property readonlyValue
	 * @type Boolean
	 */
	public Boolean readonlyValue;

	/**
	 * Schema.org/minValue
	 * The lower value of some characteristic or property.
	 * @property minValue
	 * @type Number
	 */
	public Double minValue;

	/**
	 * Schema.org/valueRequired
	 * Whether the property must be filled in to complete the action.  Default is false.
	 * @property valueRequired
	 * @type Boolean
	 */
	public Boolean valueRequired;

	/**
	 * Schema.org/stepValue
	 * The stepValue attribute indicates the granularity that is expected (and required) of the value in a PropertyValueSpecification.
	 * @property stepValue
	 * @type Number
	 */
	public Double stepValue;

	/**
	 * Schema.org/valueName
	 * Indicates the name of the PropertyValueSpecification to be used in URL templates and form encoding in a manner analogous to HTML's input@name.
	 * @property valueName
	 * @type Text
	 */
	public String valueName;

	/**
	 * Schema.org/valueMaxLength
	 * Specifies the allowed range for number of characters in a literal value.
	 * @property valueMaxLength
	 * @type Number
	 */
	public Double valueMaxLength;

	/**
	 * Schema.org/maxValue
	 * The upper value of some characteristic or property.
	 * @property maxValue
	 * @type Number
	 */
	public Double maxValue;

	/**
	 * Schema.org/multipleValues
	 * Whether multiple values are allowed for the property.  Default is false.
	 * @property multipleValues
	 * @type Boolean
	 */
	public Boolean multipleValues;

	/**
	 * Schema.org/defaultValue
	 * The default value of the input.  For properties that expect a literal, the default is a literal value, for properties that expect an object, it's an ID reference to one of the current values.
	 * @property defaultValue
	 * @type schema,Thing | schema,Text
	 */
	public Object defaultValue;

}