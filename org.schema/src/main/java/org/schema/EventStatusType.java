package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/EventStatusType
 * EventStatusType is an enumeration type whose instances represent several states that an Event may be in.
 * @author schema.org
 * @class EventStatusType
 * @module org.schema
 * @extends Enumeration
 */
public class EventStatusType extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EventStatusType()
	{
		context="http://schema.org/";
		type="EventStatusType";
	}

}