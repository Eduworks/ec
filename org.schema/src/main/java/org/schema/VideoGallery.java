package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/VideoGallery
 * Web page type: Video gallery page.
 * @author schema.org
 * @class VideoGallery
 * @module org.schema
 * @extends CollectionPage
 */
public class VideoGallery extends CollectionPage
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public VideoGallery()
	{
		context="http://schema.org/";
		type="VideoGallery";
	}

}