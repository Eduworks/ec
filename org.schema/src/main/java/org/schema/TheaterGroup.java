package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TheaterGroup
 * A theater group or company, for example, the Royal Shakespeare Company or Druid Theatre.
 * @author schema.org
 * @module schema.org
 * @class TheaterGroup
 * @extends PerformingGroup
 */
public class TheaterGroup extends PerformingGroup
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TheaterGroup()
	{
		context="http://schema.org/";
		type="TheaterGroup";
	}

}