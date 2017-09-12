package org.schema;

/**
 * Schema.org/AutoPartsStore
 * An auto parts store.
 * @author schema.org
 * @class AutoPartsStore
 * @module org.schema
 * @extends AutomotiveBusiness
 */
public class AutoPartsStore extends AutomotiveBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AutoPartsStore()
	{
		context="http://schema.org/";
		type="AutoPartsStore";
	}

}