package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AllocateAction
 * The act of organizing tasks/objects/events by associating resources to it.
 * @author schema.org
 * @class AllocateAction
 * @module org.schema
 * @extends OrganizeAction
 */
public class AllocateAction extends OrganizeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AllocateAction()
	{
		context="http://schema.org/";
		type="AllocateAction";
	}

}