package org.schema;

/**
 * Schema.org/UpdateAction
 * The act of managing by changing/editing the state of the object.
 *
 * @author schema.org
 * @class UpdateAction
 * @module org.schema
 * @extends Action
 */
public class UpdateAction extends Action {
	/**
	 * Schema.org/collection
	 * A sub property of object. The collection target of the action.
	 *
	 * @property collection
	 * @type Thing
	 */
	public Thing collection;
	/**
	 * Schema.org/targetCollection
	 * A sub property of object. The collection target of the action.
	 *
	 * @property targetCollection
	 * @type Thing
	 */
	public Thing targetCollection;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public UpdateAction() {
		context = "http://schema.org/";
		type = "UpdateAction";
	}

}