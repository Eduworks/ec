package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PresentationDigitalDocument
 * A file containing slides or used for a presentation.
 * @author schema.org
 * @module schema.org
 * @class PresentationDigitalDocument
 * @extends DigitalDocument
 */
public class PresentationDigitalDocument extends DigitalDocument
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PresentationDigitalDocument()
	{
		context="http://schema.org/";
		type="PresentationDigitalDocument";
	}

}