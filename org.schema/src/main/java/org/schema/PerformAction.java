package org.schema;

/**
 * Schema.org/PerformAction
 * The act of participating in performance arts.
 *
 * @author schema.org
 * @class PerformAction
 * @module org.schema
 * @extends PlayAction
 */
public class PerformAction extends PlayAction {
	/**
	 * Schema.org/entertainmentBusiness
	 * A sub property of location. The entertainment business where the action occurred.
	 *
	 * @property entertainmentBusiness
	 * @type EntertainmentBusiness
	 */
	public EntertainmentBusiness entertainmentBusiness;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PerformAction() {
		context = "http://schema.org/";
		type = "PerformAction";
	}

}