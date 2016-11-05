package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/WantAction
 * The act of expressing a desire about the object. An agent wants an object.
 * @author schema.org
 * @module schema.org
 * @class WantAction
 * @extends ReactAction
 */
public class WantAction extends ReactAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public WantAction()
	{
		context="http://schema.org/";
		type="WantAction";
	}

}