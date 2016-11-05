package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ElementarySchool
 * An elementary school.
 * @author schema.org
 * @module schema.org
 * @class ElementarySchool
 * @extends EducationalOrganization
 */
public class ElementarySchool extends EducationalOrganization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ElementarySchool()
	{
		context="http://schema.org/";
		type="ElementarySchool";
	}

}