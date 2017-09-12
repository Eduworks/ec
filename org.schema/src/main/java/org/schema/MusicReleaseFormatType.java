package org.schema;

/**
 * Schema.org/MusicReleaseFormatType
 * Format of this release (the type of recording media used, ie. compact disc, digital media, LP, etc.).
 * @author schema.org
 * @class MusicReleaseFormatType
 * @module org.schema
 * @extends Enumeration
 */
public class MusicReleaseFormatType extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MusicReleaseFormatType()
	{
		context="http://schema.org/";
		type="MusicReleaseFormatType";
	}

}