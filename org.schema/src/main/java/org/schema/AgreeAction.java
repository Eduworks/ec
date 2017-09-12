package org.schema;

/**
 * Schema.org/AgreeAction
 * The act of expressing a consistency of opinion with the object. An agent agrees to/about an object (a proposition, topic or theme) with participants.
 * @author schema.org
 * @class AgreeAction
 * @module org.schema
 * @extends ReactAction
 */
public class AgreeAction extends ReactAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AgreeAction()
	{
		context="http://schema.org/";
		type="AgreeAction";
	}

}