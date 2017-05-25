package org.credentialengine;

import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/Competency
 * An assertion of measurable or observable knowledge, skills, and abilities necessary to successful performance of a person in a given context.
 * @author credentialengine.org
 * @class Competency
 * @module org.credentialengine
 * @extends Statement
 */
public class Competency extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Competency()
	{
		super("http://schema.eduworks.com/simpleCtdl","Competency");
	}

	/**
	 * http://purl.org/ctdl/terms/inLanguage
	 * The primary language used in or by the resource being described.
	 * @property inLanguage
	 * @type language
	 */
	public String inLanguage;

}