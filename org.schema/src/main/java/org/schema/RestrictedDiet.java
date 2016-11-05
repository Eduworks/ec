package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/RestrictedDiet
 * A diet restricted to certain foods or preparations for cultural, religious, health or lifestyle reasons. 
 * @author schema.org
 * @module schema.org
 * @class RestrictedDiet
 * @extends Enumeration
 */
public class RestrictedDiet extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RestrictedDiet()
	{
		context="http://schema.org/";
		type="RestrictedDiet";
	}

}