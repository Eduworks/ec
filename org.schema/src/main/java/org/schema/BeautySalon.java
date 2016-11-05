package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BeautySalon
 * Beauty salon.
 * @author schema.org
 * @module schema.org
 * @class BeautySalon
 * @extends HealthAndBeautyBusiness
 */
public class BeautySalon extends HealthAndBeautyBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BeautySalon()
	{
		context="http://schema.org/";
		type="BeautySalon";
	}

}