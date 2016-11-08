package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ApplyAction
 * The act of registering to an organization/service without the guarantee to receive it.\n\nRelated actions:\n\n* [[RegisterAction]]: Unlike RegisterAction, ApplyAction has no guarantees that the application will be accepted.
 * @author schema.org
 * @class ApplyAction
 * @module org.schema
 * @extends OrganizeAction
 */
public class ApplyAction extends OrganizeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ApplyAction()
	{
		context="http://schema.org/";
		type="ApplyAction";
	}

}