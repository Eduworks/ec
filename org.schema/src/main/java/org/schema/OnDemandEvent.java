package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/OnDemandEvent
 * A publication event e.g. catch-up TV or radio podcast, during which a program is available on-demand.
 * @author schema.org
 * @module schema.org
 * @class OnDemandEvent
 * @extends PublicationEvent
 */
public class OnDemandEvent extends PublicationEvent
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public OnDemandEvent()
	{
		context="http://schema.org/";
		type="OnDemandEvent";
	}

}