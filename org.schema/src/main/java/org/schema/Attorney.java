package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Attorney
 * Professional service: Attorney. \n\nThis type is deprecated - [[LegalService]] is more inclusive and less ambiguous.
 * @author schema.org
 * @module schema.org
 * @class Attorney
 * @extends LegalService
 */
public class Attorney extends LegalService
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Attorney()
	{
		context="http://schema.org/";
		type="Attorney";
	}

}