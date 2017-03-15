package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/OccupationClassification
 * The class of enumerations identifying occupations.
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
		context="http://purl.org/ctdl/terms/";
		type="OccupationClassification";
	}

}