package org.schema;

/**
 * Schema.org/LiteraryEvent
 * Event type: Literary event.
 * @author schema.org
 * @class LiteraryEvent
 * @module org.schema
 * @extends Event
 */
public class LiteraryEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LiteraryEvent()
	{
		context="http://schema.org/";
		type="LiteraryEvent";
	}

}