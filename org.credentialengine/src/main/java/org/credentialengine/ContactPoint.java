package org.credentialengine;

import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/ContactPoint
 * A means of contacting a resource or its representative(s).
 *
 * @author credentialengine.org
 * @class ContactPoint
 * @module org.credentialengine
 */
public class ContactPoint extends EcRemoteLinkedData {
	/**
	 * http://purl.org/ctdl/terms/email
	 * Email address of the agent being described.
	 *
	 * @property email
	 * @type Literal
	 */
	public String email;
	/**
	 * http://purl.org/ctdl/terms/name
	 * The name of the resource being described.
	 *
	 * @property name
	 * @type Literal
	 */
	public String name;
	/**
	 * http://purl.org/ctdl/terms/socialMedia
	 * A social media resource for the resource being described.
	 *
	 * @property socialMedia
	 * @type anyURI
	 */
	public String socialMedia;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ContactPoint() {
		super("http://schema.eduworks.com/simpleCtdl", "ContactPoint");
	}

}