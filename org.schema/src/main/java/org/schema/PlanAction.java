package org.schema;

/**
 * Schema.org/PlanAction
 * The act of planning the execution of an event/task/action/reservation/plan to a future date.
 *
 * @author schema.org
 * @class PlanAction
 * @module org.schema
 * @extends OrganizeAction
 */
public class PlanAction extends OrganizeAction {
	/**
	 * Schema.org/scheduledTime
	 * The time the object is scheduled to.
	 *
	 * @property scheduledTime
	 * @type DateTime
	 */
	public String scheduledTime;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PlanAction() {
		context = "http://schema.org/";
		type = "PlanAction";
	}

}