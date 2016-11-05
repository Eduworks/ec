package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/CheckAction
 * An agent inspects/determines/investigates/inquire or examine an object's accuracy/quality/condition or state.
 * @author schema.org
 * @module schema.org
 * @class CheckAction
 * @extends FindAction
 */
public class CheckAction extends FindAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CheckAction()
	{
		context="http://schema.org/";
		type="CheckAction";
	}

}