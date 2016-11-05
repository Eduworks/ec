package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/CatholicChurch
 * A Catholic church.
 * @author schema.org
 * @module schema.org
 * @class CatholicChurch
 * @extends PlaceOfWorship
 */
public class CatholicChurch extends PlaceOfWorship
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CatholicChurch()
	{
		context="http://schema.org/";
		type="CatholicChurch";
	}

}