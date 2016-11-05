package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Aquarium
 * Aquarium.
 * @author schema.org
 * @module schema.org
 * @class Aquarium
 * @extends CivicStructure
 */
public class Aquarium extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Aquarium()
	{
		context="http://schema.org/";
		type="Aquarium";
	}

}