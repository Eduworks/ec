package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Credential
 * A credential. (Speculative)
 * @author schema.org
 * @class Credential
 * @module org.schema
 * @extends CreativeWork
 */
public class Credential extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Credential()
	{
		context="http://schema.org/";
		type="Credential";
	}

}