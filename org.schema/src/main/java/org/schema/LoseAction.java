package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/LoseAction
 * The act of being defeated in a competitive activity.
 * @author schema.org
 * @module schema.org
 * @class LoseAction
 * @extends AchieveAction
 */
public class LoseAction extends AchieveAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LoseAction()
	{
		context="http://schema.org/";
		type="LoseAction";
	}

	/**
	 * Schema.org/winner
	 * A sub property of participant. The winner of the action.
	 * @property winner
	 * @type Person
	 */
	public Person winner;

}