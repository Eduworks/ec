package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/Course
 * Structured sequence of one or more educational activities that aims to develop a prescribed set of knowledge, competence or ability of learners.
 * @author credentialengine.org
 * @class Course
 * @module org.credentialengine
 * @extends LearningOpportunity
 */
public class Course extends LearningOpportunity
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Course()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="Course";
	}

}