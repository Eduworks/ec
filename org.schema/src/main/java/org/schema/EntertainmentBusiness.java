package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/EntertainmentBusiness
 * A business providing entertainment.
 * @author schema.org
 * @module schema.org
 * @class EntertainmentBusiness
 * @extends LocalBusiness
 */
public class EntertainmentBusiness extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EntertainmentBusiness()
	{
		context="http://schema.org/";
		type="EntertainmentBusiness";
	}

}