package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/NoteDigitalDocument
 * A file containing a note, primarily for the author.
 * @author schema.org
 * @module schema.org
 * @class NoteDigitalDocument
 * @extends DigitalDocument
 */
public class NoteDigitalDocument extends DigitalDocument
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public NoteDigitalDocument()
	{
		context="http://schema.org/";
		type="NoteDigitalDocument";
	}

}