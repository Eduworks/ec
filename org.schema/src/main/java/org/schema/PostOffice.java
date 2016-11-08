package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PostOffice
 * A post office.
 * @author schema.org
 * @class PostOffice
 * @module org.schema
 * @extends GovernmentOffice
 */
public class PostOffice extends GovernmentOffice
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PostOffice()
	{
		context="http://schema.org/";
		type="PostOffice";
	}

}