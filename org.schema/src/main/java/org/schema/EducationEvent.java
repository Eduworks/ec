package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/EducationEvent
 * Event type: Education event.
 * @author schema.org
 * @module schema.org
 * @class EducationEvent
 * @extends Event
 */
public class EducationEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EducationEvent()
	{
		context="http://schema.org/";
		type="EducationEvent";
	}

}