package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ComputerStore
 * A computer store.
 * @author schema.org
 * @module schema.org
 * @class ComputerStore
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