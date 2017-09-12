package org.schema;

/**
 * Schema.org/StructuredValue
 * Structured values are used when the value of a property has a more complex structure than simply being a textual value or a reference to another thing.
 *
 * @author schema.org
 * @class StructuredValue
 * @module org.schema
 * @extends Intangible
 */
public class StructuredValue extends Intangible {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public StructuredValue() {
		context = "http://schema.org/";
		type = "StructuredValue";
	}

}