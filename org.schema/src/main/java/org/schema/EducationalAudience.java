package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/EducationalAudience
 * An EducationalAudience.
 * @author schema.org
 * @class EducationalAudience
 * @module org.schema
 * @extends Audience
 */
public class EducationalAudience extends Audience
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EducationalAudience()
	{
		context="http://schema.org/";
		type="EducationalAudience";
	}

	/**
	 * Schema.org/educationalRole
	 * An educationalRole of an EducationalAudience.
	 * @property educationalRole
	 * @type Text
	 */
	public String educationalRole;

}