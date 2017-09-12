package org.schema;

/**
 * Schema.org/ComputerStore
 * A computer store.
 * @author schema.org
 * @class ComputerStore
 * @module org.schema
 * @extends Store
 */
public class ComputerStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ComputerStore()
	{
		context="http://schema.org/";
		type="ComputerStore";
	}

}