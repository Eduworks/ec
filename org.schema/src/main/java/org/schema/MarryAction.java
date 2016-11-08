package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MarryAction
 * The act of marrying a person.
 * @author schema.org
 * @class MarryAction
 * @module org.schema
 * @extends InteractAction
 */
public class MarryAction extends InteractAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MarryAction()
	{
		context="http://schema.org/";
		type="MarryAction";
	}

}