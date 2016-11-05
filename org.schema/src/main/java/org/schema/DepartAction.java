package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DepartAction
 * The act of  departing from a place. An agent departs from an fromLocation for a destination, optionally with participants.
 * @author schema.org
 * @module schema.org
 * @class DepartAction
 * @extends MoveAction
 */
public class DepartAction extends MoveAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DepartAction()
	{
		context="http://schema.org/";
		type="DepartAction";
	}

}