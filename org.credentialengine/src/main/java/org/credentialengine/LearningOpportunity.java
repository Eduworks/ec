package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/LearningOpportunity
 * Structured and unstructured learning and development opportunities based in direct experience, formal and informal study, observation, and involvement in discourse and practice.
 * Examples of learning opportunities include education and training programs and classes, courses of study, apprenticeship or work experience programs, or other structured experiences intended to serve as educational or training events.
 * @author credentialengine.org
 * @class LearningOpportunity
 * @module org.credentialengine
 */
public class LearningOpportunity extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LearningOpportunity()
	{
		super("http://schema.eduworks.com/simpleCtdl","LearningOpportunity");
	}

}