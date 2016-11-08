package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DeleteAction
 * The act of editing a recipient by removing one of its objects.
 * @author schema.org
 * @class DeleteAction
 * @module org.schema
 * @extends UpdateAction
 */
public class DeleteAction extends UpdateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DeleteAction()
	{
		context="http://schema.org/";
		type="DeleteAction";
	}

}