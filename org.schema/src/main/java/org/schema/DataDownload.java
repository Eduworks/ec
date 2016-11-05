package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DataDownload
 * A dataset in downloadable form.
 * @author schema.org
 * @module schema.org
 * @class DataDownload
 * @extends MediaObject
 */
public class DataDownload extends MediaObject
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DataDownload()
	{
		context="http://schema.org/";
		type="DataDownload";
	}

}