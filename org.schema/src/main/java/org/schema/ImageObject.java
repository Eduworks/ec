package org.schema;

/**
 * Schema.org/ImageObject
 * An image file.
 *
 * @author schema.org
 * @class ImageObject
 * @module org.schema
 * @extends MediaObject
 */
public class ImageObject extends MediaObject {
	/**
	 * Schema.org/exifData
	 * exif data for this object.
	 *
	 * @property exifData
	 * @type Text
	 */
	public String exifData;
	/**
	 * Schema.org/representativeOfPage
	 * Indicates whether this image is representative of the content of the page.
	 *
	 * @property representativeOfPage
	 * @type Boolean
	 */
	public Boolean representativeOfPage;
	/**
	 * Schema.org/thumbnail
	 * Thumbnail image for an image or video.
	 *
	 * @property thumbnail
	 * @type ImageObject
	 */
	public ImageObject thumbnail;
	/**
	 * Schema.org/caption
	 * The caption for this object.
	 *
	 * @property caption
	 * @type Text
	 */
	public String caption;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ImageObject() {
		context = "http://schema.org/";
		type = "ImageObject";
	}

}