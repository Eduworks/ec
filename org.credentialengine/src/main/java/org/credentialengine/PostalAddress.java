package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/PostalAddress
 * The mailing address.
 * @author credentialengine.org
 * @class PostalAddress
 * @module org.credentialengine
 * @extends ContactPoint
 */
public class PostalAddress extends ContactPoint
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PostalAddress()
	{
		context="http://purl.org/ctdl/terms/";
		type="PostalAddress";
	}

	/**
	 * credentialengine.org/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * credentialengine.org/targetContactPoint
	 * Options for contacting the resource being described.
	 * @property targetContactPoint
	 * @type ContactPoint
	 */
	public ContactPoint targetContactPoint;

}