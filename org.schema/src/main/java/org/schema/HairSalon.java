package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/HairSalon
 * A hair salon.
 * @author schema.org
 * @class HairSalon
 * @module org.schema
 * @extends HealthAndBeautyBusiness
 */
public class HairSalon extends HealthAndBeautyBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public HairSalon()
	{
		context="http://schema.org/";
		type="HairSalon";
	}

}