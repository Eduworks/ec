package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PawnShop
 * A shop that will buy, or lend money against the security of, personal possessions.
 * @author schema.org
 * @module schema.org
 * @class PawnShop
 * @extends Store
 */
public class PawnShop extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PawnShop()
	{
		context="http://schema.org/";
		type="PawnShop";
	}

}