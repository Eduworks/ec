package org.schema;

/**
 * Schema.org/WatchAction
 * The act of consuming dynamic/moving visual content.
 * @author schema.org
 * @class WatchAction
 * @module org.schema
 * @extends ConsumeAction
 */
public class WatchAction extends ConsumeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public WatchAction()
	{
		context="http://schema.org/";
		type="WatchAction";
	}

}