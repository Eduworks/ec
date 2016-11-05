package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TieAction
 * The act of reaching a draw in a competitive activity.
 * @author schema.org
 * @module schema.org
 * @class TieAction
 * @extends AchieveAction
 */
public class TieAction extends AchieveAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TieAction()
	{
		context="http://schema.org/";
		type="TieAction";
	}

}