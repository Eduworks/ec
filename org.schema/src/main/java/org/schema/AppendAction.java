package org.schema;

/**
 * Schema.org/AppendAction
 * The act of inserting at the end if an ordered collection.
 * @author schema.org
 * @class AppendAction
 * @module org.schema
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