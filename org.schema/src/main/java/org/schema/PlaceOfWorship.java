package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PlaceOfWorship
 * Place of worship, such as a church, synagogue, or mosque.
 * @author schema.org
 * @module schema.org
 * @class PlaceOfWorship
 * @extends CivicStructure
 */
public class PlaceOfWorship extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PlaceOfWorship()
	{
		context="http://schema.org/";
		type="PlaceOfWorship";
	}

}