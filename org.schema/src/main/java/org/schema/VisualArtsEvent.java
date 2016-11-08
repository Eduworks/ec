package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/VisualArtsEvent
 * Event type: Visual arts event.
 * @author schema.org
 * @class VisualArtsEvent
 * @module org.schema
 * @extends Event
 */
public class VisualArtsEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public VisualArtsEvent()
	{
		context="http://schema.org/";
		type="VisualArtsEvent";
	}

}