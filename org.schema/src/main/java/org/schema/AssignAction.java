package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AssignAction
 * The act of allocating an action/event/task to some destination (someone or something).
 * @author schema.org
 * @class AssignAction
 * @module org.schema
 * @extends AllocateAction
 */
public class AssignAction extends AllocateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AssignAction()
	{
		context="http://schema.org/";
		type="AssignAction";
	}

}