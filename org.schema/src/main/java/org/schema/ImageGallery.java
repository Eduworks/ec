package org.schema;

/**
 * Schema.org/ImageGallery
 * Web page type: Image gallery page.
 *
 * @author schema.org
 * @class ImageGallery
 * @module org.schema
 * @extends CollectionPage
 */
public class ImageGallery extends CollectionPage {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ImageGallery() {
		context = "http://schema.org/";
		type = "ImageGallery";
	}

}