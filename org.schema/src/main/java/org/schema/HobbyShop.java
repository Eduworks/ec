package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/HobbyShop
 * A store that sells materials useful or necessary for various hobbies.
 * @author schema.org
 * @class HobbyShop
 * @module org.schema
 * @extends Store
 */
public class HobbyShop extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public HobbyShop()
	{
		context="http://schema.org/";
		type="HobbyShop";
	}

}