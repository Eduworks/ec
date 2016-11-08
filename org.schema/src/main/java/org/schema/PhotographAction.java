package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PhotographAction
 * The act of capturing still images of objects using a camera.
 * @author schema.org
 * @class PhotographAction
 * @module org.schema
 * @extends CreateAction
 */
public class PhotographAction extends CreateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PhotographAction()
	{
		context="http://schema.org/";
		type="PhotographAction";
	}

}