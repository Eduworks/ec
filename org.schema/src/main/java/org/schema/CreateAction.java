package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/CreateAction
 * The act of deliberately creating/producing/generating/building a result out of the agent.
 * @author schema.org
 * @class CreateAction
 * @module org.schema
 * @extends Action
 */
public class CreateAction extends Action
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CreateAction()
	{
		context="http://schema.org/";
		type="CreateAction";
	}

}