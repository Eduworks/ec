package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Mountain
 * A mountain, like Mount Whitney or Mount Everest.
 * @author schema.org
 * @module schema.org
 * @class Mountain
 * @extends Landform
 */
public class Mountain extends Landform
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Mountain()
	{
		context="http://schema.org/";
		type="Mountain";
	}

}