package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/HomeAndConstructionBusiness
 * A construction business.\n\nA HomeAndConstructionBusiness is a [[LocalBusiness]] that provides services around homes and buildings.\n\nAs a [[LocalBusiness]] it can be described as a [[provider]] of one or more [[Service]]\(s).
 * @author schema.org
 * @module schema.org
 * @class HomeAndConstructionBusiness
 * @extends LocalBusiness
 */
public class HomeAndConstructionBusiness extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public HomeAndConstructionBusiness()
	{
		context="http://schema.org/";
		type="HomeAndConstructionBusiness";
	}

}