package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/FilmAction
 * The act of capturing sound and moving images on film, video, or digitally.
 * @author schema.org
 * @module schema.org
 * @class FilmAction
 * @extends CreateAction
 */
public class FilmAction extends CreateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public FilmAction()
	{
		context="http://schema.org/";
		type="FilmAction";
	}

}