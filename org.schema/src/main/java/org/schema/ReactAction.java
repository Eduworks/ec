package org.schema;

/**
 * Schema.org/ReactAction
 * The act of responding instinctively and emotionally to an object, expressing a sentiment.
 * @author schema.org
 * @class ReactAction
 * @module org.schema
 * @extends AssessAction
 */
public class ReactAction extends AssessAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ReactAction()
	{
		context="http://schema.org/";
		type="ReactAction";
	}

}