package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PerformingGroup
 * A performance group, such as a band, an orchestra, or a circus.
 * @author schema.org
 * @class PerformingGroup
 * @module org.schema
 * @extends Organization
 */
public class PerformingGroup extends Organization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PerformingGroup()
	{
		context="http://schema.org/";
		type="PerformingGroup";
	}

}