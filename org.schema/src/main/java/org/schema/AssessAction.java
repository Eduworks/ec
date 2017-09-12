package org.schema;

/**
 * Schema.org/AssessAction
 * The act of forming one's opinion, reaction or sentiment.
 * @author schema.org
 * @class AssessAction
 * @module org.schema
 * @extends Action
 */
public class AssessAction extends Action
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AssessAction()
	{
		context="http://schema.org/";
		type="AssessAction";
	}

}