package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PerformAction
 * The act of participating in performance arts.
 * @author schema.org
 * @module schema.org
 * @class PerformAction
 * @extends PlayAction
 */
public class PerformAction extends PlayAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PerformAction()
	{
		context="http://schema.org/";
		type="PerformAction";
	}

	/**
	 * Schema.org/entertainmentBusiness
	 * A sub property of location. The entertainment business where the action occurred.
	 * @property entertainmentBusiness
	 * @type EntertainmentBusiness
	 */
	public EntertainmentBusiness entertainmentBusiness;

}