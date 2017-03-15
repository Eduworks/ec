package org.credentialengine;

import org.schema.Thing;
import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/IdentifierValue
 * An identifier value.
 * @author credentialengine.org
 * @class IdentifierValue
 * @module org.credentialengine
 * @extends identifier
 */
public class IdentifierValue extends Thing
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public IdentifierValue()
	{
		context="http://purl.org/ctdl/terms/";
		type="IdentifierValue";
	}

	/**
	 * credentialengine.org/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * credentialengine.org/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

}