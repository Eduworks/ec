package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ContactPointOption
 * Enumerated options related to a ContactPoint.
 * @author schema.org
 * @class ContactPointOption
 * @module org.schema
 * @extends Enumeration
 */
public class ContactPointOption extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ContactPointOption()
	{
		context="http://schema.org/";
		type="ContactPointOption";
	}

}