package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DeactivateAction
 * The act of stopping or deactivating a device or application (e.g. stopping a timer or turning off a flashlight).
 * @author schema.org
 * @module schema.org
 * @class DeactivateAction
 * @extends ControlAction
 */
public class DeactivateAction extends ControlAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DeactivateAction()
	{
		context="http://schema.org/";
		type="DeactivateAction";
	}

}