package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AppendAction
 * The act of inserting at the end if an ordered collection.
 * @author schema.org
 * @module schema.org
 * @class AppendAction
 * @extends InsertAction
 */
public class AppendAction extends InsertAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AppendAction()
	{
		context="http://schema.org/";
		type="AppendAction";
	}

}