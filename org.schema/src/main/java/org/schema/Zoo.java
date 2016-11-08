package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Zoo
 * A zoo.
 * @author schema.org
 * @class Zoo
 * @module org.schema
 * @extends CivicStructure
 */
public class Zoo extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Zoo()
	{
		context="http://schema.org/";
		type="Zoo";
	}

}