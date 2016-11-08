package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/WinAction
 * The act of achieving victory in a competitive activity.
 * @author schema.org
 * @class WinAction
 * @module org.schema
 * @extends AchieveAction
 */
public class WinAction extends AchieveAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public WinAction()
	{
		context="http://schema.org/";
		type="WinAction";
	}

	/**
	 * Schema.org/loser
	 * A sub property of participant. The loser of the action.
	 * @property loser
	 * @type Person
	 */
	public Person loser;

}