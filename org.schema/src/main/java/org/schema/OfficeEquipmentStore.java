package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/OfficeEquipmentStore
 * An office equipment store.
 * @author schema.org
 * @module schema.org
 * @class OfficeEquipmentStore
 * @extends Store
 */
public class OfficeEquipmentStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public OfficeEquipmentStore()
	{
		context="http://schema.org/";
		type="OfficeEquipmentStore";
	}

}