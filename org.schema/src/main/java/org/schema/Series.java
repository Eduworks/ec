package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Series
 * 
          A Series in schema.org is a group of related items, typically but not necessarily of the same kind. 
 * @author schema.org
 * @class Series
 * @module org.schema
 * @extends CreativeWork
 */
public class Series extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Series()
	{
		context="http://schema.org/";
		type="Series";
	}

}