package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MovingCompany
 * A moving company.
 * @author schema.org
 * @module schema.org
 * @class MovingCompany
 * @extends HomeAndConstructionBusiness
 */
public class MovingCompany extends HomeAndConstructionBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MovingCompany()
	{
		context="http://schema.org/";
		type="MovingCompany";
	}

}