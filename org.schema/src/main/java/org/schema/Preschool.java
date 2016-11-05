package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Preschool
 * A preschool.
 * @author schema.org
 * @module schema.org
 * @class Preschool
 * @extends EducationalOrganization
 */
public class Preschool extends EducationalOrganization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Preschool()
	{
		context="http://schema.org/";
		type="Preschool";
	}

}