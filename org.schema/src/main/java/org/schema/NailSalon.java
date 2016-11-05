package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/NailSalon
 * A nail salon.
 * @author schema.org
 * @module schema.org
 * @class NailSalon
 * @extends HealthAndBeautyBusiness
 */
public class NailSalon extends HealthAndBeautyBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public NailSalon()
	{
		context="http://schema.org/";
		type="NailSalon";
	}

}