package org.schema;

/**
 * Schema.org/ReserveAction
 * Reserving a concrete object.\n\nRelated actions:\n\n* [[ScheduleAction]]</a>: Unlike ScheduleAction, ReserveAction reserves concrete objects (e.g. a table, a hotel) towards a time slot / spatial allocation.
 *
 * @author schema.org
 * @class ReserveAction
 * @module org.schema
 * @extends PlanAction
 */
public class ReserveAction extends PlanAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ReserveAction() {
		context = "http://schema.org/";
		type = "ReserveAction";
	}

}