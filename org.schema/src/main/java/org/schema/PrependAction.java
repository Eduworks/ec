package org.schema;

/**
 * Schema.org/PrependAction
 * The act of inserting at the beginning if an ordered collection.
 * @author schema.org
 * @class PrependAction
 * @module org.schema
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