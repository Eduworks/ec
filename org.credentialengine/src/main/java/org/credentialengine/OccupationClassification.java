package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/OccupationClassification
 * Class of concept schemes identifying occupations such as the Standard Occupational Classification (SOC) system in the U.S. and the European Skills/Competences, Qualifications and Occupations (ESCO).
 * @author credentialengine.org
 * @class OccupationClassification
 * @module org.credentialengine
 * @extends CredentialFramework
 */
public class OccupationClassification extends CredentialFramework
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public OccupationClassification()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="OccupationClassification";
	}

}