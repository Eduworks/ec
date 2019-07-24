package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CredentialFramework
 * Class of all structured sets of conceptual entities intentionally designed for use as value vocabulary terms for description and classification in the credentialing context.
 * The class includes, but is not limited to, subclasses of specialized concept schemes describing industries, occupations, professions, learning contexts and jobs, as well as specialized subject concept schemes, assessment rubrics, proficiency scales, and competency frameworks.
 * @author credentialengine.org
 * @class CredentialFramework
 * @module org.credentialengine
 */
public class CredentialFramework extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CredentialFramework()
	{
		super("http://schema.eduworks.com/simpleCtdl","CredentialFramework");
	}

}