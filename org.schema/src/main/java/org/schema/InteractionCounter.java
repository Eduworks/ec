package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/InteractionCounter
 * A summary of how users have interacted with this CreativeWork. In most cases, authors will use a subtype to specify the specific type of interaction.
 * @author schema.org
 * @module schema.org
 * @class InteractionCounter
 * @extends StructuredValue
 */
public class InteractionCounter extends StructuredValue
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public InteractionCounter()
	{
		context="http://schema.org/";
		type="InteractionCounter";
	}

	/**
	 * Schema.org/interactionService
	 * The WebSite or SoftwareApplication where the interactions took place.
	 * @property interactionService
	 * @type schema,SoftwareApplication | schema,WebSite	 */
	public Object interactionService;

	/**
	 * Schema.org/userInteractionCount
	 * The number of interactions for the CreativeWork using the WebSite or SoftwareApplication.
	 * @property userInteractionCount
	 * @type Integer
	 */
	public Integer userInteractionCount;

	/**
	 * Schema.org/interactionType
	 * The Action representing the type of interaction. For up votes, +1s, etc. use [[LikeAction]]. For down votes use [[DislikeAction]]. Otherwise, use the most specific Action.
	 * @property interactionType
	 * @type Action
	 */
	public Action interactionType;

}