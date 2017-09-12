package org.schema;

/**
 * Schema.org/Energy
 * Properties that take Energy as values are of the form '&lt;Number&gt; &lt;Energy unit of measure&gt;'.
 * @author schema.org
 * @class Energy
 * @module org.schema
 * @extends Quantity
 */
public class Energy extends Quantity
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Energy()
	{
		context="http://schema.org/";
		type="Energy";
	}

}