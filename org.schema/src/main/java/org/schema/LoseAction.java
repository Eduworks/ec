package org.schema;

/**
 * Schema.org/LoseAction
 * The act of being defeated in a competitive activity.
 *
 * @author schema.org
 * @class LoseAction
 * @module org.schema
 * @extends AchieveAction
 */
public class LoseAction extends AchieveAction {
	/**
	 * Schema.org/winner
	 * A sub property of participant. The winner of the action.
	 *
	 * @property winner
	 * @type Person
	 */
	public Person winner;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public LoseAction() {
		context = "http://schema.org/";
		type = "LoseAction";
	}

}