package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Mass
 * Properties that take Mass as values are of the form '&lt;Number&gt; &lt;Mass unit of measure&gt;'. E.g., '7 kg'.
 * @author schema.org
 * @module schema.org
 * @class Mass
 * @extends Quantity
 */
public class Mass extends Quantity
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Mass()
	{
		context="http://schema.org/";
		type="Mass";
	}

}