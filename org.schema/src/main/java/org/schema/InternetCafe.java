package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/InternetCafe
 * An internet cafe.
 * @author schema.org
 * @class InternetCafe
 * @module org.schema
 * @extends LocalBusiness
 */
public class InternetCafe extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public InternetCafe()
	{
		context="http://schema.org/";
		type="InternetCafe";
	}

}