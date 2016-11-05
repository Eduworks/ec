package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/HealthClub
 * A health club.
 * @author schema.org
 * @module schema.org
 * @class HealthClub
 * @extends HealthAndBeautyBusiness
 */
public class HealthClub extends HealthAndBeautyBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public HealthClub()
	{
		context="http://schema.org/";
		type="HealthClub";
	}

}