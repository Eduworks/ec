package org.credentialengine;

import org.schema.Thing;
import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/Competency
 * An assertion of measurable or observable knowledge, skills, and abilities necessary to successful performance of a person in a given context.
 * @author credentialengine.org
 * @class Competency
 * @module org.credentialengine
 * @extends Statement
 */
public class Competency extends Thing
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Competency()
	{
		context="http://purl.org/ctdl/terms/";
		type="Competency";
	}

}