package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PaintAction
 * The act of producing a painting, typically with paint and canvas as instruments.
 * @author schema.org
 * @module schema.org
 * @class PaintAction
 * @extends CreateAction
 */
public class PaintAction extends CreateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PaintAction()
	{
		context="http://schema.org/";
		type="PaintAction";
	}

}