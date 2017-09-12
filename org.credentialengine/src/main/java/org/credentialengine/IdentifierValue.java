package org.credentialengine;

import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/IdentifierValue
 * An identifier value.
 *
 * @author credentialengine.org
 * @class IdentifierValue
 * @module org.credentialengine
 * @extends identifier
 */
public class IdentifierValue extends EcRemoteLinkedData {
	/**
	 * http://purl.org/ctdl/terms/description
	 * A short description of the resource being described.
	 *
	 * @property description
	 * @type Literal
	 */
	public String description;
	/**
	 * http://purl.org/ctdl/terms/name
	 * The name of the resource being described.
	 *
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public IdentifierValue() {
		super("http://schema.eduworks.com/simpleCtdl", "IdentifierValue");
	}

}