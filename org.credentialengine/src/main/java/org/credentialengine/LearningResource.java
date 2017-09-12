package org.credentialengine;

/**
 * credentialengine.org/LearningResource
 * An entity that is used as part of an Educational Activity (e.g. a textbook) or that describes (e.g. a lesson plan) or records the Educational Activity (e.g. an audio- or video-recording of a lesson).
 *
 * @author credentialengine.org
 * @class LearningResource
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class LearningResource extends org.schema.CreativeWork {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public LearningResource() {
		context = "http://schema.eduworks.com/simpleCtdl";
		type = "LearningResource";
	}

}