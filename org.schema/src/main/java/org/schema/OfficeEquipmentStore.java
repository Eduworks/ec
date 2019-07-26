package org.schema;

/**
 * Schema.org/OfficeEquipmentStore
 * An office equipment store.
 *
 * @author schema.org
 * @class OfficeEquipmentStore
 * @module org.schema
 * @extends Store
 */
public class OfficeEquipmentStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public OfficeEquipmentStore() {
		context = "http://schema.org/";
		type = "OfficeEquipmentStore";
	}

}