package org.credentialengine;

/**
 * credentialengine.org/CompetencyFramework
 * An entity comprised of a logically related set of competencies.
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

	/**
	 * http://purl.org/ctdl/terms/inLanguage
	 * The primary language used in or by the resource being described.
	 * @property inLanguage
	 * @type language
	 */
	public String inLanguage;

}