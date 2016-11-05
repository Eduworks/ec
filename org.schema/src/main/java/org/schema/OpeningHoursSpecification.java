package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/OpeningHoursSpecification
 * A structured value providing information about the opening hours of a place or a certain service inside a place.\n\n
The place is __open__ if the [[opens]] property is specified, and __closed__ otherwise.\n\nIf the value for the [[closes]] property is less than the value for the [[opens]] property then the hour range is assumed to span over the next day.
      
 * @author schema.org
 * @module schema.org
 * @class OpeningHoursSpecification
 * @extends StructuredValue
 */
public class OpeningHoursSpecification extends StructuredValue
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public OpeningHoursSpecification()
	{
		context="http://schema.org/";
		type="OpeningHoursSpecification";
	}

	/**
	 * Schema.org/opens
	 * The opening hour of the place or service on the given day(s) of the week.
	 * @property opens
	 * @type Time
	 */
	public String opens;

	/**
	 * Schema.org/dayOfWeek
	 * The day of the week for which these opening hours are valid.
	 * @property dayOfWeek
	 * @type DayOfWeek
	 */
	public DayOfWeek dayOfWeek;

	/**
	 * Schema.org/validFrom
	 * The date when the item becomes valid.
	 * @property validFrom
	 * @type DateTime
	 */
	public String validFrom;

	/**
	 * Schema.org/closes
	 * The closing hour of the place or service on the given day(s) of the week.
	 * @property closes
	 * @type Time
	 */
	public String closes;

	/**
	 * Schema.org/validThrough
	 * The date after when the item is not valid. For example the end of an offer, salary period, or a period of opening hours.
	 * @property validThrough
	 * @type DateTime
	 */
	public String validThrough;

}