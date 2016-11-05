package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DislikeAction
 * The act of expressing a negative sentiment about the object. An agent dislikes an object (a proposition, topic or theme) with participants.
 * @author schema.org
 * @module schema.org
 * @class DislikeAction
 * @extends ReactAction
 */
public class DislikeAction extends ReactAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DislikeAction()
	{
		context="http://schema.org/";
		type="DislikeAction";
	}

}