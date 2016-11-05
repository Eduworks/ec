package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Notary
 * A notary.
 * @author schema.org
 * @module schema.org
 * @class Notary
 * @extends LegalService
 */
public class Notary extends LegalService
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Notary()
	{
		context="http://schema.org/";
		type="Notary";
	}

}