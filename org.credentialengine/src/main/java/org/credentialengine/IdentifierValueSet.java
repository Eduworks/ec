package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/IdentifierValueSet
 * A set of identifier values.
 * @author credentialengine.org
 * @class IdentifierValueSet
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class IdentifierValueSet extends org.schema.CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public IdentifierValueSet()
	{
		context="http://purl.org/ctdl/terms/";
		type="IdentifierValueSet";
	}

}