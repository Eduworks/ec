package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BuddhistTemple
 * A Buddhist temple.
 * @author schema.org
 * @module schema.org
 * @class BuddhistTemple
 * @extends PlaceOfWorship
 */
public class BuddhistTemple extends PlaceOfWorship
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BuddhistTemple()
	{
		context="http://schema.org/";
		type="BuddhistTemple";
	}

}