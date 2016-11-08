package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PerformanceRole
 * A PerformanceRole is a Role that some entity places with regard to a theatrical performance, e.g. in a Movie, TVSeries etc.
 * @author schema.org
 * @class PerformanceRole
 * @module org.schema
 * @extends Role
 */
public class PerformanceRole extends Role
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PerformanceRole()
	{
		context="http://schema.org/";
		type="PerformanceRole";
	}

	/**
	 * Schema.org/characterName
	 * The name of a character played in some acting or performing role, i.e. in a PerformanceRole.
	 * @property characterName
	 * @type Text
	 */
	public String characterName;

}