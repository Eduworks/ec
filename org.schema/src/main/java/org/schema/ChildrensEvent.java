package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ChildrensEvent
 * Event type: Children's event.
 * @author schema.org
 * @class ChildrensEvent
 * @module org.schema
 * @extends Event
 */
public class ChildrensEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ChildrensEvent()
	{
		context="http://schema.org/";
		type="ChildrensEvent";
	}

}