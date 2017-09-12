package org.schema;

/**
 * Schema.org/CourseInstance
 * An instance of a [[Course]] which is distinct from other instances because it is offered at a different time or location or through different media or modes of study or to a specific section of students.
 *
 * @author schema.org
 * @class CourseInstance
 * @module org.schema
 * @extends Event
 */
public class CourseInstance extends Event {
	/**
	 * Schema.org/courseMode
	 * The medium or means of delivery of the course instance or the mode of study, either as a text label (e.g. "online", "onsite" or "blended"; "synchronous" or "asynchronous"; "full-time" or "part-time") or as a URL reference to a term from a controlled vocabulary (e.g. https://ceds.ed.gov/element/001311#Asynchronous ).
	 *
	 * @property courseMode
	 * @type schema, URL | schema,Text
	 */
	public Object courseMode;
	/**
	 * Schema.org/instructor
	 * A person assigned to instruct or provide instructional assistance for the [[CourseInstance]].
	 *
	 * @property instructor
	 * @type Person
	 */
	public Person instructor;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CourseInstance() {
		context = "http://schema.org/";
		type = "CourseInstance";
	}

}