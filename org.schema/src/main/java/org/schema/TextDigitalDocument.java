package org.schema;

/**
 * Schema.org/TextDigitalDocument
 * A file composed primarily of text.
 * @author schema.org
 * @class TextDigitalDocument
 * @module org.schema
 * @extends DigitalDocument
 */
public class TextDigitalDocument extends DigitalDocument
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TextDigitalDocument()
	{
		context="http://schema.org/";
		type="TextDigitalDocument";
	}

}