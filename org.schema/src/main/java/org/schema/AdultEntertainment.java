package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AdultEntertainment
 * An adult entertainment establishment.
 * @author schema.org
 * @module schema.org
 * @class AdultEntertainment
 * @extends EntertainmentBusiness
 */
public class AdultEntertainment extends EntertainmentBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AdultEntertainment()
	{
		context="http://schema.org/";
		type="AdultEntertainment";
	}

}