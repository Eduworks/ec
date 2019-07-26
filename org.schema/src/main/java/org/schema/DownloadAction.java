package org.schema;

/**
 * Schema.org/DownloadAction
 * The act of downloading an object.
 *
 * @author schema.org
 * @class DownloadAction
 * @module org.schema
 * @extends TransferAction
 */
public class DownloadAction extends TransferAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DownloadAction() {
		context = "http://schema.org/";
		type = "DownloadAction";
	}

}