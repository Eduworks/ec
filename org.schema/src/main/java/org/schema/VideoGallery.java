package org.schema;

/**
 * Schema.org/VideoGallery
 * Web page type: Video gallery page.
 *
 * @author schema.org
 * @class VideoGallery
 * @module org.schema
 * @extends CollectionPage
 */
public class VideoGallery extends CollectionPage {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public VideoGallery() {
		context = "http://schema.org/";
		type = "VideoGallery";
	}

}