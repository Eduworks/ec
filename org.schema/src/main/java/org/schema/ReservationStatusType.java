package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ReservationStatusType
 * Enumerated status values for Reservation.
 * @author schema.org
 * @class ReservationStatusType
 * @module org.schema
 * @extends Enumeration
 */
public class ReservationStatusType extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ReservationStatusType()
	{
		context="http://schema.org/";
		type="ReservationStatusType";
	}

}