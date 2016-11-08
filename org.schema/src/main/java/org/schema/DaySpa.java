package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DaySpa
 * A day spa.
 * @author schema.org
 * @class DaySpa
 * @module org.schema
 * @extends HealthAndBeautyBusiness
 */
public class DaySpa extends HealthAndBeautyBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DaySpa()
	{
		context="http://schema.org/";
		type="DaySpa";
	}

}