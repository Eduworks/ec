package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ImageObject
 * An image file.
 * @author schema.org
 * @module schema.org
 * @class ImageObject
 * @extends MediaObject
 */
public class ImageObject extends MediaObject
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ImageObject()
	{
		context="http://schema.org/";
		type="ImageObject";
	}

	/**
	 * Schema.org/exifData
	 * exif data for this object.
	 * @property exifData
	 * @type schema,Text | schema,PropertyValue	 */
	public Object exifData;

	/**
	 * Schema.org/thumbnail
	 * Thumbnail image for an image or video.
	 * @property thumbnail
	 * @type ImageObject
	 */
	public ImageObject thumbnail;

	/**
	 * Schema.org/representativeOfPage
	 * Indicates whether this image is representative of the content of the page.
	 * @property representativeOfPage
	 * @type Boolean
	 */
	public Boolean representativeOfPage;

	/**
	 * Schema.org/caption
	 * The caption for this object.
	 * @property caption
	 * @type Text
	 */
	public String caption;

}