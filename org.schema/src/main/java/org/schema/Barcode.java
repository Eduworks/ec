package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Barcode
 * An image of a visual machine-readable code such as a barcode or QR code.
 * @author schema.org
 * @class Barcode
 * @module org.schema
 * @extends ImageObject
 */
public class Barcode extends ImageObject
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Barcode()
	{
		context="http://schema.org/";
		type="Barcode";
	}

}