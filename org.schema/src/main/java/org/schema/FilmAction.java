package org.schema;

/**
 * Schema.org/FilmAction
 * The act of capturing sound and moving images on film, video, or digitally.
 *
 * @author schema.org
 * @class FilmAction
 * @module org.schema
 * @extends CreateAction
 */
public class FilmAction extends CreateAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public FilmAction() {
		context = "http://schema.org/";
		type = "FilmAction";
	}

}