package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/GeneralContractor
 * A general contractor.
 * @author schema.org
 * @module schema.org
 * @class GeneralContractor
 * @extends HomeAndConstructionBusiness
 */
public class GeneralContractor extends HomeAndConstructionBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GeneralContractor()
	{
		context="http://schema.org/";
		type="GeneralContractor";
	}

}