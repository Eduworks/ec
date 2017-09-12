package org.schema;

/**
 * Schema.org/IgnoreAction
 * The act of intentionally disregarding the object. An agent ignores an object.
 * @author schema.org
 * @class IgnoreAction
 * @module org.schema
 * @extends AssessAction
 */
public class IgnoreAction extends AssessAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public IgnoreAction()
	{
		context="http://schema.org/";
		type="IgnoreAction";
	}

}