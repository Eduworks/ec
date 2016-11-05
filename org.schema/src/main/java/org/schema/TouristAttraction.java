package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TouristAttraction
 * A tourist attraction.
 * @author schema.org
 * @module schema.org
 * @class TouristAttraction
 * @extends Place
 */
public class TouristAttraction extends Place
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TouristAttraction()
	{
		context="http://schema.org/";
		type="TouristAttraction";
	}

}