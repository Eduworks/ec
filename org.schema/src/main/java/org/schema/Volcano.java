package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Volcano
 * A volcano, like Fuji san.
 * @author schema.org
 * @class Volcano
 * @module org.schema
 * @extends Landform
 */
public class Volcano extends Landform
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Volcano()
	{
		context="http://schema.org/";
		type="Volcano";
	}

}