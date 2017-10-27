package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/IdentifierValue
 * Alphanumeric Identifier value.
 * @author credentialengine.org
 * @class IdentifierValue
 * @module org.credentialengine
 * @extends identifier
 */
public class IdentifierValue extends identifier
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public IdentifierValue()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="IdentifierValue";
	}

	/**
	 * http://purl.org/ctdl/terms/description
	 * Statememnt, characterization or account of the entity.
	 * @property description
	 * @type langString
	 */
	public langString description;

	/**
	 * http://purl.org/ctdl/terms/identifierType
	 * Formal name or acronym of the identifier type such as ISBN and ISSN.
	 * @property identifierType
	 * @type langString
	 */
	public langString identifierType;

	/**
	 * http://purl.org/ctdl/terms/identifierValueCode
	 * Alphanumeric string identifier of the entity.
	 * Where a formal identification system exists for the identifier, recommended best practice is to use a string conforming to that system.
	 * @property identifierValueCode
	 * @type string
	 */
	public string identifierValueCode;

	/**
	 * http://purl.org/ctdl/terms/name
	 * Name or title of the entity.
	 * @property name
	 * @type langString
	 */
	public langString name;

}