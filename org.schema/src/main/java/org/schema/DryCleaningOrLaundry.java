package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DryCleaningOrLaundry
 * A dry-cleaning business.
 * @author schema.org
 * @class DryCleaningOrLaundry
 * @module org.schema
 * @extends LocalBusiness
 */
public class DryCleaningOrLaundry extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DryCleaningOrLaundry()
	{
		context="http://schema.org/";
		type="DryCleaningOrLaundry";
	}

}