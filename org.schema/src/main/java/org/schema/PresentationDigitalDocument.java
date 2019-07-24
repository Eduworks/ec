package org.schema;

/**
 * Schema.org/PresentationDigitalDocument
 * A file containing slides or used for a presentation.
 *
 * @author schema.org
 * @class PresentationDigitalDocument
 * @module org.schema
 * @extends DigitalDocument
 */
public class PresentationDigitalDocument extends DigitalDocument {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PresentationDigitalDocument() {
		context = "http://schema.org/";
		type = "PresentationDigitalDocument";
	}

}