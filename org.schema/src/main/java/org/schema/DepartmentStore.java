package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DepartmentStore
 * A department store.
 * @author schema.org
 * @module schema.org
 * @class DepartmentStore
 * @extends Store
 */
public class DepartmentStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DepartmentStore()
	{
		context="http://schema.org/";
		type="DepartmentStore";
	}

}