package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ControlAction
 * An agent controls a device or application.
 * @author schema.org
 * @module schema.org
 * @class ControlAction
 * @extends Action
 */
public class ControlAction extends Action
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ControlAction()
	{
		context="http://schema.org/";
		type="ControlAction";
	}

}