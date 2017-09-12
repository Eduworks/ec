package org.credentialengine;

import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CredentialAssertion
 * The class of  representations of an awarded credential, used to share information about a credential belonging to one holder.
 *
 * @author credentialengine.org
 * @class CredentialAssertion
 * @module org.credentialengine
 */
public class CredentialAssertion extends EcRemoteLinkedData {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CredentialAssertion() {
		super("http://schema.eduworks.com/simpleCtdl", "CredentialAssertion");
	}

}