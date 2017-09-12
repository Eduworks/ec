package org.schema;

/**
 * Schema.org/TransferAction
 * The act of transferring/moving (abstract or concrete) animate or inanimate objects from one place to another.
 * @author schema.org
 * @class TransferAction
 * @module org.schema
 * @extends Action
 */
public class TransferAction extends Action
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TransferAction()
	{
		context="http://schema.org/";
		type="TransferAction";
	}

	/**
	 * Schema.org/fromLocation
	 * A sub property of location. The original location of the object or the agent before the action.
	 * @property fromLocation
	 * @type Place
	 */
	public Place fromLocation;

	/**
	 * Schema.org/toLocation
	 * A sub property of location. The final location of the object or the agent after the action.
	 * @property toLocation
	 * @type Place
	 */
	public Place toLocation;

}