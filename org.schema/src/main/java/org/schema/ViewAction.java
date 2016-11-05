package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ViewAction
 * The act of consuming static visual content.
 * @author schema.org
 * @module schema.org
 * @class ViewAction
 * @extends ConsumeAction
 */
public class ViewAction extends ConsumeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ViewAction()
	{
		context="http://schema.org/";
		type="ViewAction";
	}

}