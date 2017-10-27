package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/ContactPoint
 * Means of contacting an organization or its representative.
 * For example, a public relations email address or phone number.
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
		super("http://schema.eduworks.com/simpleCtdl","ContactPoint");
	}

	/**
	 * http://purl.org/ctdl/terms/contactOption
	 * Option for a toll-free number or support for hearing-impaired callers.
	 * @property contactOption
	 * @type langString
	 */
	public String contactOption;

	/**
	 * http://purl.org/ctdl/terms/contactType
	 * Text identifying the type of service provided by an organizational contact.
	 * A person or organization may have different contact points for different services. The contact type property provides for adding text to identity the service; e.g., "toll-free number" or "support for hearing-impaired callers".
	 * @property contactType
	 * @type langString
	 */
	public String contactType;

	/**
	 * http://purl.org/ctdl/terms/email
	 * Email address of the organization or person.
	 * @property email
	 * @type string
	 */
	public String email;

	/**
	 * http://purl.org/ctdl/terms/faxNumber
	 * Fax number.
	 * @property faxNumber
	 * @type string
	 */
	public String faxNumber;

	/**
	 * http://purl.org/ctdl/terms/name
	 * Name or title of the entity.
	 * @property name
	 * @type langString
	 */
	public String name;

	/**
	 * http://purl.org/ctdl/terms/socialMedia
	 * Social media access point for an agent or an agent's contact point.
	 * @property socialMedia
	 * @type anyURI
	 */
	public String socialMedia;

	/**
	 * http://purl.org/ctdl/terms/telephone
	 * Telephone number.
	 * @property telephone
	 * @type string
	 */
	public String telephone;

}