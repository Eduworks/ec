package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/GiveAction
 * The act of transferring ownership of an object to a destination. Reciprocal of TakeAction.\n\nRelated actions:\n\n* [[TakeAction]]: Reciprocal of GiveAction.\n* [[SendAction]]: Unlike SendAction, GiveAction implies that ownership is being transferred (e.g. I may send my laptop to you, but that doesn't mean I'm giving it to you).
 * @author schema.org
 * @module schema.org
 * @class GiveAction
 * @extends TransferAction
 */
public class GiveAction extends TransferAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GiveAction()
	{
		context="http://schema.org/";
		type="GiveAction";
	}

	/**
	 * Schema.org/recipient
	 * A sub property of participant. The participant who is at the receiving end of the action.
	 * @property recipient
	 * @type schema,Organization | schema,Person | schema,Audience	 */
	public Object recipient;

}