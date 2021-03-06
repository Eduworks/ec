package org.schema;

/**
 * Schema.org/AchieveAction
 * The act of accomplishing something via previous efforts. It is an instantaneous action rather than an ongoing process.
 *
 * @author schema.org
 * @class AchieveAction
 * @module org.schema
 * @extends Action
 */
public class AchieveAction extends Action {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public AchieveAction() {
		context = "http://schema.org/";
		type = "AchieveAction";
	}

}