package org.credentialengine;

/**
 * credentialengine.org/PostalAddress
 * The mailing address.
 *
 * @author credentialengine.org
 * @class PostalAddress
 * @module org.credentialengine
 * @extends ContactPoint
 */
public class PostalAddress extends ContactPoint {
	/**
	 * http://purl.org/ctdl/terms/name
	 * The name of the resource being described.
	 *
	 * @property name
	 * @type Literal
	 */
	public String name;
	/**
	 * http://purl.org/ctdl/terms/targetContactPoint
	 * Options for contacting the resource being described.
	 *
	 * @property targetContactPoint
	 * @type ContactPoint
	 */
	public ContactPoint targetContactPoint;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PostalAddress() {
		context = "http://schema.eduworks.com/simpleCtdl";
		type = "PostalAddress";
	}

}