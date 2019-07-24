package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CredentialAssertion
 * Representation of a credential awarded to a person.
 * @author credentialengine.org
 * @class CredentialAssertion
 * @module org.credentialengine
 */
public class CredentialAssertion extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CredentialAssertion()
	{
		super("http://schema.eduworks.com/simpleCtdl","CredentialAssertion");
	}

}