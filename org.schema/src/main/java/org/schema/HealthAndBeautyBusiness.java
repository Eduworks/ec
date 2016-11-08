package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/HealthAndBeautyBusiness
 * Health and beauty.
 * @author schema.org
 * @class HealthAndBeautyBusiness
 * @module org.schema
 * @extends LocalBusiness
 */
public class HealthAndBeautyBusiness extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public HealthAndBeautyBusiness()
	{
		context="http://schema.org/";
		type="HealthAndBeautyBusiness";
	}

}