package org.schema;

/**
 * Schema.org/DayOfWeek
 * The day of the week, e.g. used to specify to which day the opening hours of an OpeningHoursSpecification refer.
 * <p>
 * Originally, URLs from [GoodRelations](http://purl.org/goodrelations/v1) were used (for [[Monday]], [[Tuesday]], [[Wednesday]], [[Thursday]], [[Friday]], [[Saturday]], [[Sunday]] plus a special entry for [[PublicHolidays]]); these have now been integrated directly into schema.org.
 *
 * @author schema.org
 * @class DayOfWeek
 * @module org.schema
 * @extends Enumeration
 */
public class DayOfWeek extends Enumeration {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DayOfWeek() {
		context = "http://schema.org/";
		type = "DayOfWeek";
	}

}