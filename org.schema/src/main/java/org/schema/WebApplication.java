package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/WebApplication
 * Web applications.
 * @author schema.org
 * @class WebApplication
 * @module org.schema
 * @extends SoftwareApplication
 */
public class WebApplication extends SoftwareApplication
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public WebApplication()
	{
		context="http://schema.org/";
		type="WebApplication";
	}

	/**
	 * Schema.org/browserRequirements
	 * Specifies browser requirements in human-readable text. For example, 'requires HTML5 support'.
	 * @property browserRequirements
	 * @type Text
	 */
	public String browserRequirements;

}