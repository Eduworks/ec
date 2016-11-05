package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ReactAction
 * The act of responding instinctively and emotionally to an object, expressing a sentiment.
 * @author schema.org
 * @module schema.org
 * @class ReactAction
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