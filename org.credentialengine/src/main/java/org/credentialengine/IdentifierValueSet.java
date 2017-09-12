package org.credentialengine;

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
		context="http://schema.eduworks.com/simpleCtdl";
		type="IdentifierValueSet";
	}

}