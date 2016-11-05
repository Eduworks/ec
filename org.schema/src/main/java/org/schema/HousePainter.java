package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/HousePainter
 * A house painting service.
 * @author schema.org
 * @module schema.org
 * @class HousePainter
 * @extends HomeAndConstructionBusiness
 */
public class HousePainter extends HomeAndConstructionBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public HousePainter()
	{
		context="http://schema.org/";
		type="HousePainter";
	}

}