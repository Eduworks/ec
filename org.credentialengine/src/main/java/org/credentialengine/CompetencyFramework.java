package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CompetencyFramework
 * Entity comprised of a logically related set of competencies.
 * A competency framework serves a container object for a set of competencies.
 * @author credentialengine.org
 * @class CompetencyFramework
 * @module org.credentialengine
 * @extends CredentialFramework
 */
public class CompetencyFramework extends CredentialFramework
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CompetencyFramework()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="CompetencyFramework";
	}

}