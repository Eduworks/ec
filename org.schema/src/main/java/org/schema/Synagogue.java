package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Synagogue
 * A synagogue.
 * @author schema.org
 * @class Synagogue
 * @module org.schema
 * @extends PlaceOfWorship
 */
public class Synagogue extends PlaceOfWorship
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Synagogue()
	{
		context="http://schema.org/";
		type="Synagogue";
	}

}