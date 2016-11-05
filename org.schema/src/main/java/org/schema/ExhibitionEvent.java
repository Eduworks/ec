package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ExhibitionEvent
 * Event type: Exhibition event, e.g. at a museum, library, archive, tradeshow, ...
 * @author schema.org
 * @module schema.org
 * @class ExhibitionEvent
 * @extends Event
 */
public class ExhibitionEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ExhibitionEvent()
	{
		context="http://schema.org/";
		type="ExhibitionEvent";
	}

}