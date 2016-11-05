package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AdministrativeArea
 * A geographical region, typically under the jurisdiction of a particular government.
 * @author schema.org
 * @module schema.org
 * @class AdministrativeArea
 * @extends Place
 */
public class AdministrativeArea extends Place
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AdministrativeArea()
	{
		context="http://schema.org/";
		type="AdministrativeArea";
	}

}