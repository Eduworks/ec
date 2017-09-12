package org.schema;

/**
 * Schema.org/MoveAction
 * The act of an agent relocating to a place.\n\nRelated actions:\n\n* [[TransferAction]]: Unlike TransferAction, the subject of the move is a living Person or Organization rather than an inanimate object.
 * @author schema.org
 * @class MoveAction
 * @module org.schema
 * @extends Action
 */
public class MoveAction extends Action
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MoveAction()
	{
		context="http://schema.org/";
		type="MoveAction";
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