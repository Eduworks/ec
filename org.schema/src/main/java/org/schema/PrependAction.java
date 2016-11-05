package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PrependAction
 * The act of inserting at the beginning if an ordered collection.
 * @author schema.org
 * @module schema.org
 * @class PrependAction
 * @extends InsertAction
 */
public class PrependAction extends InsertAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PrependAction()
	{
		context="http://schema.org/";
		type="PrependAction";
	}

}