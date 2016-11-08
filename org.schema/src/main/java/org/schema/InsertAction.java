package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/InsertAction
 * The act of adding at a specific location in an ordered collection.
 * @author schema.org
 * @class InsertAction
 * @module org.schema
 * @extends AddAction
 */
public class InsertAction extends AddAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public InsertAction()
	{
		context="http://schema.org/";
		type="InsertAction";
	}

	/**
	 * Schema.org/toLocation
	 * A sub property of location. The final location of the object or the agent after the action.
	 * @property toLocation
	 * @type Place
	 */
	public Place toLocation;

}