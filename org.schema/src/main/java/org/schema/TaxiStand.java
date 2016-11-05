package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TaxiStand
 * A taxi stand.
 * @author schema.org
 * @module schema.org
 * @class TaxiStand
 * @extends CivicStructure
 */
public class TaxiStand extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TaxiStand()
	{
		context="http://schema.org/";
		type="TaxiStand";
	}

}