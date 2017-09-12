package org.credentialengine;

/**
 * credentialengine.org/Course
 * A description of an educational course which may be offered as distinct instances at different times and places, or through different media or modes of study. An educational course is a sequence of one or more educational events and/or creative works which aims to build knowledge, competence or ability of learners.
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