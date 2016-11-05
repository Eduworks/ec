package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ArtGallery
 * An art gallery.
 * @author schema.org
 * @module schema.org
 * @class ArtGallery
 * @extends EntertainmentBusiness
 */
public class ArtGallery extends EntertainmentBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ArtGallery()
	{
		context="http://schema.org/";
		type="ArtGallery";
	}

}