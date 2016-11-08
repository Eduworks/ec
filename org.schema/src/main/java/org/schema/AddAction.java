package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AddAction
 * The act of editing by adding an object to a collection.
 * @author schema.org
 * @class AddAction
 * @module org.schema
 * @extends UpdateAction
 */
public class AddAction extends UpdateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AddAction()
	{
		context="http://schema.org/";
		type="AddAction";
	}

}