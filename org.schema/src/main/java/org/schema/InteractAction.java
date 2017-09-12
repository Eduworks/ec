package org.schema;

/**
 * Schema.org/InteractAction
 * The act of interacting with another person or organization.
 * @author schema.org
 * @class InteractAction
 * @module org.schema
 * @extends Action
 */
public class InteractAction extends Action
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public InteractAction()
	{
		context="http://schema.org/";
		type="InteractAction";
	}

}