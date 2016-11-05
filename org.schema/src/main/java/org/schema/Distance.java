package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Distance
 * Properties that take Distances as values are of the form '&lt;Number&gt; &lt;Length unit of measure&gt;'. E.g., '7 ft'.
 * @author schema.org
 * @module schema.org
 * @class Distance
 * @extends Quantity
 */
public class Distance extends Quantity
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Distance()
	{
		context="http://schema.org/";
		type="Distance";
	}

}