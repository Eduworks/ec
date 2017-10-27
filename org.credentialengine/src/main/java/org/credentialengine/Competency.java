package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/Competency
 * Description of measurable or observable knowledge, skills, and abilities necessary to successful performance of a person in a given context.
 * Competency is broadly defined to include assertions of academic, professional, occupational, vocational and life goals, outcomes, and standards, however labeled.
 * @author credentialengine.org
 * @class Competency
 * @module org.credentialengine
 * @extends Statement
 */
public class Competency extends Statement
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Competency()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="Competency";
	}

}