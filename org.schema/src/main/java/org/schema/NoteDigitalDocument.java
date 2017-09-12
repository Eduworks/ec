package org.schema;

/**
 * Schema.org/NoteDigitalDocument
 * A file containing a note, primarily for the author.
 *
 * @author schema.org
 * @class NoteDigitalDocument
 * @module org.schema
 * @extends DigitalDocument
 */
public class NoteDigitalDocument extends DigitalDocument {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public NoteDigitalDocument() {
		context = "http://schema.org/";
		type = "NoteDigitalDocument";
	}

}