package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PlanAction
 * The act of planning the execution of an event/task/action/reservation/plan to a future date.
 * @author schema.org
 * @module schema.org
 * @class PlanAction
 * @extends OrganizeAction
 */
public class PlanAction extends OrganizeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PlanAction()
	{
		context="http://schema.org/";
		type="PlanAction";
	}

	/**
	 * Schema.org/scheduledTime
	 * The time the object is scheduled to.
	 * @property scheduledTime
	 * @type DateTime
	 */
	public String scheduledTime;

}