package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/UpdateAction
 * The act of managing by changing/editing the state of the object.
 * @author schema.org
 * @module schema.org
 * @class UpdateAction
 * @extends Action
 */
public class UpdateAction extends Action
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public UpdateAction()
	{
		context="http://schema.org/";
		type="UpdateAction";
	}

	/**
	 * Schema.org/targetCollection
	 * A sub property of object. The collection target of the action.
	 * @property targetCollection
	 * @type Thing
	 */
	public Thing targetCollection;

	/**
	 * Schema.org/collection
	 * A sub property of object. The collection target of the action.
	 * @property collection
	 * @type Thing
	 */
	public Thing collection;

}