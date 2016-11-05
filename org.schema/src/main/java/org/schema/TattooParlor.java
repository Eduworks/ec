package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TattooParlor
 * A tattoo parlor.
 * @author schema.org
 * @module schema.org
 * @class TattooParlor
 * @extends HealthAndBeautyBusiness
 */
public class TattooParlor extends HealthAndBeautyBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TattooParlor()
	{
		context="http://schema.org/";
		type="TattooParlor";
	}

}