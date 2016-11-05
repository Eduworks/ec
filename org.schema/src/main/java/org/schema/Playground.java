package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Playground
 * A playground.
 * @author schema.org
 * @module schema.org
 * @class Playground
 * @extends CivicStructure
 */
public class Playground extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Playground()
	{
		context="http://schema.org/";
		type="Playground";
	}

}