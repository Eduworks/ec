package org.credentialengine;

import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CredentialFramework
 * The class of all structured sets of conceptual resources intentionally designed for use as value vocabulary terms for description and classification in the credentialing context.
 *
 * @author credentialengine.org
 * @class CredentialFramework
 * @module org.credentialengine
 */
public class CredentialFramework extends EcRemoteLinkedData {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CredentialFramework() {
		super("http://schema.eduworks.com/simpleCtdl", "CredentialFramework");
	}

}