package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ActivateAction
 * The act of starting or activating a device or application (e.g. starting a timer or turning on a flashlight).
 * @author schema.org
 * @class ActivateAction
 * @module org.schema
 * @extends ControlAction
 */
public class ActivateAction extends ControlAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ActivateAction()
	{
		context="http://schema.org/";
		type="ActivateAction";
	}

}