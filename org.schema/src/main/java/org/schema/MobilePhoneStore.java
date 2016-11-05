package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MobilePhoneStore
 * A store that sells mobile phones and related accessories.
 * @author schema.org
 * @module schema.org
 * @class MobilePhoneStore
 * @extends Store
 */
public class MobilePhoneStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MobilePhoneStore()
	{
		context="http://schema.org/";
		type="MobilePhoneStore";
	}

}