package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ConsumeAction
 * The act of ingesting information/resources/food.
 * @author schema.org
 * @module schema.org
 * @class ConsumeAction
 * @extends Action
 */
public class ConsumeAction extends Action
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ConsumeAction()
	{
		context="http://schema.org/";
		type="ConsumeAction";
	}

	/**
	 * Schema.org/expectsAcceptanceOf
	 * An Offer which must be accepted before the user can perform the Action. For example, the user may need to buy a movie before being able to watch it.
	 * @property expectsAcceptanceOf
	 * @type Offer
	 */
	public Offer expectsAcceptanceOf;

}