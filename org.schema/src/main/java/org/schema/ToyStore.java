package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ToyStore
 * A toy store.
 * @author schema.org
 * @module schema.org
 * @class ToyStore
 * @extends Store
 */
public class ToyStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ToyStore()
	{
		context="http://schema.org/";
		type="ToyStore";
	}

}