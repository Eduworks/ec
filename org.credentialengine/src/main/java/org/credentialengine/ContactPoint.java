package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/ContactPoint
 * A means of contacting a resource or its representative(s).
 * @author credentialengine.org
 * @class ContactPoint
 * @module org.credentialengine
 */
public class ContactPoint extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ContactPoint()
	{
		super(null,null);
		context="http://purl.org/ctdl/terms/";
		type="ContactPoint";
	}

	/**
	 * credentialengine.org/email
	 * Email address of the agent being described.
	 * @property email
	 * @type Literal | Email
	 */
	public Object email;

	/**
	 * credentialengine.org/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * credentialengine.org/socialMedia
	 * A social media resource for the resource being described.
	 * @property socialMedia
	 * @type anyURI
	 */
	public String socialMedia;

}