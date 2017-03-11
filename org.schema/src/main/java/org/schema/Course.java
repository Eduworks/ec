package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Course
 * A description of an educational course which may be offered as distinct instances at which take place at different times or take place at different locations, or be offered through different media or modes of study. An educational course is a sequence of one or more educational events and/or creative works which aims to build knowledge, competence or ability of learners.
 * @author schema.org
 * @class Course
 * @module org.schema
 * @extends CreativeWork
 */
public class Course extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Course()
	{
		context="http://schema.org/";
		type="Course";
	}

	/**
	 * Schema.org/hasCourseInstance
	 * An offering of the course at a specific time and place or through specific media or mode of study or to a specific section of students.
	 * @property hasCourseInstance
	 * @type CourseInstance
	 */
	public CourseInstance hasCourseInstance;

	/**
	 * Schema.org/coursePrerequisites
	 * Requirements for taking the Course. May be completion of another [[Course]] or a textual description like "permission of instructor". Requirements may be a pre-requisite competency, referenced using [[AlignmentObject]].
	 * @property coursePrerequisites
	 * @type schema,AlignmentObject | schema,Text | schema,Course
	 */
	public Object coursePrerequisites;

	/**
	 * Schema.org/courseCode
	 * The identifier for the [[Course]] used by the course [[provider]] (e.g. CS101 or 6.001).
	 * @property courseCode
	 * @type Text
	 */
	public String courseCode;

}