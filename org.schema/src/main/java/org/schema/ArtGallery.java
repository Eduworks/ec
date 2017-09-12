package org.schema;

/**
 * Schema.org/ArtGallery
 * An art gallery.
 *
 * @author schema.org
 * @class ArtGallery
 * @module org.schema
 * @extends EntertainmentBusiness
 */
public class ArtGallery extends EntertainmentBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ArtGallery() {
		context = "http://schema.org/";
		type = "ArtGallery";
	}

}