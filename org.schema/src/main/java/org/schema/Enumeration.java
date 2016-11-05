package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Enumeration
 * Lists or enumerations—for example, a list of cuisines or music genres, etc.
 * @author schema.org
 * @module schema.org
 * @class Enumeration
 * @extends Intangible
 */
public class Enumeration extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Enumeration()
	{
		context="http://schema.org/";
		type="Enumeration";
	}

}