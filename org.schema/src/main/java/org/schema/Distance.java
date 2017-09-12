package org.schema;

/**
 * Schema.org/Distance
 * Properties that take Distances as values are of the form '&lt;Number&gt; &lt;Length unit of measure&gt;'. E.g., '7 ft'.
 *
 * @author schema.org
 * @class Distance
 * @module org.schema
 * @extends Quantity
 */
public class Distance extends Quantity {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Distance() {
		context = "http://schema.org/";
		type = "Distance";
	}

}