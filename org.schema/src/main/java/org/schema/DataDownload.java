package org.schema;

/**
 * Schema.org/DataDownload
 * A dataset in downloadable form.
 *
 * @author schema.org
 * @class DataDownload
 * @module org.schema
 * @extends MediaObject
 */
public class DataDownload extends MediaObject {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DataDownload() {
		context = "http://schema.org/";
		type = "DataDownload";
	}

}